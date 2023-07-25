<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>통나무 펜션 예약 목록</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/ajax/css/style.css" type="text/css">
</head>
<body>
	<div id="wrap">
		<jsp:include page="header.jsp"/>
		<jsp:include page="nav.jsp"/>	
		<section>
			<table class="table text-center">
				<thead>
					<tr>
						<th>이름</th>
						<th>예약날짜</th>
						<th>숙박일수</th>
						<th>인원</th>
						<th>전화번호</th>
						<th>예약상태</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="booking" items="${bookingList }">
					<tr>
						<td>${booking.name }</td>
						<td><fmt:formatDate value="${booking.date }" pattern="yyyy년 MM월 dd일" /></td>
						<td>${booking.day }박</td>
						<td>${booking.headcount }명</td>
						<td>${booking.phoneNumber }</td>
						
						<td 
							<c:choose>
								<c:when test="${booking.state eq '대기중'}">
									class="text-info"					
								</c:when>
								<c:when test="${booking.state eq '확정'}">
									class="text-success"					
								</c:when>
							</c:choose>
						>${booking.state }</td>
						
						<td><button type="button" class="btn btn-sm btn-danger delete-btn" data-booking-id="${booking.id }">삭제</button></td>
					</tr>	
				</c:forEach>	
				</tbody>				
			</table>
		</section>
		<jsp:include page="footer.jsp"/>
	</div>	
	<script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
	
	<script>
		$(document).ready(function() {
			
			// 삭제 버튼을 클릭시 id를 기반으로 해당 행을 삭제
			$(".delete-btn").on("click", function() {
				
				let id = $(this).data("booking-id");
				
				$.ajax({
					type:"get"
					, url:"/ajax/pension/delete"
					, data:{"id":id}
					, success:function(data) {
						
						if(data.result == "success") {
							location.reload();
						} else {
							alert("삭제 실패");
						}
						
					}
					, error:function() {
						alert("삭제 에러");
					}
				});
				
				
			});
		});
	</script>
	
</body>
</html>