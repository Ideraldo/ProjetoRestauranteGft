package com.gft.restaurante.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gft.restaurante.entities.Mesa;
import com.gft.restaurante.repositories.MesaRepository;
import com.gft.restaurante.services.MesaService;

@Controller
@RequestMapping("mesa")
public class MesaController {
	
	@Autowired
	private MesaRepository repository;
	//private MesaService mesaService;

	@RequestMapping(path = "nova")
	public ModelAndView novaMesa() {

		ModelAndView mv = new ModelAndView("mesa/nova.html");
		mv.addObject("mesa", new Mesa());

		return mv;
	}

	@RequestMapping(method = RequestMethod.POST, path = "nova")
	public ModelAndView salvarMesa(Mesa mesa) {

		ModelAndView mv = new ModelAndView("mesa/nova.html");
		mv.addObject("mesa", mesa);
		
	//	Mesa mesaNova = new Mesa();
	//	mesaNova.setNumero(1);
	//	mesaNova.setStatus(StatusMesa.RESERVADA);

	//		mesaService.salvarMesa(mesa);
		
		Mesa mesaSalva = repository.save(mesa);

		if (mesa.getId() == null) {
			mv.addObject("mesa", new Mesa());
		} else {
			mv.addObject("mesa", mesaSalva);
		}

		mv.addObject("mesa", "Mesa salva");
		return mv;

	}

}
