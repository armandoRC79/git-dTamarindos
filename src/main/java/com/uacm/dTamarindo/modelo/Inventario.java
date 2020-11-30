package com.uacm.dTamarindo.modelo;

import java.util.HashMap;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Inventario {
	 
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "invoice")
	private static HashMap<String, Producto> productos = new HashMap<String, Producto>();



	public Long getId() {
		return id;
	}
	
	public static boolean altaProducto(Producto producto) {
		boolean exito = false;
		if(producto != null) {
			productos.put(producto.getNombre(), producto);
			exito = true;
		}
		return exito;
	}
	
	public static boolean bajaProducto(Producto producto) {
		boolean exito = false;
		
		if(producto != null)
			exito = productos.remove(producto.getNombre(), producto);
		
		return exito;
	}
	
	public static boolean modificaProducto(Producto producto) {
		boolean exito = false;
		if(producto != null) {
			productos.put(producto.getNombre(), producto);
			exito = true;
		}
		return exito;
	}
	
	public static Optional<Producto> buscaProducto(String nomProducto){
		Optional<Producto> optProducto = Optional.empty();
		
		if(productos.get(nomProducto) != null)
			optProducto = Optional.of(productos.get(nomProducto));
		
		return optProducto;
	}
	

		
}
