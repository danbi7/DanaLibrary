<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.dana.library.domain.*" %>

<%@ include file="../layout/header1.jsp" %>
<%@ include file="../layout/header2.jsp" %>

<div class="row justify-content-center">
  <div class="col-md-6 text-center" style="margin: 10px;">
    <div class="d-flex">
      <div class="dropdown">
    <select name="order" class="btn btn-secondary dropdown-toggle" aria-label="Dropdown" id="category1">
              <c:forEach var="category" items="${Category.values()}">
                  <option value="${category}">${category.category }</option>
                  </c:forEach>
    </select>
</div>


      <input class="form-control me-2" type="text" placeholder="Search" id="title">
      <button class="btn btn-primary" type="button" id="btn-searchBoard">Search</button>
    </div>
  </div>
</div>

<script src="/js/searchBoard.js"></script>

<div class="container mt-3">      
  <table class="table table-hover">
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>카테고리</th>
		<th>작성일</th>
		<th>조회수</th>
		<th>추천수</th>
	</tr>
	
	<c:forEach items="${boardList }" var="boardList">
	<tr>
		<td>${boardList.boardNum }</td>
		<td><a href="/board/view/getBoard?boardNum=${boardList.boardNum }">${boardList.title }</a></td>
		<td>${boardList.user.userid }</td>
		<td>${boardList.category }</td>
		<td>${boardList.regDate }</td>
		<td>${boardList.views }</td>
		<td>${boardList.likes }</td>
	</tr>
	</c:forEach>
	
  </table>
</div>


<%@ include file="../layout/footer.jsp" %>