package com.gft.restaurante.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gft.restaurante.entities.Cozinheiro;
import com.gft.restaurante.repositories.CozinheiroRepository;

@Service
public class CozinheiroService {

	@Autowired
	private CozinheiroRepository cozinheiroRepository;

	public Cozinheiro salvarCozinheiro(Cozinheiro cozinheiro) {
		return cozinheiroRepository.save(cozinheiro);
	}

	public List<Cozinheiro> listarCozinheiros() {
		return cozinheiroRepository.findAll();
	}

	public Cozinheiro obterCozinheiro(Long id) throws Exception {

		Optional<Cozinheiro> cozinheiro = cozinheiroRepository.findById(id);

		if (cozinheiro.isEmpty()) {
			throw new Exception("Cozinheiro não encontrado.");
		}

		return cozinheiro.get();
	}

	public void excluirCozinheiro(Long id) {

		cozinheiroRepository.deleteById(id);

	}

}
