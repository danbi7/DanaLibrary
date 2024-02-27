let increaseObject = {

   init: function() {
      let _this = this; // 변수명 오타 수정
      $(".btn-increase").click(function() {
		var boardNum = $(this).data("comment-num");
		
		_this.increaseViews(boardNum);
		});
      
   },
   
	increaseViews: function(boardNum) {

      $.ajax({
         type: "PUT",
         url: "/board/view/updateViews/" + boardNum,
         contentType: "application/json; charset=utf-8"
      }).done(function(response) { // done 대신 success 사용
         location.href = "/board/view/getBoard/" + boardNum; // location 속성 
		
      }).fail(function(error) { // fail 대신 error 사용

         alert("에러 발생: " + error.responseText);

      });

   }

}

increaseObject.init();