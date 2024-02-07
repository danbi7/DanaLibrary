package com.dana.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dana.library.domain.Board;
import com.dana.library.domain.Category;
import com.dana.library.domain.User;
import com.dana.library.dto.ResponseDTO;
import com.dana.library.service.BoardService;

import jakarta.servlet.http.HttpSession;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;

	// 글 등록 페이지
	@GetMapping("/board/view/insertBoard")
	public String insertBoard() {
		return "board/insertBoard";
	}

	// 글 등록 기능
	@PostMapping("/board/writePost")
	public @ResponseBody ResponseDTO<?> writePost(@RequestBody Board board, HttpSession session) {
		System.out.println("board: " + board);
		board.setUser((User) session.getAttribute("loginUser"));
		boardService.writeBoard(board);
		return null;
	}

	// 글 목록 보기 페이지
	@GetMapping("/public/board/view/getBoardList")
	public String getBoardList(@RequestParam(required = false) Category boardCategory, @RequestParam(required = false) String boardTitle, Model model) {

		System.out.println(boardCategory + "???????????");
		System.out.println(boardTitle + "????????????");
		
		List<Board> boardList = null;
		
		if(boardCategory == null && boardTitle == null) {
			boardList = boardService.getBoardList();
			//System.out.println(boardList.size());
		}else if(!boardCategory.equals(Category.TOTAL) && boardTitle == null) {
			boardList = boardService.getBoardList(boardCategory);
			//System.out.println(boardList.size());
		}else if(boardCategory.equals(Category.TOTAL) && boardTitle !=  null) {
			boardList = boardService.getBoardList(boardTitle);
			//System.out.println(boardList.size());
		}else if(!boardCategory.equals(Category.TOTAL) && boardTitle != null) {
			boardList = boardService.getBoardList(boardCategory, boardTitle);
			//System.out.println(boardList.size());
		}
		//List<Board> boardList = boardService.getBoardList();
		System.out.println("boardList: " + boardList);
		model.addAttribute("boardList", boardList);

		return "board/boardList";
	}

	
	// 글 목록 보기 기능 -> 없어도 됨!!!! searchBoard.js도 없어도 됨!!!!
	
	
	// 글 상세 보기 페이지
	@GetMapping("/board/view/getBoard/{boardNum}")
	public String getBoard(@PathVariable int boardNum, Model model) {
		model.addAttribute("board", (Board) boardService.getBoardById(boardNum));
		return "board/board";
	}

	// 글 수정 페이지
	@GetMapping("/board/view/updateBoard/{boardNum}")
	public String updateBoard(@PathVariable int boardNum, Model model) {
		Board board = boardService.getBoardById(boardNum);
		model.addAttribute("board", board);
		return "board/updateBoard";
	}
	
	// 글 수정 기능
	@PutMapping("/board/updateBoard/{boardNum}")
	public @ResponseBody ResponseDTO<?> updatePost(@PathVariable int boardNum, @RequestBody Board board) {
		boardService.updateBoard(board, boardNum);
		return new ResponseDTO<>(HttpStatus.OK.value(), "글 수정 완료");
	}

	// 글 삭제 기능
	@DeleteMapping("/board/deleteBoard/{boardNum}")
	public @ResponseBody ResponseDTO<?> deletePost(@PathVariable int boardNum) {
		boardService.deleteBoard(boardNum);
		return new ResponseDTO<>(HttpStatus.OK.value(), "글 삭제 컨트롤러 실행");
	}
}

