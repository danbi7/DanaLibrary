<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header1.jsp"%>
<%@ include file="../layout/header2.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style>

/* 작성자와 작성일 스타일 */
.comment-meta {
	font-size: 12px;
	color: #777;
}

/* 댓글 컨테이너 스타일 */
.comment-container {
	border-bottom: 1px solid #ddd; /* 선 스타일 추가 */
	padding-bottom: 15px; /* 선과 댓글 사이의 간격 조절 */
	margin-bottom: 10px;
	text-align: left; /* 댓글을 왼쪽으로 정렬 */
	margin-top: 10px; /* 댓글을 아래로 내리는 여백 조절 */
}
/* 댓글 내용 스타일 */
.comment-content {
	font-size: 14px;
	color: #333;
	margin-bottom: 5px;
	margin-top: 15px;
}
</style>

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
		<div class="updateDate">수정일: ${board.updateDate }</div>
		<div class="view">조회수: ${board.views }</div>
		<div class="likes">추천수: ${board.likes }</div>
	</div>


	<div class="form-control custom-textarea mb-3" id="content">${board.content }</div>

	<div class="board-button text-center">
		<c:if test="${sessionScope.loginUser.userid != null }">
			<c:if test="${sessionScope.loginUser.userid eq board.user.userid }">
				<a href="/board/view/updateBoard/${board.boardNum }"
					class="btn btn-secondary">수정하기</a>
				<button id="btn-delete" class="btn btn-secondary">삭제하기</button>
			</c:if>
		</c:if>
		<button id="btn-like" class="btn btn-secondary">추천하기</button>
		<a class="btn btn-secondary" href="/public/board/view/getBoardList">뒤로가기</a>

	</div>

	<div class="form-group mb-3">
		<label for="comment-content"></label>
		<textarea id="comment-content" name="content"
			style="width: 100%; height: 80px;" placeholder="댓글을 입력하세요..."></textarea>
	</div>

	<input type="hidden" id="boardNum" value="${board.boardNum}">
	<div class="text-center">
		<button id="btn-insert-comment" type="submit" class="btn btn-primary"
			data-user-id="${sessionScope.loginUser.userid}">댓글 등록</button>
	</div>




	<c:forEach items="${commentList}" var="comment">
		<div class="comment-container">
			<div class="comment-meta">
				작성자: <strong class="comment-author">${comment.user.userid}</strong>
				| 작성일: ${comment.regDate} <input type="hidden" class="commentNum"
					value="${comment.commentNum}">
			</div>
			<div class="comment-content">${comment.content}</div>
			<c:if test="${sessionScope.loginUser.userid eq comment.user.userid}">
				<button class="btn btn-sm btn-primary btn-delete-comment"
					data-comment-num="${comment.commentNum}">댓글 삭제</button>
			</c:if>
		</div>
	</c:forEach>

</div>
<script src="/js/board/likesBoard.js"></script>
<script src="/js/comment/deleteComment.js"></script>
<script src="/js/comment/insertComment.js"></script>
<script src="/js/board/deleteBoard.js"></script>
<%@ include file="../layout/footer.jsp"%>