package application.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UtenteDAO {
	  private final String DRIVER_CLASS_NAME = "org.postgresql.Driver";
	  private final String DB_NAME = "risorsedb";
	  private final String USER = "postgres";
	  private final String PASS = "postgres";

	  public Boolean findSegretario(String inputUsername, String inputPassword) {
	        Statement stmt = null;
	        Connection conn = null;    
	        Boolean found = false;
	        try {
	        	Class.forName(DRIVER_CLASS_NAME);
	            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+DB_NAME+"?user="+USER+"&password="+PASS);
	            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
	                    ResultSet.CONCUR_READ_ONLY);
	            String sql = "SELECT * FROM \"login\" WHERE \"user\" = '"
	                    + inputUsername + "' AND \"password\" = '" + inputPassword + "'"
	                    + " AND \"professione\" = \'segretario\';";
	            ResultSet rs = stmt.executeQuery(sql);
	            if (!rs.first()) {
	            	rs.close();
	            	stmt.close();     
	            	// rs is empty
	            	conn.close();
	            }            
	            else {     
	            		found = true;
	            		rs.close();
	            		stmt.close();
	            		conn.close();
	            }
	        } catch (SQLException se2) {
	        	se2.printStackTrace();

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return found;
	    }
}
