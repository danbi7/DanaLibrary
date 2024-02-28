package com.dana.library.controller;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.dana.library.domain.Board;
import com.dana.library.domain.Book;
import com.dana.library.domain.Book_request;
import com.dana.library.domain.Interested_book;
import com.dana.library.domain.Rent;
import com.dana.library.domain.Reserved_book;
import com.dana.library.domain.Status;
import com.dana.library.domain.User;
import com.dana.library.dto.BookRequestDTO;
import com.dana.library.dto.ResponseDTO;
import com.dana.library.service.BookRequestService;
import com.dana.library.service.BoardService;
import com.dana.library.service.BookService;
import com.dana.library.service.InterestedBookService;
import com.dana.library.service.RentService;
import com.dana.library.service.ReserveService;
import com.dana.library.service.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class AdminController {

	@Autowired
	private BookService bookService;

	@Autowired
	private UserService userService;

	@Autowired
	private RentService rentService;

	@Autowired
	private ReserveService reserveService;

	@Autowired
	private InterestedBookService interestedBookService;

	@Autowired
	private BookRequestService bookRequestService;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private BoardService boardService;

	// 관리자페이지 불러오기
	@GetMapping("/view/admin")
	public String admin(Model model) {
		List<User> userList = userService.getUserList();

		List<Book> bookList = bookService.getBookAll();

		List<Rent> rentList = rentService.getRentListDESC();

		List<Board> boardList = boardService.getBoardListDESC();

		List<Book_request> bookRequest = bookRequestService.getBookRequestList();

		model.addAttribute("bookList", bookList);
		model.addAttribute("userList", userList);
		model.addAttribute("rentList", rentList);
		model.addAttribute("boardList", boardList);
		model.addAttribute("bookRequest", bookRequest);
		return "admin/admin";
	}

	// 마이페이지
	@GetMapping("/view/myPage")
	public String myPage(HttpSession session, Model model) {
		User loginUser = (User) session.getAttribute("loginUser");
		List<Rent> currentRentList = rentService.rentedByLoginUser(loginUser);
		Reserved_book reserve = reserveService.getReserveByUser(loginUser);
		model.addAttribute("currentRentList", currentRentList);
		model.addAttribute("reserve", reserve);

		List<Rent> pastRentList = rentService.pastRentList(loginUser);
		model.addAttribute("pastRentList", pastRentList);

		List<Interested_book> interestedBookList = interestedBookService.getInterestedBookListByUser(loginUser);
		model.addAttribute("interestedBookList", interestedBookList);

		List<Book_request> bookRequestList = bookRequestService.getBookRequestList();
		model.addAttribute("bookRequestList", bookRequestList);

		List<Board> myBoardList = boardService.getMyBoardList(loginUser);
		model.addAttribute("myBoardList", myBoardList);
		return "admin/myPage";
	}

	// 회원 수정 상세 페이지 불러오기
	@GetMapping("/view/userEdit/{userid}")
	public String openEditUser(@PathVariable String userid, Model model) {
		User user = userService.getUser(userid);
		System.out.println(user.getUsername() + "의 정보 불러오기");
		model.addAttribute("user", user);
		return "admin/userEdit";
	}

	// 대출 정보 상세 페이지 불러오기
	@GetMapping("/view/rentEdit/{rentNum}")
	public String openEditRent(@PathVariable int rentNum, Model model) {
		Rent rent = rentService.getRent(rentNum);
		model.addAttribute("rent", rent);
		return "admin/rentEdit";
	}

	// 관리자 회원 수정 기능
	@PutMapping("/admin/editUser")
	public @ResponseBody ResponseDTO<?> editUserAdmin(@RequestBody User user) {
		userService.editUserAdmin(user);
		return new ResponseDTO<>(HttpStatus.OK.value(), "회원 정보 수정 완료");
	}

	// 회원 정보 수정 기능
	@PutMapping("/user/editUser")
	public @ResponseBody ResponseDTO<?> editUser(@RequestBody User user, HttpSession session) {
		userService.editUser(user, session);
		return new ResponseDTO<>(HttpStatus.OK.value(), "회원 정보 수정 완료");
	}

	// 도서 상세 정보 페이지 불러오기
	@GetMapping("/view/bookEdit/{bookNum}")
	public String openEditBook(@PathVariable int bookNum, Model model) {
		Book book = bookService.getBook(bookNum);
		model.addAttribute("book", book);
		return "admin/bookEdit";
	}

	// 도서 추가 화면 불러오기
	@GetMapping("/view/addBook")
	public String openAddBook() {
		return "admin/addBook";
	}

	// 신규 도서 추가
	@PostMapping("/admin/addBook")
	public @ResponseBody ResponseDTO<?> addBook(@RequestParam("title") String title,
			@RequestParam("author") String author, @RequestParam("publisher") String publisher,
			@RequestParam("publicationDate") String publicationDate, @RequestParam("category") String category,
			@RequestParam("info") String info, @RequestParam("pages") int pages,
			@RequestPart("file") MultipartFile file) {

		try {
			// 문자열을 Date로 변환
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date parsedDate = dateFormat.parse(publicationDate);
			java.sql.Date sqlDate = new java.sql.Date(parsedDate.getTime());

			// 파일 데이터를 바이트 배열로 변환
			byte[] fileData = file.getBytes();

			// 업로드할 파일의 원본 이름
			String originalFilename = file.getOriginalFilename();

			// timestamp를 이용하여 파일 이름 생성
			long timestamp = System.currentTimeMillis();
			String fileName = timestamp + "_" + originalFilename;

			// 프로젝트 내의 특정 폴더에 파일 저장 (예시: resources/upload 폴더)
			String uploadDir = "src/main/resources/static/image/book/";
			String image = "/image/book/" + fileName;
			String filePath = uploadDir + fileName;

			File imgFile = new File(filePath);

			// 중복 파일이 존재할 경우 덮어쓰기
			if (imgFile.exists()) {
				imgFile.delete();
			}

			FileCopyUtils.copy(fileData, imgFile);

			// Book 객체 생성 및 필드 설정
			Book book = new Book();
			book.setTitle(title);
			book.setAuthor(author);
			book.setPublisher(publisher);
			book.setPublicationDate(sqlDate);
			book.setCategory(category);
			book.setPages(pages);
			book.setImage(image);
			book.setInfo(info);

			// Book 객체를 데이터베이스에 저장
			bookService.insertBook(book);

			return new ResponseDTO<>(HttpStatus.OK.value(), "도서 등록 성공");

		} catch (ParseException e) {
			e.printStackTrace();
			// 날짜 파싱 중 에러가 발생한 경우 예외 처리
			return new ResponseDTO<>(HttpStatus.BAD_REQUEST.value(), "날짜 형식이 올바르지 않습니다.");

		} catch (IOException e) {
			e.printStackTrace();
			// 파일 처리 중 에러가 발생한 경우 예외 처리
			return new ResponseDTO<>(HttpStatus.BAD_REQUEST.value(), "도서 등록 실패");
		}
	}

	@PostMapping("/admin/bookRequest")
	public @ResponseBody ResponseDTO<?> bookRequest(@Valid @RequestBody BookRequestDTO bookDTO,
			BindingResult bindingResult, HttpSession session) {
		Book_request book = modelMapper.map(bookDTO, Book_request.class);

		User user = (User) session.getAttribute("loginUser");
		book.setUser(user);
		bookRequestService.addBook(book);
		return new ResponseDTO<>(HttpStatus.OK.value(), "희망도서 신청 완료");
	}

	@GetMapping("/view/bookRequest")
	public String bookRequest() {
		return "admin/myPage/bookRequest";
	}

	// 도서 신청 상세 페이지
	@GetMapping("/view/requestEdit/{requestNum}")
	public String getBookRequest(@PathVariable int requestNum, Model model) {
		Book_request request = bookRequestService.getBookRequest(requestNum);
		model.addAttribute("request", request);
		return "admin/requestEdit";
	}

	@PutMapping("/admin/requestCheck/{requestNum}")
	public @ResponseBody ResponseDTO<?> updateRequest(@PathVariable int requestNum) {
		Book_request request = bookRequestService.getBookRequest(requestNum);
		request.setRequestStatus(Status.ACCEPTED);
		bookRequestService.updateRequest(request);
		return new ResponseDTO<>(HttpStatus.OK.value(), "도서 신청 확인 완료");
	}

	@PutMapping("/admin/requestCancel/{requestNum}")
	public @ResponseBody ResponseDTO<?> cancelRequest(@PathVariable int requestNum) {
		Book_request request = bookRequestService.getBookRequest(requestNum);
		request.setRequestStatus(Status.DENIED);
		bookRequestService.updateRequest(request);
		return new ResponseDTO<>(HttpStatus.OK.value(), "도서 신청 반려");
	}

	@DeleteMapping("/admin/deleteUser")
	public @ResponseBody ResponseDTO<?> deleteUser(@RequestParam String userid) {
		User user = userService.getUser(userid);
		System.out.println("-----" + user);
		userService.deleteUser(user);
		return new ResponseDTO<>(HttpStatus.OK.value(), "회원 탈퇴가 완료되었습니다. 그동안 이용해주셔서 감사합니다.");
	}
}
