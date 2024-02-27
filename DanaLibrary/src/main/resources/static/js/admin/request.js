let request = {
   init: function() {
        let _this = this;
        // 수정된 클래스로 변경
        $(".btn-requestCheck").on("click", function() {
            let requestNum = $(this).data("request-num");
            // 함수명 수정
            _this.requestCheck(requestNum);
        });
       // 수정된 클래스로 변경
       $(".btn-requestCancel").on("click", function() {
            let requestNum = $(this).data("request-num");
            
            _this.requestCancel(requestNum);
        });
    },

   requestCheck: function(requestNum) {
      $.ajax({
         type: "PUT",
         url: "/admin/requestCheck/" + requestNum,
         contentType: "application/json; charset=utf-8"
      }).done(function(response) {
          alert(response.data);
          window.close();
      }).fail(function(error) {
         let message = error.responseJSON.data;
         alert("에러 발생 : " + message);
         window.close();
      });
   },
   
   requestCancel: function(requestNum) {
      $.ajax({
         type: "PUT",
         url: "/admin/requestCancel/" + requestNum,
         contentType: "application/json; charset=utf-8"
      }).done(function(response) {
          alert(response.data);
          window.close();
      }).fail(function(error) {
         let message = error.responseJSON.data;
         alert("에러 발생 : " + message);
         window.close();
      });
   },
}

// 초기화 함수 호출
request.init();