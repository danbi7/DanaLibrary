let returnBookObj = {
	
	init: function(){
		let _this=this;
		
		$("#btn-returnBook").on("click",()=>{
			_this.returnBook();
		});
	},
	
	returnBook: function(){
		alert("책 반납하기가 요청되었습니다");
		
		//alert($("#bookNum").val());
		
		$.ajax({
			type: "DELETE",
			url: "/rent/returnBook/" + $("#bookNum").val(),
			//data: JSON.stringify($("#bookNum").val()),
			contentType: "application/json; charset=utf-8"
		}).done(function(response) {
			alert("반납성공");
			location = "/"
		}).fail(function(error){
			alert("에러 발생: " + error);
		});
	}
	
}
returnBookObj.init();