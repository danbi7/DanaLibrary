<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./layout/header1.jsp" %>
<%@ include file="./layout/header2.jsp" %>
	
<div class="container mt-3">

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
      <img src="/image/example.png" alt="Los Angeles" class="d-block" style="width:100%; height: 350px;">
      <div class="carousel-caption">
        <h3>Los Angeles</h3>
        <p>We had such a great time in LA!</p>
      </div>
    </div>
    <div class="carousel-item">
      <img src="/image/image1.jpeg" alt="Chicago" class="d-block" style="width:100%; height: 350px;">
      <div class="carousel-caption">
        <h3>Chicago</h3>
        <p>Thank you, Chicago!</p>
      </div> 
    </div>
    <div class="carousel-item">
      <img src="/image/image1.jpeg" alt="New York" class="d-block" style="width:100%; height: 350px;">
      <div class="carousel-caption">
        <h3>New York</h3>
        <p>We love the Big Apple!</p>
      </div>  
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

<div class="container-main">
<div class="notice-box">
	<h3 class="title blue-line">최근 공지글</h3>
	<ul class="noticeList">
		<li><a href="#">공지글 예시로 아무거나 써봤음</a>
		<span class="date">2024-01-01</span></li>
		<li><a href="#">공지글 예시로 아무거나 써봤음</a>
		<span class="date">2024-01-01</span></li>
		<li><a href="#">공지글 예시로 아무거나 써봤음</a>
		<span class="date">2024-01-01</span></li>
		<li><a href="#">공지글 예시로 아무거나 써봤음</a>
		<span class="date">2024-01-01</span></li>
		<li><a href="#">공지글 예시로 아무거나 써봤음</a>
		<span class="date">2024-01-01</span></li>
	</ul>
</div>
<div class="notice-box">
	<h3 class="title blue-line">인기 게시글</h3>
	<ul class="noticeList">
		<li><a href="#">게시글 예시로 아무거나 써봤음</a>
		<span class="date">2024-01-01</span></li>
		<li><a href="#">게시글 예시로 아무거나 써봤음</a>
		<span class="date">2024-01-01</span></li>
		<li><a href="#">게시글 예시로 아무거나 써봤음</a>
		<span class="date">2024-01-01</span></li>
		<li><a href="#">게시글 예시로 아무거나 써봤음</a>
		<span class="date">2024-01-01</span></li>
		<li><a href="#">게시글 예시로 아무거나 써봤음</a>
		<span class="date">2024-01-01</span></li>
	</ul>
</div>
</div>

<div class="container-main">
<h3>" 다나 도서관의 추천 도서 목록 "</h3>
</div>

<div class="container-main">
<div class="rec-book">
  <img src="/image/book3.png" alt="Card image cap">
  <p>올해의 추천 도서 : <br><strong>물고기는 존재하지 않는다</strong></p> 
</div>

<div class="rec-book">
  <img src="/image/book3.png" alt="Card image cap">
  <p>올해의 추천 도서 : <br><strong>물고기는 존재하지 않는다</strong></p>
</div>

<div class="rec-book">
  <img src="/image/book1.png" alt="Card image cap">
    <p class="card-text">이번달의 신간 도서 : <br><strong>종의 기원</strong></p>
</div>

<div class="rec-book">
  <img src="/image/book2.png" alt="Card image cap">
    <p class="card-text">다나 도서관의 추천 도서 : <br><strong>이기적 유전자</strong></p>
</div>

<div class="rec-book">
  <img src="/image/book4.png" alt="Card image cap">
    <p class="card-text">주목할만한 도서 : <br><strong>데일 카네기-인간관계론</strong></p>
</div>
</div>

<div class="container-main">
<div class="rec-book">
  <img src="/image/book3.png" alt="Card image cap">
  <p>올해의 추천 도서 : <br><strong>물고기는 존재하지 않는다</strong></p> 
</div>

<div class="rec-book">
  <img src="/image/book3.png" alt="Card image cap">
  <p>올해의 추천 도서 : <br><strong>물고기는 존재하지 않는다</strong></p>
</div>

<div class="rec-book">
  <img src="/image/book1.png" alt="Card image cap">
    <p class="card-text">이번달의 신간 도서 : <br><strong>종의 기원</strong></p>
</div>

<div class="rec-book">
  <img src="/image/book2.png" alt="Card image cap">
    <p class="card-text">다나 도서관의 추천 도서 : <br><strong>이기적 유전자</strong></p>
</div>

<div class="rec-book">
  <img src="/image/book4.png" alt="Card image cap">
    <p class="card-text">주목할만한 도서 : <br><strong>데일 카네기-인간관계론</strong></p>
</div>
</div>

<div class="container-main banner">
<img alt="광고" src="/image/advertisement.png">
</div>

</div>
<%@ include file="./layout/footer.jsp" %>