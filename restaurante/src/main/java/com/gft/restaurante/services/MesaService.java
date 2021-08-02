package com.gft.restaurante.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gft.restaurante.entities.Mesa;
import com.gft.restaurante.repositories.MesaRepository;

@Service
public class MesaService {
	
	@Autowired
	private MesaRepository mesaRepository;
	
	public Mesa salvarMesa(Mesa mesa) {
		mesaRepository.save(mesa);
		return mesa;
	}
	
}
