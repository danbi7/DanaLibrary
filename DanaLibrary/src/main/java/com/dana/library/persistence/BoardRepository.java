package com.dana.library.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dana.library.domain.Board;
import com.dana.library.domain.Category;

@Repository
public interface BoardRepository extends JpaRepository<Board, Integer>{

	/*
	List<Board> findByCategoryIsAndTitleContaining(Category category, String title);
	
	List<Board> findByCategory(Category category);
	
	List<Board> findByTitleContaining(String title);
	*/
	Page<Board> findByCategoryIsAndTitleContaining(Category category, String title,Pageable pageable);
	
	Page<Board> findByCategory(Category category,Pageable pageable);
	
	Page<Board> findByTitleContaining(String title,Pageable pageable);


}
