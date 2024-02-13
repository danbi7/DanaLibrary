<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
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
			<thead></thead>
			<thead>
				<tr>
					<th>번호</th>
					<th>이름</th>
					<th>아이디</th>
					<th>이메일</th>
					<th>가입일</th>
					<th>생년월일</th>
					<th>회원상태</th>
					<th class="text-center">수정</th>
				</tr>
			</thead>

			<c:forEach var="user" items="${userList}">
				<tbody>
					<tr>
						<td>${user.userNum}</td>
						<td>${user.username}</td>
						<td>${user.userid}</td>
						<td>${user.email}</td>
						<td>${user.regDate}</td>
						<td>${user.birthDate}</td>
						<td>${user.userStatus.status}</td>
						<td>
							<div class="admin-edit">
								<img class="edit-btn" src="/image/icon/icon-edit-button.png"
									onclick="openEditWindow('${user.userid}')"> 
									
				
							</div>
						</td>
					</tr>

				</tbody>
			</c:forEach>

		</table>
	</div>

</body>

</html>
      <script src="/js/admin/deleteUser.js"></script>

