package com.dana.library.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dana.library.domain.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{

}
