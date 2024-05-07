package application.model;

public class Stanza {
	private String nome;
	private int posti;
	private int piano;
	private String tipo;
	private String edificioDiAppartenenza;

	public Stanza(String nome, int posti, int piano, String tipo, String edificioDiAppartenenza) {
		this.nome = nome;
		this.posti = posti;
		this.piano = piano;
		this.tipo = tipo;
		this.edificioDiAppartenenza = edificioDiAppartenenza;
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