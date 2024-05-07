package application.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import application.model.Caratteristica;

public class CaratteristicaDAO implements DAOActions<Caratteristica> {
	public boolean find(Caratteristica feature) {
        Statement stmt = null;
        Connection conn = null;
        try {
        	Class.forName(DRIVER_CLASS_NAME);
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+DB_NAME+"?user="+USER+"&password="+PASS);
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT * FROM \"ListaCaratteristiche\""
  			+ "WHERE \"nomeCar\" = \'" + feature.getNome() +
  				 "\' AND \"stanzaDiAppartenenza\" = \'" + feature.getStanzaDiAppartenenza() +
  				 "\' AND \"quantita\" > 0 ;";
            ResultSet rs = stmt.executeQuery(sql);
            if (!rs.first()) {
            	rs.close();
            	stmt.close();     
            	// rs is empty
            	conn.close();
                return false;
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            // Errore nel loading del driver
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }
        }
        return true;
    }

	public void store(Caratteristica feature) {
        Statement stmt = null;
        Connection conn = null;
        try {
        	Class.forName(DRIVER_CLASS_NAME);
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+DB_NAME+"?user="+USER+"&password="+PASS);
          	stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
          	String sql = "INSERT INTO \"ListaCaratteristiche\" (\"nomeCar\", \"descrizione\", \"quantita\", \"sonoRotto\", "
          			+ "\"stanzaDiAppartenenza\" ) VALUES (\'" + feature.getNome() +
          				 "\', \'" + feature.getDescrizione() + "\', " + feature.getQuantita() + ","
          			+ feature.getStato() +  ",\'" + feature.getStanzaDiAppartenenza() + "\' );";
          	stmt.executeUpdate(sql);
          	if (stmt != null)
          		stmt.close();
          	conn.close();
        }catch (SQLException se2) {
        	se2.printStackTrace();
        }catch(Exception e1) {
        	e1.printStackTrace();
        }
	}

    public void update(Caratteristica feature) {
        Statement stmt = null;
        Connection conn = null;
        try {
        	Class.forName(DRIVER_CLASS_NAME);
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+DB_NAME+"?user="+USER+"&password="+PASS);
          	stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
          	String sql = "UPDATE \"ListaCaratteristiche\" SET \"quantita\" = " + feature.getQuantita() + ", \"sonoRotto\" = "
          				+ feature.getStato() + " WHERE \"nomeCar\" = \'" + feature.getNome() + "\' AND \"stanzaDiAppartenenza\" = \'"
          				+ feature.getStanzaDiAppartenenza() + "\';";
          	stmt.executeUpdate(sql);
          	if (stmt != null)
          		stmt.close();
          	conn.close();
        }catch (SQLException se2) {
        	se2.printStackTrace();
        }catch (Exception e1) {
        	e1.printStackTrace();
        }
    }

    public void delete(Caratteristica feature) {
        Statement stmt = null;
        Connection conn = null;
        try {
        	Class.forName(DRIVER_CLASS_NAME);
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+DB_NAME+"?user="+USER+"&password="+PASS);
          	stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
          	String sql = "DELETE FROM \"ListaCaratteristiche\" WHERE \"nomeCar\" = \'" + feature.getNome() +
          					"\' AND \"stanzaDiAppartenenza\" = \'" + feature.getStanzaDiAppartenenza() + "\';";
          	stmt.executeUpdate(sql);
          	//Clean-up
          	if (stmt != null)
          		stmt.close();
          	conn.close();
        }catch (SQLException se2) {
        	se2.printStackTrace();
        }catch (Exception e1) {
        	e1.printStackTrace();
        }
    }

    public ArrayList<Caratteristica> getTable(){
    		ArrayList<Caratteristica> result =  new ArrayList<Caratteristica>();
    		Statement stmt = null;
    		Connection conn = null;
    			try {
    				Class.forName(DRIVER_CLASS_NAME);
    				conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+DB_NAME+"?user="+USER+"&password="+PASS);
    				stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
    				String sql = "SELECT * from \"ListaCaratteristiche\"";
    				ResultSet rs = stmt.executeQuery(sql);
    				while (rs.next()){    
    					//finchè ci sono elementi nella tabella risultante, aggiungili alla lista
    					String nome = rs.getString("nomeCar");
    					String descr = rs.getString("descrizione");
    					int quantita = rs.getInt("quantita");
    					boolean stato = rs.getBoolean("sonoRotto");
    					String stanzaDiAppart = rs.getString("stanzaDiAppartenenza");
    					Caratteristica tmp = new Caratteristica(nome, descr, quantita, stato, stanzaDiAppart);
    					result.add(tmp);
    				}
    				rs.close();
    				stmt.close();
    				conn.close();
    			} catch (Exception e) {
            // Errore nel loading del driver
            e.printStackTrace();
    			} finally {
    				try {
    					if (stmt != null)
                    stmt.close();
    				} catch (SQLException se2) {
    					}
    			}
        return result;
    }
}