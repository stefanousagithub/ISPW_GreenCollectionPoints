package application.control;

import application.bean.EdificioBean;
import application.model.Edificio;
import application.persistence.EdificioDAO;

public class ControllerGestioneEdifici {
	private EdificioDAO EDao = new EdificioDAO();

	public void store(EdificioBean edificio)
	{
		Edificio edificio1= new Edificio(edificio.getNome(),edificio.getMacroarea(),edificio.getVia(),edificio.getCitta(),edificio.getPiani(),
											edificio.getDataCreazione(),edificio.getDataUltimaModifica());
		EDao.store(edificio1);

	}
	public void modificaEdificio(EdificioBean edificio) {
		Edificio edificio1= new Edificio(edificio.getNome(),edificio.getMacroarea(),edificio.getVia(),edificio.getCitta(),edificio.getPiani(),
				edificio.getDataCreazione(),edificio.getDataUltimaModifica());
		EDao.update(edificio1);
	}
}
