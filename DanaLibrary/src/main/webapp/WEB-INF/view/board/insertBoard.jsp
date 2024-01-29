<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.dana.library.domain.*"%>
<%@ include file="../layout/header1.jsp"%>
<%@ include file="../layout/header2.jsp"%>

<div class="container-board">
	<div class=parent>
		<div class="d-flex">
      <div class="dropdown">
    <select name="order" class="btn btn-secondary dropdown-toggle" aria-label="Dropdown" id="category1">
              <c:forEach var="category" items="${Category.values()}">
                  <option value="${category}">${category.category }</option>
                  </c:forEach>
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

<script src="/js/insertBoard.js"></script>
<%@ include file="../layout/footer.jsp"%>