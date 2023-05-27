<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="${path}/resources/css/star.css" rel="stylesheet"/>
<title>Insert title here</title>
</head>
<body>
<h2>후기 작성</h2>
    <p>${user_name}</p>
    <p>${loc_name}</p>
    <form action="${pageContext.request.contextPath}/ratings" method="post" class="mb-3" name="myform" id="myform">
    <input type="hidden" name="reserve_id" value="${reserve_id}"/>
    <input type="hidden" name="loc_id" value="${loc_id}"/>
    <input type="hidden" name="loc_name" value="${loc_name}"/>
    <input type="hidden" name="address" value="${address}"/>
    <input type="hidden" name="charge_type" value="${charge_type}"/>
    <input type="hidden" name="user_name" value="${user_name}"/>
    <input type="hidden" name="user_phone" value="${user_phone}"/>
	<fieldset>
		<span class="text-bold">별점을 선택해주세요</span>
		<input type="radio" name="rate_score" value="5" id="rate1">
		<label for="rate1">★</label>
		<input type="radio" name="rate_score" value="4" id="rate2">
		<label for="rate2">★</label>
		<input type="radio" name="rate_score" value="3" id="rate3">
		<label for="rate3">★</label>
		<input type="radio" name="rate_score" value="2" id="rate4">
		<label for="rate4">★</label>
		<input type="radio" name="rate_score" value="1" id="rate5">
		<label for="rate5">★</label>
	</fieldset>
	<div>
		<textarea class="col-auto form-control" name="rate_content" id="reviewContents"
				  placeholder="후기를 작성해주세요"></textarea>
	</div>
	<input type="file" name="rate_img" class="form-control"><br>
	<input type="hidden" name="rate_date" id="now_date"/>
	<input type="submit" value="작성완료"/>
</form>
<script>
document.getElementById('now_date').valueAsDate = new Date();
</script>		
</body>
</html>