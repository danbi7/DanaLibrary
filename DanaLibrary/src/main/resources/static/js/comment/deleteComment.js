let deleteCommentObject = {

   init: function() {
      let _this = this;
      $(".btn-delete-comment").on("click", function() {
         let commentNum = $(this).data("comment-num");
         _this.deleteComment(commentNum);
      });
   },
   
   deleteComment: function(commentNum) {
      $.ajax({
         type: "DELETE",
         url: "/comment/delete/" + commentNum, 
         contentType: "application/json; charset=utf-8",
         dataType: "json"
      }).done(function(response) {
         console.log(response);
         alert("댓글이 삭제되었습니다.");
         location.reload(); 
      }).fail(function(error) {
         alert("댓글 삭제에 실패했습니다. 에러: " + error.responseText);
      });
   }

}

deleteCommentObject.init();