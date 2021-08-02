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

import com.gft.restaurante.entities.Mesa;
import com.gft.restaurante.services.MesaService;

@Controller
@RequestMapping("mesa")
public class MesaController {

	@Autowired
	private MesaService mesaService;
	
	@RequestMapping(path = "form")
	public ModelAndView formMesa() {

		ModelAndView mv = new ModelAndView("mesa/form.html");
		mv.addObject("mesa", new Mesa());

		return mv;
	}

	@RequestMapping(method = RequestMethod.POST, path = "form")
	public ModelAndView salvarMesa(@Valid Mesa mesa, BindingResult bindingResult) {

		ModelAndView mv = new ModelAndView("mesa/form.html");
		
		if(bindingResult.hasErrors()) {
			mv.addObject("mesa", mesa);
			return mv;
		}
		
		Mesa mesaSalvo = mesaService.salvarMesa(mesa);
		
		if(mesa.getId() == null) {
			mv.addObject("mesa", new Mesa());
		}else {
			mv.addObject(mesaSalvo);
		}
		
		mv.addObject("mensagem", "mesa salvo com sucesso");
		
		return mv;
	}

	@RequestMapping
	public ModelAndView listarMesas() {
		ModelAndView mv = new ModelAndView("mesa/listar.html");
		mv.addObject("lista", mesaService.listarMesas());
		
		return mv;
	}
	
	@RequestMapping("/editar")
	public ModelAndView editarMesa(@RequestParam Long id) {
		
		ModelAndView mv = new ModelAndView("mesa/form.html");
		Mesa mesa;
		
		try {
			mesa = mesaService.obterMesa(id);
		}catch(Exception e) {
			mesa = new Mesa();
			mv.addObject("mensagem", e.getMessage());
		}
		
		mv.addObject("mesa", mesa);
		return mv;
	}

	@RequestMapping("/excluir")
	public ModelAndView excluirMesa(@RequestParam Long id, RedirectAttributes redirectAttributes) {
		
		ModelAndView mv = new ModelAndView("redirect:/mesa");
		
		try {
			mesaService.excluirMesa(id);
			redirectAttributes.addFlashAttribute("mensagem", "Mesa excluida com sucesso.");
		}catch(Exception e) {
			redirectAttributes.addFlashAttribute("mensagem", "Erro ao excluir."+e.getMessage());
		}
	
		return mv;
	}
	
}
