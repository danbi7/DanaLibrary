let insertUser = {

	init: function() {
		let _this = this;

		$("#btn-insert").on("click", () => {
			_this.insertUser();
		});

		$("#passwordcheck").on("input", function() {
			_this.validatePasswordConfirmation();
		});

		$("#btn-idCheck").on("click", () => {
			_this.idCheck();
		});
	},
	insertUser: function() {
		let user = {
			userid: $("#userid").val(),
			password: $("#password").val(),
			username: $("#username").val(),
			birthDate: $("#birthDate").val(),
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
			if (status == 200) {
				let message = response["data"];
				alert(message);
				location = "/";
			} else if (status == 502) {
				let message = response["data"];
				alert(message);
			} else {
				let errors = response["data"];
				if (errors.userid != null) {
					$("#result-userid-message").text(errors.userid).css("color", "red");
				}
				if (errors.username != null) {
					$("#result-username-message").text(errors.username).css("color", "red");
				} else if (errors.username == null) {
					$("#result-username-message").css("display", "none");
				}
				if (errors.password != null) {
					$("#result-password-message").text(errors.password).css("color", "red");
				} else if (errors.password == null) {
					$("#result-password-message").css("display", "none");
				}
				if (errors.email != null) {
					$("#result-email-message").text(errors.email).css("color", "red");
				} else if (errors.email == null) {
					$("#result-email-message").css("display", "none");
				}
				if (errors.birthDate != null) {
					$("#result-birthDate-message").text(errors.birthDate).css("color", "red");
				} else if (errors.birthDate == null) {
					$("#result-birthDate-message").css("display", "none");
				}
			}
		}).fail(function(error) {
			let message = error["data"];
			alert("에러 발생 : " + message)
		});

	},

	validatePasswordConfirmation: function() {
		let password = $("#password").val();
		let repassword = $("#passwordcheck").val();

		if (password === null || password === "") {
			$("#result-repassword-message").text("비밀번호 입력은 필수입니다.").css("color", "red");
			return false;
		} else if (password !== repassword) {
			$("#result-repassword-message").text("비밀번호가 일치하지 않습니다.").css("color", "red");
			return false; // 일치하지 않으면 false 반환
		}
		else {
			$("#result-repassword-message").text("비밀번호가 일치합니다.").css("color", "blue");
			return true; // 일치하면 true 반환
		}

	},
	
	   idCheck: function() {
      let userid = $("#userid").val();

      $.ajax({
         type: "POST",
         url: "/user/checkUserId/" + userid,
         contentType: "application/json; charset=UTF-8"
      }).done(function(response) {
         console.log(response)
         // 성공적인 응답 처리
         // 서버로부터 받은 응답 처리
         if (response.status === 200) {
            // 중복이 아닌 경우
            $("#result-userid-message").text("사용 가능한 아이디입니다.").css("color", "blue");
         } else {
            // 중복인 경우
            $("#result-userid-message").text("사용 중인 아이디입니다.").css("color", "red");
         }
      }).fail(function(error) {
         alert("에러 발생 : " + error)
      });
   }
}

insertUser.init();