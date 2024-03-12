<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="/css/main.css">
    <link href="/webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
    <script src="/webjars/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
    <script src="/webjars/jquery/3.6.0/dist/jquery.min.js"></script>
</head>
<body>

    <div class="container mt-3" style="width:70%; border:1px solid #BDBDBD; ">
    
        
            <div class="container my-2">
                <label for="title" class="form-label">제목</label>
                <input type="text" class="form-control" id="title" name="title">
            </div>

            <div class="container my-2">
                <label for="author" class="form-label">저자</label>
                <input class="form-control" type="text" id="author" name="author">
            </div>

            <div class="container my-2">
                <label for="publisher" class="form-label">출판사</label>
                <input class="form-control" type="text" id="publisher" name="publisher">
            </div>

            <div class="container my-2">
                <label for="publicationDate" class="form-label">출간일</label>
                <input class="form-control" type="date" id="publicationDate" name="publicationDate">
            </div>

			<div class="container my-2">
				<label for="category" class="form-label">분류</label> <select
					class="form-select" id="category" name="category">
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
                <input class="form-control" type="text" id="pages" name="pages">
            </div>

            <div class="container my-2">
                <label for="info" class="form-label">도서 소개</label>
                <textarea style="height:200px;" class="form-control" id="info" name="info"></textarea>
            </div>

            <div class="container my-2 d-flex">
                <input type="file" accept=".jpg,.png" id="file" name="file">
                
                <button class="btn-add btn btn-outline-dark ms-auto" type="button">도서 추가</button>
            </div>
        
    </div>
    <script src="/js/admin/addBook.js"></script>

</body>
</html>
