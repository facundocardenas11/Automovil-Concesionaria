package com.sysone.app.SysOne.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public  class Automovil {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private Long id;
	
	
	@Column
	private String modelo;
	
	
	@Column
	private int precio;
	
	@Column
	private String opcionales;
	
	public Automovil() {
		this.id = (long) 0;
		this.modelo = "";
		this.precio = 0;
		this.opcionales = "";
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	public int getPrecio() {
		return precio;
	}


	public void setPrecio(int precio) {
		this.precio = precio;
	}


	public String getOpcionales() {
		return opcionales;
	}


	public void setOpcionales(String opcionales) {
		this.opcionales = opcionales;
	}


}
