<%@page import="step3_01_boardEx.BoardDTO"%>
<%@page import="step3_01_boardEx.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>06_bUpdate</title>
</head>
<body>
	<%
		int num = Integer.parseInt(request.getParameter("num"));	
		BoardDTO bean = BoardDAO.getInstance().getOneUpdateBoard(num);
	%>
	<div align="center" style="padding-top: 100px">
		<form action="07_bUpdatePro.jsp" method="post" >
			<div align="center">
				<h1>게시글 수정</h1>
				<br>
			</div>
			<table style="width: 700px;" border="1">
				<tr>
					<td>작성자</td>
					<td><%=bean.getWriter()%></td>
				</tr>
				<tr>
					<td>작성일</td>
					<td><%=bean.getRegDate()%></td>
				</tr>
				<tr>
					<td>제목</td>
					<td><input type="text" name="subject" value="<%=bean.getSubject()%>" /></td>
				</tr>
				<tr>
					<td>패스워드</td>
					<td><input type="password" name="password" /></td>
				</tr>
				<tr>
					<td>글내용</td>
					<td><textarea rows="10" cols="60" name="content"><%=bean.getContent()%></textarea></td>
				</tr>
				<tr align="center">
					<td colspan="4">
						<input type="hidden" name="num" value="<%=bean.getNum()%>" /> 
						<input type="submit" value="글수정" />
						<input type="button" onclick="location.href='04_bList.jsp'" value="전체글보기" />
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>