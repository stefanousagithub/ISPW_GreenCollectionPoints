package application.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import application.model.Edificio;
import application.persistence.EdificioDAO;

/**
 * Servlet implementation class InserisciEdificioServlet
 */
@WebServlet("/ModificaEliminaEdificioServlet")
public class ModificaEliminaEdificioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificaEliminaEdificioServlet() {
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
		String macroarea=request.getParameter("macroareaM");
		String numeroPiani=request.getParameter("pianiM");
		String via=request.getParameter("viaM");
		String citta=request.getParameter("cittàM");
		String dataCreazione=request.getParameter("dataDiCreazioneM");
		
		if (request.getParameter("modifica") != null) {
			Edificio Ed = new Edificio (nome, macroarea, via, citta, numeroPiani, dataCreazione, null);
			EdificioDAO EDAO = new EdificioDAO();
			EDAO.update(Ed);
			response.sendRedirect("table1.jsp");
			return;

        } else if (request.getParameter("elimina") != null) {
	        	Edificio Ed = new Edificio (nome, macroarea, via, citta, numeroPiani, dataCreazione, null);
	    		EdificioDAO EDAO = new EdificioDAO();
	    		EDAO.delete(Ed);
	    		response.sendRedirect("table1.jsp");
	    		return;
        }
	    	else if (request.getParameter("gestisci") != null) {
	    		//String nomeEd;
	    		response.sendRedirect("gestioneEdificio.jsp?buildingName="+nome);
	    		return;
	    	}
	}
}
