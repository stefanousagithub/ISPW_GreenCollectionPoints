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

public class SceltaEdificiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Elenco Edifici</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Elenco Edifici</h1>");

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
            String sql = "SELECT * from \"Edificio\"";
            ResultSet rs = stmt.executeQuery(sql);
		    while (rs.next()) {
		        if (rs.isFirst()) {
		            
		            out.println("<caption>Tabella dei miei edifici</caption>");
		            out.println("<thead>");
		            out.println("<tr><th>Nome</th><th>Macroarea</th><th>Via</th><th>Città</th><th>Piano/i</th><th>Data di costruzione</th><th>Data di ultima modifica</th></tr>");
		            out.println("</thead>");
		            out.println("<tbody>");
		        }
		        out.print("<tr>");
		        out.print("<td>" + rs.getString("nomeEdif") + "</td>");
		        out.print("<td>" + rs.getString("macroarea") + "</td>");
		        out.print("<td>" + rs.getString("via") + "</td>");
		        out.print("<td>" + rs.getString("citta") + "</td>");
		        out.print("<td>" + rs.getString("piani") + "</td>");
		        out.print("<td>" + rs.getString("primamodifica") + "</td>");
		        out.print("<td>" + rs.getString("ultimamodifica") + "</td>");
		        out.println("</tr>");
		        if (rs.isLast()) {
		            out.println("</tbody>");
		            out.println("</table>");
		            out.print("<button class=\"btn btn-default\" onclick=\"location.href='inserisciEdificio.html'\" type=\"submit\">Nuovo edificio</button>\n");
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