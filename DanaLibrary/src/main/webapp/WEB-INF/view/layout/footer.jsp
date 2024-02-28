<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.dana.library.domain.*"%>
    
<div class="container">
  <footer class="py-3 my-4">
    <ul class="nav justify-content-center border-bottom pb-3 mb-3">
      <li class="nav-item"><a href="/" class="nav-link px-2 text-muted">메인</a></li>
      <li class="nav-item"><a href="/view/libraryInfo" class="nav-link px-2 text-muted">도서관 이용안내</a></li>
      <li class="nav-item"><a href="/public/book/view/getBookList" class="nav-link px-2 text-muted">도서 목록</a></li>
      <li class="nav-item"><a href="/public/book/view/getPopularBookList" class="nav-link px-2 text-muted">인기 도서 목록</a></li>
      <c:if test="${loginUser.userStatus ne Status.ADMIN }">
      <li class="nav-item"><a href="/view/myPage" class="nav-link px-2 text-muted">나의 도서관</a></li></c:if>
      <c:if test="${loginUser.userStatus eq Status.ADMIN }">
      <li class="nav-item"><a href="/view/admin" class="nav-link px-2 text-muted">관리자 페이지</a></li></c:if>
      <li class="nav-item"><a href="/public/board/view/getBoardList" class="nav-link px-2 text-muted">열린 마당</a></li>
    </ul>
    <p class="text-center text-muted">© 2024 DANA LIBRARY, All Rights Reserved</p>
  </footer>
</div>
</body>
</html>