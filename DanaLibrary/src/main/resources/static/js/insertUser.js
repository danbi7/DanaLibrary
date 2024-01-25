let userObject = {

	init: function() {
		let _this = this;

		$("#btn-insert").on("click", () => {
			_this.insertUser();
		});
	},
	insertUser: function() {
		alert("회원가입 요청됨.");
		let user = {
			userid: $("#userid").val(),
			password: $("#password").val(),
			username: $("#username").val(),
			birthDate: $("#birthDate").val(),
			gender: $("#gender").val()
		}

		if ($("#emailDomain").val() === 'custom') {
			user.email = $("#customEmail").val();
		} else {
			user.email = $("#emailId").val() + $("#emailDomain").val();
		}


		$.ajax({
			type: "POST",
			url: "/user/insertUser",
			data: JSON.stringify(user),
			contentType: "application/json; charset=utf-8"
		}).done(function(response) {
			let status = response["status"];
			if(status == 200 ) {
				let message = response["data"];
			alert(message);
			location = "/";
			}else if(status == 502){
				let message = response["data"];
				alert(message);
			}else {
				let warn = "";
				let errors = response["data"];
				if(errors.userid != null) warn = warn + errors.userid + "\n";
				if(errors.password != null) warn = warn + errors.password + "\n";
				if(errors.email != null) warn = warn + errors.email;
				alert(warn);
			}
		}).fail(function(error) {
			let message = error["data"];
			alert("에러 발생 : " + message)
		});

	},
}

userObject.init();
