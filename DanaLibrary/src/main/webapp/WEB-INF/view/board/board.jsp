<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header1.jsp"%>
<%@ include file="../layout/header2.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container-board">
	<!-- 게시글 내용 -->
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
		<div class="view">조회수: ${board.views }</div>
		<div class="likes">추천수: ${board.likes }</div>
	</div>


	<div class="form-control custom-textarea mb-3" id="content">${board.content }</div>
	<!-- <hr class="my-3"> -->
	<div class="board-button text-center">
		<button class="btn btn-secondary" onclick="history.back()">뒤로가기</button>
		<c:if test="${sessionScope.loginUser.userid != null }">
			<c:if test="${sessionScope.loginUser.userid eq board.user.userid }">
				<a href="/board/view/updateBoard/${board.boardNum }"
					class="btn btn-secondary">수정하기</a>
				<button id="btn-delete" class="btn btn-secondary">삭제하기</button>
			</c:if>
		</c:if>
		<button id="btn-like" class="btn btn-secondary">추천하기</button>

		<div class="comment-form">

			<div class="form-group">
				<div class="form-group" style="text-align: left;">


					<input type="text" id="comment-author" name="author"
						value="${sessionScope.loginUser.userid }" readonly>
				</div>

			</div>
			<div class="form-group">
				<label for="comment-content"></label>
				<textarea id="comment-content" name="content"
					style="width: 842px; height: 100px; font-size: 10x;"> </textarea>
			</div>
			<div class="container-board">

				<input type="hidden" id="boardNum" value="${board.boardNum}">
				<div style="text-align: right;">

					<button id="btn-insert-comment" type="submit"
						class="btn btn-primary"
						data-user-id="${sessionScope.loginUser.userid}">댓글 등록</button>


				</div>
			</div>

		</div>

	</div>

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

	<c:forEach items="${commentList}" var="comment">
		<div class="comment-container">
			<div class="comment-meta">
				작성자: <strong class="comment-author">${comment.user.userid}</strong>
				| 작성일: ${comment.regDate} <input type="hidden" class="commentNum"
					value="${comment.commentNum}">
			</div>
			<div class="comment-content">${comment.content}</div>
			<c:if test="${sessionScope.loginUser.userid eq comment.user.userid}">
				<button class="btn btn-primary btn-delete-comment"
					data-comment-num="${comment.commentNum}">댓글 삭제</button>
			</c:if>
		</div>
	</c:forEach>


</div>
</div>
<script src="/js/board/likesBoard.js"></script>
<script src="/js/comment/deleteComment.js"></script>
<script src="/js/comment/insertComment.js"></script>
<script src="/js/board/deleteBoard.js"></script>
=======
	<hr class="mt-3">

	<textarea rows="15" readonly="readonly">예시글 어쩌고 저쩌고 알아라아라아아아아ㅏ</textarea>
	<hr class="my-3">



	<form action="/comment/add" method="post">


		<div class="form-group">


			<label for="comment-author">작성자</label> <input type="text"
				id=${User.userid } name="author">
		</div>

		<div class="form-group">
			<label for="comment-content">내용:</label>
			<textarea id="comment-content" name="content" rows="5"></textarea>
		</div>

		<div>

			<button onclick="#()">댓글 수정</button>
			<button onclick="#()">댓글 삭제</button>
			<button type="submit" class="btn-submit-comment">댓글 등록</button>
		</div>

		<div id="comment-list"></div>
	</form>
</div>

<hr class="my-3">

<!-- 기타 버튼 등 -->
<div class="buttons text-center">
	<button class="btn btn-secondary">뒤로가기</button>
	<button class="btn btn-secondary">글 수정</button>
	<button class="btn btn-secondary">글 삭제</button>
	<button class="btn btn-secondary">추천하기</button>
</div>
<script src="/js/comment.js"></script>
<%@ include file="../layout/footer.jsp"%>