package application.control;

import application.persistence.UtenteDAO;

public class ControllerLogin {
	public boolean controllaCredenziali(String u, String p) {
		UtenteDAO dao = new UtenteDAO();
		if (!dao.findSegretario(u, p)) {  
			//Accesso negato
			return false;
		}
		//Accesso concesso
		return true;
	}
}
