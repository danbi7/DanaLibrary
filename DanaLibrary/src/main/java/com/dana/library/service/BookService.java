package com.dana.library.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

	@Transactional(readOnly = true)
	public Page<Book> getBookList(Pageable pageable) {
		return bookRepository.findAll(pageable);
	}
	
	@Transactional(readOnly = true)
	public Page<Book> searchBookList(String category, String bookTitle,Pageable pageable) {
		return bookRepository.findByCategoryIsAndTitleContaining(category, bookTitle,pageable);
	}
	
	@Transactional(readOnly = true)
	public Page<Book> searchBookByCategory(String category,Pageable pageable) {
		return bookRepository.findByCategory(category,pageable);
	}

	@Transactional(readOnly = true)
	public Page<Book> searchBookByTitle(String title,Pageable pageable) {
		return bookRepository.findByTitleContaining(title,pageable);
	}
		
	@Transactional
	public void insertBook(Book book) {
		bookRepository.save(book);
	}
	
	//대출 횟수 순으로 getBookList
	@Transactional
	public Page<Book> getBookListOrderByRentCount(Pageable pageable){
		return bookRepository.findAllByOrderByRentCountDesc(pageable);
	}
	
	//전체 도서 가져오기
	@Transactional
	public List<Book> getBookAll(){
		return bookRepository.findAll();
	}
	
	//대출 횟수 순으로 제목으로 검색
	@Transactional
	public Page<Book> searchBookByTitleRentCount(String bookTitle, Pageable pageable) {
        return bookRepository.findByTitleContainingOrderByRentCountDesc(bookTitle, pageable);
    }
	
	//대출 횟수 순으로 분류별 검색
	@Transactional
	public Page<Book> searchBookByCategoryRentCount(String category, Pageable pageable) {
        return bookRepository.findByCategoryOrderByRentCountDesc(category, pageable);
    }
	
	@Transactional
	public Page<Book> searchBookListRentCount(String category, String bookTitle, Pageable pageable) {
        return bookRepository.findByCategoryAndTitleContainingOrderByRentCountDesc(category, bookTitle, pageable);
    }
	
	@Transactional
	public void updateBook(Book book) {
		bookRepository.save(book);
	}
	
}
