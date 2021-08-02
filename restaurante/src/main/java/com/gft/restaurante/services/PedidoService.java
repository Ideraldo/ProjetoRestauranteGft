package com.gft.restaurante.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gft.restaurante.entities.Pedido;
import com.gft.restaurante.repositories.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	public Pedido salvarPedido(Pedido pedido) {
		return pedidoRepository.save(pedido);
	}

	public List<Pedido> listarPedidos(){
		return pedidoRepository.findAll();
	}
	
	public Pedido obterPedido(Long id) throws Exception {
		
		Optional<Pedido> pedido = pedidoRepository.findById(id);
		
		if(pedido.isEmpty()) {
			throw new Exception("Pedido não encontrado.");
		}
		
		return pedido.get();
	}

	public void excluirPedido(Long id) {
		
		pedidoRepository.deleteById(id);
		
	}
	
}
