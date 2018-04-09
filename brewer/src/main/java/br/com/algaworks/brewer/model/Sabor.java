package br.com.algaworks.brewer.model;

import lombok.Getter;

public enum Sabor {

	ADOCICADA("Adocicada"),
	AMARGA("Amarga"),
	FORTE("Forte"),
	FRUTADA("Frutada"),
	SUAVE("Suave");
	
	@Getter
	private String descricao;
	
	private Sabor(String descricao) {
		this.descricao = descricao;
	}
	
}