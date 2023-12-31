<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>기상청 페이지</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="/jstl/css/style.css" type="text/css">
</head>
<body>
	<div id="wrap">
		<div class="d-flex">
			<jsp:include page="header.jsp" />
			<section class="col-10">
				<div class="container pt-4">
					<h3>과거 날씨</h3>
					<table class="table text-center">
						<thead>
							<tr>
								<th>날짜</th>
								<th>날씨</th>
								<th>기온</th>
								<th>강수량</th>
								<th>미세먼지</th>
								<th>풍속</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="weather" items="${weatherList }">
								<tr>
									<td><fmt:formatDate value="${weather.date }" pattern="yyyy년 M월 dd일" /> </td>
									
									<td>
										<c:choose>
											<c:when test="${weather.weather eq '맑음'}">
												<img alt="${weather.weather }" src="/jstl/image/맑음.jpg">											
											</c:when>
											<c:when test="${weather.weather eq '비'}">
												<img alt="${weather.weather }" src="/jstl/image/비.jpg">											
											</c:when>
											<c:when test="${weather.weather eq '흐림'}">
												<img alt="${weather.weather }" src="/jstl/image/흐림.jpg">											
											</c:when>
											<c:when test="${weather.weather eq '구름조금'}">
												<img alt="${weather.weather }" src="/jstl/image/구름조금.jpg">											
											</c:when>
											<c:otherwise>${weather.weather }</c:otherwise>
										</c:choose>
									</td>
									
									<td>${weather.temperatures }℃</td>
									<td>${weather.precipitation }mm</td>
									<td>${weather.microDust }</td>
									<td>${weather.windSpeed }km/h</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</section>
		</div>
		<jsp:include page="footer.jsp" />
	</div>
	
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>