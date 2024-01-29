<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header1.jsp" %>
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
                  <div class="text-center mb-4">
                  
                  </div>
             <h4 class="text-center">DANA 도서관</h4>
                </div>
              </div>
            </div>
            
              <div class="row gy-3 overflow-hidden">
                <div class="col-12">
                  <div class="form-floating mb-3">
                    <input type="text" class="form-control" name="input" id="input" placeholder="name@example.com" required>
                    <label for="input" class="form-label">아이디 또는 이메일</label>
                    
                  </div>
                </div>
                <div class="col-12">
                  <div class="form-floating mb-3">
                    <input type="password" class="form-control" name="password" id="password" value="" placeholder="Password" required>
                    <label for="password" class="form-label">비밀번호</label>
                  </div>
                </div>
                <div class="col-12">
                  <div class="form-check">
                    <input class="form-check-input" type="checkbox" value="" name="remember_me" id="remember_me">
                    <label class="form-check-label text-secondary" for="remember_me">
                      로그인 상태 유지
                    </label>
                   
                  </div>
                </div>
                <div class="col-12">
                  <div class="d-grid">
                    <button id="btn-login" class="btn bsb-btn-xl btn-primary" >로그인</button>
                  </div>
                </div>
              </div>
            
            <div class="row">
              <div class="col-12">
                <hr class="mt-5 mb-4 border-secondary-subtle">
                <div class="d-flex gap-2 gap-md-4 flex-column flex-md-row justify-content-center">
                  <a href="/user/view/findUserId" class="link-secondary text-decoration-none">아이디 찾기</a>
                  <a href="/user/view/verifyEmail" class="link-secondary text-decoration-none">비밀번호 변경</a>
                   <a href="/user/view/insertUser" class="link-secondary text-decoration-none">회원가입</a>
                   
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
<script src="/js/user/login.js"></script>
<%@ include file="../layout/footer.jsp" %>