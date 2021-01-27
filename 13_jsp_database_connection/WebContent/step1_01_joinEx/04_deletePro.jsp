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
	
		String id     = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		
		Connection conn 		= null;
		PreparedStatement pstmt = null;
		ResultSet rs 			= null;
		
		try {
			
			String jdbcUrl = "jdbc:mysql://localhost:3306/login_ex?serverTimezone=UTC";
			String dbId    = "root";
			String dbPass  = "1234";
			
			Class.forName("com.mysql.cj.jdbc.Driver");
	
			conn = DriverManager.getConnection(jdbcUrl, dbId, dbPass);
			
			String sql = "select id,passwd from member where id=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,id);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {	// rs.next() : 반환된 결과물이 있으면
				
				String returnId     = rs.getString("id");
				String returnPasswd = rs.getString("passwd");
				
				// 파라메타로 넘어온 ID와 DB에 있는 ID의 비교
				// 파라메타로 넘어온 Passwd와 DB에 있는 Passwd의 비교
				if (id.equals(returnId) && passwd.equals(returnPasswd)){ // 아이디 비밀번호가 일치한 경우
				
					sql = "delete from member where id=?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1,id);
					pstmt.executeUpdate();			
	%>
					<script>
						alert("회원 탈퇴되었습니다.");
						location.href="00_main.jsp"	// 00_main.jsp로 이동
					</script>
	<% 		
				} 
				else {//비밀번호가 틀린경우
	%>
					<script>
						alert("아이디와 비밀번호를 확인하세요.");
						history.go(-1);			// 한페이지 전으로 이동
					</script>
	<% 		
				}		
				
			} 
			else {	// 아이디가 없는 경우
	%>
				<script>
					alert("아이디와 비밀번호를 확인하세요.");
					history.go(-1);
				</script>
	<%		
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rs.close();
			pstmt.close();
			conn.close();
		}	
		
	%>
</body>
</html>