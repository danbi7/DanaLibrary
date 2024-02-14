package com.dana.library.persistence;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dana.library.domain.Book;
import com.dana.library.domain.Book_review;

@Repository
public interface ReviewRepository extends JpaRepository<Book_review, Integer>{

	List<Book_review> findByBookOrderByReviewNumDesc(Book book);
}
