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
              
           
              
             <p style="color:#6E6E6E; margin-bottom: 30px;">비밀번호를 재설정할 계정의<br>이메일 혹은 아이디를 입력해 주세요. </p>
              
            
            </div>
            
            <p>
            <form action="#!">
              <div class="row gy-3 overflow-hidden">
                <div class="col-10" style="padding-right: 0px;">
                  <div class="form-floating mb-3">
                    <input style="border-top-right-radius: 0px; border-bottom-right-radius: 0px;" type="text" class="form-control" name="email" id="email" placeholder="이메일 또는 아이디" required>
                    <label for="email" class="form-label">이메일 또는 아이디</label>
                  </div>
                </div>
                
               <div class="col-2" style="padding-left: 0px;">
                     <button class="btn btn-outline-secondary" type="submit " style="height: 58px; border-top-left-radius: 0px; border-bottom-left-radius: 0px;">인증</button>
               
               </div>
               
               <div class="col-12">
                  <div class="form-floating mb-3">
                    <input type="text" class="form-control" name="number" id="number" placeholder="인증번호 입력" required>
                    <label for="number" class="form-label">인증번호</label>
                  </div>
                </div>
              
            
                <div class="col-12" style="margin-bottom:30px">
                  <div class="d-grid">
                    <button class="btn bsb-btn-xl btn-primary" type="submit">확인</button>
                  </div>
                </div>
              </div>
             
            </form>
            
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>

<%@ include file="../layout/footer.jsp" %>