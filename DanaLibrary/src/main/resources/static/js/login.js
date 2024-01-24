let loginObject = {
   init : function(){
      let _this = this;

      $("#btn-login").on("click", () => {
         _this.login();
      });
   },

  

   login : function(){
      alert("로그인 요청됨");

      let user = {
         userid : $("#userid").val(),
         password : $("#password").val()
      };
      console.log(user)

      $.ajax({
         type : "POST", //요청 방식
         url : "/login", //요청 경로
         data : JSON.stringify(user), //user 객체를 JSON 형태로 변환
         contentType : "application/json; charset=utf-8"
      }).done(function(response){
         console.log(response); //콘솔창에 응답 메세지 출력
		alert("시발진짜");
         if (response.status === 200) {
                alert("로그인 성공");
                location = "/";
            } else {
                alert("로그인 실패");
            }
      }).fail(function(error){
         alert("에러 발생 : " + error);
      });
   }
}

loginObject.init();