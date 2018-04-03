package br.com.algaworks.brewer.model;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cerveja {

	@NotBlank
	private String sku;
	
	@NotBlank
	private String nome;
	
	@Size(max=50, min=1)
	private String descricao;
	
}
