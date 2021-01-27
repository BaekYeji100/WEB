<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	
		request.setCharacterEncoding("utf-8");
		
		String name      = request.getParameter("name");
		String id 	     = request.getParameter("id");
		String pwd 	     = request.getParameter("pwd");
		String age 	     = request.getParameter("age");
		String gender    = request.getParameter("gender");
		String[] hobbies = request.getParameterValues("hobbies"); // 체크박스는 여러값을 가져올 수 있으므로 배열 형태로 저장한다.
		String travel    = request.getParameter("travel");
		String content   = request.getParameter("content");	
		
	%>
	
	<p><%=name %></p>
	<p><%=id %></p>
	<p><%=pwd %></p>
	<p><%=age %></p>
	<p><%=gender %></p>
	<p>
		<%
			for(int i=0; i<hobbies.length; i++) {
		%>
			<%=hobbies[i] %>
		<% 
			}
		%>
	</p>
	<p><%=travel %></p>
	<p><%=content %></p>
	
</body>
</html>




