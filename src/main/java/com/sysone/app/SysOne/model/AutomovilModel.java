package com.sysone.app.SysOne.model;

import java.util.ArrayList;
import java.util.List;

import com.sysone.app.SysOne.entities.Automovil;
import com.sysone.app.SysOne.factory.FactoryOperation;

public  class AutomovilModel {
	
	private Long id;
	
	private String modelo;
	
	private int precio;
	
	private List<String> opcionales;
	
	public AutomovilModel() {
		this.opcionales = new ArrayList<String>();
	}
	
	public AutomovilModel(String modelo, int precio) {
		
		this.modelo=modelo;
		this.precio=precio;
		this.opcionales = new ArrayList<String>();
	}
	
	public AutomovilModel(Automovil automovil) {
		this.cargoAuto(automovil);
	}

	public  AutomovilModel(Long id, String nombre, List<String> opcionales, int precio) {
		super();
		this.setId(id);
		this.setModelo(nombre);
		this.setOpcionales(opcionales);
		this.setPrecio(0);
		
		int precioFinal = 0;
		AutomovilModel model = FactoryOperation.creoAutomovil(nombre);
		precioFinal += model.getPrecio();
		
		for (String codigo : opcionales) {
			Opcional opcional = FactoryOperation.creoOpcional(codigo);
			precioFinal += opcional.getPrecio();
		}
		this.setPrecio(precioFinal);
		
	}
	public AutomovilModel crearAutomovilModel() {
		return new AutomovilModel((long)0,this.modelo,this.opcionales,this.precio);
	}
	public void cargoAuto(Automovil a) {
		Long id = a.getId();
		String nombre = a.getModelo();
		
		List<String> opcionales = new ArrayList<String>();
		//Comprobamos que el dato de Opcionales no viene nulo (NULL) en la base de datos, o bien no es vacio
		
		if(a.getOpcionales() != null && !a.getOpcionales().isEmpty()) {
			for(String opcional : a.getOpcionales().split(",")) {
				//Cuando manejamos un SET o conjunto de datos, 
				//no podemos agregar 2 veces el mismo elemento porque sino nos lanza excepcion
				//Entonces comprobamos que en el SET no existe el elemento que queremos agregar
				if(!opcionales.contains(opcional))
					opcionales.add(opcional);
			}
		}
		
		
		this.setId(id);
		this.setModelo(nombre);
		this.setOpcionales(opcionales);
		this.setPrecio(a.getPrecio());
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

	public List<String> getOpcionales() {
		return opcionales;
	}

	public void setOpcionales(List<String> opcionales) {
		this.opcionales = opcionales;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Automovil toEntity() {
		
		Automovil entity = new Automovil();
		entity.setId(this.getId());
		entity.setModelo(this.getModelo());
		String options = "";
		
		for(String opcional : this.getOpcionales()) {
			options += opcional + ",";
		}
		if(options.length() > 2) {
			options.substring(0, options.length()-2);
		}		
		entity.setOpcionales(options);
		entity.setPrecio(this.getPrecio());
		return entity;
	}

}
