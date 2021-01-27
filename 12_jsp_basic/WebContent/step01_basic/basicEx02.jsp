<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>출력문</title>
</head>
<body>

	<h3>1.출력</h3>	<!-- html 문법 -->
	
	
	<% 	/* 자바 문법 */
		
		String name = "제임스 고슬링";
		out.println(name);		// html에서 데이터를 표시하는 자바의 메서드
	%>
	<hr>
	출력 결과 : name
	<hr>
	출력 결과 : <%=name %>   <!-- 자바 변수 표기법 -->	
	

</body>
</html>