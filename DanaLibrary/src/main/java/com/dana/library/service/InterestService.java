package com.dana.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dana.library.domain.Book;
import com.dana.library.domain.Interested_book;
import com.dana.library.domain.User;
import com.dana.library.persistence.InterestRepository;

@Service
public class InterestService {
	
	@Autowired
	private InterestRepository interestRepository;
	
	@Transactional(readOnly = true)
	public Interested_book getInterestedBook(Book book, User loginUser) {
		Interested_book interested_Book = interestRepository.findByBookAndUser(book, loginUser).orElseGet(() -> {
			return new Interested_book();
		});
		return interested_Book;
	}
	
	@Transactional
	public void updateInterest(Interested_book interestBook) {
		interestRepository.save(interestBook);
	}
	
	@Transactional
	public void deleteInterest(Book book) {
		interestRepository.deleteByBook(book);
	}
	
	@Transactional(readOnly = true)
	public List<Interested_book> getInterestList(){
		return interestRepository.findAll();
	}

}
