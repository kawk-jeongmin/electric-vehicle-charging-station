<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" contentType="text/html; charset=UTF-8" %>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/myInfoSearch" method="get">
    <label for="reserve_name">예약자 이름:</label>
    <input type="text" id="reserve_name" name="reserve_name"><br>
    <label for="reserve_phone">예약자 전화번호:</label>
    <input type="text" id="reserve_phone" name="reserve_phone"><br>
    <p>* 전화번호는 하이픈 없이 입력해주세요</p>
    <button type="submit">Search</button>
</form>
<h2>Search Result</h2>
<c:if test="${not empty myInfoList}">
    <table>
        <thead>
            <tr>
                <th>예약 시간</th>
                <th>주소</th>
                <th>예약자 이름</th>
                <th>예약자 전화번호</th>
                <th>충전기 타입</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="myInfo" items="${myInfoList}">
                <tr>
                    <td>${myInfo.reserve_time}</td>
                    <td>${myInfo.address}</td>
                    <td>${myInfo.user_name}</td>
                    <td>${myInfo.user_phone}</td>
                    <td>${myInfo.charge_type}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</c:if>
</body>
</html>