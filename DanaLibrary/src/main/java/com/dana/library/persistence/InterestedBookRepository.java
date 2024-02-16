package com.dana.library.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dana.library.domain.Book;
import com.dana.library.domain.Interested_book;
import com.dana.library.domain.User;

@Repository
public interface InterestedBookRepository extends JpaRepository<Interested_book, Integer>{

	Optional<Interested_book> findByUserAndBook(User loginUser, Book book);

	List<Interested_book> findByUser(User user);

}
