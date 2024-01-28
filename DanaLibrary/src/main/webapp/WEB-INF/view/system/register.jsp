
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../layout/header1.jsp"%>

<!-- Login 7 - Bootstrap Brain Component -->
<section class="bg-light p-3 p-md-4 p-xl-5">
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-12 col-md-9 col-lg-7 col-xl-6 col-xxl-5">
				<div class="card border border-light-subtle rounded-4">
					<div class="card-body p-3 p-md-4 p-xl-5">
						<div class="row">
							<div class="col-12">
								<div class="mb-5">
									<div class="text-center mb-4"></div>
									<h4 class="text-center">DANA 도서관</h4>
								</div>
							</div>
						</div>

						<div class="row gy-3 overflow-hidden">

							<div class="col-10" style="padding-right: 0px">
								<div class="form-floating mb-3">
									<input type="text" class="form-control" name="userid"
										id="userid"
										style="border-top-right-radius: 0px; border-bottom-right-radius: 0px">
									<label for="아이디" class="form-label">아이디</label>

								</div>
							</div>

							<div class="col-2" style="padding-left: 0px">
								<button type="button" class="btn btn-secondary" id="btn-idCheck"
									style="height: 58px; border-top-left-radius: 0px; border-bottom-left-radius: 0px">중복
									확인</button>
							</div>

							<div class="result">
								<span id="result-userid-message"></span>
							</div>

							<div class="col-12">
								<div class="form-floating mb-3">
									<input type="password" class="form-control" name="password"
										id="password"> <label for="비밀번호" class="form-label">비밀번호</label>
								</div>
							</div>

							<div class="result">
								<span id="result-password-message"></span>
							</div>
							<div class="col-12">
								<div class="form-floating mb-3">
									<input type="password" class="form-control"
										name="passwordcheck" id="passwordcheck"> <label
										for="비밀번호 확인" class="form-label">비밀번호 확인</label>
								</div>
							</div>

							<div class="result">
								<span id="result-repassword-message"></span>
							</div>

							<div class="col-12">
								<div class="form-floating mb-3">
									<input type="text" class="form-control" name="username"
										id="username"> <label for="이름" class="form-label">이름</label>
								</div>
							</div>

							<div class="result">
								<span id="result-username-message"></span>
							</div>

							<div class="col-12">
								<div class="input-group mb-3">
									<input type="text" class="form-control" name="emailId"
										id="emailId" placeholder="아이디"> <label
										class="input-group-text" for="emailDropdown">@</label> <select
										class="form-select" id="emailDomain" name="emailDomain">
										<option value="@naver.com">naver.com</option>
										<option value="@gmail.com">gmail.com</option>
										<option value="@hanmai.net">hanmai.net</option>
										<option value="custom">직접 입력</option>


									</select>
									<div class="col-12" id="customEmail-box" style="display: none; height: 37px">
										<div class="input-group mb-3">
											<input type="email" class="form-control" name="customEmail"
												id="customEmail" placeholder="ex) abc123@naver.com"
												style="display: none;">
										</div>
									</div>

								</div>
								
							<div class="result">
								<span id="result-email-message"></span>
							</div>
							</div>

							<div class="col-12">
								<div class="input-group mb-3">
									<label class="input-group-text" for="birthBox">생년월일</label> <input
										type="date" class="form-control" name="birthDate"
										id="birthDate" placeholder="YYMMDD"> <label
										class="input-group-text" for="genderDropdown">성별</label> <select
										class="form-select" id="gender" name="gender">
										<option value="남">남</option>
										<option value="여">여</option>
									</select>
								</div>
							</div>

							<div class="result">
								<span id="result-birthDate-message"></span>
							</div>

							<div class="col-12">
								<div class="d-grid">
									<button class="btn bsb-btn-xl btn-primary" id="btn-insert">회원
										가입</button>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-12">
								<hr class="mt-5 mb-4 border-secondary-subtle">
								<div
									class="d-flex gap-2 gap-md-4 flex-column flex-md-row justify-content-center">
									<a href="/user/view/verifyEmail"
										class="link-secondary text-decoration-none">비밀번호 변경</a> <a
										href="/user/view/login"
										class="link-secondary text-decoration-none">로그인</a> <a
										href="/user/view/findUserId"
										class="link-secondary text-decoration-none">아이디 찾기</a>

								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>


<script>
	$(document).ready(function() {
		$("#emailDomain").change(function() {
			if ($(this).val() === 'custom') {
				$("#customEmail-box").show();
				$("#customEmail").show();
				$("#emailId").prop('disabled', true);
			} else {
				$("#customEmail").hide();
				$("#emailId").prop('disabled', false);
			}
		});
	});

</script>
<script src="/js/idcheck.js"></script>
<script src="/js/passwordCheck.js"></script>
<script src="/js/insertUser.js"></script>

<%@ include file="../layout/footer.jsp"%>