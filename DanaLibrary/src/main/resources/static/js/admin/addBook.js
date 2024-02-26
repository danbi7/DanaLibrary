let addBook = {

	init: function() {
		let _this = this; // 변수명 오타 수정

		$("#btn-add").on("click", function() {
			_this.addBook();
		});
	},


	addBook: function() {

		let Book = {
			title: $("#title").val(),
			author: $("#author").val(),
			publisher: $("#publisher").val(),
			publicationDate: $("#publicationDate").val(),
			category: $("#category").val(),
			info: $("#info").val()
		}

		$.ajax({
			type: "POST",
			url: "/admin/addBook",
			data: JSON.stringify(Book),
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

addBook.init();
