package com.uacm.dTamarindo.modelo;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.uacm.dTamarindo.exceps.ExcepcionProducto;

import lombok.Data;

@Entity
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
	private Date fecha;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "invoice")
	private Producto producto;
	
	@NotNull
	private int piezasPedidas;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "invoice")
	private static HashMap<String, Pedido> pedidos = new HashMap<String, Pedido>();
	
	@ManyToOne
	private Usuario usuario;
	
	public Pedido(){
		this.fecha = Calendar.getInstance().getTime();
	}
	
	public Date getDate() {
		return fecha;
	}
	
	public Producto getProducto(){
		return producto;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public int getPiezasPedidas() {
		return this.piezasPedidas;
	}
	
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public void setPiezasPedidas(int piezasPedidas) {
		this.piezasPedidas = piezasPedidas;
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
		
		if(pedidos.get(idPedido) != null)
			optPedido = Optional.of(pedidos.get(idPedido));
		
		return optPedido;
	}
	
	public boolean registraPedido(Producto producto, 
			Usuario usuario, int piezas){
		
		boolean exito = false;
		
		try {
			Pedido pedido = new Pedido();
			pedido.setProducto(producto);
			pedido.setUsuario(usuario);
			pedido.setPiezasPedidas(piezas);
			
			producto.disminuyePiezas(piezas);
			
			altaPedido(pedido);
			Inventario.modificaProducto(producto);
			
			exito = true;
		} catch (ExcepcionProducto e) {
			e.printStackTrace();
		}
		
		return exito;
	}
	
	
	public boolean cancelarPedido(String idPedido) {
		boolean exito = false;
		Pedido pedido = new Pedido();
		Producto producto;
		
		if(buscaPedido(idPedido).isPresent()) {
			pedido = buscaPedido(idPedido).get();
			
			try {
				producto = new Producto();
				producto = Inventario.buscaProducto(pedido.getProducto().getNombre()).get();
				producto.aumentaPiezas(pedido.getPiezasPedidas());
				
				Inventario.modificaProducto(producto);
				bajaPedido(pedido);
				
				exito = true;
				
			} catch (ExcepcionProducto e) {
				
				e.printStackTrace();
				
			}
		}
		
		return exito;
	}
}
