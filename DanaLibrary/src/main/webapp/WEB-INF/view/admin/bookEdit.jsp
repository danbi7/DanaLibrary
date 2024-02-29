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

		<div>
			<input type="hidden" id="bookNum" name="bookNum" value="${book.bookNum}">
		</div>

		<div class="container my-2">
			 <label for="username" class="form-label">도서 제목</label>
			<input type="text" class="form-control" id="title" value="${book.title}">
		</div>

		<div class="container my-2">
		  	<label for="username" class="form-label">저자</label>
			<input class="form-control" type="text" id="author" name="author" value="${book.author}">
		</div>
		
		<div class="container my-2">
		  	<label for="username" class="form-label">출판사</label>
			<input class="form-control" type="text" id="publisher" name="publisher" value="${book.publisher}">
		</div>
		
		<div class="container my-2">
			<label for="username" class="form-label">출간일</label>
			<input class="form-control" type="date" id="publicationDate" name="publicationDate" value="${book.publicationDate}">
		</div>
		
		<div class="container my-2">
				<label for="category" class="form-label">분류</label> 
				<select class="form-select" id="category" name="category">
					<option value="${book.category}" selected>${book.category}</option>
					<option value="기술과학">기술과학</option>
					<option value="자연과학">자연과학</option>
					<option value="예술">예술</option>
					<option value="언어">언어</option>
					<option value="역사">역사</option>
					<option value="종교">종교</option>
					<option value="총류">총류</option>
					<option value="문학">문학</option>
					<option value="철학">철학</option>
					<option value="사회과학">사회과학</option>
				</select>
			</div>
		
		<div class="container my-2">
                <label for="pages" class="form-label">페이지 수</label>
                <input class="form-control" type="text" id="pages" name="pages" value="${book.pages}">
            </div>
		
		
		<div class="container my-2">
                <label for="info" class="form-label">도서 소개</label>
                <textarea style="height:200px;" class="form-control" id="info" name="info">${book.info}</textarea>
        </div>

		<div class="container my-2 d-flex">
    <input type="file" accept=".jpg,.png" id="file">
    <button class="btn-edit btn btn-outline-secondary ms-auto" type="button">도서 정보 수정</button>
</div>

	</div>
	<script src="/js/admin/editBook.js"></script>
	
</body>
</html>