let postObject = {

   init: function() {
      let _this = this; // 변수명 오타 수정
      $("#write-board").on("click", function() {
         _this.insertPost();
      });
   },
   insertPost: function() {
      alert("작성완료");

      let post = {
         category: $("#category1").val(),
         title: $("#title").val(),
         content: $("#content").val()
      };
      $.ajax({
         type: "POST",
         url: "/board/writePost",
         data: JSON.stringify(post),
         contentType: "application/json; charset=utf-8"
      }).done(function(response) { // done 대신 success 사용
         console.log(response);
         alert("글등록");
         location.href = "/board/view/getBoardList"; // location 속성 수정
      }).fail(function(error) { // fail 대신 error 사용

         alert("에러 발생: " + error.responseText);

      });

   }

}

postObject.init();