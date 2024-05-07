package application.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InserisciEdificioServlet
 */
@WebServlet("/ModificaCaratteristicheServlet")
public class ModificaCaratteristicheServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificaCaratteristicheServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//String proiettore=request.getParameter("proiettoreM");
		//String computer=request.getParameter("computerM");
		//String lavagna=request.getParameter("lavagnaM");
		//String microfono=request.getParameter("microfonoM");
		//String prese=request.getParameter("preseM");
		
		if (request.getParameter("modifica") != null) {
			
			response.sendRedirect("gestioneStanza.jsp");
			return;
		}
	}
}