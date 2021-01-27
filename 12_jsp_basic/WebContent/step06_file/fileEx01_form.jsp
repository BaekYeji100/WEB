<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 전송 폼</title>
</head>
<!-- 

	# 파일 업&다운로드

	- input 태그에서 type을 file설정하여 파일을 업로드 할 수 있다.
	 
	- form으로 파일을 웹서버로 넘기게 되면 파일은 서버에 지정된 디렉토리에 저장된다.
	
	- 보통 실제 파일은 서버의 디렉터리에 저장하고 데이터베이스에는 실제 파일이 아닌 파일이름 및 관련정보들만 저장한다.
	 
	- 파일 업 &다운로드와 관련된 이슈는 파일의 이름이 겹칠 가능성이 매우 높다는 것이어서 
	  이를 막기위해 Rename을 기본으로 사용해야한다는 것이다. 

	- 파일을 전송은 cos.jar 라이브러리를 이용한다.
	 
	- cos.jar 라이브러리를 WEB-INF/LIB위치에 추가해준 후 
	  form태그에 enctype="multipart/form-data"라는 속성을 부여하여 사용한다.
	  
	- enctype은 post방식에서만 존재하기 때문에 GET방식에서는 파일전송이 불가능하다.

 -->
<body>
	<form action="fileEx01_upload.jsp" method="post" enctype="multipart/form-data">
		<fieldset>
			<p><label>작성자 : <input type="text" name="userName"></label></p>		
			<p><label>파일명 : <input type="file" name="file"></label></p>
			<input type="submit" value="upload">
		</fieldset>
	</form>
</body>
</html>



