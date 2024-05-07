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
@WebServlet("/ModificaEliminaStanzaServlet")
public class ModificaEliminaStanzaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificaEliminaStanzaServlet() {
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
		
		String nome=request.getParameter("nomeM");
		String posti=request.getParameter("postiM");
		String piano=request.getParameter("pianoM");
		String tipo=request.getParameter("tipoM");
		String edificio=request.getParameter("edificioM");
		
		if (request.getParameter("modifica") != null) {
			Stanza St = new Stanza (nome, Integer.parseInt(posti), Integer.parseInt(piano), tipo, edificio);
			StanzaDAO EDAO = new StanzaDAO();
			EDAO.update(St);
			response.sendRedirect("gestioneEdificio.jsp?buildingName="+edificio);
			return;

        } else if (request.getParameter("elimina") != null) {
        		Stanza St = new Stanza (nome, Integer.parseInt(posti), Integer.parseInt(piano), tipo, edificio);
			StanzaDAO EDAO = new StanzaDAO();
	    		EDAO.delete(St);
	    		response.sendRedirect("table1.jsp");
	    		return;
        
        }  else if (request.getParameter("gestisci") != null) {
    		//String nomeEd;
    		response.sendRedirect("gestioneStanza.jsp?roomName="+nome);
    		return;
    	}
	}
}
