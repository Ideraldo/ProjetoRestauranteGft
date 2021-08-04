package com.gft.restaurante.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cozinheiro extends Funcionario{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	public Cozinheiro(String nome, int idade, Date dataContratacao) {
		super(nome, idade, dataContratacao);
	}

}
