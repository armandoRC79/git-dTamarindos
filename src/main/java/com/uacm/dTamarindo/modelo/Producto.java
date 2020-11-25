package com.uacm.dTamarindo.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Producto {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private int piezas;
	

	@NotNull
    @Size(max = 100)
	private String nombre;
	
	@NotNull
    @Size(max = 200)
	private String descripcion;
	
    
    public void setNombre(String nombre) {
    	this.nombre = nombre;
    }
    
    public void setDescripcion(String descripcion) {
    	this.descripcion = descripcion;
    }
    
    public void disminuyePiezas(int piezas) {
    		this.piezas = piezas;
    }
    
	public Long getId() {
		return id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	private String getDescripcion() {
		return descripcion;
	}
	
	private int getPiezas() {
		return piezas;
	}
}
