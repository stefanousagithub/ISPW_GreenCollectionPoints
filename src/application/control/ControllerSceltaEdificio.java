package application.control;

import java.util.ArrayList;

import application.bean.EdificioBean;
import application.model.Edificio;
import application.persistence.EdificioDAO;

public class ControllerSceltaEdificio {
	private EdificioDAO EDao = new EdificioDAO();

	public ArrayList<EdificioBean> getTable()
	{
		ArrayList<EdificioBean> arrayBean = new ArrayList<EdificioBean>();
		ArrayList<Edificio> arrayBean1 = new ArrayList<Edificio>();
		arrayBean1=EDao.getTable();
		for (Edificio e : arrayBean1)
		{
			EdificioBean eBean= new EdificioBean(e.getNome(),e.getMacroarea(),e.getVia(),e.getCitta(),e.getPiani(),e.getDataCreazione(),e.getDataUltimaModifica());
			arrayBean.add(eBean);
		}
		return arrayBean;
	}

	public void delete(EdificioBean e)
	{
		Edificio edificio= new Edificio(e.getNome(),e.getMacroarea(),e.getVia(),e.getCitta(),e.getPiani(),e.getDataCreazione(),e.getDataUltimaModifica());
		EDao.delete(edificio);
	}
}