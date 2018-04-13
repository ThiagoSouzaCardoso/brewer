package br.com.algaworks.brewer.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.algaworks.brewer.model.Estilo;
import br.com.algaworks.brewer.service.CadastroEstiloService;
import br.com.algaworks.brewer.service.exception.NomeEstiloCadastroException;

@Controller
@RequestMapping("estilos")
public class EstiloController {

	@Autowired
	private CadastroEstiloService estiloService;
	
	@RequestMapping("novo")
	public ModelAndView novo(Estilo estilo){
		ModelAndView mv = new ModelAndView("estilo/CadastroEstilo");
		return mv;
	}

	@RequestMapping(value="novo",method=RequestMethod.POST)
	public ModelAndView cadastrar(@Valid Estilo estilo, BindingResult result, Model model, RedirectAttributes attributes){
		if(result.hasErrors()){
			return novo(estilo);
		}
		try {
			estiloService.salvar(estilo);
		} catch (NomeEstiloCadastroException e) {
			result.rejectValue("nome", e.getMessage(),e.getMessage());
			return novo(estilo);
		}
		
		attributes.addFlashAttribute("message","Cadastrado com sucesso!");
		return new ModelAndView("redirect:/estilos/novo");
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes={MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody ResponseEntity<?> salvar(@RequestBody @Valid Estilo estilo, BindingResult result){
		if(result.hasErrors()){
			return ResponseEntity.badRequest().body(result.getFieldError("nome").getDefaultMessage());
		}
		estilo = estiloService.salvar(estilo);
		return ResponseEntity.ok(estilo);
	}
	
}