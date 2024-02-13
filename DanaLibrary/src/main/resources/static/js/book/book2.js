let book2Obj = {

	init: function() {
		let _this = this;

		$(".btn-rent").on("click", function() {
			let bookNumber = $(this).data('booknum');
			_this.rentBook(bookNumber);
		});

		$(".btn-reserve").on("click", function() {
			let bookNumber = $(this).data('booknum');
			_this.reserveBook(bookNumber);
		});

		$(".btn-reserve-cancel").on("click", function() {
			let bookNumber = $(this).data('booknum');
			_this.cancelReserve(bookNumber);
		});

		$(".btn-returnBook").on("click", function() {
			let bookNumber = $(this).data('booknum');
			_this.returnBook(bookNumber);
		});

		$(".btn-removeInterest").on("click", function() {
			let bookNumber = $(this).data('booknum');
			_this.removeInterest(bookNumber);
		});

		$(".btn-addInterest").on("click", function() {
			let bookNumber = $(this).data('booknum');
			_this.addInterest(bookNumber);
		});
	},


	rentBook: function(bookNumber) {
		alert("대출이 요청됨");


		$.ajax({
			type: "POST",
			url: "/rent/rentBook/" + bookNumber,
			//data: JSON.stringify($("#bookNum").val()),
			contentType: "application/json; charset=utf-8"
		}).done(function(response) {

			if (response.status === 200) {
				alert("대출 완료");
				location = "/public/book/view/getBookList";
			} else {
				alert(response.data);
				location = "/public/book/view/getBookList";
			}
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
			if (response.status === 200) {
				alert("예약 완료");
				location = "/public/book/view/getBookList";
			} else {
				alert(response.data);
			}
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
			if (response.status === 200) {
				alert("예약 취소 완료");
				location = "/public/book/view/getBookList";
			} else {
				alert(response.data);
			}
		}).fail(function(error) {
			alert("에러 발생: " + error);
		});
	},

	returnBook: function(bookNumber) {

		$.ajax({
			type: "PUT",
			url: "/rent/returnBook/" + bookNumber,
			//data: JSON.stringify($("#bookNum").val()),
			contentType: "application/json; charset=utf-8"
		}).done(function(response) {

			if (response.status === 200) {

				alert("반납성공" + response.data);
				location = "/public/book/view/getBookList";

			} else {
				alert("반납할 수 없음" + response.data);
				location = "/public/book/getBook/" + bookNumber;
			}

		}).fail(function(error) {
			alert("에러 발생: " + error);
		});
	},

	addInterest: function(bookNumber) {
		$.ajax({
			type: "POST",
			url: "/book/addInterestedBook/" + bookNumber,
			//data: JSON.stringify($("#bookNum").val()),
			contentType: "application/json; charset=utf-8"
		}).done(function(response) {
			alert(response.data);
			location = "/public/book/view/getBookList";
		}).fail(function(error) {
			alert("에러 발생: " + error);
		});

	},

	removeInterest: function(bookNumber) {
		$.ajax({
			type: "DELETE",
			url: "/book/removeInterestedBook/" + bookNumber,
			//data: JSON.stringify($("#bookNum").val()),
			contentType: "application/json; charset=utf-8"
		}).done(function(response) {
			alert(response.data);
			location = "/public/book/view/getBookList";
		}).fail(function(error) {
			alert("에러 발생: " + error);
		});
	}

}

$(document).ready(function() {
    $(".buttons").on("click", function() {
        checkUserIdAndInitBook2Obj();
    });
});

function checkUserIdAndInitBook2Obj() {
    console.log($("#userid").val());
    if ($("#userid").val() === null || $("#userid").val() === "") {
        alert("로그인 후 이용 가능합니다.");
        location = "/user/view/login";
    }
}

book2Obj.init();