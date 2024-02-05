let returnBookObj = {
	
	init: function(){
		let _this = this;
		
		$(".btn-returnBook").on("click", function(){
			let bookNumber = $(this).data('booknum');
			_this.returnBook(bookNumber);
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
                alert("반납 완료");
                location = "/book/getBook/"+ bookNumber;
            }else {
                alert("반납할 수 없음");
				location = "/book/getBook/"+ bookNumber;
            }
			
		}).fail(function(error){
			alert("에러 발생: " + error);
		});
	}
	
}
returnBookObj.init();