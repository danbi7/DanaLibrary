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
      <a href="/view/libraryInfo"><img src="/image/slide-1.png" alt="library information" class="d-block" style="width:100%; height: 350px;"></a>
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

<div class="container-main" style="margin-top: 40px;">
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

<div class="overflow-auto" style="margin-top: 80px;">
<h3 class="text-center mb-2">" 다나 도서관의 추천 도서 목록 "</h3>
<p class="text-center mb-4">2024 화제의 eBook! 다나 도서관이 엄선한 도서 10선</p>

<div class="container-main" style="margin-top: 30px;">
<div class="book-container">
<img src="/image/book/fish.jpg">
	<p class="card-text"><strong>물고기는 존재하지 않는다</strong></p>
</div>
<div class="book-container">
<img src="/image/book/eternal.jpg">
	<p class="card-text"><strong>영원한 현재의 철학</strong></p>
</div>
<div class="book-container">
<img src="/image/book/knowledge0.jpg">
	<p class="card-text"><strong>지적 대화를 위한 넓고 얕은 지식 0</strong></p>
</div>
<div class="book-container">
<img src="/image/book/knowledge1.jpg">
	<p class="card-text"><strong>지적 대화를 위한 넓고 얕은 지식 1</strong></p>
</div>
<div class="book-container">
<img src="/image/book/knowledge2.jpg">
	<p class="card-text"><strong>지적 대화를 위한 넓고 얕은 지식 2</strong></p>
</div>
</div>

<div class="container-main my-4">
<div class="book-container">
<img src="/image/book/medicalbest.jpg">
	<p class="card-text"><strong>의학의 대가들</strong></p>
</div>
<div class="book-container">
<img src="/image/book/selfishgene.jpg">
	<p class="card-text"><strong>이기적 유전자</strong></p>
</div>
<div class="book-container">
<img src="/image/book/show.jpg">
	<p class="card-text"><strong>쇼펜하우어의 인생 수업</strong></p>
</div>
<div class="book-container">
<img src="/image/book/wing.jpg">
	<p class="card-text"><strong>날개가 전해 준 것</strong></p>
</div>
<div class="book-container">
<img src="/image/book/nietzsche.jpg">
	<p class="card-text"><strong>니체의 말</strong></p>
</div>
</div>
</div>

<div class="container-main justify-content-center" style="margin-top: 80px;">
<a href="https://gp.ezenac.co.kr/ezen/curriculum/?idx=1824" target="_blank"><img alt="광고" src="/image/ezen.png"></a>
</div>
</div>
<%@ include file="./layout/footer.jsp" %>