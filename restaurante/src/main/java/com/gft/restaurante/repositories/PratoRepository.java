package com.gft.restaurante.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gft.restaurante.entities.Prato;

@Repository
public interface PratoRepository extends JpaRepository<Prato, Long>{

}
