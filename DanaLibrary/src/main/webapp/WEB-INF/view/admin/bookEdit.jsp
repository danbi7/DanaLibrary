<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/css/main.css">
<link href="/webjars/bootstrap/5.1.3/css/bootstrap.min.css"
	rel="stylesheet">
<script src="/webjars/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
<script src="/webjars/jquery/3.6.0/dist/jquery.min.js"></script>
</head>
<body>

	<div class="container mt-3" style="width:70%; border:1px solid #BDBDBD; ">
	
		<div class="container my-2">
			 <label for="username" class="form-label">도서 제목</label>
			<input type="text" class="form-control" id="title">
		</div>

		<div class="container my-2">
		  	<label for="username" class="form-label">저자</label>
			<input class="form-control" id=>
		</div>
		
		<div class="container my-2">
		  	<label for="username" class="form-label">출판사</label>
			<input class="form-control">
		</div>
		
		<div class="container my-2">
			<label for="username" class="form-label">출간일</label>
			<input class="form-control">
		</div>
		
		<div class="container my-2">
			<label for="username" class="form-label">분류</label>
			<input class="form-control">
		</div>
		
		<div class="container my-2">
			<label for="username" class="form-label">이미지 경로</label>
			<input class="form-control">
		</div>
		
		
		<div class="container my-2">
			<label for="username" class="form-label">도서 소개</label>
			<textarea style="height:200px;" class="form-control"></textarea>
		</div>

		<div class="container my-2 d-flex">
			<input type="file" accept=".jpg,.png">
			<button class="btn-add btn btn-outline-secondary ms-auto" type="button">도서 추가</button>
		</div>

	</div>
	
</body>
</html>