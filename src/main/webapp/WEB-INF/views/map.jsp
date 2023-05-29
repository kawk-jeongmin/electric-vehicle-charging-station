<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" contentType="text/html; charset=UTF-8" %>
<html xmlns:th="http://www.thymeleaf.org">
<head>
	<title>Home</title>
	<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.13.4/css/jquery.dataTables.min.css">
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=91ddb989957b19faffb682a0e6d6fc8a"></script>
</head>
<body>
    <h1>Map Search</h1>
    <form action="${pageContext.request.contextPath}/myInfo" method="post">
    <input type="submit" value="예약정보 보기"/>
    </form>
<form action="${pageContext.request.contextPath}/search" method="get">
    <label for="keyword">Keyword:</label>
    <input type="text" id="keyword" name="keyword">
    <button type="submit">Search</button>
</form>

<div id="map" style="width:100%;height:500px;"></div>

    <script type="text/javascript">
        var container = document.getElementById('map');
        var options = {
            center: new kakao.maps.LatLng(37.508781018659796, 126.73679290415274),
            level: 3
        };

        var map = new kakao.maps.Map(container, options);

        var markerPosition  = new kakao.maps.LatLng(37.508781018659796, 126.73679290415274);

        var marker = new kakao.maps.Marker({
            position: markerPosition
        });

        marker.setMap(map);
    </script>

<h2>Search Result</h2>
<c:if test="${not empty errorMessage}">
    <p>${errorMessage}</p>
</c:if>

<c:if test="${not empty locInfoList}">
  <table id="locTable" class="display">
    <thead>
      <tr>
        <th>번호</th>
        <th>이름</th>
        <th>주소</th>
        <th>예약하기</th>
        <th>후기보기</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="locInfo" items="${locInfoList}">
        <tr>
          <td>${locInfo.loc_id}</td>
          <td>${locInfo.loc_name}</td>
          <td>${locInfo.address}</td>
          <td>
            <form method="post" action="${pageContext.request.contextPath}/reserve" accept-charset="UTF-8">
              <input type="hidden" name="loc_id" value="${locInfo.loc_id}" />
              <input type="hidden" name="loc_name" value="${locInfo.loc_name}" />
              <input type="hidden" name="address" value="${locInfo.address}" />
              <input type="submit" value="예약하기" />
            </form>
          </td>
          <td>
            <form method="get" action="${pageContext.request.contextPath}/ratingView/{loc_id}" accept-charset="UTF-8">
              <input type="hidden" name="loc_id" value="${locInfo.loc_id}" />
              <input type="submit" value="후기보기" />
            </form>
          </td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
</c:if>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdn.datatables.net/1.13.4/js/jquery.dataTables.min.js"></script>
<script type="text/javascript">
  $(document).ready(function() {
    $('#locTable').DataTable({
    	columns: [
    		{ data: 'loc_id'},
    	    { data: 'loc_name' },
    	    { data: 'address' },
    	    { data: 'reservebtn'},
    	    { data: 'ratingbtn'}
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
