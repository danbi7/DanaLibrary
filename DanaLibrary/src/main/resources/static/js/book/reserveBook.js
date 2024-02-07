let reserveBook = {

    init: function () {
        let _this = this;

        $(".btn-reserve").on("click", function () {
            let bookNumber = $(this).data('booknum');
            _this.reserveBook(bookNumber);
        });

        $(".btn-reserve-cancel").on("click", function () {
            let bookNumber = $(this).data('booknum');
            _this.cancelReserve(bookNumber);
        });
    },

    reserveBook: function (bookNumber) {
        $.ajax({
            type: "POST",
            url: "/reserve/reserveBook/" + bookNumber,
            contentType: "application/json; charset=utf-8"
        }).done(function (response) {
            if (response.status === 200) {
                alert("예약 완료");
                location = "/book/getBook/" + bookNumber;
            } else {
                alert(response.data);
            }
        }).fail(function (error) {
            alert("에러 발생: " + error);
        });
    },

    cancelReserve: function (bookNumber) {
        $.ajax({
            type: "DELETE",
            url: "/reserve/cancelReservation/" + bookNumber,
            contentType: "application/json; charset=utf-8"
        }).done(function (response) {
            if (response.status === 200) {
                alert("예약 취소 완료");
                location = "/book/getBook/" + bookNumber;
            } else {
                alert(response.data);
            }
        }).fail(function (error) {
            alert("에러 발생: " + error);
        });
    }
};

reserveBook.init();