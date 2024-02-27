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
                    <c:when test="${fn:length(reserve.book.title) <= 15}">
                        ${reserve.book.title}
                    </c:when>
                    <c:otherwise>
                        ${fn:substring(reserve.book.title, 0, 15)}...
                    </c:otherwise>
                      </c:choose></td>
             
            <td>
              
            </td>
            
            <td>
                    <div class="admin-edit">
                    
                        <img class="edit-btn" src="/image/icon/icon-edit-button.png" 
                       >
                    </div>
                </td>
            </tr>
        </c:forEach>
    </tbody>   

      </table>
   </div>

</body>

</html>