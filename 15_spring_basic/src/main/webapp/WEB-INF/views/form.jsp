<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입폼</title>
<!-- 

	CREATE DATABASE SPRING_BASIC_EX;
	
	USE SPRING_BASIC_EX;
	
	CREATE TABLE MEMBER(
		NAME VARCHAR(20),
        ID VARCHAR(20),
        PWD VARCHAR(20),
        CONTENT VARCHAR(100)
	);
	
	SELECT * FROM MEMBER;


 -->
</head>
<body>
	<form method="post" action="dataTransferEx09" >	
		<fieldset>
			<legend>회원가입 폼</legend>
			<p><label for="name">이름 : </label><input type="text"  id="name" name="name"/></p>
			<p><label for="id">아이디 : </label><input type="text" id="id" name="id"/></p>
			<p><label for="pwd">비밀번호 : </label><input type="password" id="pwd" name="pwd"/></p>
			<p>
				<label for="content">메모</label><br/>
				<textarea rows="10" cols="50" id="content" name="content"></textarea>
			</p>
			<p>
				<input type="submit" value="회원가입"/>
				<input type="reset" value="다시쓰기"/>
			</p>
		</fieldset>
	</form>
</body>
</html>