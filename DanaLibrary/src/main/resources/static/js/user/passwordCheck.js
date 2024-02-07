let checkPassword = {
    
    init: function() {
        let _this = this;

        $("#repassword").on("input", function() {
            _this.pwcheck();
        });
    },
    pwcheck: function() {
		
        let password = $("#password").val();
        let repassword = $("#repassword").val();
        let pwcheckResult = $("#pwcheckResult");
      
        if (password !== repassword){
			pwcheckResult.text("비밀번호가 일치하지 않습니다.").css("color","red");
		}else{
			pwcheckResult.text("비밀번호가 일치합니다.").css("color","blue");
		}
    }
}

// 초기화 함수 호출
checkPassword.init();