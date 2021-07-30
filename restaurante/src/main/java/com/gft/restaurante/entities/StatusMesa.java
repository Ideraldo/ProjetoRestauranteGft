package com.gft.restaurante.entities;

public enum StatusMesa {

	
	DISPONIVEL("disponivel"),
	OCUPADA("ocupada"),
	RESERVADA("reservada");
	
	StatusMesa(String status) {
		this.status = status;
	}

	private String status;
	
	public String getStatus() {
		return status;
	}
	
	
}
