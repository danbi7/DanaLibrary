<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="./layout/header1.jsp" %>
<%@ include file="./layout/header2.jsp" %>
	
<div class="container mb-3">

<!-- Carousel -->
<div id="demo" class="carousel slide" data-bs-ride="carousel">

  <!-- Indicators/dots -->
  <div class="carousel-indicators">
    <button type="button" data-bs-target="#demo" data-bs-slide-to="0" class="active"></button>
    <button type="button" data-bs-target="#demo" data-bs-slide-to="1"></button>
    <button type="button" data-bs-target="#demo" data-bs-slide-to="2"></button>
  </div>
  
  <!-- The slideshow/carousel -->
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src="/image/slide-1.png" alt="Los Angeles" class="d-block" style="width:100%; height: 350px;">
    </div>
    <div class="carousel-item">
      <img src="/image/slide-2.png" alt="Chicago" class="d-block" style="width:100%; height: 350px;">
    </div>
    <div class="carousel-item">
      <img src="/image/slide-3.png" alt="New York" class="d-block" style="width:100%; height: 350px;">
    </div>
  </div>
  
  <!-- Left and right controls/icons -->
  <button class="carousel-control-prev" type="button" data-bs-target="#demo" data-bs-slide="prev">
    <span class="carousel-control-prev-icon"></span>
  </button>
  <button class="carousel-control-next" type="button" data-bs-target="#demo" data-bs-slide="next">
    <span class="carousel-control-next-icon"></span>
  </button>
</div>

<div class="container-main my-4">
<div class="notice-box">

	<h3 class="title blue-line"><a href="/public/board/view/getBoardList">공지글</a></h3>
	<ul class="noticeList">
        <c:forEach var="board" items="${recentNoticeBoard}">
		<li><a href="/board/view/getBoard/${board.boardNum }">${board.title }</a>
		<span class="date">${board.regDate }</span></li>
		</c:forEach>
	</ul>
</div>
<div class="notice-box">
	<h3 class="title blue-line"><a href="/public/board/view/getBoardList">게시글</a></h3>
	<ul class="noticeList">
		<c:forEach var="board" items="${recentFreeBoard}">
		<li><a href="/board/view/getBoard/${board.boardNum }">${board.title }</a>
		<span class="date">${board.regDate }</span></li>
		</c:forEach>
	</ul>
</div>
</div>

<div class="my-4 overflow-auto">
<h3 class="text-center">" 다나 도서관의 추천 도서 목록 "</h3>

<div class="container-main my-4">
<div class="book-container">
<img src="/image/book/fish.jpg">
	<p class="card-text"><strong>물고기는 존재하지 않는다.</strong></p>
</div>
<div class="book-container">
<img src="/image/book/fish.jpg">
	<p class="card-text"><strong>물고기는 존재하지 않는다.</strong></p>
</div>
<div class="book-container">
<img src="/image/book/fish.jpg">
	<p class="card-text"><strong>물고기는 존재하지 않는다.</strong></p>
</div>
<div class="book-container">
<img src="/image/book/fish.jpg">
	<p class="card-text"><strong>물고기는 존재하지 않는다.</strong></p>
</div>
<div class="book-container">
<img src="/image/book/fish.jpg">
	<p class="card-text"><strong>물고기는 존재하지 않는다.</strong></p>
</div>
</div>

<div class="container-main my-4">
<div class="book-container">
<img src="/image/book/fish.jpg">
	<p class="card-text"><strong>물고기는 존재하지 않는다.</strong></p>
</div>
<div class="book-container">
<img src="/image/book/fish.jpg">
	<p class="card-text"><strong>물고기는 존재하지 않는다.</strong></p>
</div>
<div class="book-container">
<img src="/image/book/fish.jpg">
	<p class="card-text"><strong>물고기는 존재하지 않는다.</strong></p>
</div>
<div class="book-container">
<img src="/image/book/fish.jpg">
	<p class="card-text"><strong>물고기는 존재하지 않는다.</strong></p>
</div>
<div class="book-container">
<img src="/image/book/fish.jpg">
	<p class="card-text"><strong>물고기는 존재하지 않는다.</strong></p>
</div>
</div>
</div>

<div class="container-main justify-content-center my-4">
<img alt="광고" src="/image/advertisement.png">
</div>
</div>
<%@ include file="./layout/footer.jsp" %>