<%@page import="_06_file.FileDTO"%>
<%@page import="java.util.Vector"%>
<%@page import="_06_file.FileDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 확인하기</title>
</head>
<body>
	<% 
		Vector<FileDTO> fileList =  FileDAO.getInstance().getFileList();
	%>
	<table border="1">
		<tr align="center">
			<th>작성자</th>
			<th>제목</th>
			<th>파일명</th>
			<th>첨부파일</th>
			<th>업로드날짜</th>
		</tr>
	<% 
		for (int i=0; i<fileList.size(); i++) {
	%>
			<tr align="center">
				<td><%=fileList.get(i).getUserName() %></td>
				<td><%=fileList.get(i).getTitle() %></td>
				<td><%=fileList.get(i).getOriginFileName() %></td>
				<td>
					<a href="fileEx02_download.jsp?fileName=<%=fileList.get(i).getOriginFileName()%>">다운</a>
				</td>
				<td><%=fileList.get(i).getFileUploadDate() %></td>
			</tr>
	<% 
		}
	%>
	
		<tr>
			<td colspan="5" align="right"><button onclick="location.href='fileEx02_form.jsp'">upload</button></td>
		</tr>
	</table>
</body>
</html>