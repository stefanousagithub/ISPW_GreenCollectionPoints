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
@WebServlet("/InserisciEdificioServlet")
public class InserisciEdificioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InserisciEdificioServlet() {
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
		String macroarea=request.getParameter("macroarea");
		String numeroPiani=request.getParameter("piani");
		String via=request.getParameter("via");
		String citta=request.getParameter("citta");
		String dataCreazione=request.getParameter("dataDiCreazione");
		
		Edificio Ed = new Edificio (nome, macroarea, via, citta, numeroPiani, dataCreazione, null);
		EdificioDAO EDAO = new EdificioDAO();
		EDAO.store(Ed);
		response.sendRedirect("table1.jsp");
		
	}

}
