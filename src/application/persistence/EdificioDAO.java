package application.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import application.model.Edificio;

public class EdificioDAO implements DAOActions<Edificio>{

    public boolean find(Edificio build) {
        Statement stmt = null;
        Connection conn = null;
        try {
        	Class.forName(DRIVER_CLASS_NAME);
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+DB_NAME+"?user="+USER+"&password="+PASS);
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT * FROM \"Edificio\" WHERE \"nomeStanza\" = '"
                    + build.getNome() + "';";
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
        } catch (SQLException se2) {
        	se2.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
                if (stmt != null)
					try {
						stmt.close();
					} catch (SQLException se) {
						se.printStackTrace();
					}
        }
        return true;
    }

	public void store(Edificio build) {

        Statement stmt = null;
        Connection conn = null;
        try {
        	Class.forName(DRIVER_CLASS_NAME);
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+DB_NAME+"?user="+USER+"&password="+PASS);
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
          	String sql = "INSERT INTO \"Edificio\" (\"nomeEdif\", \"macroarea\", \"via\", \"citta\", \"piani\" , \"primamodifica\""
          			+ ", \"ultimamodifica\" ) VALUES (\'" + build.getNome() + "\', \'" + build.getMacroarea() + "\', \'" + build.getVia() + "\', \'" + build.getCitta() + "\'"
          			+ ", "+build.getPiani()+ ", \'" + build.getDataCreazione() + "\', " + build.getDataUltimaModifica() + ");";
          	stmt.executeUpdate(sql);
          	if (stmt != null)
          		stmt.close();
          	conn.close();
        }catch (SQLException se2) {
        	se2.printStackTrace();
        }catch (Exception e) {
        	e.printStackTrace();
        }
    }

    public void update(Edificio build) {
        Statement stmt = null;
        Connection conn = null;
        try {
        	Class.forName(DRIVER_CLASS_NAME);
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+DB_NAME+"?user="+USER+"&password="+PASS);
          	stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
          	String sql = "UPDATE \"Edificio\" SET \"macroarea\" = \'" + build.getMacroarea() + "\', \"via\" = \'" +
          				 build.getVia() + "\', \"citta\" = \'" + build.getCitta() + "\', \"piani\" = " + build.getPiani()
          				  + ", \"primamodifica\" = \'" +
          				 build.getDataCreazione() + "\', \"ultimamodifica\" = NOW() WHERE \"nomeEdif\" = \'" +
          				 build.getNome() + "\';";
          	stmt.executeUpdate(sql);
          	//Clean-up
          	if (stmt != null)
          		stmt.close();
          	conn.close();
        }catch (SQLException se2) {
        	se2.printStackTrace();
        }catch (Exception e) {
        	e.printStackTrace();
        }
    }

    public void delete(Edificio build) {
            Statement stmt = null;
            Connection conn;
            try {
            	Class.forName(DRIVER_CLASS_NAME);
                conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+DB_NAME+"?user="+USER+"&password="+PASS);
              	stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);
              	String sql = "DELETE FROM \"Edificio\"  WHERE \"nomeEdif\" = \'" + build.getNome() + "\';";
              	stmt.executeUpdate(sql);
              	//Clean-up
              	if (stmt != null)
              		stmt.close();
              	conn.close();
            }catch (SQLException se2) {
            	se2.printStackTrace();
            }catch(Exception e) {
            	e.printStackTrace();
            }
    }
    
    public void deleteByName(String nome) {
        Statement stmt = null;
        Connection conn;
        try {
        	Class.forName(DRIVER_CLASS_NAME);
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+DB_NAME+"?user="+USER+"&password="+PASS);
          	stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
          	String sql = "DELETE FROM \"Edificio\"  WHERE \"nomeEdif\" = \'" + nome + "\';";
          	stmt.executeUpdate(sql);
          	//Clean-up
          	if (stmt != null)
          		stmt.close();
          	conn.close();
        }catch (SQLException se2) {
        	se2.printStackTrace();
        }catch(Exception e) {
        	e.printStackTrace();
        }
}

    public ArrayList<Edificio> getTable(){
    	ArrayList<Edificio> result =  new ArrayList<Edificio>();
    	Statement stmt = null;
    	Connection conn = null;
        try {
        	Class.forName(DRIVER_CLASS_NAME);
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+DB_NAME+"?user="+USER+"&password="+PASS);
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT * from \"Edificio\"";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){    //finchè ci sono elementi nella tabella risultante, aggiungili alla lista
            	String nome = rs.getString("nomeEdif");
                String macroarea = rs.getString("macroarea");
                String via = rs.getString("via");
                String citta = rs.getString("citta");
                String piano = rs.getString("piani");
                String dataCreazione = rs.getString("primamodifica");
                String dataUltimaModifica = rs.getString("ultimamodifica");
                Edificio tmp = new Edificio(nome, macroarea, via, citta, piano, dataCreazione, dataUltimaModifica);
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