package com.gft.restaurante.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gft.restaurante.entities.Prato;
import com.gft.restaurante.repositories.PratoRepository;

@Service
public class PratoService {
	
	@Autowired
	private PratoRepository pratoRepository;
	
	public Prato salvarPrato(Prato prato) {
		return pratoRepository.save(prato);
	}

	public List<Prato> listarPratos(){
		return pratoRepository.findAll();
	}
	
	public Prato obterPrato(Long id) throws Exception {
		
		Optional<Prato> prato = pratoRepository.findById(id);
		
		if(prato.isEmpty()) {
			throw new Exception("Prato não encontrado.");
		}
		
		return prato.get();
	}

	public void excluirPrato(Long id) {
		
		pratoRepository.deleteById(id);
		
	}
	
}
