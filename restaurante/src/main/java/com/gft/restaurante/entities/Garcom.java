package com.gft.restaurante.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Garcom extends Funcionario{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	public Garcom(String nome, int idade, Date dataContratacao) {
		super(nome, idade, dataContratacao);
	}

}
