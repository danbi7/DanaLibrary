let commentObject = {
    init: function() {
        let _this = this;

        $("#btn-submit-comment").on("click", function() {
            _this.submitComment();
        });
    },

    submitComment: function() {
        let commentContent = $("#comment-content").val();
        
        // Ajax - 비동기 호출
        $.ajax({
            type: "POST", // 요청 방식
            url: "/comment/register", // 요청 경로
            data: { content: commentContent },
            contentType: "application/x-www-form-urlencoded; charset=UTF-8"
        }).done(function(response) {
            console.log(response); // 콘솔창에 응답 메세지 출력
            if (response.status === 200) {
                alert("댓글이 등록되었습니다.");
                location.reload(); // 페이지 새로고침
            } else {
                alert("댓글 등록에 실패했습니다.");
            }
        }).fail(function(error) {
            alert("에러 발생 : " + error);
        });
    }
}

commentObject.init();