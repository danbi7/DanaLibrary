let userObject = {
	init: function() {
		let _this = this;

		$("#btn-verify").on("click", () => {
			_this.verify();
		});

		$("#btn-changePw").on("click", () => {
			if (_this.validatePasswordConfirmation()) {
				_this.changePw();
			}
			else {
				alert("입력된 정보를 다시 확인해주세요.")
			}
		});

		$("#repassword").on("input", function() {
			_this.validatePasswordConfirmation();
		});
	},

	verify: function() {
		let input = $("#input").val();

		// Ajax - 비동기 호출
		// done() 함수 - 요청 처리에 성공 했을때
		// fail() 함수 - 요청 처리에 실패 했을때
		$.ajax({
			type: "POST", // 요청 방식
			url: "/user/findUser", // 요청 경로
			data: { input: input },
			contentType: "application/x-www-form-urlencoded; charset=UTF-8"
		}).done(function(response) {
			console.log(response); // 콘솔창에 응답 메세지 출력
			if (response.status === 200) {
				alert("회원 정보가 확인되었습니다.");
				location = "/user/view/changePw";
			} else {
				alert("존재하지 않는 회원 정보입니다.");

			}
		}).fail(function(error) {
			alert("에러 발생 : " + error)
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
					location = "/user/view/verify";
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
		let repasswordError = $("#repasswordError");

		if (password !== repassword) {
			repasswordError.text("비밀번호가 일치하지 않습니다.");
			return false; // 일치하지 않으면 false 반환
		}
		else {
			repasswordError.text("");
			return true; // 일치하면 true 반환
		}

	},


}

userObject.init();