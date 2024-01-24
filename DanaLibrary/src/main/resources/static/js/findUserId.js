let findUserIdObj = {
    init: function(){
        let _this=this;

        $("#btn-findId").on("click",()=>{
            _this.findUserId();
        });
    },

    findUserId: function(){
        alert("아이디찾기가 요청되었습니다");

        let user = {
            email: $("#email").val(),
            username: $("#username").val(),
            birthDate: $("#birthDate").val()
        }

        $.ajax({
            type: "POST",
            url: "/user/findUserId",
            data: JSON.stringify(user),
            contentType: "application/json; charset=utf-8"
        }).done(function(response){
            if(response.status == 200){
				alert("아이디 찾기 완료");
				location = "/";
			}else{
				alert("회원정보 없음");
			}
        }).fail(function(error){
            alert("에러 발생: " + error);
        });
    }
};

findUserIdObj.init();
