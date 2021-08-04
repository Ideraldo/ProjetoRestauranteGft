package com.gft.restaurante.entities;

import java.util.Date;

public class Funcionario {

	private String nome;
	private int idade;
	private Date dataContratacao;

	public Funcionario(String nome, int idade, Date dataContratacao) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.dataContratacao = dataContratacao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public Date getDataContratacao() {
		return dataContratacao;
	}

	public void setDataContratacao(Date dataContratacao) {
		this.dataContratacao = dataContratacao;
	}

}
