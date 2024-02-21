<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.dana.library.domain.*"%>
<%@ include file="../layout/header1.jsp"%>
<%@ include file="../layout/header2.jsp"%>

<div class="container-board">
	<div class="parent">
		<div class="d-flex">
			<div class="dropdown">
				<select name="order" class="btn btn-secondary dropdown-toggle"
					aria-label="Dropdown" id="category1">
					<%-- 사용자가 로그인한 경우에만 드롭다운에 공지사항이 표시되도록 설정 --%>
					<c:choose>
						<c:when
							test="${empty sessionScope.loginUser || sessionScope.loginUser.userStatus != Status.ADMIN}">
							<c:forEach var="category" items="${Category.values()}">
								<c:if test="${category != Category.NOTICE && category != Category.TOTAL}">
									<option value="${category}">${category.category}</option>
								</c:if>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<c:forEach var="category" items="${Category.values()}">
								<c:if test="${category != Category.TOTAL}">
									<option value="${category}">${category.category}</option>
								</c:if>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</select>
			</div>
		</div>

		<div class="second">
			<input type="text" id="title" name="title" class="form-control"
				placeholder="제목을 입력하세요">
		</div>
	</div>

	<div class="third">
		<p>작성자: ${loginUser.username}</p>
	</div>

	<div class="fourth">
		<textarea rows="5" id="content" name="content" class="form-control"></textarea>
	</div>

	<script>
		$(document).ready(function() {
			$("#content").summernote({
				placeholder : '내용을 입력하세요',
				height : 300
			});
		});
	</script>

	<div class="fifth text-center">
		<button id="write-board" class="btn btn-secondary">글등록</button>
	</div>

</div>

<script src="/js/board/insertBoard.js"></script>
<%@ include file="../layout/footer.jsp"%>