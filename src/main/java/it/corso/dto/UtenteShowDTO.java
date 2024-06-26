package it.corso.dto;

import java.util.List;

public class UtenteShowDTO {
	
	private int id;
	private String nome;
	
	private String cognome;

	private String email;
	
	//non c'è bisogno di usare "new" perché ci pensa il mapper ad istanziare l'oggetto
	private List<UtenteRuoloDTO> ruoli; //i nomi delle liste devono essere uguali ai model

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}


	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}


	public List<UtenteRuoloDTO> getRuoli() {
		return ruoli;
	}
	public void setRuoli(List<UtenteRuoloDTO> ruoli) {
		this.ruoli = ruoli;
	}
	
}
