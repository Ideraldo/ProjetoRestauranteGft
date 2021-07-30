package com.gft.restaurante.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gft.restaurante.entities.Prato;
import com.gft.restaurante.repositories.PratoRepository;

//Falta a anotação aqui?
@Service
public class PratoService {
	
	@Autowired
	private PratoRepository pratoRepository;
	
	public Prato salvarPrato(Prato prato) {
		return pratoRepository.save(prato);
	}
	
}
