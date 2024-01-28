let idcheck = {
	
    init: function() {
        let _this = this;

        $("#btn-idCheck").on("click", () => {
            _this.idCheck();
        });
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
	},
}

// 초기화 함수 호출
idcheck.init();
