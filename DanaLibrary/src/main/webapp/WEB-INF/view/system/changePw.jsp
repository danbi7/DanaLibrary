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
              
           
              
             <p style="color:#6E6E6E; margin-bottom: 30px;">이메일 인증이 완료되었습니다.<br>새로운 비밀번호를 설정해주세요. </p>
             
            
            </div>
            
            <p>
            
           
              <div class="row gy-3 overflow-hidden">
                <div class="col-12">
                  <div class="form-floating mb-3">
                    <input type="password" class="form-control" name="password" id="password" placeholder="비밀번호 입력" required>
                    <label for="number" class="form-label">새 비밀번호</label>
                  </div>
                </div>
                              
               <div class="col-12">
                  <div class="form-floating mb-3">
                    <input type="password" class="form-control" name="repassword" id="repassword" placeholder="비밀번호 재입력" required>
                    <label for="number" class="form-label">비밀번호 재입력</label>
                  </div>
                  <div id="repasswordError" style="color: red;"></div>
                </div>
              
            
                <div class="col-12" style="margin-bottom:30px">
                  <div class="d-grid">
                    <button class="btn bsb-btn-xl btn-primary"  id="btn-changePw">확인</button>
                  </div>
                </div>
              </div>
             
            
            
            </div>
          </div>
        </div>
      </div>
    </div>
  
</section>
<script src="/js/changePw.js"></script>

<%@ include file="../layout/footer.jsp" %>