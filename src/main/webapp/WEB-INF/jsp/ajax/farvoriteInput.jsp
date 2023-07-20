<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>즐겨찾기 추가</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body>
	<div class="container">
		<h2>즐겨 찾기 추가하기</h2>
		<label>제목</label> <br>
		<input type="text" class="form-control" name="name" id="nameInput"> <br>
		<label>주소</label> <br>
		<input type="text" class="form-control" name="address" id="addressInput"> <br>
		<button type="button" class="btn-success" id="addBtn">추가</button>	
	</div>	
	<script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	
	<script>
		$("#document").ready(function() {
			
			$("#addBtn").on("click", function() {
				let name = $("#nameInput").val();
				let address = $("#addressInput").val();
				
				if(name == "") {
					alert("이름을 입력하세요");
					return;
				}
				if(address == "") {
					alert("url주소를 입력하세요");
					return;
				}
				
				// http:// 시작하지 않고, https:// 시작하지 않으면 
				if(!url.startsWith("http://") && !url.startsWith("https://")) {
					alert("주소를 확인하세요");
					return;
				}
				
				
				
				$.ajax({
					type:"post"
					, utl:"/ajax/test/add"
					, data:{"name":name, "address":address} // request
					,success:function(data) {               // response
						if(data.result == "success") {
							
							// 리스트 페이지 이동
							location.href = "/ajax/test/list";
							
						}else {
							alert("추가 실패");
						}
					}
					, error:function(){
						alert("에러");
					}
				});
			});
			
		});
	</script>

</body>
</html>