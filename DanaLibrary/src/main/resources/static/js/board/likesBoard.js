let likesBoardObject = {

	init: function() {
		let _this = this; // 변수명 오타 수정
		$("#btn-like").on("click", function() {
			_this.likesBoard();
		});
	},

	likesBoard: function() {



		$.ajax({
			type: "POST",
			url: "/board/likesBoard/" + $("#boardNum").val(),
			contentType: "application/json; charset=utf-8"
		}).done(function(response) { // done 대신 success 사용
			alert("게시글추천")
			location.href =  $("#boardNum").val(); // location 속성 수정
		}).fail(function(error) { // fail 대신 error 사용
			alert("에러 발생: " + error.responseText);

		});

	}

}

likesBoardObject.init();