<%@page import="step3_01_boardEx.BoardDTO"%>
<%@page import="step3_01_boardEx.BoardDAO"%>
<%@page import="java.util.Vector"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>04_bList</title>
</head>
<body>
	<div align="center" style="padding-top: 100px">
		<h1>게시글 보기</h1>
		<br>
		<table border="1">
			<colgroup>
				<col width="10%">
				<col width="40%">
				<col width="20%">
				<col width="20%">
				<col width="10%">
			</colgroup>
			<tr align="center">
				<td>번호</td>
				<td>제목</td>
				<td>작성자</td>
				<td>작성일</td>
				<td>조회수</td>
			</tr>
	<%
		Vector<BoardDTO> vec = BoardDAO.getInstance().getAllBoard(); 
		for (int i=0; i<vec.size(); i++){	
			BoardDTO bean = vec.get(i);
	%>
			<tr align="center">
				<td><%= i+1 %></td>
				<td><a href="05_bInfo.jsp?num=<%= bean.getNum() %>"><%= bean.getSubject() %></a></td>
				<td><%= bean.getWriter() %></td>
				<td><%= bean.getRegDate() %></td>
				<td><%= bean.getReadCount() %></td>
			</tr>
	<%
		}
	%>
			<tr align="right">
				<td colspan="5">
					<input type="button" style="float: right" value="글쓰기" onclick="location.href='02_bWrite.jsp'">
				</td>
			</tr>
		</table>
	</div>					
</html>