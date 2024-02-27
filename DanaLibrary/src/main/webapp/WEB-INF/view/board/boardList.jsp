<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.dana.library.domain.*" %>

<%@ include file="../layout/header1.jsp" %>
<%@ include file="../layout/header2.jsp" %>


<div class="container-boardList mt-4" align="center">
<div class="row justify-content-between">

<div class="boardList-icon text-center">
<img src="/image/icon/icon-board.png"><h5><strong>열린 마당</strong></h5></div>

  <div class="col-md-6 text-center">
<form action="/public/board/view/getBoardList">
    <div class="d-flex">
      <div class="dropdown">
    <select name="boardCategory" class="btn btn-outline-primary dropdown-toggle" aria-label="Dropdown" id="category1" style="height: 100%">
              <c:forEach var="category" items="${Category.values()}">
                  <option value="${category}">${category.category }</option>
                  </c:forEach>
    </select>
</div>


      <input class="form-control me-2" type="text" placeholder="검색어를 입력하세요" name="boardTitle">
      <button type="submit" class="btn" type="button" style="padding: 0px"><img src="/image/icon/search.png"></button>
    </div>
</form>
  </div>
  
  

  <a href="/board/view/insertBoard" id="insertButton"><img src="/image/icon/icon-edit-button.png">새 글 등록</a>
  
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
		<th>추천</th>
	</tr>
	
	<c:forEach items="${boardList.content }" var="boardList">
	<tr>
		<td>${boardList.boardNum }</td>
		<td style="overflow: hidden; white-space: nowrap; text-overflow: ellipsis;"><a class="btn-increase"
               data-comment-num="${boardList.boardNum}">${boardList.title}</a></td>
		<td>${boardList.user.userid }</td>
		<td>${boardList.category.category }</td>
		<td>${boardList.regDate }</td>
		<td>${boardList.views }</td>
		<td>${boardList.likes }</td>
	</tr>
	</c:forEach>
	
  </table>
  </div>
  
  <script src="/js/board/increaseViews.js"></script>
  
  <div class="mt-2">
<c:choose>
	<c:when test="${boardList.first }">
		<a class="btn btn-secondary">이전</a>
	</c:when>
	<c:otherwise>
		<a href="?page=${boardList.number-1 }" class="btn btn-primary">이전</a>
	</c:otherwise>
</c:choose>

<c:forEach begin="${startPage }" end="${endPage }" var="i">
<c:choose>
<c:when test="${nowPage == i }">
<a href="/public/board/view/getBoardList?page=${i-1}" class="btn">${i }</a>
</c:when>
<c:otherwise>

<a href="/public/board/view/getBoardList?page=${i-1}" class="btn">${i }</a>
</c:otherwise>
</c:choose>

</c:forEach>

<c:choose>
	<c:when test="${boardList.last }">
		<a class="btn btn-secondary">다음</a>
	</c:when>
	<c:otherwise>
		<a href="?page=${boardList.number+1 }" class="btn btn-primary">다음</a>
	</c:otherwise>
</c:choose>
</div>
</div>

<%@ include file="../layout/footer.jsp" %>