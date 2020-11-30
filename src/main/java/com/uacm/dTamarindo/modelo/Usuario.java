package com.uacm.dTamarindo.modelo;

import java.util.regex.Pattern;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.uacm.dTamarindo.exceps.ExcepcionUsuario;

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
	
	public void setRol(String rol) throws ExcepcionUsuario {
		if(compruebaCadena(rol))
			this.rol = rol;
		else 
			throw new ExcepcionUsuario("Un rol sólo incluye letras y espacios");
	}
	 
	public String getRol() {
			return rol;
	}	    
	
	private boolean compruebaCadena(String s) {
		boolean esCadena = Pattern.matches("[A-Za-z\\u00F1\\u00FA\\u00E1\\u00E9"
				+ "\\u00ED\\u00E3\\u00C1\\u00C9\\u00CD\\u00D3\\u00DA\\u00D1\s]*", s);
		return esCadena;
	}
		
}
