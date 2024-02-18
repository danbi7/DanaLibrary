let bookReq = {

	init: function() {
		let _this = this; // 변수명 오타 수정

		$("#btn-request").on("click", function() {
			_this.bookRequest();
		});
	},


	bookRequest: function() {

		let book = {
			title: $("#title").val(),
			author: $("#author").val(),
			publisher: $("#publisher").val()
		}

		$.ajax({
			type: "POST",
			url: "/admin/bookRequest",
			data: JSON.stringify(book),
			contentType: "application/json; charset=utf-8"
		}).done(function(response) {
			alert(response.data);
			window.close();
			location = "/view/bookRequest";
		}).fail(function(error) {
			let message = error.responseJSON.data; // 'responseJSON'으로 수정
			alert("에러 발생 : " + message)
		});
	}

}

bookReq.init();
