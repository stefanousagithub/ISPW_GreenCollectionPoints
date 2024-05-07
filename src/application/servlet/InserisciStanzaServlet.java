package application.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import application.model.Stanza;
import application.persistence.StanzaDAO;

/**
 * Servlet implementation class InserisciEdificioServlet
 */
@WebServlet("/InserisciStanzaServlet")
public class InserisciStanzaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InserisciStanzaServlet() {
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
		
		String nome=request.getParameter("nome");
		String posti=request.getParameter("posti");
		String piano=request.getParameter("piano");
		String tipo=request.getParameter("tipo");
		String edificio=request.getParameter("edificio");
		//String proiettore=request.getParameter("proiettore");
		//String computer=request.getParameter("computer");
		//String lavagna=request.getParameter("lavagna");
		//String microfono=request.getParameter("microfono");
		//String prese=request.getParameter("prese");
		
		Stanza St = new Stanza (nome, Integer.parseInt(posti), Integer.parseInt(piano), tipo, edificio);
		StanzaDAO EDAO = new StanzaDAO();
		EDAO.store(St);
		response.sendRedirect("table1.jsp");
		
	}

}
