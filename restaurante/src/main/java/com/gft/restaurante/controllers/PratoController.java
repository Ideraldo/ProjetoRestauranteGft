package com.gft.restaurante.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gft.restaurante.entities.Prato;
import com.gft.restaurante.services.PratoService;

@Controller
@RequestMapping("prato")
public class PratoController {

	private PratoService pratoService;
	
	@RequestMapping(path = "novo")
	public ModelAndView novoPrato() {

		ModelAndView mv = new ModelAndView("prato/novo.html");
		mv.addObject("prato", new Prato());

		return mv;
	}

	@RequestMapping(method = RequestMethod.POST, path = "novo")
	public ModelAndView salvarPrato(Prato prato) {

		ModelAndView mv = new ModelAndView("prato/novo.html");
		mv.addObject("prato", new Prato());

		Prato pratoSalvo = pratoService.salvarPrato(prato);
		
		if(prato.getId() == null) {
			mv.addObject("prato", new Prato());
		}else {
			mv.addObject("prato", pratoSalvo);
		}
		
		mv.addObject("mensagem", "Desenvolvedor salvo");
		return mv;

	}

}
