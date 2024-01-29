<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../layout/header1.jsp" %>
<%@ include file="../layout/header2.jsp" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>getBook</title>
<style>

a {
display: block;
text-align: center;
}
</style>
</head>
<body>

<div class="container main">

<div style="width:150px; height:150px; float:left; margin-left:200px;">
<img src="${gettedBook.image }" class="img-thumbnail" alt="책 이미지">
</div>
<input type="hidden" id="bookNum" value="${gettedBook.bookNum }">
<div class="container mt-3">
  <table class="table" style="width:30%; float:left; margin-left:50px; margin-right:50px;">
      <tr>
        <td colspan=2><Strong>제목	</Strong> ${gettedBook.title }</td>
      </tr>
      <tr>
        <td colspan=2><Strong>저자	</Strong> ${gettedBook.author }</td>
      </tr>
      <tr>
        <td colspan=2><Strong>출판사	</Strong> ${gettedBook.publisher }</td>
      </tr>
      <tr>
        <td colspan=2><Strong>분류	</Strong> ${gettedBook.category }</td>
      </tr>
       <tr>
        <td><Strong>사이즈	</Strong>${gettedBook.size }</td>
        <td><Strong>페이지	</Strong>${gettedBook.pages }</td>
      </tr>
  </table>
</div>

<div>
  <table class="table" style="width:15%; float:left;">
	<tr>
		<td><a href="#">관심도서 수</a></td>
	</tr>
	<tr>
		<td><a href="#">대출회수</a></td>
	</tr>
	<tr>
		<td><a href="#" id="btn-rent">대출하기</a></td>
		<td><a href="#" id="btn-returnBook">반납하기</a></td>
	</tr>
  </table>
</div>

<script src="/js/rentBook.js"></script>
<script src="/js/returnBook.js"></script>

<div>
  <table class="table" style="width:70%; margin-left:200px">
	<tr>
		<td style="width:15%;"><Strong>도서 설명</Strong></td>
	</tr>
	<tr>
		<td>${getttedBook.info }
	</tr>
  </table>
</div>


<div class="review" style="width:70%; margin-left:200px;">
   <label for="content">도서 후기 등록하기</label>
    <input type="text" id="content" name="content" class="form-control">
    <a href="#" class="btn btn-primary" id="btn-review" style="float:right;">후기 등록</a>
</div>

<script src="/js/insertReview.js"></script>

<br>
<br>
<div class="container mt-3" style="width:70%; margin-left:200px;">
<c:forEach items="${reviewList }" var="views">
 <div class="card">
    <div class="card-body">
      <p>${views.content }</p>
    </div>
</div>
</c:forEach>
</div>
</div>

<%@ include file="../layout/footer.jsp" %>
</body>
</html>