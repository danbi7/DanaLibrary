<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.dana.library.domain.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ include file="../layout/header1.jsp"%>
<%@ include file="../layout/header2.jsp"%>

	<div class="container" align="center">
		<h2>도서 목록</h2>
		<div class="col-md-6 text-center">
		
		<form action="/book/view/getBookList">
			<div class="d-flex">
				<div class="dropdown">
					<select name="category"
						class="btn btn-outline-primary dropdown-toggle"
						aria-label="Dropdown" id="bookCategory" style="height: 100%">
						<option value="전체">전체
						<option value="총류">총류
						<option value="철학">철학
						<option value="종교">종교
						<option value="사회과학">사회과학
						<option value="언어">언어
						<option value="자연과학">자연과학
						<option value="기술과학">기술과학
						<option value="예술">예술
						<option value="문학">문학
						<option value="역사">역사
						
					</select>
				</div>
				<input class="form-control me-2" type="text" placeholder="책 제목을 입력하세요" name="bookTitle">
				<button type="submit" class="btn btn-primary" type="button" id="btn-searchBook">Search</button>
				
			</div>
			</form>
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
							<button class="btn-reserve-cancel btn btn-outline-secondary custom-button" type="button" data-booknum="${book.bookNum }">예약취소</button>
						</c:when>

						<c:when test="${map[book] eq 2}">
							<button class="btn-returnBook btn btn-outline-info custom-button" type="button" data-booknum="${book.bookNum }">반납하기</button>
						</c:when>

						<c:when test="${map[book] eq 3}">
							<button class="btn-reserve btn btn-outline-success custom-button" type="button" data-booknum="${book.bookNum }">예약하기</button>
						</c:when>

						<c:when test="${map[book] eq 4}">
							<button class="btn-rent btn btn-outline-primary custom-button" type="button" data-booknum="${book.bookNum }">대출하기</button>
						</c:when>
					</c:choose>


				</div>
			</div>
			<hr>
		</c:forEach>
		
	</div>

	<script src="/js/book/book2.js"></script>
	
<%@ include file="../layout/footer.jsp"%>