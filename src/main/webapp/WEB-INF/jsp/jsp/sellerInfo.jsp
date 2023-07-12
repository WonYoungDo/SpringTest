<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>판매자 정보</title>
</head>
<body>
	<h1>판매자 정보</h1>
	<img alt="${seller.nickname }" height="100" width="100" src="${seller.profileImage }">
	<h1>${seller.nickname }</h1>
	<h3>${seller.temperature }</h3>	
</body>
</html>