package br.com.algaworks.brewer.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.algaworks.brewer.service.exception.NomeEstiloCadastroException;

@ControllerAdvice
public class ControllerAdviceExceptionHandle {

	@ExceptionHandler(NomeEstiloCadastroException.class)
	public ResponseEntity<String> h(NomeEstiloCadastroException e){
		return ResponseEntity.badRequest().body(e.getMessage());
	}
	
}
