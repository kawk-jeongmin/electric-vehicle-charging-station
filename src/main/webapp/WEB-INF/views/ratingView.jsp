<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" contentType="text/html; charset=UTF-8" %>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border=1>
        <thead>
            <tr>
            	<th>충전소 번호</th>
            	<th>사용자 이름</th>
                <th>후기 점수</th>
                <th>후기 내용</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${review}" var="review">
                <tr>
                	<td>${review.loc_id}</td>
                	<td>${review.user_name }</td>
                    <td>${review.rate_score}</td>
                    <td>${review.rate_content}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    
<form action="${pageContext.request.contextPath}/map">
<div class="box-footer">
<button type="submit" class="btn btn-primary">홈으로 돌아가기</button>
</div>
</form>
</body>
</html>