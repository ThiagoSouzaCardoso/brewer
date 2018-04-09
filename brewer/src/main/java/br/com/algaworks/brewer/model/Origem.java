package br.com.algaworks.brewer.model;

import lombok.Getter;

public enum Origem {

	NACIONAL("Nacional"),
	INTERNACIONAL("Internacional");
	
	@Getter
	private String descricao;

	private Origem(String descricao) {
		this.descricao = descricao;
	}
	
	
}
