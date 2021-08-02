package com.gft.restaurante.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gft.restaurante.entities.Mesa;

@Repository
public interface MesaRepository extends JpaRepository<Mesa, Long>{

}
