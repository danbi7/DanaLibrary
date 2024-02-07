let rentBookObj = {
	
	init: function(){
		let _this=this;
		
		$("#btn-rent").on("click",()=>{
			_this.rentBook();
		});
	},
	
	rentBook: function(){
		
		$.ajax({
			type: "POST",
			url: "/rent/rentBook/" + $("#bookNum").val(),
			//data: JSON.stringify($("#bookNum").val()),
			contentType: "application/json; charset=utf-8"
		}).done(function(response) {
			
			if (response.status === 200) {
                alert("대출 완료");
                location = "/book/getBook/"+$("#bookNum").val();
            }else {
                alert(response.data);
				location = "/book/getBook/"+$("#bookNum").val();
            }
		}).fail(function(error){
			alert("에러 발생: " + error);
		});
	}
	
}
rentBookObj.init();