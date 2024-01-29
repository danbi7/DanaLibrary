package com.dana.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.dana.library.domain.Board;
import com.dana.library.service.BoardService;

import jakarta.servlet.http.HttpSession;

@Controller
public class BoardController {
	
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/board/getBoardList")
	public String getBoardList(Model model) {
		
		List<Board> boardList = boardService.getBoardList();
		System.out.println("boardList: " + boardList);
		model.addAttribute("boardList", boardList);
		
		return "board/boardList";
	}
	
	@PostMapping("/board/getBoardList")
	public String searchBoard(@RequestBody Board board, Model model) {
		System.out.println(board.getCategory() + " " + board.getTitle());
		
		List<Board> boardList = boardService.getBoardList(board);
		
		System.out.println(boardList);
		
		model.addAttribute("boardList", boardList);
		
		System.out.println("1111111");
		
		return "board/boardList";
	}
	

}
