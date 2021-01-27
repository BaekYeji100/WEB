package step2_00_loginEx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAO {
	
	private MemberDAO () {}
	private static MemberDAO instance = new MemberDAO();
	public static MemberDAO getInstance() {
		return instance;
	}
	
	private Connection conn;   			// 데이터베이스에 접근하기 위한 객체
    private PreparedStatement pstmt;  	// 쿼리문을 실행하기 위한 객체
    private ResultSet rs;   			// 정보를 담을 수 있는 변수를 생성
	
    // Database 연결 메서드
    public Connection getConnection() {
    	
		String dbURL      = "jdbc:mysql://localhost:3306/login_ex?serverTimezone=UTC";                             
        String dbID       = "root";
        String dbPassword = "1234";
        try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL,dbID,dbPassword);
		} catch (Exception e) {			
			e.printStackTrace();
		}	
	    return conn;
	    
	}	

    
    // 1. 회원가입 DAO
	public boolean insertMember(MemberDTO mdto) {
       
		boolean isFirstMember = true;

		try {
			
    		conn = getConnection();	
    		pstmt = conn.prepareStatement("SELECT * FROM MEMBER WHERE ID=?");
    		pstmt.setString(1, mdto.getId());
    		rs = pstmt.executeQuery();
	
    		if (!rs.next()) {  		
	            pstmt = conn.prepareStatement("INSERT INTO MEMBER VALUES(?, ?, ?, NOW())");
	            pstmt.setString(1,mdto.getId());
	            pstmt.setString(2,mdto.getPasswd());
	            pstmt.setString(3,mdto.getName());			                       
	            pstmt.executeUpdate();
	            isFirstMember = true;
    		}
        
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	if (rs != null)    try { rs.close(); }    catch(SQLException e) {}
			if (pstmt != null) try { pstmt.close(); } catch(SQLException e) {}
			if (conn != null)  try { conn.close(); }  catch(SQLException e) {}
		}
        return isFirstMember;
       
    }
		
	
	// 2. 회원탈퇴 DAO
	public boolean leaveMember(String id, String passwd) {
			
		boolean isLeaveMember = false;
		
		try {	
			
			if (memberCheck(id,passwd)) { 							
				conn = getConnection();
		    	pstmt = conn.prepareStatement("DELETE FROM MEMBER WHERE ID=?");
		    	pstmt.setString(1,id);
		    	pstmt.executeUpdate();
		    	
		    	System.out.println("member 테이블의 계정이 삭제 되었습니다.");
				System.out.println(id + "/"+passwd);
				 
				isLeaveMember = true;			
			}
			
		} catch (SQLException e){ 
			e.printStackTrace();
		} finally {
			 if (pstmt != null) try {pstmt.close();} catch(SQLException e){}
			 if (conn != null)  try {conn.close();}  catch(SQLException e){}
		}
		
		return isLeaveMember;
		
	}
	
	
	// 3. 업데이트 DAO
	public boolean updateMember(MemberDTO mdto) {
		
		boolean isValidMember = false;
			
		try {
			
			if (memberCheck(mdto.getId(),mdto.getPasswd())) { 
				
				conn = getConnection();				
				pstmt = conn.prepareStatement("UPDATE MEMBER SET NAME=? WHERE ID=?");
				pstmt.setString(1,mdto.getName());
				pstmt.setString(2,mdto.getId());
				pstmt.executeUpdate();	 
				
				isValidMember = true;
				
				System.out.println("member테이블이 업데이트 되었습니다.");
				System.out.println(mdto.getId()+"/"+mdto.getName());
				
			}				
		} catch (Exception e){ 
			e.printStackTrace();
		} finally{
			if (pstmt != null)  try {pstmt.close();} catch(SQLException e){}
			if (conn != null)   try {conn.close();}  catch(SQLException e){}
		}
		return isValidMember;
		
	}
	
	
	//4. 회원정보 확인 메서드
	public boolean memberCheck(String id, String passwd)  {
		
		boolean isValidMember = false;
		
		try {
			conn = getConnection();
			String sql = "SELECT * FROM MEMBER WHERE ID=? AND PASSWD=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, passwd);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				isValidMember = true; // 인증 성공
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null)    try { rs.close(); }    catch(SQLException e) {}
			if (pstmt != null) try { pstmt.close(); } catch(SQLException e) {}
			if (conn != null)  try { conn.close(); }  catch(SQLException e) {}
		}
		
		return isValidMember;
		
	}		
		
}
