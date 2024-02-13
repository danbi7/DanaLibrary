let boardObject = {

   init: function() {
      let _this = this; // 변수명 오타 수정
      $("#btn-delete").on("click", function() {
         _this.deleteBoard();
      });
   },
   
	deleteBoard: function() {

      $.ajax({
         type: "DELETE",
         url: "/board/deleteBoard/" + $("#boardNum").val(),
         contentType: "application/json; charset=utf-8"
      }).done(function(response) { // done 대신 success 사용
      	 alert("게시글이 삭제되었습니다.")
         location.href = "/public/board/view/getBoardList"; // location 속성 수정
      }).fail(function(error) { // fail 대신 error 사용

         alert("에러 발생: " + error.responseText);

      });

   }

}

boardObject.init();