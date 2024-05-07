package application.bean;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class EdificioBean {
	private String nome;
	private String macroarea;
	private String via;
	private String citta;
	private String numeroPiani;
	private String dataCreazione; //Data di inaugurazione dell'edificio
	private String dataUltimaModifica;
	private StringProperty nome1;
	private StringProperty macroarea1;

	public static final String UNDEFINED = "Non specificato"; //va messa nella cartella util

	public EdificioBean(){
	}

	public EdificioBean(String nome, String macroarea, String via, String citta, String numeroPiani, String dataCreazione){
		this.nome = nome;
		this.macroarea = macroarea;
		this.via = via;
		this.citta = citta;
		this.numeroPiani = numeroPiani;
		this.dataCreazione = dataCreazione;
		this.dataUltimaModifica = null;

	}

	public EdificioBean(String nome, String macroarea, String via, String citta, String numeroPiani, String dataCreazione, String dataUltimaModifica) {
		//costruttore con tutti gli attributi in input, viene chiamato solo dal DAO dell'edificio per eseguire
		//il prelievo di tutti i dati dalla tabella
		this.nome = nome;
		this.macroarea = macroarea;
		this.via = via;
		this.citta = citta;
		this.numeroPiani = numeroPiani;
		this.dataCreazione = dataCreazione;
		this.dataUltimaModifica = dataUltimaModifica;
		this.nome1 = new SimpleStringProperty((String) nome);
		this.macroarea1 = new SimpleStringProperty((String) macroarea);
	}

	public String getNome() {
		return this.nome;
	}
	public StringProperty getNome1() {
		return this.nome1;
	}

	public void setNome(String nome) {
		this.nome = nome;
    }

	public String getPiani() {
		return this.numeroPiani;
	}

	public void setPiani(String numeroPiani) {
		this.numeroPiani=numeroPiani;
	}

	public String getMacroarea() {
		return this.macroarea;
	}
	public StringProperty getMacroarea1() {
		return this.macroarea1;
	}
	public void setMacroarea(String macroarea) {
		this.macroarea = macroarea;
	}

	public String getVia() {
		return this.via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public String getCitta() {
		return this.citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getDataCreazione() {
		return this.dataCreazione;
	}

	public void setDataCreazione(String dataCreazione) {
		this.dataCreazione = dataCreazione;
	}

	public String getDataUltimaModifica() {
		return this.dataUltimaModifica;
	}

	public void setDataUltimaModifica(String dataUltimaModifica) {
		this.dataUltimaModifica = dataUltimaModifica;
	}

	@Override
	public String toString() {
		return "Edificio " + this.getNome() + " creato in data " + this.getDataCreazione() + ".\n";
	}
}
