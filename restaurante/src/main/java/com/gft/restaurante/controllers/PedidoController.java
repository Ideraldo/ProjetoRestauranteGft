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

import com.gft.restaurante.entities.Pedido;
import com.gft.restaurante.services.MesaService;
import com.gft.restaurante.services.PedidoService;
import com.gft.restaurante.services.PratoService;

@Controller
@RequestMapping("pedido")
public class PedidoController {

	@Autowired
	private PedidoService pedidoService;
	
	@Autowired
	private PratoService pratoService;
	
	@Autowired
	private MesaService mesaService;
	
	@RequestMapping(path = "form")
	public ModelAndView formPedido() {

		ModelAndView mv = new ModelAndView("pedido/form.html");
		mv.addObject("pedido", new Pedido());
		
		mv.addObject("listaPratos", pratoService.listarPratos());
		mv.addObject("listaMesas", mesaService.listarMesas());

		return mv;
	}

	@RequestMapping(method = RequestMethod.POST, path = "form")
	public ModelAndView salvarPedido(@Valid Pedido pedido, BindingResult bindingResult) {

		ModelAndView mv = new ModelAndView("pedido/form.html");
		
		if(bindingResult.hasErrors()) {
			mv.addObject("pedido", pedido);
			return mv;
		}
		
		Pedido pedidoSalvo = pedidoService.salvarPedido(pedido);
		
		if(pedido.getId() == null) {
			mv.addObject("pedido", new Pedido());
		}else {
			mv.addObject(pedidoSalvo);
		}
		
		mv.addObject("mensagem", "pedido salvo com sucesso");
		mv.addObject("listaPratos", pratoService.listarPratos());
		mv.addObject("listaMesas", mesaService.listarMesas());
		
		return mv;
	}

	@RequestMapping
	public ModelAndView listarPedidos() {
		ModelAndView mv = new ModelAndView("pedido/listar.html");
		mv.addObject("lista", pedidoService.listarPedidos());
		
		return mv;
	}
	
	@RequestMapping("/editar")
	public ModelAndView editarPedido(@RequestParam Long id) {
		
		ModelAndView mv = new ModelAndView("pedido/form.html");
		Pedido pedido;
		
		try {
			pedido = pedidoService.obterPedido(id);
		}catch(Exception e) {
			pedido = new Pedido();
			mv.addObject("mensagem", e.getMessage());
		}
		
		mv.addObject("pedido", pedido);
		mv.addObject("listaPratos", pratoService.listarPratos());
		mv.addObject("listaMesas", mesaService.listarMesas());
		
		return mv;
	}

	@RequestMapping("/excluir")
	public ModelAndView excluirPedido(@RequestParam Long id, RedirectAttributes redirectAttributes) {
		
		ModelAndView mv = new ModelAndView("redirect:/pedido");
		
		try {
			pedidoService.excluirPedido(id);
			redirectAttributes.addFlashAttribute("mensagem", "Pedido excluido com sucesso.");
		}catch(Exception e) {
			redirectAttributes.addFlashAttribute("mensagem", "Erro ao excluir."+e.getMessage());
		}
	
		return mv;
	}
	
}