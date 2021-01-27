<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>데이터 전송 기초</title>
</head>
<body>
	 
	 <!-- 
	 	
	 	- 폼 전송을 통해서 넘어오는 데이터는 request 객체를 통해서 전달 받는다.
	 	- 페이지의 encoding설정 외에 request객체의 encoding을 추가로 지정해 주어야 한다.
	 
	 	- request.getParameter(); 메서드를 통해서 form통해 넘어온 데이터의 name속성 값을 가져온다.
	 	- request.getParameter(); 의 기본 반환 타입은 '문자열' 이다.
	 -->
	 
	<% 
	
		request.setCharacterEncoding("utf-8");
		
		String language = request.getParameter("language");
		String reason   = request.getParameter("reason");
		//String age    = request.getParameter("age");
		int age         = Integer.parseInt(request.getParameter("age"));
		
		age += 5;	// 숫자연산이 아닌 문자열 연산을 한다. > 숫자는 형변환을 해야 한다.
		
		System.out.println("==============================================================");
		System.out.println("여기서부터 '백 앤드'의 영역입니다. 사용자의 눈에는 보이지 않죠.");
		System.out.println("좋아하는 언어 : " + language);
		System.out.println("이유 : " + reason);
		System.out.println("나이 : " + age);
		
	%>
	
</body>
</html>