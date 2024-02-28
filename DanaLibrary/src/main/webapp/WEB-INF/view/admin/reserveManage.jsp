<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
   
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
               <th>회원 아이디</th>
               <th>예약 도서</th>
              
               <th>수정</th>
            </tr>
         </thead>
         <tbody>
        <c:forEach var="reserve" items="${reserveList}">
            <tr>
                <td>${reserve.reserveNum}</td>
                <td>${reserve.user.userid}</td>
              
               <td> <c:choose>
                    <c:when test="${fn:length(reserve.book.title) <= 50}">
                        ${reserve.book.title}
                    </c:when>
                    <c:otherwise>
                        ${fn:substring(reserve.book.title, 0, 50)}...
                    </c:otherwise>
                      </c:choose></td>
             
        
            
            	<td>
                 	<div onclick="confirmCancel('${reserve.reserveNum}')">예약취소</div>
                </td>
            </tr>
        </c:forEach>
    </tbody>   

      </table>
   </div>
   <script>
    function confirmCancel(reserveNum) {
        var result = confirm("예약을 취소하시겠습니까?");
        if (result) {
            // 사용자가 '예'를 클릭하면 삭제 함수를 호출합니다.
            deleteReserve(reserveNum);
        }
    }

    function deleteReserve(reserveNum) {
        // Ajax를 사용하여 서버에 보드를 삭제하도록 호출합니다.
    	$.ajax({
    	    type: 'DELETE',
    	    url: '/reserve/delete/' + reserveNum,
    	    success: function(response) {
    	        // 성공적으로 처리할 경우 페이지를 새로 고치거나 UI를 업데이트합니다.
    	        alert("예약 취소가 완료되었습니다.");
    	        location.reload();
    	    },
    	    error: function(error) {
    	        alert('예약 취소 중 오류가 발생하였습니다.');
    	    }
    	});
    }
</script>

</body>

</html>