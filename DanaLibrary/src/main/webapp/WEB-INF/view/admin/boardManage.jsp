<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>

</head>
<body>

	<div class="table-responsive" style="margin-top: 20px;">
		<table class="table">
			<thead></thead>
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>카테고리</th>
					<th>작성일</th>
					<th>조회수</th>
					<th>추천수</th>
					<th class="text-center">삭제</th>
				</tr>
			</thead>

			<c:forEach var="board" items="${boardList}">
				<tbody>
					<tr>
						<td>${board.boardNum}</td>
						<td><a href="/board/view/getBoard/${board.boardNum }">${board.title}</a></td>
						<td>${board.user.userid}</td>
						<td>${board.category.category}</td>
						<td>${board.regDate}</td>
						<td>${board.views}</td>
						<td>${board.likes}</td>
						<td>
							 <div class="admin-edit">
								<img class="delete-btn" src="/image/icon/icon-delete-button.png"
									onclick="confirmDelete('${board.boardNum}')">
							</div>
						</td>
					</tr>

				</tbody>
			</c:forEach>

		</table>
	</div>
	
	<script>
    function confirmDelete(boardNum) {
        var result = confirm("글을 삭제하시겠습니까?");
        if (result) {
            // 사용자가 '예'를 클릭하면 삭제 함수를 호출합니다.
            deleteBoard(boardNum);
        }
    }

    function deleteBoard(boardNum) {
        // Ajax를 사용하여 서버에 보드를 삭제하도록 호출합니다.
    	$.ajax({
    	    type: 'DELETE',
    	    url: '/board/deleteBoard/' + boardNum,
    	    success: function(response) {
    	        // 성공적으로 처리할 경우 페이지를 새로 고치거나 UI를 업데이트합니다.
    	        alert("게시판이 성공적으로 삭제되었습니다.");
    	    },
    	    error: function(error) {
    	        alert('게시판 삭제 중 오류가 발생했습니다.');
    	    }
    	});
    }
</script>
</body>

</html>
     

