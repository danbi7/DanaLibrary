let notice = {
    init: function() {
        let _this = this;

        $(".btn-rent").on("click", function() {
            var bookNum = $(this).data("book-num");
            _this.rent(bookNum);
        });

        $(".btn-cancel").on("click", function() {
            _this.deleteNotice();
        });
    },

    rent: function(bookNum) {
        let _this = this;  // 새로운 _this 변수를 생성하여 함수 내부에서 사용

        $.ajax({
            type: "POST",
            url: "/rent/rentBook/" + bookNum,
            contentType: "application/json; charset=utf-8"
        }).done(function(response) {
            if (response.status === 200) {
                alert("대출 완료");
                _this.deleteNotice();
            } else {
                alert(response.data);
            }
        }).fail(function(error) {
            alert("에러 발생: " + error);
        });
    },

    deleteNotice: function() {
        $.ajax({
            type: "GET",
            url: "/notice/deleteNotice",
        }).done(function(response) {
            if (response.status === 200) {
                alert("예약 도서 처리 완료");
                window.close();
            } else {
                alert(response.data);
            }
        }).fail(function(error) {
            alert("에러 발생: " + error);
        });
    }
}

// notice 객체 초기화
notice.init();
