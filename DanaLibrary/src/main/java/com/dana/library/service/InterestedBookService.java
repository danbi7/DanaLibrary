package com.dana.library.service;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dana.library.domain.Book;
import com.dana.library.domain.Interested_book;
import com.dana.library.domain.User;
import com.dana.library.persistence.InterestedBookRepository;

@Service
public class InterestedBookService {

	@Autowired
	private InterestedBookRepository interestedBookRepository;

	@Transactional
	public void addInterestedBook(Book book, User loginUser) {
		Interested_book interestedBook = new Interested_book();
		interestedBook.setBook(book);
		interestedBook.setUser(loginUser);

		interestedBookRepository.save(interestedBook);
	}

	@Transactional
	public void removeInterestedBook(Book book, User loginUser) {
		Interested_book interestedBook = interestedBookRepository.findByUserAndBook(loginUser, book).get();

		interestedBookRepository.deleteById(interestedBook.getInterestedNum());
	}

	@Transactional
	public boolean isInterestedByUser(User loginUser, Book book) {
		Interested_book interestedBook = interestedBookRepository.findByUserAndBook(loginUser, book)
				.orElseGet(new Supplier<Interested_book>() {
					public Interested_book get() {
						return new Interested_book();
					}
				});

		if (interestedBook.getBook() == null) {
			return false;
		} else {
			return true;
		}
	}

	@Transactional
	public List<Interested_book> getInterestedBookListByUser(User user) {
		List<Interested_book> interestedBookList = interestedBookRepository.findByUser(user);
		return interestedBookList;
	}

	@Transactional(readOnly = true)
	public Interested_book getInterestedBook(Book book, User loginUser) {
		Interested_book interested_Book = interestedBookRepository.findByUserAndBook(loginUser, book).orElseGet(() -> {
			return new Interested_book();
		});
		return interested_Book;
	}

	@Transactional
	public void updateInterest(Interested_book interestBook) {
		interestedBookRepository.save(interestBook);
	}

	@Transactional
	public void deleteInterest(Book book) {
		interestedBookRepository.deleteByBook(book);
	}

	@Transactional(readOnly = true)
	public List<Interested_book> getInterestList(Book book) {
		return interestedBookRepository.findByBook(book);
	}

	@Transactional
	public void deleteInterest(Book book, User loginUser) {
		interestedBookRepository.deleteByBookAndUser(book, loginUser);
	}
}
