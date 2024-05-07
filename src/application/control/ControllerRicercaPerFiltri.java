package application.control;

import java.util.ArrayList;
import java.util.Iterator;

import application.bean.CaratteristicaBean;
import application.bean.StanzaBean;
import application.model.Caratteristica;
import application.model.Stanza;
import application.persistence.CaratteristicaDAO;
import application.persistence.StanzaDAO;

public class ControllerRicercaPerFiltri {
	/*
	 * Mostra in grafica la lista aggiornata, ottenuta dal db,  delle stanze
	 *
	 * */
	public ArrayList<Stanza> refreshRoomTable(){
		StanzaDAO DAO = new StanzaDAO();
		ArrayList<Stanza> refreshed = new ArrayList<Stanza>();
		refreshed = DAO.getTable();
		return refreshed;
	}

	public ArrayList<Caratteristica> refreshFeatureTable(String roomName){
		/*
		 * Mostra in grafica la lista aggiornata, ottenuta dal db, delle caratteristiche
		 * che hanno come nome della stanza di appartenenza la stringa contenuta in roomName
		 *
		 * */
		CaratteristicaDAO DAO = new CaratteristicaDAO();
		ArrayList<Caratteristica> refreshed = new ArrayList<Caratteristica>();
		refreshed = DAO.getTable();
		Iterator<Caratteristica> it = refreshed.iterator() ;
		try {
			while ( it.hasNext()) {

				if (!(it.next().getStanzaDiAppartenenza().equals(roomName))) {
					it.remove();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
			return refreshed;
	}

	public ArrayList<Stanza> applyFilter(String roomType, ArrayList<String> featArr, int minSeats){
		ArrayList<Stanza> filtered = refreshRoomTable();
		try {
			Iterator<Stanza> itType = filtered.iterator();   
			//filtro per il tipo di stanza
			while (itType.hasNext()) {
				if (roomType.equals("Qualsiasi tipo"))
					break;
				if (!(itType.next().getTipo().equals(roomType))) {
					itType.remove();
				}
			}
			if (filtered.isEmpty() && !(roomType.equals("Qualsiasi tipo"))) {
				return filtered;
			}
			Iterator<Stanza> itSeats = filtered.iterator(); 
			//filtro per il numero minimo di posti
			while(itSeats.hasNext()) {
				if (itSeats.next().getPosti() < minSeats ) {
					itSeats.remove();
				}
			}
			if (filtered.isEmpty()) {
				return filtered;
			}
			Iterator<Stanza> itFeat = filtered.iterator(); 
			//filtro per la presenza di caratteristiche
			while (itFeat.hasNext()) {
				String roomName = itFeat.next().getNome();
				if (!(this.hasRequestedFeatures(roomName, featArr))) {
					itFeat.remove();
				}
			}
			if (filtered.isEmpty()) {
				return filtered;
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		return filtered;
	}

	public boolean hasRequestedFeatures(String roomName, ArrayList<String> featArr) {
		ArrayList<Caratteristica> featuresInRoom = refreshFeatureTable(roomName);
		for (String inputFeature : featArr) {
				if (!checkFeature(inputFeature, featuresInRoom))
					return false;
		}
		return true;
	}

	public boolean checkFeature(String f, ArrayList<Caratteristica> featuresInRoom) {
		for (Caratteristica feature : featuresInRoom) {
			if (f.equals(feature.getNome()))
				return true;
		}
		return false;
	}

	public ArrayList<StanzaBean> roomBeanConvert(ArrayList<Stanza> roomArray){
		ArrayList<StanzaBean> arrayBean = new ArrayList<StanzaBean>();
		for (Stanza s : roomArray)
		{
			StanzaBean sBean= new StanzaBean(s.getNome(),s.getPosti(),s.getPiano(),s.getTipo(),s.getEdifDiAppartenenza());
			arrayBean.add(sBean);
		}
		return arrayBean;
	}

	public ArrayList<CaratteristicaBean> featureBeanConvert(ArrayList<Caratteristica> featArray){
		ArrayList<CaratteristicaBean> arrayBean = new ArrayList<CaratteristicaBean>();
		for (Caratteristica c : featArray)
		{
			CaratteristicaBean cBean= new CaratteristicaBean(c.getNome(),c.getDescrizione(),c.getQuantita(),c.getStato(),c.getStanzaDiAppartenenza());
			arrayBean.add(cBean);
		}
		return arrayBean;
	}
}