package application.bean;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CaratteristicaBean {
	private String nome;
	private String descrizione;
	private int quantita = 1;
	private boolean sonoRotto = false;
	private String stanzaDiAppartenenza;
	private StringProperty nomeObservable;
	private IntegerProperty quantitaObservable;
	private BooleanProperty sonoRottoObservable;

	public CaratteristicaBean(){
	}

	public CaratteristicaBean(String nome, String descrizione, String stanzaDiAppartenenza){
		this.nome=nome;
		this.descrizione=descrizione;
		this.stanzaDiAppartenenza = stanzaDiAppartenenza;
	}

	public CaratteristicaBean(String nome, String descrizione, int quantita, boolean sonoRotto, String stanzaDiAppartenenza) {
		//costruttore con tutti gli attributi in input, viene chiamato solo dal DAO della caratteristica per eseguire
		//il prelievo di tutti i dati dalla tabella
		this.nome=nome;
		this.descrizione=descrizione;
		this.stanzaDiAppartenenza = stanzaDiAppartenenza;
		this.quantita = quantita;
		this.sonoRotto = sonoRotto;
		nomeObservable = new SimpleStringProperty((String) nome);
		quantitaObservable= new SimpleIntegerProperty((int)quantita);
		sonoRottoObservable= new SimpleBooleanProperty((Boolean)sonoRotto);
	}
	
	public StringProperty getNomeProperty(){
		return nomeObservable;
	}
	
	public IntegerProperty getQuantitaProperty(){
		return quantitaObservable;
	}
	
	public BooleanProperty getStatoProperty(){
		return sonoRottoObservable;
	}
	
	public String getNome() {
		return this.nome;
	}

	public String getDescrizione(){
		return this.descrizione;
	}

	public void setQuantita(int quantita){
		this.quantita = quantita;
	}

	public int getQuantita(){
		return this.quantita;
	}

	public boolean getStato(){
		return this.sonoRotto;
	}

	public String getStanzaDiAppartenenza(){
		return this.stanzaDiAppartenenza;
	}

	public void guasta() {
		this.sonoRotto = true;
	}

	@Override
	public String toString() {
		return "[" + this.getNome() + "] quantità: " + this.getQuantita() + " nella stanza " +
				this.getStanzaDiAppartenenza() + ".\n";
	}
}
