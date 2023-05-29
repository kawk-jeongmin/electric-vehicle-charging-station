<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" contentType="text/html; charset=UTF-8" %>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.13.4/css/jquery.dataTables.min.css">
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
        	<c:when test="${myInfo.status eq '현재'}">
                <c:set var="hasCurrent" value="true" />
            </c:when>
            <c:when test="${myInfo.status eq '미래'}">
                <c:set var="hasFuture" value="true" />
            </c:when>
            <c:when test="${myInfo.status eq '과거'}"> 
                <c:set var="hasPast" value="true" />
            </c:when>
        </c:choose>
    </c:forEach>
    
    <c:if test="${hasCurrent}">
        <h2>사용중</h2>
       <table id="nowTable" class="display">
       <thead>
            <tr>
                <th>이름</th>
                <th>전화번호</th>
                <th>주소</th>
                <th>타입</th>
                <th>날짜</th>
                <th>시간</th>
                <th>남은 시간</th>
            </tr>
            </thead>
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
        <table id="futureTable" class="display">
        <thead>
            <tr>
                <th>이름</th>
                <th>전화번호</th>
                <th>주소</th>
                <th>타입</th>
                <th>날짜</th>
                <th>시간</th>
                <th>예약 취소</th>
            </tr>
            </thead>
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
                		</td>
                    </tr>
                </c:if>
            </c:forEach>
        </table>
    </c:if>
    
    <c:if test="${hasPast}">
        <h2>사용 완료</h2>
        <table id="pastTable" class="display">
        <thead>
            <tr>
                <th>이름</th>
                <th>전화번호</th>
                <th>주소</th>
                <th>타입</th>
                <th>날짜</th>
                <th>시간</th>
                <th>후기쓰기</th>
            </tr>
            </thead>
            <c:forEach var="myInfo" items="${myInfoList}">
                <c:if test="${myInfo.status eq '과거'}">
                    <tr>
                        <td>${myInfo['user_name']}</td>
                        <td>${myInfo['user_phone']}</td>
                        <td>${myInfo['address']}</td>
                        <td>${myInfo['charge_type']}</td>
                        <td>${myInfo['reserve_date']}</td>
                        <td>${myInfo['reserve_time']}</td>
                        <td>
                        <form action="${pageContext.request.contextPath}/rating" method="Post" >
                        <input type="hidden" name="reserve_id" value="${myInfo['reserve_id']}" />
              			<input type="hidden" name="loc_id" value="${myInfo['loc_id']}" />
              			<input type="hidden" name="loc_name" value="${myInfo['loc_name']}" />
              			<input type="hidden" name="address" value="${myInfo['address']}" />
              			<input type="hidden" name="charge_type" value="${myInfo['charge_type']}" />
              			<input type="hidden" name="user_name" value="${myInfo['user_name']}"/>
              			<input type="hidden" name="user_phone" value="${myInfo['user_phone']}" />
              			<input type="submit" value="후기쓰기" />
            			</form>
          				</td>
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
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdn.datatables.net/1.13.4/js/jquery.dataTables.min.js"></script>
<script type="text/javascript">
  $(document).ready(function() {
    $('#nowTable').DataTable({
    	columns: [
    	    { data: 'user_name' },
    	    { data: 'user_phone' },
    	    { data: 'address' },
    	    { data: 'charge_type' },
    	    { data: 'reserve_date' },
    	    { data: 'reserve_time' },
    	    { data: 'time_remaining'}
    	  ],
    	  
    	  pageLength: 3,
          bPaginate: true,
          bLengthChange: true,
          lengthMenu : [ [ 3, 5, 10, -1], [ 3, 5, 10, "All" ] ],
          bAutoWidth: false,
          processing: true,
          ordering: true,
          serverSide: false,
          searching: true
    });
  });
</script>
<script type="text/javascript">
  $(document).ready(function() {
    $('#futureTable').DataTable({
    	columns: [
    	    { data: 'user_name' },
    	    { data: 'user_phone' },
    	    { data: 'address' },
    	    { data: 'charge_type' },
    	    { data: 'reserve_date' },
    	    { data: 'reserve_time' },
    	    { data: 'cancel'}
    	  ],
    	  
    	  pageLength: 3,
          bPaginate: true,
          bLengthChange: true,
          lengthMenu : [ [ 3, 5, 10, -1], [ 3, 5, 10, "All" ] ],
          bAutoWidth: false,
          processing: true,
          ordering: true,
          serverSide: false,
          searching: true
    });
  });
</script>
<script type="text/javascript">
  $(document).ready(function() {
    $('#pastTable').DataTable({
    	columns: [
    	    { data: 'user_name' },
    	    { data: 'user_phone' },
    	    { data: 'address' },
    	    { data: 'charge_type' },
    	    { data: 'reserve_date' },
    	    { data: 'reserve_time' },
    	    { data: 'rating'}
    	  ],
    	  
    	  pageLength: 3,
          bPaginate: true,
          bLengthChange: true,
          lengthMenu : [ [ 3, 5, 10, -1], [ 3, 5, 10, "All" ] ],
          bAutoWidth: false,
          processing: true,
          ordering: true,
          serverSide: false,
          searching: true
    });
  });
</script>
</body>
</html>