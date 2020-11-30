package com.uacm.dTamarindo.servicios.imp;

import java.util.List;
import java.util.Optional;

import com.uacm.dTamarindo.exceps.ExcepcionProducto;
import com.uacm.dTamarindo.modelo.Inventario;
import com.uacm.dTamarindo.modelo.Pedido;
import com.uacm.dTamarindo.modelo.Producto;
import com.uacm.dTamarindo.modelo.Usuario;
import com.uacm.dTamarindo.servicios.PedidoServicios;
import com.uacm.dTamarindo.servicios.UsuarioServicios;

public class PedidoServiciosImp implements PedidoServicios, UsuarioServicios{
	
	private List<Pedido> pedidos;
	
	public boolean altaPedido(List <Producto> producto, Usuario usuario) {
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
	
	public boolean registraPedido(List<Producto> producto, 
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
	
	
	
	
}
