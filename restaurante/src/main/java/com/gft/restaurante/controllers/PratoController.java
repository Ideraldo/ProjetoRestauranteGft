package com.gft.restaurante.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gft.restaurante.entities.Prato;
import com.gft.restaurante.services.PratoService;

@Controller
@RequestMapping("prato")
public class PratoController {

	@Autowired
	private PratoService pratoService;
	
	@RequestMapping(path = "form")
	public ModelAndView formPrato() {

		ModelAndView mv = new ModelAndView("prato/form.html");
		mv.addObject("prato", new Prato());

		return mv;
	}

	@RequestMapping(method = RequestMethod.POST, path = "form")
	public ModelAndView salvarPrato(@Valid Prato prato, BindingResult bindingResult) {

		ModelAndView mv = new ModelAndView("prato/form.html");
		
		if(bindingResult.hasErrors()) {
			mv.addObject("prato", prato);
			return mv;
		}
		
		Prato pratoSalvo = pratoService.salvarPrato(prato);
		
		if(prato.getId() == null) {
			mv.addObject("prato", new Prato());
		}else {
			mv.addObject(pratoSalvo);
		}
		
		mv.addObject("mensagem", "prato salvo com sucesso");
		
		return mv;
	}

	@RequestMapping
	public ModelAndView listarPratos() {
		ModelAndView mv = new ModelAndView("prato/listar.html");
		mv.addObject("lista", pratoService.listarPratos());
		
		return mv;
	}
	
	@RequestMapping("/editar")
	public ModelAndView editarPrato(@RequestParam Long id) {
		
		ModelAndView mv = new ModelAndView("prato/form.html");
		Prato prato;
		
		try {
			prato = pratoService.obterPrato(id);
		}catch(Exception e) {
			prato = new Prato();
			mv.addObject("mensagem", e.getMessage());
		}
		
		mv.addObject("prato", prato);
		return mv;
	}

	@RequestMapping("/excluir")
	public ModelAndView excluirPrato(@RequestParam Long id, RedirectAttributes redirectAttributes) {
		
		ModelAndView mv = new ModelAndView("redirect:/prato");
		
		try {
			pratoService.excluirPrato(id);
			redirectAttributes.addFlashAttribute("mensagem", "Prato excluido com sucesso.");
		}catch(Exception e) {
			redirectAttributes.addFlashAttribute("mensagem", "Erro ao excluir."+e.getMessage());
		}
	
		return mv;
	}
	
}
