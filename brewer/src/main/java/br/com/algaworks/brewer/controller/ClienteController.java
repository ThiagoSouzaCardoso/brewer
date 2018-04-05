package br.com.algaworks.brewer.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.algaworks.brewer.model.Usuario;

@Controller
public class ClienteController {

	@RequestMapping("/clientes/novo")
	public String novo(Usuario cliente){
		return "cliente/CadastroCliente";
	}

	@RequestMapping(value="/clientes/novo",method=RequestMethod.POST)
	public String cadastrar(@Valid Usuario usuario, BindingResult result, Model model, RedirectAttributes attributes){
		if(result.hasErrors()){
			return novo(usuario);
		}
			attributes.addFlashAttribute("message","Cadastrado com sucesso!");
		return "redirect:/clientes/novo";
	}
	
}