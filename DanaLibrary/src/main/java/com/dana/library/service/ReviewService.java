package com.dana.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dana.library.domain.Book_review;
import com.dana.library.persistence.ReviewRepository;

@Service
public class ReviewService {
	
	@Autowired
	private ReviewRepository reviewRepository;
	
	@Transactional
	public void insertReview(Book_review review) {
		reviewRepository.save(review);
	}
	
	@Transactional(readOnly = true)
	public List<Book_review> getReviewList() { 
		return reviewRepository.findAll();
	}
	
}
