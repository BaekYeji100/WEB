<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>el 전달 폼</title>
</head>
<body>
	<form method="post" action="elEx02_pro.jsp">
		<fieldset>
			<legend>회원가입 폼</legend>
			<p><label for="name"><span style="color: red">*</span>이름 : </label><input type="text"  id="name" name="name"/></p>
			<p><label for="id"><span style="color: red">*</span>아이디 : </label><input type="text" id="id" name="id"/></p>
			<p><label for="pwd"><span style="color: red">*</span>비밀번호 : </label><input type="password" id="pwd" name="pwd"/></p>
			<p><label for="age">나이 : </label><input type="text" id="age" name="age"/></p>
			<p>
				성별 : <input type="radio" name="gender" value="1"/>남자
			   		   <input type="radio" name="gender" value="2"/>여자
			</p>
			<p>
				<span style="color: red">*</span>취미 : 
					<input type="checkbox" name="hobbies" value="운동"/>운동
					<input type="checkbox" name="hobbies" value="잠자기"/>잠자기
					<input type="checkbox" name="hobbies" value="공부하기"/>공부하기
			</p>
			<p>
				<label for="travel"> 가고 싶은 여행지는</label>
				<select id="travel" name="travel">
					<option value="괌">괌</option>
					<option value="다낭">다낭</option>
					<option value="나트랑">나트랑</option>
					<option value="코타니카발루">코타키나발루</option>
					<option value="대만">대만</option>
					<option value="푸꾸옥">푸꾸옥</option>
				</select>
			</p>
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