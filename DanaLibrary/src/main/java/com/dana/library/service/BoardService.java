package com.dana.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dana.library.domain.Board;
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
	public List<Board> getBoardList(Category category, String keyword){
		System.out.println("222222");
		System.out.println(category + "22222" + keyword);
		return boardRepository.findAllByCategoryAndTitle(category, keyword);
	}
	*/
	@Transactional(readOnly = true)
	public List<Board> getBoardList(Board board){
		System.out.println("222222");
		System.out.println(board.getCategory() + "22222" + board.getTitle());
		
		List<Board> aaaa = boardRepository.findAllByCategoryAndTitle(board.getCategory(), board.getTitle());
		
		System.out.println("aaaa" + aaaa.toString());
		
		return aaaa;
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
