package com.dana.library.service;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dana.library.domain.Book;
import com.dana.library.domain.Reserved_book;
import com.dana.library.domain.User;
import com.dana.library.persistence.ReserveRepository;

@Service
public class ReserveService {
	
	@Autowired
	private ReserveRepository reserveRepository;
	
	@Transactional
	public boolean isReserved(User user) {
		// 로그인된 유저가 이미 예약한 도서가 존재하는지 여부 확인 과정
		Reserved_book reservedBook = reserveRepository.findByUser(user).orElseGet(new Supplier<Reserved_book>(){
			public Reserved_book get() {
				return new Reserved_book();
			}
		});
	
		if(reservedBook.getUser() == null) {
			return false;
		}else {
			return true;
		}
	}
	
	@Transactional
	public boolean isReservedByUser(User user, Book book) {
		Reserved_book reservedBook = reserveRepository.findByUserAndBook(user, book).orElseGet(new Supplier<Reserved_book>(){
			public Reserved_book get() {
				return new Reserved_book();
			}
		});
		
		if(reservedBook.getReserveNum() == 0) {
			return false;
		}else {
			return true;
		}
	}

	@Transactional
	public void reserveBook(Reserved_book reserve) {
		reserveRepository.save(reserve);
	}

	@Transactional
	public void cancelReservation(Reserved_book reserve) {
		reserveRepository.delete(reserveRepository.findByUserAndBook(reserve.getUser(), reserve.getBook()).get());
	}

	@Transactional
	public List<Reserved_book> getReservedBookList(Book book) {
		List<Reserved_book> reservedBookList = reserveRepository.findAllByBook(book);
		return reservedBookList;
			
	}

}