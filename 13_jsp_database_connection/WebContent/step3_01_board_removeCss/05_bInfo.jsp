<%@page import="step3_01_boardEx.BoardDTO"%>
<%@page import="step3_01_boardEx.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>05_bInfo</title>
</head>
<body>
	<%
		int num = Integer.parseInt(request.getParameter("num"));
		BoardDTO bean = BoardDAO.getInstance().getOneBoard(num);
	%>
	<div align="center" style="padding-top: 100px">
	<div align="center">
		<h1>게시글 보기</h1>
		<br>
	</div>
		<table style="width: 700px; text-align: center" border="1">
			<colgroup>
				<col width="20%">
				<col width="80%">
			</colgroup>
			<tr>
				<td>글번호</td>
				<td><%=bean.getNum()%></td>
			</tr>
			<tr>
				<td>조회수</td>
				<td><%=bean.getReadCount()%></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><%=bean.getWriter()%></td>
			</tr>
			<tr>
				<td>작성일</td>
				<td><%=bean.getRegDate()%></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><%=bean.getEmail()%></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><%=bean.getSubject()%></td>
			</tr>
			<tr>
				<td>글 내용</td>
				<td><%=bean.getContent()%></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" value="수정하기" onclick="location.href='06_bUpdate.jsp?num=<%=bean.getNum()%>'">
					<input type="button" value="삭제하기" onclick="location.href='08_bDelete.jsp?num=<%=bean.getNum()%>'">
					<input type="button" value="목록보기" onclick="location.href='04_bList.jsp'">
				</td>
			</tr>
		</table>
	</div>
</body>
</html>