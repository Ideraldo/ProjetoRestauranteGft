package com.gft.restaurante.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gft.restaurante.entities.Mesa;
import com.gft.restaurante.repositories.MesaRepository;

@Service
public class MesaService {

	@Autowired
	private MesaRepository mesaRepository;
	
	public Mesa salvarMesa(Mesa mesa) {
		return mesaRepository.save(mesa);
	}

	public List<Mesa> listarMesas(){
		return mesaRepository.findAll();
	}
	
	public Mesa obterMesa(Long id) throws Exception {
		
		Optional<Mesa> mesa = mesaRepository.findById(id);
		
		if(mesa.isEmpty()) {
			throw new Exception("Mesa não encontrado.");
		}
		
		return mesa.get();
	}

	public void excluirMesa(Long id) {
		
		mesaRepository.deleteById(id);
		
	}
	
	
	
}
