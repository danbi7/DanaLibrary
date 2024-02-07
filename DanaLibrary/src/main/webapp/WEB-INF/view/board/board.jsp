<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header1.jsp"%>
<%@ include file="../layout/header2.jsp"%>
<input type="hidden" id="boardNum" value="${board.boardNum }">

<div class="container-board">
	<hr class="my-4">
	<div class="container-head">
		<div class="title">
			제목: <strong>${board.title }</strong>
		</div>
		<div class="writer">작성자: ${board.user.userid }</div>
	</div>
	<hr class="mt-4">

	<div class="container-body mb-3">
		<div class="category">카테고리: ${board.category.category }</div>
		<div class="regDate">작성일: ${board.regDate }</div>
		<div class="cnt">조회수: ${board.views }</div>
		<div class="likes">추천수: ${board.likes }</div>
	</div>

	<!-- <hr class="mt-3"> -->
	
	<div class="form-control custom-textarea mb-3" id="content">${board.content }</div>
	<!-- <hr class="my-3"> -->
		<div class="board-button text-center">
			<button class="btn btn-secondary" onclick="history.back()">뒤로가기</button>
			<c:if test="${sessionScope.loginUser.userid != null }">
			<c:if test="${sessionScope.loginUser.userid eq board.user.userid }">
			<a href="/board/view/updateBoard/${board.boardNum }" class="btn btn-secondary">수정하기</a>
			<button id="btn-delete" class="btn btn-secondary">삭제하기</button>
			</c:if></c:if>
			<button id="btn-like" class="btn btn-secondary">추천하기</button>
	</div>
</div>
<script src="/js/board/deleteBoard.js"></script>
<%@ include file="../layout/footer.jsp"%>