package br.com.algaworks.brewer.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "estilo")
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Estilo implements Serializable {

	private static final long serialVersionUID = 7813474019558247757L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	@NotNull(message="Nome é obrigatorio")
	@Size(max=20,message="Nome deve conter no maximo {max} caracteres")
	private String nome;

	@OneToMany(mappedBy = "estilo")
	private List<Cerveja> cervejas;

}
