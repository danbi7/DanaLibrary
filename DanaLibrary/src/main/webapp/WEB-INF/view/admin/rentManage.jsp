<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
	
<!DOCTYPE html>
<html lang="en">

<body>

	<div class="table-responsive" style="margin-top: 20px;">
		<table class="table">
		<thead></thead>
			<thead>
				<tr>
					<th>번호</th>
					<th>회원 아이디</th>
					<th>대출 도서</th>
					<th>대출 날짜</th>
					<th>반납 날짜</th>
					<th>대출 상태</th>
					<th class="text-center">수정</th>
				</tr>
			</thead>
			<tbody>
        <c:forEach var="rent" items="${rentList}">
            <tr>
                <td>${rent.rentNum}</td>
                <td>${rent.user.userid}</td>
              
               <td> <c:choose>
                    <c:when test="${fn:length(rent.book.title) <= 7}">
                        ${rent.book.title}
                    </c:when>
                    <c:otherwise>
                        ${fn:substring(rent.book.title, 0, 7)}...
                    </c:otherwise>
               		 </c:choose></td>
                <td>${rent.rentDate}</td>
                <td>${rent.dueDate}</td>
				<td>
					<c:choose>
						<c:when test="${rent.rentStatus eq 'ACTIVE'}">대출중</c:when>
						<c:when test="${rent.rentStatus eq 'INACTIVE'}">반납</c:when>
						<c:otherwise>기타 상태</c:otherwise>
					</c:choose>
				</td>
				
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

</body>

</html>
