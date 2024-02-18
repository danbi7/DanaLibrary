package com.dana.library.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dana.library.domain.Book_request;

@Repository
public interface BookRequestRepository extends JpaRepository<Book_request, Integer>{

}
