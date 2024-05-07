package application.model;

public class Utente {
	private String nome;
	private String password;
	private String professione;
	
	public Utente(String nome, String password, String professione) {	
		this.nome = nome;
		this.password = password;
		this.professione = professione;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setPassword(String password) {	
		this.password = password;
	}
	
	public void setProfessione(String professione) {	
		this.professione = professione;
	}
	
	public String getNome() {	
		return this.nome;
	}
	
	public String getPassword() {	
		return this.password;
	}
	
	public String getProfessione() {	
		return this.professione;
	}
}