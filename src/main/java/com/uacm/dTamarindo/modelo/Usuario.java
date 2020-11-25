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
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String nombre;
	
	@NotNull
    @Size(max = 10)
	private String password;
	
	@NotNull
    @Size(max = 20)
	private String rol;
	
	public void setId(Long id) {
    	this.id = id;
	}
 
	public Long getId() {
			return id;
	}
	
	public void setNombre(String nombre) {
	    	this.nombre = nombre;
	}
	 
	public String getNombre() {
			return nombre;
	}
	
	public void setPassword(String password) {
    	this.password = password;
	}
	 
	public String getPassword() {
			return password;
	}
	
	public void setRol(String rol) {
    	this.rol = rol;
	}
	 
	public String getRol() {
			return rol;
	}
	
	    
	   
	    
		
}
