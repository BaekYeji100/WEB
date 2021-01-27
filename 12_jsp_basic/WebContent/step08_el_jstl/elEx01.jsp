<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL 기초</title>
</head>
<body>

	<%--   
	
		# EL (Expression Language)
		
			- 자바코드를 사용하지 않고 간편하게 출력을 지원하기 위한 방법이다.
			- $ 와 {}를 사용하여 표현한다.
	
	
			[ 형식 ]
			
			${표현1.표현2}     : $ 와 {}를 사용하여 표현한다.



			[표현1 상세]	
			
			${param.} 			  : 파라미터값 접근        
			${paramValues.} 	  : 파라미터값 배열로 접근  
			${sessionScope.}	  : 세션Scope에 접근
			${pageScope.}		  : 페이지Scope에 접근
			${requestScope.} 	  : 리퀘스트Scope에 접근
			${applicationScope.}  : 어플리케이션Scope에 접근



			[표현2 상세]
			
			- form형식의 name값 , 세션 및 쿠키의 id 값 등등
			
			
			
			[ 예시 ] 
			 
			${param.contact}   : 파라메타로 전달되는 값 중에 contact속성
			${param.grade}     : 파라메타로 전달되는 값 중에 grade속성
			${sessionScope.id} : session중에 id속성
		
	
	--%>

	<h2>적용 범위</h2>
	
	<% 
	
		String name1 = "팀 버너스 리1";					// 자바의 변수
		
		request.setAttribute("name2", "팀 버너스 리2");	// page영역값 셋업(key, value)
	
	%>
	
	<%=name1 %><br>					<!-- 자바의 변수를 html에서 표현하는 표현식 -->
	${name2}						<!--  el표기식 -->
	
	<hr>
	
	<% 
		int num1 = 12;
		int num2 = 3;
		
		request.setAttribute("num3", 12);
		request.setAttribute("num4", 3);
	%>
	
	<h2>산술 연산자</h2>
	
	<h4><%=num1 + num2 %> , ${num3 + num4 }</h4>
	<h4><%=num1 - num2 %> , ${num3 - num4 }</h4>
	<h4><%=num1 * num2 %> , ${num3 * num4 }</h4>
	<h4><%=num1 / num2 %> , ${num3 / num4 } , ${num3 div num4 }</h4>
	<h4><%=num1 % num2 %> , ${num3 % num4 } , ${num3 mod num4 }</h4>
	
	<hr>
	
	<h2>관계 연산자</h2>
	<h4><%=num1 > num2 %>  , ${num3 > num4}  , ${num3 gt num4}</h4> <!-- Greater than -->
	<h4><%=num1 >= num2 %> , ${num3 >= num4} , ${num3 ge num4}</h4> <!-- Greater than or Equal to -->
	<h4><%=num1 < num2 %>  , ${num3 < num4}  , ${num3 lt num4}</h4> <!-- Less than --> 
	<h4><%=num1 <= num2 %> , ${num3 <= num4} , ${num3 le num4}</h4> <!-- Less than or Equal to -->
	<h4><%=num1 == num2 %> , ${num3 == num4} , ${num3 eq num4}</h4>	<!-- Equal -->
	<h4><%=num1 != num2 %> , ${num3 != num4} , ${num3 ne num4}</h4>	<!-- Not Equal -->
	
	<hr>
	
	<h2>논리 연산자</h2>
	
	<h4><%= 1==1 && 1==1 %> , ${1==1 && 1==1 } , ${1==1 and 1==1}</h4>
	<h4><%= 1==1 || 1==1 %> , ${1==1 || 1==1 } , ${1==1 or 1==1}</h4>
	<h4><%=!(1==1) %>       , ${!(1==1) }      , ${not (1==1) }</h4>
	
</body>
</html>



