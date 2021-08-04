package com.gft.restaurante.entities;

public enum StatusPedido {

	
	AGUARDANDO("aguardando"),
	PREPARANDO("preparando"),
	PRONTO("pronto"),
	ENTREGUE("entregue");
	
	StatusPedido(String status) {
		this.status = status;
	}

	private String status;
	
	public String getStatus() {
		return status;
	}
	
	
}
