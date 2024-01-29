<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

						<div id="findUserid" style="display: none"></div>
						
						<div class="row gy-3 overflow-hidden">
							<div class="col-10" style="padding-right: 0px;">
								<div class="form-floating mb-3">
									<input
										style="border-top-right-radius: 0px; border-bottom-right-radius: 0px;"
										type="text" class="form-control" name="email" id="email"
										placeholder="이메일" required> <label for="email"
										class="form-label">이메일</label>
								</div>
							</div>

							<div class="col-2" style="padding-left: 0px;">
								<button class="btn btn-outline-secondary"
									style="height: 58px; border-top-left-radius: 0px; border-bottom-left-radius: 0px;">인증</button>

							</div>
							<div class="col-12">
								<div class="form-floating mb-3">
									<input type="text" class="form-control" name="username"
										id="username" placeholder="이름을 입력하세요" required> <label
										for="username" class="form-label">이름</label>
								</div>
							</div>
							<div class="col-12">
								<div class="form-floating mb-3">
									<input type="date" class="form-control" name="birthDate"
										id="birthDate" placeholder="생년월일을 입력하세요" required> <label
										for="birthDate" class="form-label">생년월일</label>
								</div>
							</div>

							<div class="col-12">
								<div class="d-grid">
									<button class="btn bsb-btn-xl btn-primary" id="btn-findId">아이디
										찾기</button>
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
										href="/user/view/insertUser"
										class="link-secondary text-decoration-none">회원가입</a>

								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>

<script src="/js/findUserId.js"></script>

<%@ include file="../layout/footer.jsp"%>
</body>
