package it.corso.dto;

import it.corso.model.NomeRuolo;

public class AddRuoloDTO {
	private NomeRuolo nome;
	
	public NomeRuolo getNome() {
		return nome;
	}
	public void setNome(NomeRuolo nome) {
		this.nome = nome;
	}
}
