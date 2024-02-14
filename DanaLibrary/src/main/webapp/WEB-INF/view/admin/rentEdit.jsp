<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/css/main.css">
<link rel="stylesheet" type="text/css" href="/css/myPage.css">

<link href="/webjars/bootstrap/5.1.3/css/bootstrap.min.css"
	rel="stylesheet">
<script src="/webjars/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
<script src="/webjars/jquery/3.6.0/dist/jquery.min.js"></script></head>
<body>
	
	<div class="container mt-5 d-flex justify-content-center">
            
  <table class="table table-bordered" style="width: 600px;">
    <tr>
    	<td rowspan="5" style="width: 200px;"><div style="display: flex; align-items: center; justify-content: center;">
        <img src="${rent.book.image}" style="width: 160px; height: 190px;">
    </div></td>
        <td  class="text-center">대출 번호</td>
        <td  class="text-center">${rent.rentNum}</td>
    </tr>
    <tr>
   
    	<td class="text-center">대출 도서</td>
        <td class="text-center">
        	<c:choose>
                    <c:when test="${fn:length(rent.book.title) <= 10}">
                        ${rent.book.title}
                    </c:when>
                    <c:otherwise>
                        ${fn:substring(rent.book.title, 0, 10)}...
                    </c:otherwise>
           	</c:choose></td>
    </tr>
    <tr>
    
    	  <td  class="text-center">대출 상태</td>
        <td  class="text-center"><c:choose>
						<c:when test="${rent.rentStatus eq 'ACTIVE'}">대출중</c:when>
						<c:when test="${rent.rentStatus eq 'INACTIVE'}">반납</c:when>
						<c:otherwise>기타 상태</c:otherwise>
					</c:choose></td>
   	</tr>
   	 <tr>
   	 	
        <td  class="text-center">대출일</td>
        <td class="text-center">${rent.rentDate}</td>
     </tr>
     <tr>
     
      <td  class="text-center">반납일</td>
        <td class="text-center">${rent.dueDate}</td>
    </tr>
</table>

</div>

<div class="container d-flex justify-content-center">
<button class="btn-renewal btn btn-outline-primary custom-button mx-2" type="button" data-rent-num="${rent.rentNum}">연장하기</button>
<button class="btn-return btn btn-outline-danger custom-button" type="button" data-rent-num="${rent.rentNum}">반납하기</button>
</div>

<script src="/js/book/renewalRent.js"></script>

</body>
</html>