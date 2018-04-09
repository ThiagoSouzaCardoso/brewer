package br.com.algaworks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.algaworks.brewer.model.Estilo;

public interface Estilos extends JpaRepository<Estilo, Long>{

}
