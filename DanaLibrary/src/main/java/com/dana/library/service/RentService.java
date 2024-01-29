package com.dana.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dana.library.domain.Book;
import com.dana.library.domain.Rent;
import com.dana.library.domain.User;
import com.dana.library.persistence.RentRepository;

@Service
public class RentService {
	
	@Autowired
	private RentRepository rentRepository;
	
	@Transactional(readOnly = true)
	public Rent getRent(Book book) {
		Rent rent = rentRepository.findByBook(book).orElseGet(()->{
			return new Rent();
		});
		return rent;
	}
	
	@Transactional
	public void updateRent(Rent rent) {
		rentRepository.save(rent);
	}
	
	@Transactional(readOnly = true)
	public List<Rent> getRentList(User user) {
		return rentRepository.findAllByUser(user);
	}
	
	@Transactional
	public void deleteRent(Book book) {
		rentRepository.deleteByBook(book);
	}

}
