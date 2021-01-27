package _06_file;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class FileDAO {

	private FileDAO() {}
	private static FileDAO instance = new FileDAO();
	public static FileDAO getInstance() {
		return instance;
	}
	
	
	private Connection conn;   			
    private PreparedStatement pstmt;  	
    private ResultSet rs;   			
	
    
    public Connection getConnection() {
    	
		String dbURL      = "jdbc:mysql://localhost:3306/file_ex?serverTimezone=UTC";                             
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
	
    // 파일 정보를 저장하는 DAO
    public boolean saveFile(FileDTO fdto) {
    	
    	boolean isSave = false;
    	
    	try {
			
    		conn = getConnection();
    		pstmt = conn.prepareStatement("INSERT INTO FILE VALUES(?,?,?,?,?,NOW())");
    		pstmt.setString(1, fdto.getUserName());
    		pstmt.setString(2, fdto.getTitle());
    		pstmt.setString(3, fdto.getOriginFileName());
    		pstmt.setString(4, fdto.getServerFileName());
    		pstmt.setString(5, fdto.getFileType());
    		pstmt.executeUpdate();
    		isSave = true;
        
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
			if (pstmt != null) try { pstmt.close(); } catch(SQLException e) {}
			if (conn != null)  try { conn.close(); }  catch(SQLException e) {}
		}
    	
    	return isSave;
    	
    }
   
    
    // 파일 정보 리스트 DAO
    public Vector<FileDTO> getFileList() {
    	
    	Vector<FileDTO> files = new Vector<FileDTO>();
    	FileDTO fdto = null;
    	
    	try {
    		
    		conn  = getConnection();
    		pstmt = conn.prepareStatement("SELECT * FROM FILE");
    		rs    = pstmt.executeQuery();
    		
    		while (rs.next()) {
    			fdto = new FileDTO();
    			fdto.setUserName(rs.getString(1)); 
    			fdto.setTitle(rs.getString(2));
    			fdto.setOriginFileName(rs.getString(3));
    			fdto.setServerFileName(rs.getString(4));
    			fdto.setFileType(rs.getString(5));
    			fdto.setFileUploadDate(rs.getDate(6));
    			files.add(fdto);
    		}
    		
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	if (rs != null) try    { rs.close(); } catch(SQLException e) {}
			if (pstmt != null) try { pstmt.close(); } catch(SQLException e) {}
			if (conn != null)  try { conn.close(); }  catch(SQLException e) {}
		}
    	
    	return files; 
    	
    }
	

}
