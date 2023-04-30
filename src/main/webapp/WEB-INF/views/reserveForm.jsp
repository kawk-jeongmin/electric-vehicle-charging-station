<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" contentType="text/html; charset=UTF-8" %>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/reserves" accept-charset="UTF-8">
    <input type="hidden" name="loc_id" value="${loc_id}" />
    <input type="hidden" name="loc_name" value="${loc_name}" />
    <input type="hidden" name="address" value="${address}" />
    <label for="user_name">예약자 이름:</label>
    <input type="text" id="user_name" name="user_name" required /><br>
    <label for="user_phone">예약자 전화번호:</label>
    <input type="text" id="user_phone" name="user_phone" required /><br>
    <label for="charge_type">충전 방법:</label>
    <select id="charge_type" name="charge_type">
        <option value="AC">AC</option>
        <option value="DC">DC</option>
    </select><br>
       
    <label for="reserve_time">예약시간:</label>
	<input type="datetime-local" id="reserve_time" name="reserve_time"
       required min="${LocalDateTime.now().withHour(9).withMinute(0).withSecond(0).format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)}"
       max="${LocalDateTime.now().plusMonths(1).withHour(21).withMinute(0).withSecond(0).format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)}"
       step="3600"
       value="${LocalDateTime.now().withMinute(0).withSecond(0).format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)}"/><br>
       
	<input type="submit" value="예약하기"
       onclick="if (new Date(document.getElementById('reserve_time').value).getTime() < Date.now()) {
           alert('지난 날짜는 예약할 수 없습니다.');
           return false;
       } else if (new Date(document.getElementById('reserve_time').value).getHours() 
       < 9 || new Date(document.getElementById('reserve_time').value).getHours() >= 21) {
           alert('9시부터 21시까지만 예약 가능합니다.');
           return false;
       }"/>
       
</form>
</body>
</html>