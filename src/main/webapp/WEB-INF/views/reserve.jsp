<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" contentType="text/html; charset=UTF-8" %>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>예약이 완료되었습니다!</h1>
    <h2>예약 정보</h2>
    <p>장소 ID: ${loc_id}</p>
    <p>장소 이름: ${loc_name}</p>
    <p>주소: ${address}</p>
    <p>예약자 이름: ${user_name}</p>
    <p>예약자 전화번호: ${user_phone}</p>
    <p>결제 방식: ${charge_type}</p>
    <p>예약 시간: ${reserve_time}</p>
</body>
</html>