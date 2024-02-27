let likesBoardObject = {
	init: function() {
		let _this = this;
		$("#btn-like").on("click", function() {
			_this.likesBoard();
		});
	},

	likesBoard: function() {
		$.ajax({
			type: "POST",
			url: "/board/likesBoard/" + $("#boardNum").val(),
			contentType: "application/json; charset=utf-8"
		}).done(function(response) {
			if (response.status === 200) { // 서버 응답이 성공인 경우
				alert("게시글이 추천되었습니다.");
				location.reload(); // 페이지 새로고침
			} else { // 서버 응답이 실패인 경우
				alert("추천에 실패했습니다.");
			}
		}).fail(function(error) {
			alert("에러 발생: " + error.responseText);
		});
	}
}

likesBoardObject.init();