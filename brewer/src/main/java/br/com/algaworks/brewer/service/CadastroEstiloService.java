package br.com.algaworks.brewer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.algaworks.brewer.model.Estilo;
import br.com.algaworks.brewer.service.exception.NomeEstiloCadastroException;
import br.com.algaworks.repository.Estilos;

@Service
public class CadastroEstiloService {

	@Autowired
	private Estilos estilos;
	
	@Transactional
	public void salvar(Estilo estilo){
		if(estilos.findByNomeIgnoreCase(estilo.getNome()).isPresent()){
			throw new NomeEstiloCadastroException("Estilo já cadastrado!");
		}
		
		estilos.save(estilo);
	}
	
}
