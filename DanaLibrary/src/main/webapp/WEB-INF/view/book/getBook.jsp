<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.dana.library.domain.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ include file="../layout/header1.jsp"%>
<%@ include file="../layout/header2.jsp"%>

	<div class="container mt-4">

		<div
			style="width: 150px; height: 150px; float: left; margin-left: 200px;">
			<img src="${gettedBook.image }" class="img-thumbnail" alt="책 이미지">
		</div>
		<input type="hidden" id="userid" value="${loginUser.userid }">
		<input type="hidden" id="bookNum" value="${gettedBook.bookNum }">
		<div class="container mt-3">
			<table class="table"
				style="width: 30%; float: left; margin-left: 50px; margin-right: 50px;">
				<tr>
					<td colspan=2><Strong>제목 </Strong> ${gettedBook.title }</td>
				</tr>
				<tr>
					<td colspan=2><Strong>저자 </Strong> ${gettedBook.author }</td>
				</tr>
				<tr>
					<td colspan=2><Strong>출판사 </Strong> ${gettedBook.publisher }</td>
				</tr>
				<tr>
					<td colspan=2><Strong>분류 </Strong> ${gettedBook.category }</td>
				</tr>
				<tr>
					<td colspan=2><Strong>페이지 </Strong> ${gettedBook.pages }</td>

				</tr>
			</table>
		</div>
		<div>
			<c:choose>
				<c:when test="${empty interestedBook.book }">
					<button class="btn-interest btn btn-outline-secondary"
						type="button">
						<img src="/image/emptyheart.png" style="width: 25px; height: 25px"> ${interestCount }
					</button>
				</c:when>
				<c:otherwise>
					<button class="btn-interest-cancel btn btn-outline-secondary"
						type="button">
						<img src="/image/fillheart.png" style="width: 25px; height: 25px"> ${interestCount }
					</button>
				</c:otherwise>
			</c:choose>

			<c:choose>
				<c:when test="${bookStatus eq 1}">
					<button class="btn btn-outline-secondary" id="btn-reserve-cancel">예약취소</button>
				</c:when>
				<c:when test="${bookStatus eq 2}">
					<button class="btn btn-outline-info" id="btn-returnBook">반납하기</button>
				</c:when>
				<c:when test="${bookStatus eq 3}">
					<button class="btn btn-outline-success" id="btn-reserve">예약하기</button>
				</c:when>
				<c:when test="${bookStatus eq 4}">
					<button class="btn btn-outline-primary" id="btn-rent">대출하기</button>
				</c:when>
				<c:otherwise>
					<p>error</p>
				</c:otherwise>
			</c:choose>

			<a href="/public/book/view/getBookList" class="btn btn-light">뒤로가기</a>
		</div>


		<div>
			<table class="table" style="width: 70%; margin-left: 200px">
				<tr>
					<td style="width: 15%;"><Strong>도서 설명</Strong></td>
				</tr>
				<tr>
					<td>${gettedBook.info }
				</tr>
			</table>
		</div>
		</div>

<div class="container" style="margin-left: 250px; margin-top: 100px">
			<div class="row" style="width: 75%;">
			<label for="content">도서 후기 등록하기</label>
			<div class="col-10" style="padding-right: 2px">
			<input type="text"
				id="content" name="content" class="form-control"></div>
				<div class="col-2" style="padding-left: 2px">
			<button class="btn btn-outline-primary" id="btn-review2">후기 등록</button></div></div>

			<c:forEach items="${reviewList }" var="views">
			<hr class="my-4" style="width: 72%">
				<div class="row" style="width: 70%;">
					<div class="comment-meta col-11">
						작성자: <strong>${views.user.userid}</strong> | 작성일: ${views.regDate}
					</div>
					<c:if test="${views.user.userid eq loginUser.userid }">
						<a href="#" class="comment-meta btn-deleteReview col-1"
							data-reviewnum="${views.reviewNum }">삭제</a>
					</c:if>
					<div class="col-12">${views.content }</div>


				</div>
			</c:forEach>
</div>
	<script src="/js/book/interestBook.js"></script>
	<script src="/js/book/book1.js"></script>



	<%@ include file="../layout/footer.jsp"%>