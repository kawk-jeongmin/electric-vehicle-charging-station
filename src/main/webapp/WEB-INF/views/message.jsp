<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" contentType="text/html; charset=UTF-8" %>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
            margin-top: 100px;
        }
        .error-message {
            color: red;
            font-size: 20px;
        }
    </style>
<body>
<form action="${pageContext.request.contextPath}/map">
<div class="box-footer">
<button type="submit" class="btn btn-primary">홈으로 돌아가기</button>
</div>
</form>
<div class="error-message">
        <h2>이미 후기를 작성하였습니다.</h2>
    </div>
    <button onclick="goBack()">이전 페이지로 돌아가기</button>

    <script>
        function goBack() {
            window.history.back();
        }
    </script>
</body>
</html>