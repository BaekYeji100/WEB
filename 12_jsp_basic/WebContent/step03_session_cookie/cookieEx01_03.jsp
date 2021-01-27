<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 정보 확인하기</title>
</head>
<body>
	<h2> 쿠키 정보 확인 하기 </h2>
	<% 
	
		Cookie[] cookie = request.getCookies();
	
		out.println("cookie length : " + cookie.length);
		
		if (cookie.length == 1) { // JSESSIONID
			out.println("<h1>최초 로그인</h1>");
		}
		else {
			out.println("<h1>로그인한 상태</h1>");
			for (int i=0; i<cookie.length; i++) {
				out.println("cookie name : " + cookie[i].getName() +"<br>");
				out.println("cookie value : " + cookie[i].getValue()+"<br><br>");
			}
			
		}
	
	%>
	
	<h2><a href="cookieEx01_04.jsp">쿠키 정보 삭제하기</a></h2>
	
</body>
</html>