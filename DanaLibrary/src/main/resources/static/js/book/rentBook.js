let rentBookObj = {
    init: function () {
        let _this = this;

        // Using arrow function here may cause issues with 'this', so using a regular function
        $(".btn-rent").on("click", function () {
            // Get the bookNumber from the clicked button
            let bookNumber = $(this).data('booknum');
            _this.rentBook(bookNumber);
        });
    },

    rentBook: function (bookNumber) {
        $.ajax({
            type: "POST",
            url: "/rent/rentBook/" + bookNumber,
            // data: JSON.stringify($("#bookNum").val()),
            contentType: "application/json; charset=utf-8"
        }).done(function (response) {
            if (response.status === 200) {
                alert("대출 완료");
                location = "/book/getBook/" + bookNumber;
            } else {
                alert(response.data);
                location = "/book/getBook/" + bookNumber;
            }
        }).fail(function (error) {
            alert("에러 발생: " + error);
        });
    }
};

rentBookObj.init();