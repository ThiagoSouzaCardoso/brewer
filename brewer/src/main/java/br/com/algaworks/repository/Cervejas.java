package br.com.algaworks.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.algaworks.brewer.model.Cerveja;

@Repository
public interface Cervejas extends JpaRepository<Cerveja, Long>{

	Optional<Cerveja> findBySkuIgnoreCase(String sku);
	
}
