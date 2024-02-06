let myPage = {

	init: function() {
		let _this = this; // 변수명 오타 수정
		$("#btn-edit").on("click", function() {
			_this.editButton();
		});

		$("#save-button").on("click", function() {
			_this.save();
		});
	},

	editButton: function() {
		alert("정보 수정");

		$("#username").prop('readonly', !$("#username").prop('readonly'));
		$("#birthDate").prop('readonly', !$("#birthDate").prop('readonly'));
		$(".password1-form").css("display", "none");
		$(".password2-form, .password3-form").css({
			"display": "flex",
			"flex-direction": "column"
		});

		$(".edit-button").css("display", "none");
		$(".save-change").css("display", "flex");
	},

	save: function() {

		if ($("#current-password").val() === ($("#password").val())) {
			let user = {
				userid: $("#userid").val(),
				password: $("#new-password").val(),
				username: $("#username").val(),
				birthDate: $("#birthDate").val(),
				email: $("#email").val()
			}

			$.ajax({
				type: "PUT",
				url: "/user/editUser",
				data: JSON.stringify(user),
				contentType: "application/json; charset=utf-8"
			}).done(function(response) {
				alert(response.data);

				$(".edit-button").css("display", "flex");
				location = "/view/myPage";

			}).fail(function(error) {
				let message = error["data"];
				alert("에러 발생 : " + message)
			});
		} else {
			alert("비밀번호를 다시 확인하세요.");
		}
	}

}

myPage.init();