package com.gft.restaurante.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gft.restaurante.entities.Garcom;

@Repository
public interface GarcomRepository extends JpaRepository<Garcom, Long>{

}
