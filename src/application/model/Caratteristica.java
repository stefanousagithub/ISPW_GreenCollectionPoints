package application.model;

public class Caratteristica {
	private String nome;
	private String descrizione;
	private int quantita = 1;
	private boolean sonoRotto = false;
	private String stanzaDiAppartenenza;

	public Caratteristica(String nome, String descrizione, String stanzaDiAppartenenza)
	{
		this.nome=nome;
		this.descrizione=descrizione;
		this.stanzaDiAppartenenza = stanzaDiAppartenenza;
	}

	public Caratteristica(String nome, String descrizione, int quantita, boolean sonoRotto, String stanzaDiAppartenenza) {
		/*costruttore con tutti gli attributi in input, viene chiamato solo dal DAO della caratteristica per eseguire
		il prelievo di tutti i dati dalla tabella*/
		this.nome=nome;
		this.descrizione=descrizione;
		this.stanzaDiAppartenenza = stanzaDiAppartenenza;
		this.quantita = quantita;
		this.sonoRotto = sonoRotto;
	}

	public String getNome() {
		return this.nome;
	}

	public String getDescrizione() {
		return this.descrizione;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	public int getQuantita() {
		return this.quantita;
	}

	public boolean getStato() {
		return this.sonoRotto;
	}

	public String getStanzaDiAppartenenza() {
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
