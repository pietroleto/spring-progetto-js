package it.corso.dto;

import java.util.List;

import it.corso.model.Ruolo;

public class UtenteAggiornamentoDTO {
	private int id;
	private String nome;
	private String cognome;
	private String email;
	private List<Ruolo> ruoli;
	
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
	
	
	public List<Ruolo> getRuoli() {
		return ruoli;
	}
	public void setRuoli(List<Ruolo> ruoli) {
		this.ruoli = ruoli;
	}
}
