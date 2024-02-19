let searchBoardObj = {
	
	init: function(){
		let _this=this;
		
		$("#btn-searchBoard").on("click",()=>{
			_this.searchBoard();
		});
	},
	
	searchBoard: function(){
		alert("제목찾기가 요청되었습니다");
		
		let board={
			title: $("#title").val(),
			category: $("#category1").val()
		}
		alert($("#title").val() +" "+ $("#category1").val());
		
		/*
		if(board.category === '카테고리' && board.keyword === ''){
			alert("둘다 없음" + board.category + board.keyword);
			delete board.category;
			delete board.keyword;
		}else if (board.category === '카테고리') {
			alert("카테고리 없이 검색");
            delete board.category;
        }else if(board.keyword === ''){
			alert("키워드 없이 검색" );
			delete board.keyword;
		}
		*/
		
		$.ajax({
			type: "GET",
			url: "/board/getBoardList",
			data: JSON.stringify(board),
			/*{
				keyword: board.keyword,
				category: board.category
			},*/
			contentType: "application/json; charset=utf-8"//"application/x-www-form-urlencoded"
		}).done(function(response){
			alert("제목찾기 완료");
			location = "/board/getBoardList"
		}).fail(function(error){
			alert("에러 발생: " + error);
		});
	}
	
}

searchBoardObj.init();

