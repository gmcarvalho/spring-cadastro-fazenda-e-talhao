package com.farm.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.farm.model.Fazenda;

@Controller
public class FazendasController {
	@RequestMapping("/fazendas/novo")
	public String novo(Fazenda cerveja) {
		return "fazenda/CadastroFazenda";
	}
	
	@RequestMapping(value = "/fazendas/novo", method = RequestMethod.POST)
	public String cadastrar(@Valid Fazenda cerveja, BindingResult result, Model model, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return novo(cerveja);
		}
		
		// Salvar no banco de dados...
		attributes.addFlashAttribute("mensagem", "Cerveja salva com sucesso!");
		System.out.println(">>> sku: " + cerveja.getSku());
		return "redirect:/fazendas/novo";
	}
}
