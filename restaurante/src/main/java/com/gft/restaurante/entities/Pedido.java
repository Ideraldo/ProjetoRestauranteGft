package com.gft.restaurante.entities;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


@Entity
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//@OneToMany(mappedBy = "pedido")
	//private List<Pedido_Prato> pratos;
	
	@ManyToMany
	private List<Prato> pratos;
	
	@ManyToOne
	private Mesa mesa;

	private double precoTotal;

	private StatusPedido statusPedido;
	
	private int quantidade;
	
	
	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public StatusPedido getStatusPedido() {
		return statusPedido;
	}

	public void setStatusPedido(StatusPedido statusPedido) {
		this.statusPedido = statusPedido;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getPrecoTotal() {
		this.precoTotal = 0;
		precoTotal = this.pratos.stream().mapToDouble(p -> p.getPreco()).sum();
		return precoTotal*quantidade;
	}

	public void setPrecoTotal(double precoTotal) {
		this.precoTotal = precoTotal;
	}

	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}

	public List<Prato> getPratos() {
		return pratos;
	}

	public void setPratos(List<Prato> pratos) {
		this.pratos = pratos;
	}

	/* public List<Pedido_Prato> getPratos() {
		return pratos;
	}

	public void setPratos(List<Pedido_Prato> pratos) {
		this.pratos = pratos;
	} */
	
	@Override
	public String toString() {		
		return pratos.stream().map(p -> p.getNome()).collect(Collectors.toList()).toString();
		
	}
		
}
