package com.dana.library.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dana.library.domain.Book;
import com.dana.library.persistence.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	@Transactional(readOnly = true)
	public Book getBook(int bookNum) {
		return bookRepository.findByBookNum(bookNum).get();
	}

	public List<Book> getBookList(){
		return bookRepository.findAll();
	}

}
