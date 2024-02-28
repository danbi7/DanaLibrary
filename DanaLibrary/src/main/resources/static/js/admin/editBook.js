let editBook = {

    init: function() {
        let _this = this;

        $(".btn-edit").on("click", function() {
			alert("확인");
            _this.updateBook();
        });
    },


    updateBook: function() {
        var formData = new FormData();
        formData.append("bookNum", $("#bookNum").val());
        formData.append("title", $("#title").val());
        formData.append("author", $("#author").val());
        formData.append("publisher", $("#publisher").val());
        formData.append("publicationDate", $("#publicationDate").val());
        formData.append("category", $("#category").val());
        formData.append("pages", $("#pages").val());
        formData.append("info", $("#info").val());
       	formData.append("file", $("#file")[0].files[0]);

        $.ajax({
            type: "PUT",
          	url: "/admin/updateBook/" + $("#bookNum").val(),
            data: formData,
            processData: false,
            contentType: false,
            success: function (response) {
                alert("도서 정보가 수정되었습니다.");
                window.close();
            },
            error: function (error) {
                alert("도서 정보 수정에 실패했습니다.");
            }
        });
    }

}

editBook.init();
