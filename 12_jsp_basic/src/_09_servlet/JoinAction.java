package _09_servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/JoinAction.do")
public class JoinAction extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request,response);
	}

	protected void reqPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("utf-8");
		
		String id    = request.getParameter("id");
		String pw    = request.getParameter("pw");
		String name  = request.getParameter("name");
		String email = request.getParameter("email");
		
		String[] temp = request.getParameterValues("hobby");
		String hobby = "";
		
		for (int i = 0; i < temp.length; i++) {
			hobby += temp[i];
			if (i != temp.length - 1) {
				hobby += ",";
			}
		}
		
		MemberDTO mdto = new MemberDTO(id, pw, name, email, hobby);
		
		// request객체에 dto 객체를 저장
		request.setAttribute("mdto", mdto);
		
		RequestDispatcher dis = request.getRequestDispatcher("step09_servlet/02_joinView.jsp");
		dis.forward(request, response);
		
	}
	
}
