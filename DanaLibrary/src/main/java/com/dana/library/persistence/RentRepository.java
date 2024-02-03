package com.dana.library.persistence;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dana.library.domain.Book;
import com.dana.library.domain.Rent;
import com.dana.library.domain.User;

@Repository
public interface RentRepository extends JpaRepository<Rent, Integer>{

	Optional<Rent> findByBook(Book book);
	
	List<Rent> findAllByUser(User user); //select * from Rent where user= ?(로그인 유저랑 같음)
	
	Optional<Rent> findByUserAndBook(User user, Book book);
}
