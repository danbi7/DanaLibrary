package com.dana.library.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dana.library.domain.Board;
import com.dana.library.domain.Comment;
import com.dana.library.domain.User;
import com.dana.library.dto.ResponseDTO;
import com.dana.library.service.BoardService;
import com.dana.library.service.CommentService;

import jakarta.servlet.http.HttpSession;

@Controller
public class CommentController {

   @Autowired
   private CommentService commentService;
   
   @Autowired
   private BoardService boardService;
   
   
   
   @PostMapping("/comment/insert/{boardNum}")
   public @ResponseBody ResponseDTO<?> insertComment(@PathVariable int boardNum, @RequestBody Comment comment, HttpSession session) {
      comment.setUser((User) session.getAttribute("loginUser"));
      Board board = boardService.getBoardById(boardNum);
      comment.setBoard(board);
      commentService.insertComment(comment);
      return new ResponseDTO<>(HttpStatus.OK.value(),"댓글 등록 성공");
   }

   @DeleteMapping("/comment/delete/{commentNum}")
   public @ResponseBody ResponseDTO<?> deleteComment(@PathVariable int commentNum, HttpSession session) {
       System.out.println("안녕아아아아아아아아아");
	   User loginUser = (User) session.getAttribute("loginUser");
       Comment comment = commentService.getCommentById(commentNum);
       System.out.println(comment.toString() + "알라알라알라아랄라");
       
       if (comment != null && loginUser != null && comment.getUser().getUserid().equals(loginUser.getUserid())) {
           System.out.println("가나다라마바사아카차ㅏ");
    	   commentService.deleteComment(commentNum);
           return new ResponseDTO<>(HttpStatus.OK.value(), "댓글 삭제 성공");
       } else {
           return new ResponseDTO<>(HttpStatus.BAD_REQUEST.value(), "해당 댓글을 삭제할 수 있는 권한이 없습니다.");
       }

}
}
