package com.dana.library.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dana.library.domain.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

	Optional<Book> findByBookNum(int bookNum);

	List<Book> findByCategoryIsAndTitleContaining(String category, String title);

	List<Book> findByCategory(String category);

	List<Book> findByTitleContaining(String title);	
	
}
