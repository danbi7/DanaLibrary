let reserveBook = {
	
	init: function(){
		let _this=this;
		
		$("#btn-reserve").on("click",()=>{
			_this.reserveBook();
		});
		
		$("#btn-reserve-cancel").on("click",()=>{
			_this.cancelReserve();
		});
	},
	
	reserveBook: function(){
		
		$.ajax({
			type: "POST",
			url: "/reserve/reserveBook/" + $("#bookNum").val(),
			contentType: "application/json; charset=utf-8"
		}).done(function(response) {
			if (response.status === 200) {
                alert("예약 완료");
                location = "/book/getBook/" + $("#bookNum").val();       

            }else {
                alert(response.data);
            }
		}).fail(function(error){
			alert("에러 발생: " + error);
		});
	},
	
	cancelReserve: function(){
		
		$.ajax({
			type: "DELETE",
			url: "/reserve/cancelReservation/" + $("#bookNum").val(),
			contentType: "application/json; charset=utf-8"
		}).done(function(response) {
			if (response.status === 200) {
				alert("예약 취소 완료");
				location = "/book/getBook/" + $("#bookNum").val();       
            }else {
                alert(response.data);
            }
		}).fail(function(error){
			alert("에러 발생: " + error);
		});
	}
	
}

reserveBook.init();