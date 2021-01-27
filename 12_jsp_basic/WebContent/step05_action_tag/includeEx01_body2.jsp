<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>body 2</title>
</head>
<body>

	<% 
		request.setCharacterEncoding("utf-8");
	
		String sampleData1 = URLDecoder.decode(request.getParameter("sampleData1"),"utf-8");
		String sampleData2 = request.getParameter("sampleData2");
		
	%>
	<h1 align="center">화면 본문에서 보여질 페이지 예시2</h1>
	<h3> 전달된 데이터1 : <%=sampleData1 %></h3>
	<h3> 전달된 데이터2 : <%=sampleData2 %></h3>
	
</body>
</html>