<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.dana.library.domain.Status"%>

<link rel="stylesheet" type="text/css" href="/css/myPage.css">
<link rel="stylesheet" type="text/css" href="/css/main.css">

<link href="/webjars/bootstrap/5.1.3/css/bootstrap.min.css"
	rel="stylesheet">
<script src="/webjars/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
<script src="/webjars/jquery/3.6.0/dist/jquery.min.js"></script>

<div class="container-myInfo">
	<div class="col-md-7 col-lg-8">
		<hr class="my-4">
		<div class="myInfo">
			<div class="col-9">
				<h4 class="mb-3">
					<strong>${user.username}</strong>님의 정보
				</h4>
			</div>
			
		</div>
		<hr class="my-4">

		<div class="row g-3">
			<div class="col-sm-12">
				<label for="username" class="form-label">이름</label> <input
					type="text" class="form-control" id="username"
					value="${user.username}">
			</div>

			<div class="col-12">
				<label for="userid" class="form-label">아이디</label>
				<div class="input-group">
					<input type="text" class="form-control" id="userid"
						value="${user.userid}">
				</div>
			</div>

			<div class="col-12">
				<label for="email" class="form-label">이메일</label> <input
					type="email" class="form-control" id="email" value="${user.email}">
			</div>

			<div class="col-12">
				<label for="birthDate" class="form-label">생년월일</label> <input
					type="date" class="form-control" id="birthDate"
					value="${user.birthDate}">
			</div>

			<div class="col-md-12">
				<label for="password" class="form-label">비밀번호</label> <input
					type="password" class="form-control" id="password"
					value="${user.password}">
			</div>

			<div class="col-12">
				<label for="userid" class="form-label">회원 상태</label>
				<div class="input-group">
					<select class="form-control" id="status" name="status">
						<option value="ACTIVE"
							${user.userStatus == 'ACTIVE' ? 'selected' : ''}>활성</option>
						<option value="INACTIVE"
							${user.userStatus == 'INACTIVE' ? 'selected' : ''}>비활성</option>
						<option value="PENDING"
							${user.userStatus == 'PENDING' ? 'selected' : ''}>대기</option>
						<option value="ADMIN"
							${user.userStatus == 'ADMIN' ? 'selected' : ''}>관리자</option>
					</select>
				</div>
			</div>

		</div>

		<hr class="my-4">
<button id="save-button" class="btn btn-outline-primary save-change">저장</button>
	</div>
</div>

      <script src="/js/admin/editUser.js"></script>
