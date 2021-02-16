<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script src="${contextPath }/resources/script.js"></script>
<link href="${contextPath }/resources/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<header id="header">
			<tiles:putAttribute name="header"/>		
		</header>
		<aside id="sidebar">
			<tiles:putAttribute name="menu"/>
		</aside>
		<article id="content">
			<tiles:putAttribute name="content"/>
		</article>
		<footer id="footer">
			<tiles:putAttribute name="footer"/>
		</footer>
	</div>
</body>
</html>