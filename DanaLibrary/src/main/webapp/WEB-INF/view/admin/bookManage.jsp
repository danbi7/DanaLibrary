<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html lang="en">
<head>
<script>
	function openEditBook(bookNum) {
		window.open('/view/bookEdit/' + bookNum, '_blank', 'width=800,height=800');
	}
	
	function openAddBook() {
		window.open('/view/addBook', '_blank', 'width=800,height=800');
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
					<th>도서명</th>
					<th>저자</th>
					<th>출판사</th>
					<th>출간일</th>
					<th>분류</th>
					<th>페이지</th>
				
					<th>이미지 경로</th>
					<th class="text-center">수정</th>
				</tr>
			</thead>
			
			<tbody>
			 <c:forEach var="book" items="${bookList.content}">
				<tr>
					<td>${book.bookNum}</td>
					<td> <c:choose>
                    <c:when test="${fn:length(book.title) <= 7}">
                        ${book.title}
                    </c:when>
                    <c:otherwise>
                        ${fn:substring(book.title, 0, 7)}...
                    </c:otherwise>
               		 </c:choose></td>
                
					<td><c:choose>
                    <c:when test="${fn:length(book.author) <= 5}">
                        ${book.author}
                    </c:when>
                    <c:otherwise>
                        ${fn:substring(book.author, 0, 5)}...
                    </c:otherwise>
               		 </c:choose></td>
					<td>${book.publisher}</td>
					<td>${book.publicationDate}</td>
					<td>${book.category}</td>
					<td>${book.pages}쪽</td>
					
					<td><c:choose>
                    <c:when test="${fn:length(book.image) <= 10}">
                        ${book.image}
                    </c:when>
                    <c:otherwise>
                        ${fn:substring(book.image, 0, 10)}...
                    </c:otherwise>
               		 </c:choose></td>
					<td><div class="admin-edit">
                        <img class="edit-btn" src="/image/icon/icon-edit-button.png" 
                        onclick="openEditBook('${book.bookNum}')">
                    </div></td>
				</tr>
				</c:forEach>
			</tbody>	

		</table>
		<div class="container my-2 d-flex">
			<button class="btn btn-outline-dark ms-auto ms-auto" type="button" onclick="openAddBook()">새 도서 등록</button>
		</div>
		
	</div>

</body>

</html>
