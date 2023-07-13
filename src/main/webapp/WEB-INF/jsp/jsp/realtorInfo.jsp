<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공인중개사 정보</title>
</head>
<body>
	
	<h1>공인중개사 정보</h1>
	<table>
		<tr>
			<td>${realtor.id }</td>
			<td>${realtor.office }</td>
			<td>${realtor.phoneNumber }</td>
			<td>${realtor.address }</td>
			<td>${realtor.grade }</td>
		</tr>
	</table>
</body>
</html>