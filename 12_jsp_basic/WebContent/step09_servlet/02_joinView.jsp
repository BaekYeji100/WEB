<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입 확인</title>
</head>
<body>
	<div align="center">
		<h2>가입정보</h2>
		<table border="1">
			<tr>
				<th>아이디</th>
				<td>${mdto.id }</td>
			</tr>
			<tr>
				<th>패스워드</th>
				<td>${mdto.pw }</td>
			</tr>
			<tr>
				<th>이름</th>
				<td>${mdto.name }</td>
			</tr>
			<tr>
				<th>이메일</th>
				<td>${mdto.email }</td>
			</tr>
			<tr>
				<th>취미</th>
				<td>${mdto.hobby }</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="button" onclick="location.href='Login.do'" value="로그인"></td>
			</tr>
		</table>
	</div>
</body>
</html>