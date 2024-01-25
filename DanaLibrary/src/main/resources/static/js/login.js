let loginObject = {
	init: function() {
		let _this = this;

		$("#btn-login").on("click", () => {
			_this.login();
		});
	},



	login: function() {
		alert("로그인 요청됨");

		let inputData = {
			input: $("#input").val(),
			password: $("#password").val()
		};

		$.ajax({
			type: "POST", //요청 방식
			url: "/user/login", //요청 경로
			data: {
				input: inputData.input,
				password: inputData.password
			},
			contentType: "application/x-www-form-urlencoded"
		}).done(function(response) {
			console.log(response); //콘솔창에 응답 메세지 출력
			alert("시발진짜");
			if (response.status === 200) {
				alert("로그인 성공");
				location = "/";
			} else {
				alert("로그인 실패");
			}
		}).fail(function(error) {
			alert("에러 발생 : " + error);
		});
	}
}

loginObject.init();