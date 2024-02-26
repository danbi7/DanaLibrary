let renewalRent = {

   init: function() {
        let _this = this;
        $(".btn-renewal").on("click", function() {
            let rentNum = $(this).data("rent-num");
            _this.renewal(rentNum);
        });
        $(".btn-return").on("click", function() {
            let rentNum = $(this).data("rent-num");
            _this.return(rentNum);
        });
    },


   renewal: function(rentNum) {
      
      $.ajax({
         type: "PUT",
         url: "/rent/renewalRent/" + rentNum,
         contentType: "application/json; charset=utf-8"
      }).done(function(response) {
         if(response.status===200){
            alert(response.data);
         }
         else if(response.status===400){
            alert(response.data);
         }
         else{
            alert(response.data);
         }

      }).fail(function(error) {
         let message = error.responseJSON.data; // 'responseJSON'으로 수정
         alert("에러 발생 : " + message)
      });
   },
   
   return: function(rentNum) {
      
      $.ajax({
         type: "PUT",
         url: "/rent/returnRent/" + rentNum,
         contentType: "application/json; charset=utf-8"
      }).done(function(response) {
            if(response.status===200){
               alert(response.data);
            }
            else{
               alert(response.data);
            }
            
      }).fail(function(error) {
         let message = error.responseJSON.data; // 'responseJSON'으로 수정
         alert("에러 발생 : " + message)
      });
   }


}

renewalRent.init();