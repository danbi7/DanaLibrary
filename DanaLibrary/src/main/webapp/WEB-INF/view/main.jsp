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
<a href="/book/getBook/8"><img src="/image/book/fish.jpg"></a>
	<p class="card-text"><strong><a href="/book/getBook/8">물고기는 존재하지 않는다</a></strong></p>
</div>
<div class="book-container">
<a href="/book/getBook/27"><img src="/image/book/1708927181950_powerofmath.jpg"></a>
	<p class="card-text"><strong><a href="/book/getBook/27">수학의 힘</a></strong></p>
</div>
<div class="book-container">
<a href="/book/getBook/55"><img src="/image/book/1708929841371_XL(19).jpg"></a>
	<p class="card-text"><strong><a href="/book/getBook/55">사라진 것들</a></strong></p>
</div>
<div class="book-container">
<a href="/book/getBook/66"><img src="/image/book/1708930261425_guedo.jpg"></a>
	<p class="card-text"><strong><a href="/book/getBook/66">과학이 필요한 시간</a></strong></p>
</div>
<div class="book-container">
<a href="/book/getBook/68"><img src="/image/book/1709011608540_4walls.jpg"></a>
	<p class="card-text"><strong><a href="/book/getBook/68">제 4의 벽</a></strong></p>
</div>
</div>

<div class="container-main my-4">
<div class="book-container">
<a href="/book/getBook/9"><img src="/image/book/cosmos.jpg"></a>
	<p class="card-text"><strong><a href="/book/getBook/9">코스모스</a></strong></p>
</div>
<div class="book-container">
<a href="/book/getBook/12"><img src="/image/book/TheStroryOfUsAll.jpg"></a>
	<p class="card-text"><strong><a href="/book/getBook/12">이주하는 인류 - 인구의 대이동과 그들이 써내려간 역동의 세계사</a></strong></p>
</div>
<div class="book-container">
<a href="/book/getBook/43"><img src="/image/book/1708928826819_XL(15).jpg"></a>
	<p class="card-text"><strong><a href="/book/getBook/43">금과 부동산이 100% 오를 때, 200% 오른 수익률 1위 해외 ETF 백과사전</a></strong></p>
</div>
<div class="book-container">
<a href="/book/getBook/81"><img src="/image/book/1709012384959_selfishgene.jpg"></a>
	<p class="card-text"><strong><a href="/book/getBook/81">이기적 유전자</a></strong></p>
</div>
<div class="book-container">
<a href="/book/getBook/46"><img src="/image/book/1708929013029_ban.jpg"></a>
	<p class="card-text"><strong><a href="/book/getBook/46">반도체 구조 원리 교과서</a></strong></p>
</div>
</div>
</div>

<div class="container-main justify-content-center" style="margin-top: 80px;">
<a href="https://gp.ezenac.co.kr/ezen/curriculum/?idx=1824" target="_blank"><img alt="광고" src="/image/ezen.png"></a>
</div>
</div>
<%@ include file="./layout/footer.jsp" %>