<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>통나무 펜션 예약하기</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/ajax/css/style.css" type="text/css">
</head>
<body>
	<div id="wrap">
		<jsp:include page="header.jsp"/>
		<jsp:include page="nav.jsp"/>
		<section class="d-flex justify-content-center">
			<div class="col-6  mt-3">
				<div class="text-center">
					<h2 class="font-weight-bold">예약하기</h2>
				</div>
				<div>
					<label class="font-weight-bold">이름</label>
					<div class="d-none text-secondary" id="nameDiv">이름을 입력해주세요!</div>
					<input class="form-control mb-2" id="nameInput">
				</div>
				<div>
					<label class="font-weight-bold">예약날짜</label> 
					<div class="d-none text-secondary" id="dateDiv">예약날짜를 입력해주세요!</div> 
					<input class="form-control mb-2" id="dateInput">
				</div>
				<div>
					<label class="font-weight-bold">숙박일수</label> 
					<div class="d-none text-secondary" id="dayDiv">숙박일수를 입력해주세요!</div> 
					<input class="form-control mb-2" id="dayInput">
				</div>
				<div>
					<label class="font-weight-bold">인원</label> 
					<div class="d-none text-secondary" id="headcountDiv">숙박인원을 입력해주세요!</div>
					<input class="form-control mb-2" id="headcountInput">
				</div>
				<div>
					<label class="font-weight-bold">전화번호</label> 
					<div class="d-none text-secondary" id="phoneNumberDiv">전화번호를 입력해주세요!</div>
					<input class="form-control mb-3" id="phoneNumberInput">
				</div>
				<div>
					<button type="button" class="form-control btn-warning font-weight-bold" id="bookingBtn">예약</button>
				</div>
			</div>
		</section>
		<jsp:include page="footer.jsp"/>
	</div>
	<script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
	<script>
		$(document).ready(function() {
			
			// 리셋 변수 생성
//			var reset = false;

			// 유효성 검사 -> 예약 정보를 리스트 목록에 추가
			$("#bookingBtn").on("click", function() {
				let name = $("#nameInput").val();
				let date = $("#dateInput").val();
				let day = $("#dayInput").val();
				let phoneNumber = $("#phoneNumberInput").val();
				let headcount = $("#headcountInput").val();
				
				if(name == "") {
					$("#nameDiv").removeClass("d-none");
				} else {
					$("#nameDiv").addClass("d-none");
				} 
				
				if(date == "") {
					$("#dateDiv").removeClass("d-none");
				} else {
					$("#dateDiv").addClass("d-none");
				} 
				
				if(day == "") {
					$("#dayDiv").removeClass("d-none");
				} else {
					$("#dayDiv").addClass("d-none");
				} 
				// 숙박 일 수가 숫자가 아닌 경우
				// Not a Number
				if(isNaN(day)) {
					alert("숫자를 입력해주세요.");
					return;
				}
				
				if(headcount == "") {
					$("#headcountDiv").removeClass("d-none");
				} else {
					$("#headcountDiv").addClass("d-none");
				}
				// 인원 수가 숫자가 아닌 경우
				if(isNaN(headcount)) {
					alert("숫자를 입력해주세요.");
					return;
				}
				
				if(phoneNumber == "") {
					$("#phoneNumberDiv").removeClass("d-none");
				} else {
					$("#phoneNumberDiv").addClass("d-none");
				} 
			
				$.ajax({
					type:"get"
					, url:"/ajax/pension/add"
					, data:{"day":day, "date":date, "phoneNumber":phoneNumber, "name":name, "headcount":headcount}
					, success:function(data) {
						
						if(data.result == "success") { // 성공
							location.href = "/ajax/pension/info";
							alert("예약이 완료되었습니다.")
						} else { // 실패
							alert("예약 실패");
						}
						
					}		
					, error:function() {
						alert("예약 에러");
					}
				});
				
			});
			
			
			// 날짜 입력란에 달력 생성
			$("#dateInput").datepicker({
				minDate:0
				, currentText: '오늘'
				, dateFormat: "yy년 mm월 dd일"
				, dayNamesMin:['월', '화', '수', '목', '금', '토', '일']
				, onSelect:function (dateText) {
                	$( "#endDate" ).datepicker('option', 'minDate', dateText);
             	}
			});
			
		});
	</script>
</body>
</html>