
let userObject = {
	
	init : function(){
		let _this = this;  
		
		$("#btn-insert").on("click", () => {
			_this.insertUser();
		});
		
		  // emailDomain 변경 감지
        $("#emailDomain").change(function () {
            _this.updateEmail();  // email 갱신
        });

        // customEmailDomain 입력 시 갱신
        $("#customEmailDomain").on("input", function () {
            _this.updateEmail();  // email 갱신
        });

        // 페이지 로드 시 초기 email 설정
        _this.updateEmail();
    },

    updateEmail: function () {
        let emailId = $("#emailId").val();
        let emailDomain = $("#emailDomain").val();

        if (emailDomain === '@custom') {
            emailDomain = $("#customEmailDomain").val();
        }

        let email = emailId + emailDomain;

        // email 객체에 할당
        this.user.email = email;
    },

	
	
	insertUser : function(){
		alert("회원가입 요청됨.");
		//사용자가 입력한 값(jsp화면에서)
		let user = {
			id : $("#id").val(),
			password : $("#password").val(),
			username : $("#username").val(),
			email : $("#email").val(),
			birthDate : $("#birthDate").val(),
			gender : $("gender").val()
		}
		
		$.ajax({
			type : "POST", 
			url : "/user/insertUser",  
			data : JSON.stringify(user),  
			contentType : "application/json; charset=utf-8"
		}).done(function(response){
			let message = response["data"];
			alert(message);
			location = "/";  
		}).fail(function(error){
			let message = error["data"];
			alert("에러 발생 : "+message)
		});
		
	}, 
}


userObject.init();