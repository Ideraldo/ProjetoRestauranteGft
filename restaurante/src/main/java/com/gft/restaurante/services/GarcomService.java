package com.gft.restaurante.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gft.restaurante.entities.Garcom;
import com.gft.restaurante.repositories.GarcomRepository;

@Service
public class GarcomService {

	@Autowired
	private GarcomRepository garcomRepository;

	public Garcom salvarGarcom(Garcom garcom) {
		return garcomRepository.save(garcom);
	}

	public List<Garcom> listarGarcoms() {
		return garcomRepository.findAll();
	}

	public Garcom obterGarcom(Long id) throws Exception {

		Optional<Garcom> garcom = garcomRepository.findById(id);

		if (garcom.isEmpty()) {
			throw new Exception("Garcom não encontrado.");
		}

		return garcom.get();
	}

	public void excluirGarcom(Long id) {

		garcomRepository.deleteById(id);

	}

}
