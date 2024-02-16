let interestObject = {

   init: function() {
      let _this = this; // 변수명 오타 수정
      $(".btn-interest").on("click", function() {
         _this.interest();
      });
      
      $(".btn-interest-cancel").on("click", function() {
         _this.interestCancel();
      });
   },
   interest: function() {

     let interestBook = {
        bookNum: $("#bookNum").val()
     };
     
      $.ajax({
         type: "POST",
         url: "/book/addInterest",
         data: JSON.stringify(interestBook),
         contentType: "application/json; charset=utf-8"
      }).done(function(response) { // done 대신 success 사용
         alert(response.data);
         location.reload();
      }).fail(function(error) { // fail 대신 error 사용
         alert("에러 발생: " + error);

      });

   },
   
   interestCancel: function() {

     let interestBook = {
        bookNum: $("#bookNum").val()
     };
     
      $.ajax({
         type: "DELETE",
         url: "/book/cancelInterest",
         data: JSON.stringify(interestBook),
         contentType: "application/json; charset=utf-8"
      }).done(function(response) { // done 대신 success 사용
         alert(response.data);
         location.reload();
      }).fail(function(error) { // fail 대신 error 사용
         alert("에러 발생: " + error.responseText);

      });

   }

}

interestObject.init();