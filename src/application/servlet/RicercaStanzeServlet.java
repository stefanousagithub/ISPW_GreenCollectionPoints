package application.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SceltaEdificiServlet
 */

public class RicercaStanzeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Ricerca stanze</title>");
		out.println("</head>");
		out.println("<body>");

		Statement stmt = null;
		Connection conn = null;
	    final String USER = "postgres";
	    final String PASS = "postgres";
	    final String DB_NAME = "risorsedb";
		final String DRIVER_CLASS_NAME = "org.postgresql.Driver";
		
		try {
			
			Class.forName(DRIVER_CLASS_NAME);
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+DB_NAME+"?user="+USER+"&password="+PASS);
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            
            String sql = "SELECT * from \"Stanza\"";
            ResultSet rs = stmt.executeQuery(sql);
		    while (rs.next()) {
		        if (rs.isFirst()) {
		            
		            out.println("<thead>");
		            out.println("<tr><th>Nome</th><th>Posti</th><th>Piano</th><th>Tipo</th><th>Edificio</th></tr>");
		            out.println("</thead>");
		            out.println("<tbody>");
		        }
		        out.print("<tr>");
		        out.print("<td>" + rs.getString("nomeStanza") + "</td>");
		        out.print("<td>" + rs.getString("posti") +"</td>");
		        out.print("<td>" + rs.getString("piano") + "</td>");
		        out.print("<td>" + rs.getString("tipo") + "</td>");
		        out.print("<td>" + rs.getString("edificio") + "</td>");
		        
		        out.println("</tr>");
		        if (rs.isLast()) {
		            out.println("</tbody>");
		            out.println("</table>");
		        }
		    }
		    
		    
		    conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			}

		out.println("</body>");
		out.println("</html>");
	}
}