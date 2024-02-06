package com.dana.library.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dana.library.domain.Book;
import com.dana.library.domain.Reserved_book;
import com.dana.library.domain.User;

public interface ReserveRepository extends JpaRepository<Reserved_book, Integer>{
	Optional<Reserved_book> findByUser(User user);
	
	Optional<Reserved_book> findByUserAndBook(User user, Book book);
	
	List<Reserved_book> findAllByBook(Book book);
}
