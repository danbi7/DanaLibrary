let book2Obj = {
	init: function() {
		let _this = this;

		$(".btn-rent").on("click", function() {
			if (checkUserIdAndInitBook2Obj()) {
				let bookNumber = $(this).data('booknum');
				_this.rentBook(bookNumber);
			}
		});

		$(".btn-reserve").on("click", function() {
			if (checkUserIdAndInitBook2Obj()) {
				let bookNumber = $(this).data('booknum');
				_this.reserveBook(bookNumber);
			}
		});

		$(".btn-reserve-cancel").on("click", function() {
			if (checkUserIdAndInitBook2Obj()) {
				let bookNumber = $(this).data('booknum');
				_this.cancelReserve(bookNumber);
			}
		});

		$(".btn-returnBook").on("click", function() {
			if (checkUserIdAndInitBook2Obj()) {
				let bookNumber = $(this).data('booknum');
				_this.returnBook(bookNumber);
			}
		});

		$(".btn-removeInterest").on("click", function() {
			if (checkUserIdAndInitBook2Obj()) {
				let bookNumber = $(this).data('booknum');
				_this.removeInterest(bookNumber);
			}
		});

		$(".btn-addInterest").on("click", function() {
			if (checkUserIdAndInitBook2Obj()) {
				let bookNumber = $(this).data('booknum');
				_this.addInterest(bookNumber);
			}
		});
	},


	rentBook: function(bookNumber) {

		$.ajax({
			type: "POST",
			url: "/rent/rentBook/" + bookNumber,
			contentType: "application/json; charset=utf-8"
		}).done(function(response) {
			alert(response.data);
			location.reload();
		}).fail(function(error) {
			alert("에러 발생: " + error);
		});

	},

	reserveBook: function(bookNumber) {

		$.ajax({
			type: "POST",
			url: "/reserve/reserveBook/" + bookNumber,
			contentType: "application/json; charset=utf-8"
		}).done(function(response) {
			alert(response.data);
			location.reload();
		}).fail(function(error) {
			alert("에러 발생: " + error);
		});
	},

	cancelReserve: function(bookNumber) {

		$.ajax({
			type: "DELETE",
			url: "/reserve/cancelReservation/" + bookNumber,
			contentType: "application/json; charset=utf-8"
		}).done(function(response) {
			alert(response.data);
			location.reload();
		}).fail(function(error) {
			alert("에러 발생: " + error);
		});
	},

	returnBook: function(bookNumber) {

		$.ajax({
			type: "PUT",
			url: "/rent/returnBook/" + bookNumber,
			contentType: "application/json; charset=utf-8"
		}).done(function(response) {
			alert(response.data);
			location.reload();
		}).fail(function(error) {
			alert("에러 발생: " + error);
		});
	},

	addInterest: function(bookNumber) {
		$.ajax({
			type: "POST",
			url: "/book/addInterestedBook/" + bookNumber,
			contentType: "application/json; charset=utf-8"
		}).done(function(response) {
			alert(response.data);
			location.reload();
		}).fail(function(error) {
			alert("에러 발생: " + error);
		});

	},

	removeInterest: function(bookNumber) {
		$.ajax({
			type: "DELETE",
			url: "/book/removeInterestedBook/" + bookNumber,
			contentType: "application/json; charset=utf-8"
		}).done(function(response) {
			alert(response.data);
			location.reload();
		}).fail(function(error) {
			alert("에러 발생: " + error);
		});
	}

}

function checkUserIdAndInitBook2Obj() {
	console.log($("#userid").val());
	if ($("#userid").val() === null || $("#userid").val() === "") {
		alert("로그인 후 이용 가능합니다.");
		location = "/user/view/login";
		return false;
	} else {
		return true;
	}
}

book2Obj.init();
