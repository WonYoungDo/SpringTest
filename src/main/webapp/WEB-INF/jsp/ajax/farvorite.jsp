<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>즐겨찾기 목록</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
	<h2>즐겨 찾기 목록</h2>
	<table id="favoriteTable" class="table text-center">
		<thead>
			<tr>
				<th>NO.</th>
				<th>이름</th>
				<th>주소</th>
				<th></th>
			</tr>		
		</thead>
		<tbody>
			<c:forEach var="favorite" items="${favoriteList }">
			<tr>
				<td>${favorite.id }</td>
				<td>${favorite.name }</td>
				<td>${favorite.address }</td>
				<td><button type="button" class="btn btn-danger btn-sm delete-btn" data-favorite-id="${favorite.id }">삭제</button></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	
	<script>
		$(document).ready(function() {
			$(".delete-btn").on("click", function() {				
				
				let id = $(this).data("favorite-id");
				
				
//				$(this).closest("tr").remove();				
//				var favoriteId = $(this).data("id");

				$.ajax({ // 요청
		            type: "get"
		            , url: "/ajax/test/delete" // + favoriteId
		            , data:{"id":id}
				
		            , success: function(data) { // 전달
		                // 4. 서버의 응답이 성공적인 경우 해당 행을 삭제합니다.
		                
		                // 성공 : {"result":"success"}
						// 실패 : {"result":"fail"}
						if(data.result == "success") {
							location.reload(); // 새로고침해서 새로 데이터 보여줌
						} else {
							alert("삭제 실패");
						}

		            }
		            , error: function() {
		                // 서버의 응답이 실패한 경우, 에러 메시지를 표시합니다.
		                alert("삭제 에러");
		            }
		        });
			});
		});	
	</script>
	
	
</body>
</html>