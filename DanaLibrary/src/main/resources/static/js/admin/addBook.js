let addBook = {

    init: function() {
        let _this = this;

        $(".btn-add").on("click", function() {

            _this.insertBook();
        });
    },


    insertBook: function() {
        var formData = new FormData();
        formData.append("title", $("#title").val());
        formData.append("author", $("#author").val());
        formData.append("publisher", $("#publisher").val());
        formData.append("publicationDate", $("#publicationDate").val());
        formData.append("category", $("#category").val());
        formData.append("pages", $("#pages").val());
        formData.append("info", $("#info").val());
       	formData.append("file", $("#file")[0].files[0]);

        $.ajax({
            type: "POST",
          	url: "/admin/addBook",
            data: formData,
            processData: false,
            contentType: false,
            success: function (response) {
                alert("도서를 추가하였습니다");
                window.close();
            },
            error: function (error) {
                alert("도서 추가를 실패하였습니다");
            }
        });
    }

}

addBook.init();
