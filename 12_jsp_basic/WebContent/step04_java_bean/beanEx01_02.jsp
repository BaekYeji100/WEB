<%@page import="_04_bean.TesterBean"%>
<%@page import="_04_bean.ProductBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자바 빈</title>
</head>
<body>

	 
	<% 
		request.setCharacterEncoding("utf-8");
	
		//1) getParameter를 사용하는 방법
		String pdCd   = request.getParameter("pdCd");	
		String pdNm   = request.getParameter("pdNm");	
		String deptCd = request.getParameter("deptCd");	
		String deptNm = request.getParameter("deptNm");	
		String mgrNm  = request.getParameter("mgrNm");	

		ProductBean bean1 = new ProductBean();
		bean1.setPdCd(pdCd);
		bean1.setPdNm(pdNm);
		bean1.setDeptCd(deptCd);
		bean1.setDeptNm(deptNm);
		bean1.setMgrNm(mgrNm);
	
	%>
	
	
	<!-- 2) Bean을 사용하는 방법1 -->
	<jsp:useBean id="bean2" class="_04_bean.ProductBean">
		<jsp:setProperty name="bean2" property="pdCd"   value="<%=pdCd %>" />
		<jsp:setProperty name="bean2" property="pdNm"   value="<%=pdNm %>" />
		<jsp:setProperty name="bean2" property="deptCd" value="<%=deptCd %>" />
		<jsp:setProperty name="bean2" property="deptNm" value="<%=deptNm %>" />
		<jsp:setProperty name="bean2" property="mgrNm"  value="<%=mgrNm %>" />
	</jsp:useBean>
	
	
	<!-- 3) Bean을 사용하는 방법2 -->
	<jsp:useBean id="bean3" class="_04_bean.ProductBean">
		<jsp:setProperty name="bean3" property="*" />
	</jsp:useBean>

	
	<!-- 간단한 테스트1 -->

	bean1 : <%=bean1.getPdNm() %> <hr>
	bean2 : <%=bean2.getPdNm() %> , <jsp:getProperty property="pdNm" name="bean2" /> <hr>
	bean3 : <%=bean3.getPdNm() %> , <jsp:getProperty property="pdNm" name="bean3"/> <hr>



	<!-- 간단한 테스트2 -->
	<% 
	
		TesterBean obj = new TesterBean();
		
		obj.showData(bean1);
		obj.showData(bean2);
		obj.showData(bean3);
		
	%>




</body>
</html>