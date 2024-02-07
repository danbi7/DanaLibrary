<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.dana.library.domain.*" %>

<%@ include file="../layout/header1.jsp" %>
<%@ include file="../layout/header2.jsp" %>

<div class="container-boardList mt-4">
<div class="row justify-content-between">

<div class="boardList-icon text-center">
<img src="/image/icon/icon-board.png"><h5><strong>열린 마당</strong></h5></div>

  <div class="col-md-6 text-center">
<form action="/board/view/getBoardList">
    <div class="d-flex">
      <div class="dropdown">
    <select name="boardCategory" class="btn btn-outline-primary dropdown-toggle" aria-label="Dropdown" id="category1" style="height: 100%">
              <c:forEach var="category" items="${Category.values()}">
                  <option value="${category}">${category.category }</option>
                  </c:forEach>
    </select>
</div>


      <input class="form-control" type="text" placeholder="Search" name="boardTitle">
      <button type="submit" class="btn" type="button"><img src="/image/icon/search.png"></button>
    </div>
</form>
  </div>

  <a href="/board/view/insertBoard" class="btn btn-outline-primary" id="insertButton">새글 등록</a>
  
</div>
<script src="/js/board/searchBoard.js"></script>

<div class="mt-3" style="border-top: 7px solid #205295; padding-top: 20px"> 
     
  <table class="table table-hover">
	<tr>
		<th width="100px">번호</th>
		<th width="300px">제목</th>
		<th>작성자</th>
		<th>카테고리</th>
		<th>작성일</th>
		<th>조회수</th>
		<th>추천수</th>
	</tr>
	
	<c:forEach items="${boardList }" var="boardList">
	<tr>
		<td>${boardList.boardNum }</td>
		<td><a href="/board/view/getBoard/${boardList.boardNum }">${boardList.title }</a></td>
		<td>${boardList.user.userid }</td>
		<td>${boardList.category.category }</td>
		<td>${boardList.regDate }</td>
		<td>${boardList.views }</td>
		<td>${boardList.likes }</td>
	</tr>
	</c:forEach>
	
  </table>
</div>
</div>

<%@ include file="../layout/footer.jsp" %>