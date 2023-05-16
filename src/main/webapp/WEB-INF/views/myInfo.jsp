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
<h2>검색 결과</h2>
                   
<c:if test="${not empty myInfoList}">
    <c:set var="hasPast" value="false" />
    <c:set var="hasFuture" value="false" />
    <c:set var="hasCurrent" value="false" />
    
    <c:forEach var="myInfo" items="${myInfoList}">
        <c:choose> 
            <c:when test="${myInfo.status eq '과거'}"> 
                <c:set var="hasPast" value="true" />
            </c:when>
            <c:when test="${myInfo.status eq '미래'}">
                <c:set var="hasFuture" value="true" />
            </c:when>
            <c:when test="${myInfo.status eq '현재'}">
                <c:set var="hasCurrent" value="true" />
            </c:when>
        </c:choose>55555555
    </c:forEach>
    
    <c:if test="${hasCurrent}">
        <h2>사용중</h2>
        <table border=1>
            <tr>
                <th>이름</th>
                <th>전화번호</th>
                <th>주소</th>
                <th>타입</th>
                <th>날짜</th>
                <th>시간</th>
                <th>남은 시간</th>
            </tr>
            <c:forEach var="myInfo" items="${myInfoList}">
                <c:if test="${myInfo.status eq '현재'}">
                    <tr>
                        <td>${myInfo['user_name']}</td>
                        <td>${myInfo['user_phone']}</td>
                        <td>${myInfo['address']}</td>
                        <td>${myInfo['charge_type']}</td>
                        <td>${myInfo['reserve_date']}</td>
                        <td>${myInfo['reserve_time']}</td>
                        <td>${myInfo['time_remaining']}</td>
                    </tr>
                </c:if>
            </c:forEach>
        </table>
    </c:if>
    
    <c:if test="${hasFuture}">
        <h2>사용 예정</h2>
        <table border=1>
            <tr>
                <th>이름</th>
                <th>전화번호</th>
                <th>주소</th>
                <th>타입</th>
                <th>날짜</th>
                <th>시간</th>
                <th>예약 취소</th>
            </tr>
            <c:forEach var="myInfo" items="${myInfoList}">
                <c:if test="${myInfo.status eq '미래'}">
                    <tr>
                        <td>${myInfo['user_name']}</td>
                        <td>${myInfo['user_phone']}</td>
                        <td>${myInfo['address']}</td>
                        <td>${myInfo['charge_type']}</td>
                        <td>${myInfo['reserve_date']}</td>
                        <td>${myInfo['reserve_time']}</td>
                        <td>
                        <form action="${pageContext.request.contextPath}/delete" method="post">
                        <input type="hidden" name="reserve_id" value="${myInfo['reserve_id']}">
    					<input type="submit" value="예약 취소">
						</form>
                		<td>
                    </tr>
                </c:if>
            </c:forEach>
        </table>
    </c:if>
    
    <c:if test="${hasPast}">
        <h2>사용 완료</h2>
        <table border=1>
            <tr>
                <th>이름</th>
                <th>전화번호</th>
                <th>주소</th>
                <th>타입</th>
                <th>날짜</th>
                <th>시간</th>
            </tr>
            <c:forEach var="myInfo" items="${myInfoList}">
                <c:if test="${myInfo.status eq '과거'}">
                    <tr>
                        <td>${myInfo['user_name']}</td>
                        <td>${myInfo['user_phone']}</td>
                        <td>${myInfo['address']}</td>
                        <td>${myInfo['charge_type']}</td>
                        <td>${myInfo['reserve_date']}</td>
                        <td>${myInfo['reserve_time']}</td>
                    </tr>
                </c:if>
            </c:forEach>
        </table>
    </c:if>
</c:if>

<c:if test="${empty myInfoList}">
    <p>${errorMessage}</p>
</c:if>

<form action="${pageContext.request.contextPath}/map">
<div class="box-footer">
<button type="submit" class="btn btn-primary">홈으로 돌아가기</button>
</div>
</form>
</body>
</html>