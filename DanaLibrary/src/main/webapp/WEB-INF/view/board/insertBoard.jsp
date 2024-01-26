<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.dana.library.domain.*"%>
<%@ include file="../layout/header1.jsp"%>
<%@ include file="../layout/header2.jsp"%>

<div class="container-board">
	<div class=parent>
		<div class="dropdown first">
			<button class="btn btn-secondary dropdown-toggle" type="button"
				id="dropdownMenuButton1" data-bs-toggle="dropdown"
				aria-expanded="false">카테고리</button>
			<ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
				<c:forEach var="category" items="${Category.values()}">
					<li><a class="dropdown-item" onclick="changeCategory('${category.category}')">${category.category}</a></li>
				</c:forEach>
			</ul>
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
		<button id="btn-save" class="btn btn-secondary">글등록</button>
	</div>
</div>

<script>
	function changeCategory(category) {
		$('#dropdownMenuButton1').text(category);
	}
</script>
<%@ include file="../layout/footer.jsp"%>