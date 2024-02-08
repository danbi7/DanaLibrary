/*let commentObject = {

   init: function() {
      let _this = this;
      $("#btn-insert-comment").on("click", function() {
         _this.insertComment();
      });
   },
   insertComment: function() {
      alert("댓글작성완료");

      let comment = {
         author: $("#comment-author").val(),
         content: $("#comment-content").val()
      };

      console.log(comment);

      $.ajax({
         type: "POST",
         url: "/comment/insert",
         data: JSON.stringify(comment),
         contentType: "application/json; charset=utf-8", // Content-Type을 application/json으로 설정
         dataType: "json" // 응답의 데이터 타입을 JSON으로 설정 (선택적)
      }).done(function(response) {
         console.log(response);
         alert("댓글이 등록되었습니다.");
      }).fail(function(error) {
         alert("댓글 등록에 실패했습니다. 에러: " + error.responseText);
      });
   }

}

commentObject.init();*/

let commentinsertObject = {

   init: function() {
      let _this = this;
      $("#btn-insert-comment").on("click", function() {
         _this.insertComment();
      });
   },
   
   insertComment: function() {
      // 작성한 댓글 내용 가져오기
      let author = $("#comment-author").val();
      let content = $("#comment-content").val();
      let boardNum = $("#boardNum").val(); // 게시글 번호 가져오기
      
      // 댓글 객체 생성
      let comment = {
         author: author,
         content: content,
      };

      // AJAX를 사용하여 댓글 서버로 전송
      $.ajax({
         type: "POST",
         url: "/comment/insert/" + boardNum, // URL에 게시글 번호를 추가하여 전송
         data: JSON.stringify(comment),
         contentType: "application/json; charset=utf-8",
         dataType: "json"
      }).done(function(response) {
         console.log(response);
         alert("댓글이 등록되었습니다.");
         location = "/board/view/getBoard/" + boardNum; // 글 상세 페이지로 이동
      }).fail(function(error) {
         alert("댓글 등록에 실패했습니다. 에러: " + error.responseText);
      });
   }

}

commentinsertObject.init();