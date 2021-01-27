<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 생성 폼</title>
</head>
<body>
	<form method="post" action="cookieEx01_02.jsp">
		<fieldset>
			<p> id : <input type="text" name="id"></p>
			<p> pwd : <input type="password" name="pwd"></p>
			<p> <input type="checkbox" value="y" name="makeCookie">쿠키생성</p>
			<input type="submit" value="로그인">
		</fieldset>
	</form>
</body>
</html>