package com.dana.library.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dana.library.domain.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer>{

}
