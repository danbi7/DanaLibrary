package com.dana.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dana.library.domain.Board;
import com.dana.library.domain.Comment;
import com.dana.library.domain.User;
import com.dana.library.dto.ResponseDTO;
import com.dana.library.service.BoardService;
import com.dana.library.service.CommentService;

import jakarta.servlet.http.HttpSession;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@Autowired
	private CommentService commentService;

	// 글 등록 페이지
	@GetMapping("/board/view/insertBoard")
	public String insertBoard() {
		return "board/insertBoard";
	}

	// 글 등록 기능
	@PostMapping("/board/writePost")
	public @ResponseBody ResponseDTO<?> writePost(@RequestBody Board board, HttpSession session) {
		System.out.println("board: " + board);
		board.setUser((User) session.getAttribute("loginUser"));
		boardService.writeBoard(board);
		return null;
	}

	// 글 목록 보기 페이지
	@GetMapping("/board/view/getBoardList")
	public String getBoardList(Model model) {

		List<Board> boardList = boardService.getBoardList();
		System.out.println("boardList: " + boardList);
		model.addAttribute("boardList", boardList);

		return "board/boardList";
	}

	// 글 목록 보기 기능
	@PostMapping("/board/getBoardList")
	public String searchBoard(@RequestBody Board board, Model model) {
		System.out.println(board.getCategory() + " " + board.getTitle());

		List<Board> boardList = boardService.getBoardList(board);

		System.out.println(boardList);

		model.addAttribute("boardList", boardList);

		System.out.println("1111111");

		return "board/boardList";
	}

	// 글 상세 보기 페이지
	@GetMapping("/board/view/getBoard/{boardNum}")
	public String getBoard(@PathVariable int boardNum, Model model) {
	    Board board = boardService.getBoardById(boardNum);
	    model.addAttribute("board", board);
	    
	    List<Comment> commentList = commentService.getComment(board);
	    model.addAttribute("commentList", commentList);
	    System.out.println(commentList.toString());
	    
	    return "board/board";
	}
	

	// 글 수정 페이지
	@GetMapping("/board/view/updateBoard/{boardNum}")
	public String updateBoard(@PathVariable int boardNum, Model model) {
		Board board = boardService.getBoardById(boardNum);
		model.addAttribute("board", board);
		return "board/updateBoard";
	}

	// 글 수정 기능
	@PutMapping("/board/updateBoard/{boardNum}")
	public @ResponseBody ResponseDTO<?> updatePost(@PathVariable int boardNum, @RequestBody Board board) {
		boardService.updateBoard(board, boardNum);
		return new ResponseDTO<>(HttpStatus.OK.value(), "글 수정 완료");
	}

	// 글 삭제 기능
	@DeleteMapping("/board/deleteBoard/{boardNum}")
	public @ResponseBody ResponseDTO<?> deletePost(@PathVariable int boardNum) {
		boardService.deleteBoard(boardNum);
		return new ResponseDTO<>(HttpStatus.OK.value(), "글 삭제 컨트롤러 실행");
	}


}