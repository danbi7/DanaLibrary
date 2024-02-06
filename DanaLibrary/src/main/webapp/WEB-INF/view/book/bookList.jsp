<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ include file="../layout/header1.jsp"%>
<%@ include file="../layout/header2.jsp"%>

	<div class="container-page-content-book">

		<div class="jumbotron">
			<div class="container" align="center">
				<h2>도서 목록</h2>

			</div>
		</div>

		<c:forEach var="book" items="${bookList}">
			<div class="row">

				<div class="col-md-3" align="center"
					style="display: flex; justify-content: center;">
					<img src="${book.image}" style="width: 130px; height: 180px;">

				</div>

				<div class="col-md-7">
					<p>
					<h6>
						<b>${book.title}</b>
					</h6>
					<p>${book.author}&nbsp| &nbsp ${book.publisher} &nbsp | &nbsp
						${book.category}
					<p style="padding-top: 20px;">
						<c:choose>
							<c:when test="${fn:length(book.info) <= 200}">
                        ${book.info}
                    </c:when>
							<c:otherwise>
                        ${fn:substring(book.info, 0, 200)}...
                    </c:otherwise>
						</c:choose>
					</p>
				</div>

				<div class="col-md-2 buttons">

					<a href="/book/getBook/${ book.bookNum }"
						class="btn btn-outline-danger custom-button" type="button">상세정보</a>
					<c:choose>
						<c:when test="${map[book] eq 1}">
							<a href="#"
								class="btn-reserve-cancel btn btn-outline-secondary custom-button"
								data-booknum="${book.bookNum }">예약취소</a>
						</c:when>

						<c:when test="${map[book] eq 2}">
							<a href="#"
								class="btn-returnBook btn btn-outline-info custom-button"
								data-booknum="${book.bookNum }">반납하기</a>
						</c:when>

						<c:when test="${map[book] eq 3}">
							<a href="#"
								class="btn-reserve btn btn-outline-success custom-button"
								data-booknum="${book.bookNum }">예약하기</a>
						</c:when>

						<c:when test="${map[book] eq 4}">
							<a href="#"
								class="btn-rent btn btn-outline-primary custom-button"
								data-booknum="${book.bookNum }">대출하기</a>
						</c:when>
					</c:choose>
					
					<c:choose>
					<c:when test="${interestedBookMap[book] ne null}">
						<a href="/book/removeInterestedBook/${book.bookNum }" class="btn btn-outline-secondary custom-button" style="font-size: 11px; width: 90px; height: 33.2px; padding: 4.1px 6px;"><img src="/image/fillheart.png" style="width: 25px; height: 25px"></a>
					</c:when>
					<c:otherwise>
						<a href="/book/addInterestedBook/${book.bookNum }" class="btn btn-outline-secondary custom-button" style="font-size: 11px; width: 90px; height: 33.2px; padding: 4.1px 6px;"><img src="/image/emptyheart.png" style="width: 25px; height: 25px"></a>
					</c:otherwise>
					</c:choose>
				
				</div>
			</div>
			<hr>

		</c:forEach>
	</div>

	<script src="/js/book/rentBook.js"></script>
	<script src="/js/book/returnBook.js"></script>
	<script src="/js/book/reserveBook.js"></script>

	<%@ include file="../layout/footer.jsp"%>