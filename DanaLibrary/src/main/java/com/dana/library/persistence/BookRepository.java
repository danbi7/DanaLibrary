package com.dana.library.persistence;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dana.library.domain.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

	Optional<Book> findByBookNum(int bookNum);
  
	Page<Book> findByCategoryIsAndTitleContaining(String category, String title,Pageable pageable );

	Page<Book> findByCategory(String category, Pageable pageable);

	Page<Book> findByTitleContaining(String title, Pageable pageable);
	
	
    Page<Book> findAllByOrderByRentCountAsc(Pageable pageable);
    
    Page<Book> findAllByOrderByRentCountDesc(Pageable pageable);

    Page<Book> findByTitleContainingOrderByRentCountDesc(String title, Pageable pageable);

    Page<Book> findByCategoryOrderByRentCountDesc(String category, Pageable pageable);

    Page<Book> findByCategoryAndTitleContainingOrderByRentCountDesc(String category, String title, Pageable pageable);

}
