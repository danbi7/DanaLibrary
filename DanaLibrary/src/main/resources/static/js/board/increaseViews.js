let increaseObject = {

	init: function() {
		let _this = this;
		
		$(".btn-increase").on("click", function() {
			if (checkUserIdAndInitBoardObj()) {
				let boardNum = $(this).data("board-num");
				_this.increaseViews(boardNum);

			}
		});

	},

	increaseViews: function(boardNum) {

		$.ajax({
			type: "PUT",
			url: "/board/view/updateViews/" + boardNum,
			contentType: "application/json; charset=utf-8"
		}).done(function(response) { // done 대신 success 사용
			location.href = "/board/view/getBoard/" + boardNum; // location 속성 

		}).fail(function(error) { // fail 대신 error 사용

			alert("에러 발생: " + error);

		});

	}

}

function checkUserIdAndInitBoardObj() {
	console.log($("#userid").val());
	if ($("#userid").val() === null || $("#userid").val() === "") {
		alert("로그인 후 이용 가능합니다.");
		location = "/user/view/login";
		return false;
	} else {
		return true;
	}
}

increaseObject.init();