let insertReviewObj = {
	
	init: function() {
		let _this=this;
		
		$("#btn-review").on("click",()=>{
			_this.insertReview();
		});
	},
	
	insertReview: function() {
		alert("도서 후기가 요청되었습니다");
		
		let user={
			content: $("#content").val()
		}
		
		$.ajax({
			type: "POST",
			url: "/review/insertReview",
			data: JSON.stringify(user),
			contentType: "application/json; charset=utf-8"
		}).done(function(response) {
			alert("리뷰 등록 완료");
			location = "/book/getBook"
		}).fail(function(error) {
			alert("에러 발생: " + error);
		});
	}
	
}
insertReviewObj.init();