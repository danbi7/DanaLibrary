<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container">          
  <table class="table table-hover mt-3">
    <thead>
      <tr>
        <th>도서 제목</th>
        <th>저자</th>
        <th>신청자</th>
        <th>상태</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach var="book" items="${bookRequestList}">
      <tr>
        <td>${book.title }</td>
        <td>${book.author }</td>
        <td>${book.user.userid }</td>
        <td>${book.requestStatus.status }</td>
      </tr>
      </c:forEach>
    </tbody>
  </table>

<div class="text-center mt-3">  
<button class="btn btn-outline-primary" onclick="openEditWindow()">도서 신청하기</button>
</div>
  </div>
  
<script>
	function openEditWindow() {
		window.open('/view/bookRequest','_blank',
				'width=700,height=500');
	}	
</script>