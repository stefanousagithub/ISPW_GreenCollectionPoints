package application.control;

import application.persistence.CaratteristicaDAO;

import java.util.ArrayList;

import application.bean.CaratteristicaBean;
import application.model.Caratteristica;


public class ControllerVisualizzazioneGuasti {
	private CaratteristicaDAO CDao = new CaratteristicaDAO();
	private ArrayList<Caratteristica> featureList = new ArrayList<Caratteristica>();
	private ArrayList<CaratteristicaBean> featureBeanList = new ArrayList<CaratteristicaBean>();

	public ArrayList<CaratteristicaBean> riceviEConsegnaCaratteristiche()
	{
		featureList=CDao.getTable();
		for(Caratteristica caratteristica:featureList)
		{
			featureBeanList.add(new CaratteristicaBean(caratteristica.getNome(),caratteristica.getDescrizione(),caratteristica.getQuantita(),caratteristica.getStato(),caratteristica.getStanzaDiAppartenenza()));
		}
		return featureBeanList;
	}
}