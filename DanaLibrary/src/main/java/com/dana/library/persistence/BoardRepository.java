package com.dana.library.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dana.library.domain.Board;
import com.dana.library.domain.Category;

@Repository
public interface BoardRepository extends JpaRepository<Board, Integer>{

	List<Board> findByCategoryIsAndTitleContaining(Category category, String title);
	
	List<Board> findByCategory(Category category);
	
	List<Board> findByTitleContaining(String title);

}
