package com.gft.restaurante.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gft.restaurante.entities.Cozinheiro;

@Repository
public interface CozinheiroRepository extends JpaRepository<Cozinheiro, Long>{

}
