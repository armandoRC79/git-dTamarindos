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
public class InventarioGeneral {
	 
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "invoice")
	private static HashMap<String, Producto> productos = new HashMap<String, Producto>();

	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "invoice")
	private static HashMap<String, Pedido> pedidos = new HashMap<String, Pedido>();

	public Long getId() {
		return id;
	}
	
	public boolean altaProducto(Producto producto) {
		boolean exito = false;
		if(producto != null) {
			productos.put(producto.getNombre(), producto);
			exito = true;
		}
		return exito;
	}
	
	public boolean bajaProducto(Producto producto) {
		boolean exito = false;
		
		if(producto != null)
			exito = productos.remove(producto.getNombre(), producto);
		
		return exito;
	}
	
	public boolean modificaProducto(Producto producto) {
		boolean exito = false;
		if(producto != null) {
			productos.put(producto.getNombre(), producto);
			exito = true;
		}
		return exito;
	}
	
	public Optional<Producto> buscaProducto(String nomProducto){
		Optional<Producto> optProducto = Optional.empty();
		
		if(productos.get(nomProducto) != null)
			optProducto = Optional.of(productos.get(nomProducto));
		
		return optProducto;
	}
	
	public boolean altaPedido(Pedido pedido) {
		boolean exito = false;
		if(pedido != null) {
			pedidos.put(pedido.getId().toString(), pedido);
			exito = true;
		}
		return exito;
	}
	
	public boolean bajaPedido(Pedido pedido) {
		boolean exito = false;
		
		if(pedido != null)
			exito = pedidos.remove(pedido.getId().toString(), pedido);
		
		return exito;
	}
	
	public boolean modificaPedido(Pedido pedido) {
		boolean exito = false;
		if(pedido != null) {
			pedidos.put(pedido.getId().toString(), pedido);
			exito = true;
		}
		return exito;
	}

	public Optional<Pedido> buscaPedido(String idPedido){
		Optional<Pedido> optPedido = Optional.empty();
		
		if(productos.get(idPedido) != null)
			optPedido = Optional.of(pedidos.get(idPedido));
		
		return optPedido;
	}
		
}
