<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

		<!-- 
		
			# 세션(Session)

				- HTTP 프로토콜은 클라이언트의 요청(request)과 서버의 응답(response)이 이루어지고 나면 더 이상 연결상태를 지속하지 않는다. 
				
				- 클라이언트와 서버의 연결 정보를 계속 유지할 방법이 필요한데 대표적으로 '쿠키(Cookie)'와 '세션(Session)'이 있다. 
				
				- 세션은 클라이언트와의 연결 정보를 유지하기 위한 정보를 웹 컨테이너(웹 서버)에 저장한다.
				
				- 쿠키는 클라이언트와의 연결정보를 유지하기 위한 정보를 클라이언트측에 저장한 뒤에 웹 서버가 클라이언트의 웹브라우저에서 쿠키를 읽어서 사용한다.
				
				- 클라이언트측에 저장된 연결정보(쿠키)는 연결정보가 클라이언트에서 관리되고 있다는 점에서 
				  연결정보를 서버측에서 관리하는 것보다 보안상 문제가 생길 확률이 많다. 
				
				- 그렇지만 세션만을 사용하면 서버에 부하를 줄 수도 있으므로 현재 쿠키와 세션을 각각 목적에 맞게 사용하고 있다.
		
		
				[ 자주 사용되어지는 메서드 ]
			
				setAttribute(속성명, 값) 				: 세션 속성명이 name인 속성에 속성값으로 value를 할당한다. 
				getAttribute(속성명) 					: 세션 속성명이 name인 속성의 값을 Object 타입으로 리턴한다. 
														  해당 되는 속성명이 없을 경우에는 null 값을 리턴한다.
				removeAttribute(속성명)					: 세션 속성명이 name인 속성을 제거한다. (특정 속성 제거) 
				invalidate() 							: 세션정보를 제거한다. (초기화 , 주로 로그아웃시 사용)
				setMaxInactiveInterval(유지기간(초))	: 세션을 유지하기 위한 세션 유지시간을 초 단위로 설정한다. (기본값은 30분)

		-->
	


	<h2>로그인폼 처리 페이지</h2>
	<%
	
		request.setCharacterEncoding("utf-8");
	
		String id     = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		
		session.setAttribute("id", id);
		session.setAttribute("passwd", passwd);
				
	%>
	
	아이디   : <%=id %> <br>
	비밀번호 : <%=passwd %> <br>
	
	<a href="sessionEx01_06.jsp">다음페이지 이동</a>
	
</body>
</html>