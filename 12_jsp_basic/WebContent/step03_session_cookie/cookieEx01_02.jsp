<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 생성</title>
</head>

	<!-- 
	
		# Cookie
		
			- 쿠키는 상태정보를 유지하기 위한 기술로 클라이언트에 상태정보를 저장한다.	
			
			- 웹 서버와 웹 브라우저는 필요한 값을 공유하고 상태를 유지할 수 있다
			
			- 클라이언트 측에서 관리되는 연결정보는 서버에서 관리되는 session보다 보안에 취약할 수 있다.
			
			- 저장 기간이 지정되면, 브라우저가 종료되어도 유지된다.
			
			- 웹 브라우저는 여러개의 쿠키를 가질 수 있고, 각각의 쿠키는 이름으로 구분한다.
			
			- 쿠키의 제약 사항
				
				문자열 데이터만 가능	,	4kb이하의 공간을 차지해야함	,	여러개의 쿠키설정 가능
				도메인당 20개까지 저장 가능	, 총 300개 까지 저장가능 
				저장한도를 넘으면 최근에 사용되지 않은 쿠키부터 자동 삭제
		
		
			- 쿠키 설정 절차 및 동작방식
			
				1) 클라이언트가 처음 서버에 접근하면 서버는 쿠키를 생성하고 http응답 헤더에 쿠키를 실어서 보낸다.
        			클라이언트의 브라우저 메모리 혹은 물리적인 하드에 저장한다.
				2) 클라이언트가 다시 사이트를 방문할때 쿠키를 서버에 보낸다
				3) 서버는 쿠키를 보고 클라이언트의 접속상태를 유지한다		
		
		
			- 쿠키에는 유효기간이 있으며, 유효기간이 지나면 자동으로 삭제된다.
			
				유효기간 미 설정시  웹브라우저에 저장( 웹브라우저 닫을때 삭제)   [개발자도구 > Application > Cookie에서 확인]
				유효기간 설정시 사용자의 PC에 저장됨 

		
		
			[ 자주 사용되어지는 메서드 ]

    		1) setMaxAge(int max) : 쿠키 만료기간을 지정 (쿠키가 저장되는 기간 설정)
      			setMaxAge(0)        > 쿠키삭제
         		setMaxAge(-1)       > 쿠키의 정보는 저장된 상태이고 브라우저를 닫으면 쿠키정보 사라짐. (생략시 기본값)
          		setMaxAge(60*15)    > 15분
          		setMaxAge(60*60*12) > 12시간
    	 
    	 	2) setPath(String path) : 쿠키의 적용이 유효한 디렉토리(폴더) 설정
    	 		setPath("/") 		 > 웹 어플리케이션 전체 경로에서 쿠키사용가능
    	 		setPath("/폴더명1")  > 폴더명1과 그 하위 폴더에서 쿠키사용가능
            
			3) setValue(Cookie c) : 쿠키정보 수정하기
                 쿠키의 정보가 수정되면 setMaxAge도 수정해야만  정보의 유효기간이 설정된다.
  
 	-->

<body>

	<%

		request.setCharacterEncoding("utf-8");
	
		String id          = request.getParameter("id");
		String pwd         = request.getParameter("pwd");
		String makeCookie  = request.getParameter("makeCookie");
	
		if (makeCookie != null && makeCookie.equals("y")) {
			
			// 1. 쿠키 생성
			Cookie cookie = new Cookie("id",id);
			
			// 2. 쿠키 관련정보 설정(필수x)
			cookie.setMaxAge(60*60*24); // 생성된 쿠키에 대한 기간 설정
			cookie.setPath("/");  		// 생성된 쿠키에 적용가능한 path 설정
			
			// 3. 생성된 쿠키를 클라이언트에게 전송
			response.addCookie(cookie);
			
		}
		
	%>
	
	id : <%=id %><br>
	pwd : <%=pwd %><br>
	
	<a href="cookieEx01_03.jsp">다음 페이지로 이동</a>
	
	
	

</body>
</html>