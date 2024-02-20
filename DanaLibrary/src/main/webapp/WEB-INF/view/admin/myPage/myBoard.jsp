<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.dana.library.domain.*" %>
<div class="container"> 
     
  <table class="table table-hover mt-3">
  <thead>
	<tr>
		<th width="100px">번호</th>
		<th width="300px">제목</th>
		<th>작성자</th>
		<th>카테고리</th>
		<th>작성일</th>
		<th>조회수</th>
		<th>추천수</th>
	</tr>
	</thead>
	
	<tbody>
	<c:forEach items="${myBoardList }" var="myBoard">
	<tr>
		<td>${myBoard.boardNum }</td>
		<td><a href="/board/view/getBoard/${myBoard.boardNum }">${myBoard.title }</a></td>
		<td>${myBoard.user.userid }</td>
		<td>${myBoard.category.category }</td>
		<td>${myBoard.regDate }</td>
		<td>${myBoard.views }</td>
		<td>${myBoard.likes }</td>
	</tr>
	</c:forEach>
	</tbody>
	
  </table>
  </div>
 