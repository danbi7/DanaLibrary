package com.dana.library.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dana.library.domain.Board;
import com.dana.library.domain.Category;
import com.dana.library.domain.Likes;
import com.dana.library.domain.User;
import com.dana.library.persistence.BoardRepository;
import com.dana.library.persistence.LikesRepository;

@Service
public class BoardService {

	@Autowired
	private BoardRepository boardRepository;

	@Autowired
	private LikesRepository likesRepository;

	@Transactional(readOnly = true)
	public List<Board> getBoardList() {
		return boardRepository.findAll();
	}

	// 페이징
	@Transactional(readOnly = true)
	public Page<Board> getBoardList(Pageable pageable) {
		return boardRepository.findAll(pageable);
	}

	@Transactional(readOnly = true)
	public Page<Board> getBoardList(Category category, Pageable pageable) {
		return boardRepository.findByCategory(category, pageable);
	}

	@Transactional(readOnly = true)
	public Page<Board> getBoardList(String title, Pageable pageable) {
		return boardRepository.findByTitleContaining(title, pageable);
	}

	@Transactional(readOnly = true)
	public Page<Board> getBoardList(Category category, String title, Pageable pageable) {
		return boardRepository.findByCategoryIsAndTitleContaining(category, title, pageable);
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
		board.setUpdateDate(new Date(System.currentTimeMillis()));
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

	@Transactional
	public void increaseViews(Board board) {
		board.setViews(board.getViews() + 1);
		boardRepository.save(board);
	}

	@Transactional
	public void likesBoard(Likes likes) {
		likesRepository.save(likes);
	}

	@Transactional
	public Likes getLikesByUserNumAndBoardNum(User userNum, Board boardNum) {
		return likesRepository.findByUserNumAndBoardNum(userNum, boardNum).orElse(null);
	}

	@Transactional
	public int getLikesCount(Board boardNum) {
		return likesRepository.countByBoardNum(boardNum);
	}

	@Transactional
	public void increaseLikes(Board board, int likesCount) {
		board.setLikes(likesCount);
		boardRepository.save(board);
	}

	@Transactional
	public List<Board> getBoardListDESC() {
		List<Board> boardList = boardRepository.findAll(Sort.by(Sort.Direction.DESC, "boardNum"));
		return boardList;
	}

	@Transactional
	public List<Board> getRecentNoticeBoard() {
		List<Board> recentNoticeBoard = boardRepository.findTop5ByCategoryOrderByBoardNumDesc(Category.NOTICE);
		return recentNoticeBoard;
	}

	@Transactional
	public List<Board> getRecentFreeBoard() {
		List<Board> recentFreeBoard = boardRepository.findTop5ByCategoryNotOrderByBoardNumDesc(Category.NOTICE);
		return recentFreeBoard;
	}

	@Transactional
	public List<Board> getMyBoardList(User loginUser) {
		List<Board> myBoard = boardRepository.findByUser(loginUser);
		return myBoard;
	}
}
