let userObject = {
	init: function() {
		let _this = this;

		$("#btn-verify").on("click", () => {
			_this.verify();
		});

		$("#btn-verifyCode").on("click", () => {
			_this.verifyCode();
		});


		$("#btn-changePw").on("click", () => {
			if (_this.validatePasswordConfirmation()) {
				_this.changePw();
			} else {
				alert("입력된 정보를 다시 확인해주세요.");
			}
		});

		$("#repassword").on("input", function() {
			_this.validatePasswordConfirmation();
		});
	},

	verify: function() {
		let input = $("#input").val();

		$.ajax({
			type: "POST",
			url: "/user/findUser",
			data: { input: input },
			contentType: "application/x-www-form-urlencoded; charset=UTF-8"
		}).done(function(response) {
			console.log(response);
			if (response.status === 200) {
				alert("회원 정보가 확인되었습니다.");
				alert("이메일로 인증번호를 발송하였습니다.");
				// 이메일 보내기
				userObject.sendEmail(response.data);
			} else {
				alert("존재하지 않는 회원 정보입니다.");
			}
		}).fail(function(error) {
			alert("에러 발생 : " + error);
		});
	},

	sendEmail: function(email) {
		$.ajax({
			type: "POST",
			url: "/send/email",
			data: { email: email },
			contentType: "application/x-www-form-urlencoded; charset=UTF-8",
			success: function(response) {
				console.log(response);
			},
			error: function(error) {
				console.error("Error sending email:", error);
				// Handle error (if needed)
			}
		});
	},


	verifyCode: function() {

    $.ajax({
        type: "POST",
        url: "/user/verifyCode",
        data: { enteredCode: $("#enteredCode").val() },
        contentType: "application/x-www-form-urlencoded; charset=UTF-8"
    }).done(function(response) {
        console.log(response);
        if (response.status === 200) {
            alert("인증 성공");
            // Redirect to the password change page
            location.href = "/user/view/changePw";
        } else {
            alert("인증 실패");
        }
    }).fail(function(error) {
        alert("에러 발생 : " + error);
    });
},

	changePw: function() {
		let password = $("#password").val();
		let repassword = $("#repassword").val();

		// 여기에서 입력한 비밀번호와 재입력한 비밀번호를 검증하는 로직을 추가할 수 있음
		// 예를 들면, 비밀번호와 재입력한 비밀번호가 일치하는지 확인

		// Ajax - 비동기 호출
		$.ajax({
			type: "PUT", // 요청 방식
			url: "/user/changePw", // 요청 경로
			data: {
				password: password
			},
			success: function(response) {
				console.log(response); // 콘솔창에 응답 메세지 출력
				if (response.status === 200) {
					alert("비밀번호 변경 성공");
					location = "/"; // 로그인 페이지로 보내야됨
				} else {
					alert("비밀번호 변경 실패");
					location = "/user/view/verifyEmail";
				}
			},
			error: function(error) {
				alert("에러 발생 : " + error)
			}
		});
	},

	validatePasswordConfirmation: function() {
		let password = $("#password").val();
		let repassword = $("#repassword").val();

		if (password === null || password === "") {
			$(".result").css("display", "flex");
			$("#result-message").text("비밀번호 입력은 필수입니다.");
			return false;
		} else if (password !== repassword) {
			$(".result").css("display", "flex");
			$("#result-message").text("비밀번호가 일치하지 않습니다.");
			return false; // 일치하지 않으면 false 반환
		} else {
			$(".result").css("display", "none");
			return true; // 일치하면 true 반환
		}
	},
}

userObject.init();
