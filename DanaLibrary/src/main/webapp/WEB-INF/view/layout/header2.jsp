<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.dana.library.domain.*"%>

<div class="container">
	<header class="d-flex justify-content-center my-2">
		<ul class="nav header-nav-item secondNav">
			<li class="nav-item"><a href="/view/libraryInfo" class="nav-link">도서관 이용안내</a></li>
			<li class="nav-item"><a href="/public/book/view/getBookList" class="nav-link">전체 도서 목록</a></li>
			<li class="nav-item"><a href="/public/book/view/getPopularBookList" class="nav-link">인기 도서 목록</a></li>
			<c:if test="${loginUser.userStatus ne Status.ADMIN }">
			<li class="nav-item"><a href="/view/myPage" class="nav-link">나의 도서관</a></li></c:if>
			<c:if test="${loginUser.userStatus eq Status.ADMIN }">
			<li class="nav-item"><a href="/view/admin" class="nav-link">관리자 페이지</a></li></c:if>
			<li class="nav-item"><a href="/public/board/view/getBoardList" class="nav-link">열린 마당</a></li>
		</ul>
	</header>
</div>