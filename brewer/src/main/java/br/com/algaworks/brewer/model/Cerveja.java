package br.com.algaworks.brewer.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "cerveja")
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Cerveja implements Serializable {

	private static final long serialVersionUID = 2704777295662584454L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@SKU
	@NotBlank(message = "SKU é obrigatório")
	private String sku;

	@NotBlank(message = "Nome é obrigatório")
	private String nome;

	@NotBlank(message = "Descrição é obrigatória")
	@Size(min = 1, max = 50, message = "O tamanho da descrição deve estar entre 1 e 50")
	private String descricao;

	@NotNull(message="Valor é obrigatório")
	@DecimalMin("0.01")
	@DecimalMax(value="9999999.99", message="O Valor da cerveja deve ser menor que 9.999.999,99")
	private BigDecimal valor;

	@NotNull(message="Teor Alcóolico é obrigatório")
	@DecimalMax(value="100.0", message="O Teor Alcóolico deve ser Menor ou igual a 100")
	@Column(name = "teor_alcoolico")
	private BigDecimal teorAlcoolico;

	@NotNull(message="Comissão é obrigatório")
	@DecimalMax(value="100.0", message="Comissão deve ser Menor ou Igual a 100")
	private BigDecimal comissao;

	@NotNull(message="Quantidade Estoque é obrigatório")
	@Max(value=9999,message="A quantidade de estoque deve ser menor que 9.999")
	@Column(name = "quantidade_estoque")
	private Integer quantidadeEstoque;

	@NotNull(message="Origem é obrigatório")
	@Enumerated(EnumType.STRING)
	private Origem origem;

	@NotNull(message="Sabor é obrigatório")
	@Enumerated(EnumType.STRING)
	private Sabor sabor;

	
	@NotNull(message="Estilo é obrigatório")
	@ManyToOne
	@JoinColumn(name = "codigo_estilo")
	private Estilo estilo;
	
	@PrePersist
	@PreUpdate
	private void onSaveAndUpdate(){
		this.sku = this.sku.toUpperCase();
	}
	
}
