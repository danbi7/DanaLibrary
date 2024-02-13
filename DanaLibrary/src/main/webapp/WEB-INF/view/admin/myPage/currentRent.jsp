<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="/css/myPage.css">
<div class="container-currentRent">
<h5 class="my-4"><strong>현재 대출중인 도서</strong></h5>

<div class="container-small">
<c:if test="${empty currentRentList }">
<p>현재 대출중인 도서가 없습니다.</p>
</c:if>

<c:if test="${currentRentList ne null }">
<c:forEach var="rent" items="${currentRentList}">

<div class="currentRent-book">
	<a href="/book/getBook/${rent.book.bookNum }">
  <img src="${rent.book.image }" alt="Card image cap"></a>
    <a href="/book/getBook/${rent.book.bookNum }"><p class="card-text" style="overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">${rent.book.title }</p></a>
</div>

</c:forEach>
</c:if>
</div>

<h5 class="my-4"><strong>현재 예약중인 도서</strong></h5>

<div class="container-small justify-content-between">
<c:if test="${reserve eq null }">
<p>현재 예약중인 도서가 없습니다.</p>
</c:if>

<c:if test="${reserve ne null }">
<div class="currentRent-book">
	<a href="/book/getBook/${reserve.book.bookNum }">
  <img src="${reserve.book.image }" alt="Card image cap">
    <p class="card-text" style="overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">${reserve.book.title }</p></a>
</div>
</c:if>
</div>
</div>