<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% 
		request.setCharacterEncoding("utf-8");
		
		Connection conn 		= null;
		PreparedStatement pstmt = null;
		ResultSet rs 			= null;
	
		String id 		= request.getParameter("id");	
		String passwd 	= request.getParameter("passwd");	
		String name 	= request.getParameter("name");	
		
		try {
			
			String jdbcUrl = "jdbc:mysql://localhost:3306/login_ex?serverTimezone=UTC";
			String dbId    = "root";
			String dbPass  = "1234";
			
			Class.forName("com.mysql.cj.jdbc.Driver");
	
			conn = DriverManager.getConnection(jdbcUrl, dbId, dbPass);
		
			String sql = "select id,passwd from member where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
		
			if (rs.next()) {	// 아이디가 있으면
				
				String rId     = rs.getString("id");
				String rPasswd = rs.getString("passwd");
				
				if (id.equals(rId) && passwd.equals(rPasswd)) { // 아이디와 비밀번호가 일치하면
					sql = "update member set name=? where id=?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, name);
					pstmt.setString(2, id);
					pstmt.executeUpdate();
	%>
					<script>
						alert("수정 되었습니다.");
						location.href="00_main.jsp";
					</script>
	<% 				
				}
				else {	// 비밀번호가 틀리면
	%>
					<script>
						alert("아이디와 비밀번호를 확인하세요.");
						history.go(-1);
					</script>	
	<% 				
				}
		
			}
			else {	// 아이디가 없으면
	%>
				<script>
					alert("아이디와 비밀번호를 확인하세요.");
					history.go(-1);
				</script>	
	<% 		
			}	
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			rs.close();
			pstmt.close();
			conn.close();
		}
		
	%>
	
</body>
</html>

