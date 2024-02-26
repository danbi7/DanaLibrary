<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>DANA LIBRARY</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="/webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
    <script src="/webjars/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
    <script src="/webjars/jquery/3.6.0/dist/jquery.min.js"></script>
    <script src="/webjars/summernote/0.8.10/summernote-bs4.min.js"></script>
    <link rel="stylesheet" type="text/css" href="/css/main.css">
    <link rel="stylesheet" type="text/css" href="/css/myPage.css">
    <link rel="stylesheet" type="text/css" href="/css/result.css">
</head>
<body>
    <div class="container-bookRequest">
        <div class="col-md-7 col-lg-8">
            <hr class="my-4">
            <div class="col-12 text-center">
                <h4 class="mb-3">희망도서 신청</h4>
            </div>
            <hr class="mt-4">
            <table class="table">
                <tbody>
                    <tr>
                        <td>도서 제목 *</td>
                        <td>${request.title}</td>
                    </tr>
                    <tr>
                        <td>저자 *</td>
                        <td>${request.author}</td>
                    </tr>
                    <tr>
                        <td>출판사</td>
                        <td>${request.publisher}</td>
                    </tr>
                    <!-- 기타 필요한 데이터 출력 추가 -->
                </tbody>
            </table>
            <div class="col-12 mt-4 text-center">
                <button id="btn-check" class="btn btn-outline-primary">확인</button>
                <button id="btn-cancel" class="btn btn-outline-danger">반려</button>
            </div>
            <hr class="my-4">
        </div>
    </div>

</body>
</html>
