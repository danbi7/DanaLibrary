package com.dana.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dana.library.domain.Comment;
import com.dana.library.persistence.CommentRepository;

@Service
public class CommentService {

	@Autowired
	private CommentRepository commentReository;

	public Comment registerComment(Comment comment) {
		return commentReository.save(comment);
	}
}
