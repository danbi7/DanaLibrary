let deleteCommentObject = {
   
   init: function() {
      let _this = this;
      $(".btn-delete-comment").on("click", function() {
         let commentNum = $(this).data("comment-num");
         _this.deleteComment(commentNum);
         alert("확인용");
      });
   },
   
   deleteComment: function(commentNum) {
    $.ajax({
        type: "DELETE",
        url: "/comment/delete/" + commentNum, // commentNum을 그대로 사용
        contentType: "application/json; charset=utf-8",
    }).done(function(response) {
        console.log(response);
        if (response.status === 200) {
            alert("댓글이 삭제되었습니다.");
            location.href = "/board/view/getBoard/" + $("#boardNum").val();
        } else {
            alert("댓글 삭제에 실패했습니다.");
        }
    }).fail(function(error) {
        alert("댓글 삭제에 실패했습니다. 에러: " + error.responseText);
    });
}

}

deleteCommentObject.init();