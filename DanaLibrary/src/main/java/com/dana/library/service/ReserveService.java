package com.dana.library.service;

import java.util.Comparator;
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
	
	//회원이 예약한 도서가 존재하는지 여부 확인
	@Transactional
	public boolean isReserved(User user) {
		Reserved_book reservedBook = reserveRepository.findByUser(user).orElseGet(new Supplier<Reserved_book>() {
			public Reserved_book get() {
				return new Reserved_book();
			}
		});

		if (reservedBook.getUser() == null) {
			return false;
		} else {
			return true;
		}
	}

	@Transactional
	public boolean isReservedByUser(User user, Book book) {
		Reserved_book reservedBook = reserveRepository.findByUserAndBook(user, book)
				.orElseGet(new Supplier<Reserved_book>() {
					public Reserved_book get() {
						return new Reserved_book();
					}
				});

		if (reservedBook.getReserveNum() == 0) {
			return false;
		} else {
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
	
	//대출도서중 예약 정보 조회
	@Transactional
	public Reserved_book rentedBookInReservedBook(Book book) {
		List<Reserved_book> reservedBookList=reserveRepository.findAllByBook(book);
		
		 if (!reservedBookList.isEmpty()) {
		        // reserveNum을 기준으로 정렬
		        reservedBookList.sort(Comparator.comparingInt(Reserved_book::getReserveNum));
		        
		        Reserved_book find_reserve = reservedBookList.get(0);
		        return find_reserve;
		    } else {
		        // 처리할 예외 또는 기본값 설정 등
		        return null;
		    }
	}
	
	@Transactional
	public Reserved_book getReserveByUser(User user) {
	    return reserveRepository.findByUser(user).orElseGet(() -> {
	        return null;
	    });
	}
	
	//bookNum으로 예약 정보 검사
	@Transactional
	public Reserved_book getReserve(int bookNum) {
		Reserved_book reserve= reserveRepository.findByBook_BookNum(bookNum);
		return reserve;
	}

	@Transactional
	public int reserveTurn(int bookNum) {
		return reserveRepository.findAllByBook_BookNum(bookNum).size();
	}
	
	@Transactional
	public List<Reserved_book> getResersveList(){
		return reserveRepository.findAll();
	}

}
