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

public class SceltaCaratteristicheServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Elenco caratteristiche</h1>");

		Statement stmt = null;
		Connection conn = null;
	    final String USER = "postgres";
	    final String PASS = "postgres";
	    final String DB_NAME = "risorsedb";
		final String DRIVER_CLASS_NAME = "org.postgresql.Driver";
		
		String roomName = request.getParameter("roomName");
		
		try {
			
			Class.forName(DRIVER_CLASS_NAME);
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+DB_NAME+"?user="+USER+"&password="+PASS);
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            
            //String buildingName=edificio.getNome();
            String sql = "SELECT * from \"ListaCaratteristiche\" WHERE \"stanzaDiAppartenenza\" = \'" + roomName + "\';";
            //String sql = "SELECT * from \"Stanza\"";
            ResultSet rs = stmt.executeQuery(sql);
		    while (rs.next()) {
		        if (rs.isFirst()) {
		            
		            out.println("<caption>Tabella delle caratteristiche della stanza</caption>");
		            out.println("<thead>");
		            //out.println("<tr><th>Proiettore</th><th>Computer</th><th>Lavagna</th><th>Microfono</th><th>Prese</th></tr>");
		            out.println("</thead>");
		            out.println("<tbody>");
		        }
		        out.print("<tr>");
		        out.print("<td>" + rs.getString("nomeCar") + "</td>");
		        out.print("<td>" + rs.getString("quantita") + "</td>");
		        out.println("</tr>");
		        if (rs.isLast()) {
		            out.println("</tbody>");
		            out.println("</table>");
		            out.print("\n");
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