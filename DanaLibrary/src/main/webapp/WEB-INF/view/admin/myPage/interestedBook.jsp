<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<div class="container-interestedBook">
	<h5 class="my-4">
		<strong>관심 도서 목록</strong>
	</h5>

	<c:if test="${empty interestedBookList}">
		<p>등록된 관심도서가 없습니다.</p>
	</c:if>

	<c:if test="${not empty interestedBookList}">
		<c:set var="count" value="0" />
		<c:forEach var="book" items="${interestedBookList}">
			<c:if test="${count % 5 eq 0}">
				<div class="container-small">
			</c:if>
			<div class="interested-book">
				<a href="/book/getBook/${book.book.bookNum}"> <img
					src="${book.book.image}" alt="Card image cap">
				</a>
				<p class="card-text">
					<a href="/book/getBook/${book.book.bookNum}"><strong>${book.book.title}</strong></a>
				</p>
				<button class="btn-removeInterest btn btn-outline-primary"
					style="width: 100%" data-booknum="${book.book.bookNum }">관심
					도서 등록 해제</button>
			</div>
			<c:set var="count" value="${count + 1}"/>
                <c:if test="${count % 5 eq 0 or count eq fn:length(interestedBookList)}">
                    </div>
                </c:if>
		</c:forEach>
</c:if>
</div>