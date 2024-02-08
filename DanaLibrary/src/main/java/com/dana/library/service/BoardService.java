package com.dana.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dana.library.domain.Board;
import com.dana.library.domain.Category;
import com.dana.library.persistence.BoardRepository;

@Service
public class BoardService {
	
	@Autowired
	private BoardRepository boardRepository;
	
	@Transactional(readOnly = true)
	public List<Board> getBoardList(){
		return boardRepository.findAll();
	}
	/*
	@Transactional(readOnly = true)
	public List<Board> getBoardList(Category category){
		return boardRepository.findByCategory(category);
	}
	
	@Transactional(readOnly = true)
	public List<Board> getBoardList(String title){
		return boardRepository.findByTitleContaining(title);
	}
	
	@Transactional(readOnly = true)
	public List<Board> getBoardList(Category category, String title) {
		return boardRepository.findByCategoryIsAndTitleContaining(category, title);
	}
	*/
	
	//페이징
		@Transactional(readOnly = true)
		public Page<Board> getBoardList(Pageable pageable){
			return boardRepository.findAll(pageable);
		}
		@Transactional(readOnly = true)
		public Page<Board> getBoardList(Category category,Pageable pageable){
			return boardRepository.findByCategory(category,pageable);
		}
		
		@Transactional(readOnly = true)
		public Page<Board> getBoardList(String title,Pageable pageable){
			return boardRepository.findByTitleContaining(title,pageable);
		}
		
		@Transactional(readOnly = true)
		public Page<Board> getBoardList(Category category, String title,Pageable pageable) {
			return boardRepository.findByCategoryIsAndTitleContaining(category, title,pageable);
		}
	

	@Transactional
	public void writeBoard(Board board) {
		boardRepository.save(board);
	}

	@Transactional
	public void updateBoard(Board requestBoard, int boardNum) {
		Board board = boardRepository.findById(boardNum).orElse(null);
		board.setTitle(requestBoard.getTitle());
		board.setContent(requestBoard.getContent());
		board.setCategory(requestBoard.getCategory());
		boardRepository.save(board);
	}

	@Transactional
	public Board getBoardById(int boardNum) {
		return boardRepository.findById(boardNum).orElse(null);

	}

	@Transactional
	public void deleteBoard(int boardNum) {
		boardRepository.deleteById(boardNum);
	}

}
