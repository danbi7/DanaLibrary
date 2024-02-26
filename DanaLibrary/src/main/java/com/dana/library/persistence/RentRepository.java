package com.dana.library.persistence;


import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dana.library.domain.Book;
import com.dana.library.domain.Rent;
import com.dana.library.domain.Status;
import com.dana.library.domain.User;

@Repository
public interface RentRepository extends JpaRepository<Rent, Integer> {

	Optional<Rent> findByBook(Book book);
	
	//List<Rent> findAllByUser(User user); //select * from Rent where user= ?(로그인 유저랑 같음)
	
	//List<Rent> findAllByRentStatus(Status status);
	
	//List<Rent> findAllByBook(Book book);
	
	List<Rent> findAllByUserAndRentStatus(User user, Status rentStatus);
	
	Optional<Rent> findByUserAndBookAndRentStatus(User user, Book book, Status rentStatus);

	Optional<Rent> findByBookAndRentStatus(Book book, Status rentStatus);
	
	List<Rent> findByBookAndUser(Book book, User user); //빌린 적 있는지

}
