let book1Obj = {
	
	init: function(){
		let _this=this;
		
		$("#btn-rent").on("click",()=>{
			_this.rentBook();
		});
		
		$("#btn-reserve").on("click",()=>{
			_this.reserveBook();
		});
		
		$("#btn-reserve-cancel").on("click",()=>{
			_this.cancelReserve();
		});
		
		$("#btn-returnBook").on("click",()=>{
			_this.returnBook();
		});
		
		$("#btn-review2").on("click",()=>{
			_this.insertReview();
		});
		
		
		$(".btn-deleteReview").on("click", function() {
			let reviewNumber = $(this).data('reviewnum');
			_this.deleteReview(reviewNumber);
		});
	},
	
	rentBook: function(){
		
		$.ajax({
			type: "POST",
			url: "/rent/rentBook/" + $("#bookNum").val(),
			//data: JSON.stringify($("#bookNum").val()),
			contentType: "application/json; charset=utf-8"
		}).done(function(response) {
			alert(response.data);
			location.reload();
		}).fail(function(error) {
			alert("에러 발생: " + error);
		});
	},
	
	reserveBook: function(){
		
		$.ajax({
			type: "POST",
			url: "/reserve/reserveBook/" + $("#bookNum").val(),
			contentType: "application/json; charset=utf-8"
		}).done(function(response) {
			alert(response.data);
			location.reload();
		}).fail(function(error) {
			alert("에러 발생: " + error);
		});
	},
	
	cancelReserve: function(){
		
		$.ajax({
			type: "DELETE",
			url: "/reserve/cancelReservation/" + $("#bookNum").val(),
			contentType: "application/json; charset=utf-8"
		}).done(function(response) {
			alert(response.data);
			location.reload();
		}).fail(function(error) {
			alert("에러 발생: " + error);
		});
	},
	
	returnBook: function(){
		
		$.ajax({
			type: "PUT",
			url: "/rent/returnBook/" + $("#bookNum").val(),
			//data: JSON.stringify($("#bookNum").val()),
			contentType: "application/json; charset=utf-8"
		}).done(function(response) {
			alert(response.data);
			location.reload();
		}).fail(function(error) {
			alert("에러 발생: " + error);
		});
	},
	
	insertReview: function() {
		let bookReview = {
			content : $("#content").val()
		}
		
		$.ajax({
			type: "POST",
			url: "/review/insertReview",
			data: JSON.stringify(bookReview),
			contentType: "application/json; charset=utf-8"
		}).done(function(response) {
			
			if (response.status === 200) {
                alert(response.data);
                location = "/book/getBook/"+$("#bookNum").val();
            }else {
                alert(response.data);
				location = "/book/getBook/"+$("#bookNum").val();
            }
			
		}).fail(function(error) {
			alert("에러 발생: " + error);
		});
	},
	
	deleteReview: function(reviewNumber) {
		
		$.ajax({
			type: "DELETE",
			url: "/review/deleteReview/" + reviewNumber,
			//data: JSON.stringify(review),
			contentType: "application/json; charset=utf-8"
		}).done(function(response) {
			if (response.status === 200) {
				alert("리뷰 삭제 완료");
				location = "/book/getBook/" + $("#bookNum").val();
            }else {
                alert(response.data);
            }
		}).fail(function(error){
			alert("에러 발생: " + error);
		});
	}
	
}

book1Obj.init();