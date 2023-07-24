<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>통나무 팬션</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/ajax/css/style.css" type="text/css">
</head>
<body>
	<div id="wrap">
        <jsp:include page="header.jsp"/>
		<jsp:include page="nav.jsp"/>
        <section class="main text-white">
            <div class="main-picture bg-danger">
                <img id="img" height="400" width="1200"  src="/ajax/image/통나무 팬션.jpg" alt="통나무 팬션">
            </div>
            <div class="reserve d-flex">  
                    <div class="real-time col-4 d-flex align-items-center justify-content-center">
                        <a href="#"><h1 class="text-white">실시간<br>예약하기</h1></a>
                    </div>
                <div class="confirmation col-5">
                    <div class="d-flex align-items-end pt-3">
                        <h3 class="ml-2">예약확인</h3>
                    </div>
                    <div>
                        <div id="memberBox">
                            <div class="pt-4 pb-2 d-flex">
                                <label class="col-3 text-center">아이디</label>
                                <input type="text" id="idInput" class="col-7 form-control">
                            </div>
                            <div class="d-flex">
                                <label class="col-3 text-center">비밀번호</label>
                                <input type="password" id="passwordInput" class="col-7 form-control">
                            </div>
                        </div>
                    </div>
                    <div class="d-flex justify-content-end">
                        <button type="button" class="btn text-white bg-success" id="search">조회</button>
                    </div>    
                </div>
                <div class="inquiry col-3 d-flex align-items-center justify-content-center">
                    <h1 class="text-white">예약문의:<br>010-<br>000-1111<br></h1>      
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
	
	        var image = ["/ajax/image/통나무 팬션.jpg", "/ajax/image/거실.jpg", "/ajax/image/침실.jpg", "/ajax/image/풍경.jpg"];
	        
	        var currentIndex = 0;
	
	        // 슬라이드 사진 만들기
	        setInterval(function() {
	            
	            currentIndex++;
	
	            if(currentIndex == image.length) {
	                currentIndex = 0;
	            }
	
	            // 배열의 길이가 4이면 다시 처음 사진을 보여준다.
	            //if(currentIndex == 4) {
	            //    currentIndex = 0;
	            //}
	
	            // 3초마다 반복
	            $("#img").attr("src", image[currentIndex]);                    
	            }, 3000);
	
	
	        $("#search").on("click", function() {            
	            // 아이디 비밀번호 유효성 검사를 실행
	            let = type = $("input[name='reserve']:checked").val();
	            
	            if(type == "member") {
	            	
	                let idInput = $("#idInput").val();
	                let passwordInput = $("#passwordInput").val();
	                
	                if(idInput == "") {
	                    alert("아이디를 입력하세요.");
	                    return;
	                }
	                if(passwordInput == "") {
	                    alert("비밀번호를 입력하세요.");
	                    return;
	                }
	            }  
	        });
	    });
	</script>


</body>
</html>