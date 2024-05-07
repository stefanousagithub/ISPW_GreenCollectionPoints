package application.persistence;

import java.sql.*;
import java.util.ArrayList;

import application.model.Stanza;

public class StanzaDAO implements DAOActions<Stanza> {

    public boolean find(Stanza room) {
        Statement stmt = null;
        Connection conn = null;
        try {
        	Class.forName(DRIVER_CLASS_NAME);
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+DB_NAME+"?user="+USER+"&password="+PASS);
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT * FROM \"Stanza\" WHERE \"nomeStanza\" = '"
                    + room.getNome() + "';";
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

    public void store(Stanza room) {
        Statement stmt = null;
        Connection conn = null;
        try {
        	Class.forName(DRIVER_CLASS_NAME);
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+DB_NAME+"?user="+USER+"&password="+PASS);
          	stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
          	String sql = "INSERT INTO \"Stanza\" (\"nomeStanza\", \"piano\", \"posti\", \"tipo\", \"edificio\" ) VALUES (\'" + room.getNome() +
          				 "\', " + room.getPiano() + ", " + room.getPosti() + ", \'" + room.getTipo() + "\', \'" +
          				 room.getEdifDiAppartenenza() + "\');";
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

    public void update(Stanza room) {
        Statement stmt = null;
        Connection conn = null;
        try {
        	Class.forName(DRIVER_CLASS_NAME);
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+DB_NAME+"?user="+USER+"&password="+PASS);
          	stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
          	String sql = "UPDATE \"Stanza\" SET \"piano\" = " + room.getPiano() + ", \"posti\" = " + room.getPosti() +
          			       " WHERE \"nomeStanza\" = \'" + room.getNome() + "\';";
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

    public void delete(Stanza room) {
        Statement stmt = null;
        Connection conn = null;
        try {
        	Class.forName(DRIVER_CLASS_NAME);
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+DB_NAME+"?user="+USER+"&password="+PASS);
          	stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
          	String sql = "DELETE FROM \"Stanza\" WHERE \"nomeStanza\" = \'" + room.getNome() + "\';";
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

    public ArrayList<Stanza> getTable(){
    	ArrayList<Stanza> result =  new ArrayList<Stanza>();
    	Statement stmt = null;
    	Connection conn = null;
        try {
        	Class.forName(DRIVER_CLASS_NAME);
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+DB_NAME+"?user="+USER+"&password="+PASS);
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT * from \"Stanza\"";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){    
            		//finchè ci sono elementi nella tabella risultante, aggiungili alla lista
            		String nome = rs.getString("nomeStanza");
            		int posti = rs.getInt("posti");
            		int piano = rs.getInt("piano");
            		String tipo = rs.getString("tipo");
            		String edificio = rs.getString("edificio");
            		Stanza tmp = new Stanza(nome,posti,piano,tipo, edificio);
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
            	se2.printStackTrace();
            }
        }
        return result;
    }

    public ArrayList<Stanza> fetchRoomsFromBuilding(String buildingName){
    		ArrayList<Stanza> result =  new ArrayList<Stanza>();
    		Statement stmt = null;
    		Connection conn = null;
        try {
        		Class.forName(DRIVER_CLASS_NAME);
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+DB_NAME+"?user="+USER+"&password="+PASS);
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT * from \"Stanza\" WHERE \"edificio\" = \'" + buildingName + "\';";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){    
            	//finchè ci sono elementi nella tabella risultante, aggiungili alla lista
            		String nome = rs.getString("nomeStanza");
                int posti = rs.getInt("posti");
                int piano = rs.getInt("piano");
                String tipo = rs.getString("tipo");
                String edif = rs.getString("edificio");
                Stanza tmp = new Stanza(nome,posti,piano,tipo,edif);
                result.add(tmp);
            }
                rs.close();
                stmt.close();
            } catch (Exception e) {
                // Errore nel loading del driver
                e.printStackTrace();
            } finally {
                try {
                    if (stmt != null)
                        stmt.close();
                    conn.close();
                } catch (SQLException se2) {
                	se2.printStackTrace();
                }
            }
            return result;
        }
}