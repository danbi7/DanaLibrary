<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<style>
.truncate-text {
    white-space: nowrap;
    overflow: hidden;
    text-overflow: ellipsis;
    max-width: 100px; /* Adjust the max-width according to your needs */
}
</style>
<script>
	function openEditWindow(userid) {
		window.open('/view/userEdit/' + userid, '_blank',
				'width=800,height=800');
	}	
</script>
</head>
<body>

	<div class="table-responsive" style="margin-top: 20px;">
    <table class="table">
        <thead>
            <tr>
                <th>번호</th>
                <th>제목</th>
                <th>저자</th>
                <th>출판사</th>
                <th>신청자</th>
                <th>신청일</th>
                <th>신청 상태</th>
                <th>확인</th>
            </tr>
        </thead>

        <tbody>
            <c:forEach var="request" items="${bookRequest}">
                <tr>
                    <td>${request.requestNum}</td>
                    <td>
                        <div class="truncate-text">${request.title}</div>
                    </td>
                    <td>
                        <div class="truncate-text">${request.author}</div>
                    </td>
                    <c:choose>
                        <c:when test="${empty request.publisher}">
                            <td>-</td>
                        </c:when>
                        <c:otherwise>
                            <td>
                                <div class="truncate-text">${request.publisher}</div>
                            </td>
                        </c:otherwise>
                    </c:choose>
                    <td>${request.user.userid}</td>
                    <td>${request.requestDate}</td>
                    <td>${request.requestStatus}</td>
                    <td>
                        <div class="admin-edit">
                            <img class="edit-btn" src="/image/icon/icon-edit-button.png"> 
                        </div>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

      <script src="/js/admin/deleteUser.js"></script>

</body>

</html>