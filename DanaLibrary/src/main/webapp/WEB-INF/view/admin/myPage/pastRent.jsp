<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="/css/myPage.css">
<div class="container-pastRent">
<h5 class="my-4"><strong>지난 대출 도서 목록</strong></h5>

<div class="container-small">
<c:if test="${empty pastRentList }">
<p>지난 대출 도서 내역이 없습니다.</p>
</c:if>

<c:if test="${pastRentList ne null }">
<c:forEach var="book" items="${pastRentList }">
<div class="pastRent-book">
	<a href="/book/getBook/${book.book.bookNum }">
  <img src="${book.book.image }" alt="Card image cap"></a>
    <a href="/book/getBook/${book.book.bookNum }"><p class="card-text">${book.book.title }</p></a>
</div>
</c:forEach>
</c:if>
</div>
</div>