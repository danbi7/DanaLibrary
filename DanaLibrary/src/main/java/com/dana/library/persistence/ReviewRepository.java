package com.dana.library.persistence;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dana.library.domain.Book_review;

@Repository
public interface ReviewRepository extends JpaRepository<Book_review, Integer>{

}
