package application.bean;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class StanzaBean {
	private String nome;
	private int posti;
	private int piano;
	private String tipo;
	private String edificioDiAppartenenza;
	private StringProperty nomeObservable;
	private IntegerProperty pianoObservable;
	private IntegerProperty postiObservable;

	public StanzaBean(){
	}

	public StanzaBean(String nome, int posti, int piano, String tipo, String edificioDiAppartenenza) {
		this.nome = nome;
		nomeObservable = new SimpleStringProperty((String) nome);
		this.posti = posti;
		this.piano = piano;
		pianoObservable = new SimpleIntegerProperty((int)piano);
		postiObservable= new SimpleIntegerProperty((int)posti);
		this.tipo = tipo;
		this.edificioDiAppartenenza = edificioDiAppartenenza;
	}

	public StringProperty getNomeProperty() {
		return nomeObservable;
	}
	
	public IntegerProperty getPianoProperty() {
		return pianoObservable;
	}
	
	public IntegerProperty getPostiProperty() {
		return postiObservable;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getPosti() {
		return this.posti;
	}

	public void setPosti(int posti) {
		this.posti = posti;
	}

	public int getPiano() {
		return this.piano;
	}

	public void setPiano(int piano) {
		this.piano = piano;
	}

	public String getTipo(){
		return this.tipo;
	}

	public String getEdifDiAppartenenza() {
		return this.edificioDiAppartenenza;
	}

	public void setEdifDiAppartenenza(String edificioDiAppartenenza) {
		this.edificioDiAppartenenza = edificioDiAppartenenza;
	}
	
	@Override
	public String toString() {

		return this.getTipo() + " di nome " + this.getNome() + " al piano " + this.getPiano() +
				" con " + this.getPosti() + " posti. si trova nell'edificio " + this.getEdifDiAppartenenza() + ". \n";
	}
}
