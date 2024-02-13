package com.dana.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dana.library.domain.Board;

import com.dana.library.domain.Comment;
import com.dana.library.persistence.CommentRepository;

@Service
public class CommentService {

	@Autowired
	private CommentRepository commentRepository;

	@Transactional
	public Comment insertComment(Comment comment) {
		return commentRepository.save(comment);
	}

	@Transactional
	public void deleteComment(int commentId) {
		commentRepository.deleteById(commentId);
	}

	public List<Comment> getComment(Board board) {
		return commentRepository.findAllByBoard(board);
	}
	
    public Comment getCommentById(int commentNum) {
        return commentRepository.findById(commentNum).orElse(null);
    }

}
