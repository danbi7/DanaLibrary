package com.dana.library.service;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dana.library.domain.Book;
import com.dana.library.domain.Rent;
import com.dana.library.domain.Status;
import com.dana.library.domain.User;
import com.dana.library.persistence.RentRepository;

@EnableScheduling
@Service
public class RentService {
	@Autowired
	private RentRepository rentRepository;

	@Transactional(readOnly = true)
	public Rent getRent(Book book) {
		Rent rent = rentRepository.findByBook(book).orElseGet(() -> {
			return new Rent();
		});
		return rent;
	}

	@Transactional
	public void updateRent(Rent rent) {
		
		rent.setRentStatus(Status.ACTIVE);
		LocalDate rentDate = LocalDate.now();
		LocalDate dueDate = LocalDate.now().plusDays(7);
		rent.setRentDate(rentDate);
		rent.setDueDate(dueDate);
		
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
		Rent rentedBook = rentRepository.findByUserAndBookAndRentStatus(loginUser, book, Status.ACTIVE).orElseGet(new Supplier<Rent>() {
			public Rent get() {
				return new Rent();
			}
		});

		if(rentedBook.getBook() == null) {
			return false;
		}else {
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
				//반납 후 예약이 걸려있는지 확인해서 걸려있으면 알림을 보내는 메소드 호출
				iterator.remove();
			}
		}
	}
	
	//자동반납이 안됐을 때 자동반납을 시킨다
	public void autoReturnCheck() {
		List<Rent> rentList = getRentBookList();
		LocalDate today = LocalDate.now();
		
		Iterator<Rent> iterator = rentList.iterator();
		while (iterator.hasNext()) {
			Rent rent = iterator.next();
			if (rent.getRentStatus().equals(Status.ACTIVE) && (rent.getDueDate().isBefore(today) || rent.getDueDate().isEqual(today))) {
                rent.setRentStatus(Status.INACTIVE);
                updateRent(rent);
                //반납 후 예약이 걸려있는지 확인해서 걸려있으면 알림을 보내는 메소드 호출
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

		if(rentedBook.getBook() == null) {
			return false;
		}else {
			return true;
		}
	}

	@Transactional
	public Rent isRentedByLoginUser(User loginUser, Book book) {
		Rent rentedBook = rentRepository.findByUserAndBookAndRentStatus(loginUser, book, Status.ACTIVE).orElseGet(() -> {
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
	public List<Rent> rentedByLoginUser(User loginUser) {
		List<Rent> rentList = rentRepository.findAllByUserAndRentStatus(loginUser, Status.ACTIVE);
		return rentList;
	}
}
