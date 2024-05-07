package application.control;

import java.util.ArrayList;

import application.bean.CaratteristicaBean;
import application.bean.EdificioBean;
import application.bean.StanzaBean;
import application.model.Caratteristica;
import application.model.Stanza;
import application.persistence.CaratteristicaDAO;
import application.persistence.StanzaDAO;

public class ControllerGestioneStanze {
	private StanzaDAO SDao = new StanzaDAO();

	public ControllerGestioneStanze() {
	}

	public ArrayList<StanzaBean> prelevaStanze(EdificioBean edificio)
	{	ArrayList<Stanza> listaStanze = new ArrayList<Stanza>();
		ArrayList<StanzaBean> arrayBean = new ArrayList<StanzaBean>();
		listaStanze=SDao.fetchRoomsFromBuilding(edificio.getNome());
		for (Stanza s : listaStanze)
		{
			StanzaBean sBean= new StanzaBean(s.getNome(),s.getPosti(),s.getPiano(),s.getTipo(),s.getEdifDiAppartenenza());
			arrayBean.add(sBean);
		}
		return arrayBean;
	}
	
	public void eliminaStanza(StanzaBean stanza) {
		Stanza stanza1= new Stanza(stanza.getNome(),stanza.getPosti(),stanza.getPiano(),stanza.getTipo(),stanza.getEdifDiAppartenenza());
		SDao.delete(stanza1);
	}

	public void modificaStanza(StanzaBean stanza) {
		Stanza stanza1= new Stanza(stanza.getNome(),stanza.getPosti(),stanza.getPiano(),stanza.getTipo(),stanza.getEdifDiAppartenenza());
		SDao.update(stanza1);
	}

	public void creaStanza(StanzaBean stanza) {
		Stanza stanza1= new Stanza(stanza.getNome(),stanza.getPosti(),stanza.getPiano(),stanza.getTipo(),stanza.getEdifDiAppartenenza());
		SDao.store(stanza1);
	}

	public void creaCaratteristica(CaratteristicaBean caratteristica) {
		CaratteristicaDAO CDao = new CaratteristicaDAO();
		Caratteristica nuova= new Caratteristica(caratteristica.getNome(),caratteristica.getDescrizione(),caratteristica.getQuantita(),caratteristica.getStato(),caratteristica.getStanzaDiAppartenenza());
		CDao.store(nuova);
	}
}
