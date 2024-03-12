let updateBoardObject = {

	init: function() {
		let _this = this; // 변수명 오타 수정
		$("#update-board").on("click", function() {
			_this.updateboard();
		});
	},
	updateboard: function() {

		let board = {
			category: $("#category").val(),
			title: $("#title").val(),
			content: $("#content").val(),
			boardNum: $("#boardNum").val()
		};

		$.ajax({
			type: "PUT",
			url: "/board/updateBoard/" + board.boardNum,
			data: JSON.stringify(board),
			contentType: "application/json; charset=utf-8"
		}).done(function(response) { // done 대신 success 사용
			console.log(response);
			alert("글 수정완료");

			location.href = "/public/board/view/getBoardList"; // location 속성 수정
		}).fail(function(error) { // fail 대신 error 사용

			alert("에러 발생: " + error.responseText);

		});

	}

};

updateBoardObject.init();