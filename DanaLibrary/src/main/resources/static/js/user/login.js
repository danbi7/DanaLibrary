let loginObject = {
	init: function() {
		let _this = this;

		$("#btn-login").on("click", () => {
			_this.login();
		});
	},



	login: function() {

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
			alert(response.data);

			if (response.status === 200) {
				location = "/";
			}
		}).fail(function(error) {
			alert("에러 발생 : " + error);
		});
	}
}

loginObject.init();