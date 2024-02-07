let book2Obj = {
	
	init: function(){
		let _this=this;
		
		$(".btn-rent").on("click",function () {
			let bookNumber = $(this).data('booknum');
			_this.rentBook(bookNumber);
		});
		
		$(".btn-reserve").on("click",function () {
			let bookNumber = $(this).data('booknum');
			_this.reserveBook(bookNumber);
		});
		
		$(".btn-reserve-cancel").on("click",function () {
			let bookNumber = $(this).data('booknum');
			_this.cancelReserve(bookNumber);
		});
		
		$(".btn-returnBook").on("click",function () {
			let bookNumber = $(this).data('booknum');
			_this.returnBook(bookNumber);
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
                location = "/book/getBook/"+bookNumber;
            }else {
                alert(response.data);
				location = "/book/getBook/"+bookNumber;
            }
		}).fail(function(error){
			alert("에러 발생: " + error);
		});
		
	},
	
	reserveBook: function(bookNumber){
		
		$.ajax({
			type: "POST",
			url: "/reserve/reserveBook/" +bookNumber,
			contentType: "application/json; charset=utf-8"
		}).done(function(response) {
			if (response.status === 200) {
                alert("예약 완료");
                location = "/book/getBook/" + bookNumber;       

            }else {
                alert(response.data);
            }
		}).fail(function(error){
			alert("에러 발생: " + error);
		});
	},
	
	cancelReserve: function(bookNumber){
		
		$.ajax({
			type: "DELETE",
			url: "/reserve/cancelReservation/" + bookNumber,
			contentType: "application/json; charset=utf-8"
		}).done(function(response) {
			if (response.status === 200) {
				alert("예약 취소 완료");
				location = "/book/getBook/" + bookNumber;       
            }else {
                alert(response.data);
            }
		}).fail(function(error){
			alert("에러 발생: " + error);
		});
	},
	
	returnBook: function(bookNumber){
		
		$.ajax({
			type: "PUT",
			url: "/rent/returnBook/" + bookNumber,
			//data: JSON.stringify($("#bookNum").val()),
			contentType: "application/json; charset=utf-8"
		}).done(function(response) {
			
			if (response.status === 200) {

                alert("반납성공" + response.data);
                location = "/book/view/getBookList";

                alert("반납 완료");
                location = "/book/getBook/"+bookNumber;

            }else {
                alert("반납할 수 없음"+ response.data);
				location = "/book/getBook/"+bookNumber;
            }
			
		}).fail(function(error){
			alert("에러 발생: " + error);
		});
	}
	
}
book2Obj.init();