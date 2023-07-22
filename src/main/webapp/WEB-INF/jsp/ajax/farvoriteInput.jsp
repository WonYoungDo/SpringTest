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
		<input type="text" class="form-control d-flex col-12" name="name" id="nameInput"> <br>
		
		<label>주소</label> <br>
		<div class="d-flex">
			<input type="text" class="form-control col-11" name="address" id="addressInput">
			<button type="button" class="form-control col-1 btn-primary" id="duplicateBtn">중복확인</button> <br>
		</div>
		<div class="smail text-danger d-none" id="duplicateUrlText">중복된 url입니다.</div>
		<div class="smail text-primary d-none" id="availableUrlText">사용가능한 url입니다.</div>
		
		<div class="d-flex justify-content-end">
			<button type="button" class="btn-success form-control mt-2" id="addBtn">추가</button>	
		</div>
		
	</div>	
	<script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	
	<script>
		$("#document").ready(function() {
		
			var checkedDuplicate = false; // 중복 체크 여부
			var isDuplicateUrl = true; // 주소 중복 여부 
			
			
			
			
			// url이 중복되었고 
			$("#addressInput").on("input", function() {
				
				// 중복확인 관련 데이터 초기화
				checkedDuplicate = false;
				isDuplicateUrl = true;
			
				$("#availableUrlText").addClass("d-none");
				$("#duplicateUrlText").addClass("d-none");
			});
			
			
			
			
			
			// 주소를 입력했을 때 
			// 중복이 된다면 밑에 안내글 보여지게 하기
			$("#duplicateBtn").on("click", function() {
				
				let address = $("#addressInput").val();
				
				if(address == "") {
					alert("이메일을 입력하세요.");
					return;
				}
				
				$.ajax({
					type:"post"
					, url:"/ajax/test/confirm"
					, data:{"address":address}
					, success:function(data) {
						
						checkedDuplicate = true;
												
						// 중복됨 : {"duplicateResult":true}
						// 중복되지 않음 : {"duplicateResult":false}
						if(data.duplicateResult) { // 중복됨 값 자체가 true를 return해줌
							$("#duplicateUrlText").removeClass("d-none");
							$("#availableUrlText").addClass("d-none");
							isDuplicateUrl = true;
						} else { // 중복되지 않음
							$("#availableUrlText").removeClass("d-none");							
							$("#duplicateUrlText").addClass("d-none");
							isDuplicateUrl = false;
						}
						
					}
					, error:function() {
						alert("중복 확인 에러")
					}
				});
			});
			

			
			// 추가 버튼을 눌렀을 때 입력확인 유효성 검사
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
				if(!address.startsWith("http://") && !address.startsWith("https://")) {
					alert("주소를 확인하세요");
					return;
				}

				// 중복 체크를 하지 않은 경우
				if(checkedDuplicate == false) {
					alert("url 중복 확인하세요");
					return;
				}
				
				// url주소가 중복된 경우
				if(isDuplicateUrl) {
					alert("url이 중복되었습니다.");
					return;
				}
					
				$.ajax({
					type:"post"
					, url:"/ajax/test/add"
					, data:{"name":name, "address":address} // request
					, success:function(data) {               // response
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