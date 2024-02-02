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
		rentRepository.save(rent);
	}

	@Transactional(readOnly = true)
	public List<Rent> getRentList(User user) {
		return rentRepository.findAllByUser(user);
	}

	@Transactional
	public List<Rent> getRentBookList() {
		return rentRepository.findAll();
	}

	@Transactional
	public boolean isRentedBySomeone(User loginUser, Book book) {
		Rent rentedBook = rentRepository.findByUserAndBook(loginUser, book).orElseGet(new Supplier<Rent>() {
			public Rent get() {
				return new Rent();
			}
		});

		if (rentedBook.getRentStatus() == null || rentedBook.getRentStatus().equals(Status.INACTIVE)) {
			return false;
		} else if (rentedBook.getRentStatus().equals(Status.ACTIVE)) {
			return true;
		}

		return false;
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
				iterator.remove();
			}
		}
	}
	
	public void autoReturnCheck() {
		List<Rent> rentList = getRentBookList();
		LocalDate today = LocalDate.now();
		
		Iterator<Rent> iterator = rentList.iterator();
		while (iterator.hasNext()) {
			Rent rent = iterator.next();
			if (rent.getRentStatus().equals(Status.ACTIVE) && (rent.getDueDate().isBefore(today) || rent.getDueDate().isEqual(today))) {
                rent.setRentStatus(Status.INACTIVE);
                updateRent(rent);
                iterator.remove();
            }
        }
	}
}
