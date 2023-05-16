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
     <!-- <div class ="form-group" style="text-align: center;"> -->
                        <div class="btn-group" data-toggle="buttons">
                            <label class="btn btn-primary active">
                                <input type="radio" name="charge_type" autocomplete="off" value="AC" checked>AC
                            </label>
                            <label class="btn btn-primary">
                                <input type="radio" name="charge_type" autocomplete="off" value="DC" checked>DC
                            </label>
                            </div>    
                    <!-- </div> -->
    
    <label for="reserve_date">예약 날짜:</label>
    <input type="date" id="reserve_date" name="reserve_date" required /><br>
    
    <label for="reserve_time">예약시간:</label>
    <input type="time" id="reserve_time" name="reserve_time" required /><br>
    
    <input type="submit" value="예약하기" />
</form>
</body>
</html>