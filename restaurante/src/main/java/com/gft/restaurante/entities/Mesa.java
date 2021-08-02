package com.gft.restaurante.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Mesa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private int numero;
	private StatusMesa status;
	
	@OneToMany(mappedBy = "mesa")
	private List<Pedido> pedidos;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public StatusMesa getStatus() {
		return status;
	}
	public void setStatus(StatusMesa status) {
		this.status = status;
	}
	
	
	
}
