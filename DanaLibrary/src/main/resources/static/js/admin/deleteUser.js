let deleteUser = {

	init: function() {
		let _this = this; // 변수명 오타 수정

		$(".btn-deleteUser").on("click", function() {
			_this.delteUser();
		});
	},


	delteUser: function() {
		let result = confirm("회원 탈퇴를 진행하시겠습니까?");

		if(result == true){
			let userid = $("#userid").val();

		$.ajax({
			type: "DELETE",
			url: "/admin/deleteUser",
			data: { userid: userid },
			contentType: "application/x-www-form-urlencoded; charset=UTF-8"
		}).done(function(response) {
			alert(response.data);
			location.href = "/user/logout"

		}).fail(function(error) {
			let message = error.responseJSON.data; // 'responseJSON'으로 수정
			alert("에러 발생 : " + message)
		});
		}
		
	}

}

deleteUser.init(); // 'myPage'를 'editUser'로 수정
