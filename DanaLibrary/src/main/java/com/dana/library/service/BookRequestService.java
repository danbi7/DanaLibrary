package com.dana.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dana.library.domain.Book_request;
import com.dana.library.persistence.BookRequestRepository;

@Service
public class BookRequestService {
	
	@Autowired
	private BookRequestRepository bookRequestRepository;

	@Transactional
	public void addBook(Book_request book) {
		bookRequestRepository.save(book);
	}

	@Transactional
	public List<Book_request> getBookRequestList() {
		return bookRequestRepository.findAll();
	}

}
