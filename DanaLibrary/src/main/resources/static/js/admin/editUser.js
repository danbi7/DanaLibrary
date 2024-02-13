let editUser = {

	init: function() {
		let _this = this; // 변수명 오타 수정

		$("#save-button").on("click", function() {
			_this.save();
		});
	},


	save: function() {
		alert("회원정보 수정")
		let user = {
			userid: $("#userid").val(),
			password: $("#password").val(),
			username: $("#username").val(),
			birthDate: $("#birthDate").val(),
			email: $("#email").val(),
			userStatus: $("#status").val()
		}

		$.ajax({
			type: "PUT",
			url: "/admin/editUser",
			data: JSON.stringify(user),
			contentType: "application/json; charset=utf-8"
		}).done(function(response) {
			alert(response.data);
			window.close();  // 창을 닫습니다.
			
		}).fail(function(error) {
			let message = error.responseJSON.data; // 'responseJSON'으로 수정
			alert("에러 발생 : " + message)
		});
	}

}

editUser.init(); // 'myPage'를 'editUser'로 수정
