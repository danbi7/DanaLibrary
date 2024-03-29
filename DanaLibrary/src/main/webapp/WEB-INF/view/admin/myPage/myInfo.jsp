<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="container-myInfo">
      <div class="col-md-7 col-lg-8">
         <hr class="my-4">
         <div class="myInfo">
         <div class="col-9">
        <h4 class="mb-3"><strong>${sessionScope.loginUser.username }</strong>님의 정보</h4>
        </div>
        <div class="col-3 edit-button">
        <a href="#" id="btn-edit"><img class ="edit-img" src="/image/icon/icon-edit-button.png"><span class="edit-text">수정하기</span></a></div></div>
        <hr class="mt-4">
        
          <div class="row g-3">
            <div class="col-sm-12">
              <label for="username" class="form-label">이름</label>
              <input type="text" class="form-control" id="username" value="${sessionScope.loginUser.username }" readonly="readonly">
            </div>

            <div class="col-12">
              <label for="userid" class="form-label">아이디</label>
              <div class="input-group">
                <input type="text" class="form-control" id="userid" value="${sessionScope.loginUser.userid }" readonly="readonly">
              </div>
            </div>

            <div class="col-12">
              <label for="email" class="form-label">이메일</label>
              <input type="email" class="form-control" id="email" value="${sessionScope.loginUser.email }" readonly="readonly">
            </div>

            <div class="col-12">
              <label for="birthDate" class="form-label">생년월일</label>
              <input type="date" class="form-control" id="birthDate" value="${sessionScope.loginUser.birthDate }" readonly="readonly">
            </div>

            <div class="password1-form col-md-12">
              <label for="password" class="form-label">비밀번호</label>
              <input type="password" class="form-control" id="password" value="${sessionScope.loginUser.password }" readonly="readonly">
            </div>
            

            <div class="password2-form col-md-12">
              <label for="current-password" class="form-label">현재 비밀번호</label>
              <input type="text" class="form-control" id="current-password">
            </div>
            
            <div class="password3-form col-md-12">
              <label for="new-password" class="form-label">새로운 비밀번호</label>
              <input type="text" class="form-control" id="new-password">
            </div>
            </div>

	<div class="col-12 mt-4 save-change">
		<button id="save-button" class="btn btn-outline-primary save-change">저장하기</button>
		</div>
          <hr class="my-4">
          <div class="col-12 text-center">
             <a class="btn-deleteUser">회원 탈퇴</a></div>
      </div>      
      </div>
      
      <script src="/js/admin/deleteUser.js"></script>