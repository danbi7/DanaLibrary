package com.dana.library.service;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dana.library.domain.Book;
import com.dana.library.domain.Rent;
import com.dana.library.domain.Reserved_book;
import com.dana.library.domain.Status;
import com.dana.library.domain.User;
import com.dana.library.persistence.RentRepository;

@EnableScheduling
@Service
public class RentService {
	@Autowired
	private RentRepository rentRepository;

	@Autowired
	private ReserveService reserveService;

	@Autowired
	private NoticeService noticeService;

	@Transactional(readOnly = true)
	public Rent getRent(Book book) {
		Rent rent = rentRepository.findByBook(book).orElseGet(() -> {
			return new Rent();
		});
		return rent;
	}

	@Transactional
	public void updateRent(Rent rent) {
		rentRepository.save(rent);
	}

	@Transactional
	public void returnBook(Rent rent) {

		rentRepository.save(rent);
	}

	@Transactional(readOnly = true)
	public List<Rent> getRentList() {
		return rentRepository.findAll();
	}

	@Transactional(readOnly = true)
	public List<Rent> getRentList(User user) {
		return rentRepository.findAllByUser(user);
	}

	@Transactional(readOnly = true)
	public List<Rent> getRentList(Status status) {
		return rentRepository.findAllByRentStatus(status);
	}

	@Transactional(readOnly = true)
	public List<Rent> getRentList(Book book) {
		return rentRepository.findAllByBook(book);
	}

	@Transactional
	public List<Rent> getRentBookList() {
		return rentRepository.findAll();
	}

	@Transactional
	public boolean isRentedByUser(User loginUser, Book book) {
		Rent rentedBook = rentRepository.findByUserAndBookAndRentStatus(loginUser, book, Status.ACTIVE)
				.orElseGet(new Supplier<Rent>() {
					public Rent get() {
						return new Rent();
					}
				});

		if (rentedBook.getBook() == null) {
			return false;
		} else {
			return true;
		}
	}

	// 매일 12시에 자동 반납 대상 도서를 자동으로 반납시키는 메소드
	@Scheduled(cron = "0 0 0 * * ?")
	public void autoReturnBooks() {
		List<Rent> rentList = getRentBookList();
		LocalDate today = LocalDate.now();

		Iterator<Rent> iterator = rentList.iterator();
		while (iterator.hasNext()) {
			Rent rent = iterator.next();
			if (rent.getRentStatus().equals(Status.ACTIVE) && rent.getDueDate().isEqual(today)) {
				rent.setRentStatus(Status.INACTIVE);
				updateRent(rent);
				Reserved_book reserve = reserveService.rentedBookInReservedBook(rent.getBook());
				System.out.println("테스트 예약 정보: " + reserve);
				if (reserve != null) {
					noticeService.addNotice(reserve);
				}
				iterator.remove();
			}
		}
	}

	// 자동반납이 안됐을 때 자동반납을 시킨다
	public void autoReturnCheck() {
		List<Rent> rentList = getRentBookList();
		LocalDate today = LocalDate.now();

		Iterator<Rent> iterator = rentList.iterator();
		while (iterator.hasNext()) {
			Rent rent = iterator.next();
			if (rent.getRentStatus().equals(Status.ACTIVE)
					&& (rent.getDueDate().isBefore(today) || rent.getDueDate().isEqual(today))) {
				rent.setRentStatus(Status.INACTIVE);
				updateRent(rent);
				Reserved_book reserve = reserveService.rentedBookInReservedBook(rent.getBook());
				System.out.println("테스트 예약 정보: " + reserve);
				if (reserve != null) {
					noticeService.addNotice(reserve);
				}
				iterator.remove();
			}
		}
	}

	@Transactional
	public boolean isRentedBySomeone(Book book) {
		Rent rentedBook = rentRepository.findByBookAndRentStatus(book, Status.ACTIVE).orElseGet(new Supplier<Rent>() {
			public Rent get() {
				return new Rent();
			}
		});

		if (rentedBook.getBook() == null) {
			return false;
		} else {
			return true;
		}
	}

	@Transactional
	public Rent isRentedByLoginUser(User loginUser, Book book) {
		Rent rentedBook = rentRepository.findByUserAndBookAndRentStatus(loginUser, book, Status.ACTIVE)
				.orElseGet(() -> {
					return new Rent();
				});
		return rentedBook;
	}

	@Transactional
	public Rent rentedBySomeone(Book book) {
		Rent rentedBook = rentRepository.findByBookAndRentStatus(book, Status.ACTIVE).orElseGet(() -> {
			return new Rent();
		});
		return rentedBook;
	}

	@Transactional(readOnly = true)
	public List<Rent> rentedByLoginUser(User user) {
		List<Rent> rentList = rentRepository.findAllByUserAndRentStatus(user, Status.ACTIVE);
		return rentList;
	}

	
	@Transactional(readOnly = true) //빌린 적 있니
	public List<Rent> haveRented(Book book, User user) {
		return rentRepository.findByBookAndUser(book, user);
	}

	@Transactional
	public List<Rent> pastRentList(User user) {
		List<Rent> rentList = rentRepository.findAllByUserAndRentStatus(user, Status.INACTIVE);
		return rentList;
	}

	@Transactional
	public List<Rent> getRentListDESC() {
		List<Rent> rentList = rentRepository.findAll(Sort.by(Sort.Direction.DESC, "rentNum"));
		return rentList;
	}

	
	@Transactional
	public Rent getRent(int rentNum) {
		Rent rent= rentRepository.findById(rentNum).orElse(null);
		return rent;
	}
	
	//3일 연장
	@Transactional
	public void renewalRent(Rent rent) {
		rent.setDueDate(rent.getDueDate().plusDays(3));
		rent.setRenewalStatus(Status.ACTIVE);
	}
}
