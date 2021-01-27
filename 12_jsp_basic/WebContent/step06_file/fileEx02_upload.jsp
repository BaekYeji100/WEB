<%@page import="_06_file.FileDAO"%>
<%@page import="_06_file.FileDTO"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드</title>
</head>
<body>

	<% 

		request.setCharacterEncoding("utf-8");
		
	
		try {
			
			// 파일이 저장될 위치 지정
			String fileSaveLocation = "C:\\Users\\User\\Desktop\\안병욱\\15_웹개발_공유폴더\\12_jsp_basic\\WebContent\\step06_file\\attachment_file";
			String encType = "utf-8";	// 인코딩 타입
			int maxSize = 1024*1024*15;	// '한번에' 최대 업로드될 파일의 크기 지정[byte단위]

			MultipartRequest multi = new MultipartRequest(request,
															fileSaveLocation,
															maxSize,
															encType,
															new DefaultFileRenamePolicy()
														  );
					
			
			String userName = multi.getParameter("userName"); // enctype으로 전송되었기 때문에 request.getParameter가 불가능하고
			String title    = multi.getParameter("title");	  // MultipartRequest의 객체로 getParameter를 처리한다.
			
			Enumeration<?> files = multi.getFileNames();
			
			while (files.hasMoreElements()) {
				
				FileDTO fdto = new FileDTO();
				
				String element          = (String)files.nextElement();
				String serverFileName   = multi.getFilesystemName(element);
				String originalFileName = multi.getOriginalFileName(element);
				String type				= multi.getContentType(element);
				
				fdto.setUserName(userName);
				fdto.setTitle(title);
				fdto.setServerFileName(serverFileName);
				fdto.setOriginFileName(originalFileName);
				fdto.setFileType(type);
				
				FileDAO.getInstance().saveFile(fdto);
				
			}
			
			response.sendRedirect("fileEx02_list.jsp");
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
	
	
	%>

</body>
</html>