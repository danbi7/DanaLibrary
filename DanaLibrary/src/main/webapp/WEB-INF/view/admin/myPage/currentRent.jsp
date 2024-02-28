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
    <p class="card-text"><a href="/book/getBook/${rent.book.bookNum }"><strong>${rent.book.title }</strong></a></p>
    <p class="card-text-date">${rent.rentDate } ~ ${rent.dueDate }</p>
    <button class="btn-returnBook btn btn-outline-info mt-2" data-booknum="${rent.book.bookNum }" style="width: 86px; font-size: 14px">반납하기</button>
    <c:if test="${rent.renewalStatus ne 'ACTIVE' }">
    <button class="btn-renewal btn btn-outline-primary mt-2" data-rent-num="${rent.rentNum }" style="width: 86px; font-size: 14px">연장하기</button></c:if>
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
  <img src="${reserve.book.image }" alt="Card image cap"></a>
  <p class="card-text"><a href="/book/getBook/${rent.book.bookNum }"><strong>${reserve.book.title }</strong></a></p>
      <button class="btn-reserve-cancel btn btn-outline-secondary" data-booknum="${reserve.book.bookNum }">예약취소</button>
</div>
</c:if>
</div>
</div>