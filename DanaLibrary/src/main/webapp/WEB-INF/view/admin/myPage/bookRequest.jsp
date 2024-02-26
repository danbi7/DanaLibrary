<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>DANA LIBRARY</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="/webjars/bootstrap/5.1.3/css/bootstrap.min.css"
	rel="stylesheet">
<script src="/webjars/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
<script src="/webjars/jquery/3.6.0/dist/jquery.min.js"></script>
<script src="/webjars/summernote/0.8.10/summernote-bs4.min.js"></script>
<link rel="stylesheet" type="text/css" href="/css/main.css">
<link rel="stylesheet" type="text/css" href="/css/myPage.css">
<link rel="stylesheet" type="text/css" href="/css/result.css">
</head>
<body>
<div class="container-bookRequest">
	<div class="col-md-7 col-lg-8">
		<hr class="my-4">
		<div class="col-12 text-center">
			<h4 class="mb-3">희망도서 신청하기</h4>
		</div>
		<hr class="mt-4">
		<div class="row g-3">
			<div class="col-sm-12">
				<label for="title" class="form-label">도서 제목 *</label> <input
					type="text" class="form-control" id="title"
					placeholder="예시) 운수 좋은 날">
			</div>
			
			<div class="result">
				<span id="result-title-message"></span>
			</div>

			<div class="col-12">
				<label for="author" class="form-label">저자 *</label>
				<div class="input-group">
					<input type="text" class="form-control" id="author"
						placeholder="예시) 현진건">
				</div>
			</div>
			
			<div class="result">
				<span id="result-author-message"></span>
			</div>

			<div class="col-12">
				<label for="publisher" class="form-label">출판사</label> <input
					type="text" class="form-control" id="publisher"
					placeholder="예시) 신원 문화사">
			</div>

		</div>

		<div class="col-12 mt-4 text-center">
			<button id="btn-request" class="btn btn-outline-primary">신청하기</button>
		</div>
		<hr class="my-4">

	</div>
</div>

<script src="/js/admin/bookRequest.js"></script>

</body>

</html>