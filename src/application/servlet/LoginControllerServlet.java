package application.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import application.control.ControllerLogin;

/**
 * Servlet implementation class LoginController
 */
public class LoginControllerServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String un=request.getParameter("username");
		String pw=request.getParameter("password");
		
		ControllerLogin controller = new ControllerLogin();
		
		if(controller.controllaCredenziali(un, pw))
		{
			response.sendRedirect("dashboard.html");
			return;
		}
		else
		{
			response.sendRedirect("accessoNonConcesso.html");
			return;
		}
	}

}
