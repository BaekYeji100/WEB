<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>include 액션태그</title>
</head>

	<!-- 
	
		# include 
		
		- 동적 include 방식, 포함하는 문서와 상관없이 동적으로 컴파일 된다. 
		
		- 파일들이 완전히 별도로 동작하므로 완성된 문서의 형태를 포함해야 한다.
		
		- 주로 화면의 레이아웃을 구성할때 사용한다. 
		
		- param 액션 태그를 통해 데이터를 전달할 수 있다.

	 -->

<body>
	<div style="height:200px; background-color: green;" >
		<jsp:include page="includeEx01_header.jsp"></jsp:include>
	</div>
	
	<div style="height:600px">
	<%-- <jsp:include page="includeEx01_body1.jsp" /> --%>
		
		<jsp:include page="includeEx01_body2.jsp">
			<jsp:param value='<%=URLEncoder.encode("팀 버너스리" , "utf-8") %>' name="sampleData1"/>
			<jsp:param value="Timothy John Berners Lee" name="sampleData2"/>
		</jsp:include>
		
	</div>
	
	<div style="height:200px; background-color: skyblue;">
		<jsp:include page="includeEx01_footer.jsp" />
	</div>
</body>
</html>