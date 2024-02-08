<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DANA LIBRARY</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="/webjars/bootstrap/5.1.3/css/bootstrap.min.css"
	rel="stylesheet">
<script src="/webjars/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
<script src="/webjars/jquery/3.6.0/dist/jquery.min.js"></script>
<link href="/webjars/summernote/0.8.10/summernote-bs4.css"
	rel="stylesheet">
<script src="/webjars/summernote/0.8.10/summernote-bs4.min.js"></script>
<link rel="stylesheet" type="text/css" href="/css/main.css">
<link rel="stylesheet" type="text/css" href="/css/result.css">
<link rel="stylesheet" type="text/css" href="/css/board.css">
<link rel="stylesheet" type="text/css" href="/css/book.css">

</head>
<body>

	<nav class="py-2 bg-body-tertiary border-bottom sticky-top">
	
	<form action="/book/view/getBookList">
		<div class="container d-flex flex-wrap">
			<ul class="nav me-auto">
				<li class="nav-item firstNav-left"><a href="/"
					onclick="window.location.href='/';" class="nav-link link-dark">
						<img src="/image/dana-removebg-preview.png"
						alt="DANA LIBRARY Logo"> DANA LIBRARY
				</a></li>
			</ul>

			<ul class="nav ms-auto">
				<c:if test="${sessionScope.loginUser != null }">
					<li class="noti-icon"><img src="/image/icon/notification.png"
						data-bs-toggle="modal" data-bs-target="#notificationModal"></li>

					<li class="nav-item firstNav-right"><a href="/user/logout"
						class="nav-link link-dark px-2">로그아웃</a></li>
				</c:if>
				<c:if test="${sessionScope.loginUser == null }">
					<li class="nav-item firstNav-right"><a href="/user/view/login"
						class="nav-link link-dark px-2">로그인</a></li>
					<li class="nav-item firstNav-right"><a
						href="/user/view/insertUser" class="nav-link link-dark px-2">회원가입</a></li>
				</c:if>
				<li><input type="hidden" name="category" value="전체"></li>
				<li><input type="text" class="form-control"
					placeholder="제목으로 검색하기" aria-label="Search" name = "bookTitle"></li>
				<li><button type="submit" class="btn" type="button" id="btn-searchBook"><img src="/image/icon/search.png"></button>
			</ul>
		</div>
	</form>
	</nav>



	<!-- Modal -->
	<div class="modal fade" id="notificationModal" tabindex="-1"
		aria-labelledby="notificationModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="notificationModalLabel">알림</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					이처럼 사소한 것들 | 
			
					<button type="button" class="btn btn-outline-success">대출</button>
					<button type="button" class="btn btn-outline-danger">취소</button>
					
				</div>
			</div>
		</div>
	</div>