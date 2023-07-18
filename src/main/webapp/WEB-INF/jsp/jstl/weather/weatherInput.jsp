<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="/jstl/css/style.css" type="text/css">
</head>
<body>
	<div id="wrap">
		<div class="d-flex">
			<jsp:include page="header.jsp" />
			<section>
			
				<div class="pt-4 pl-5">
					<h3>날씨 입력</h3>
				</div>
				
				
				<div class="d-flex justify-content-between align-items-center">
				
					<div class="d-flex col-6 pt-5">
						<label>날짜</label><input type="text" class="form-control col-7" name="date">
					</div>
					
					<div class="weather-select col-3 d-flex">
						<div>날씨</div>
						<select name="weather">
							<option>맑음</option>
							<option>흐림</option>
							<option>비</option>
							<option>구름조금</option>
						</select>
					</div>
					
					<div class="microDust-select col-3 d-flex">
						<div>미세먼지</div>
						<select name="microDust">
							<option>좋음</option>
							<option>보통</option>
							<option>나쁨</option>
							<option>최악</option>
						</select>
					</div>		
							
				</div>
				
				<div class="d-flex justify-content-between align-items-center pt-3">
					<label>기온</label><input type="text" class="form-control col-3" name="temperatures">
					<label>강수량</label><input type="text" class="form-control col-3" name="precipitation">
					<label>풍속</label><input type="text" class="form-control col-3" name="windSpeed">
				</div>
				
				<div class="d-flex justify-content-end pt-3">
					<button type="button" class="btn btn-success">저장</button>
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