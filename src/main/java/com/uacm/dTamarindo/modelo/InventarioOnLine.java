package com.uacm.dTamarindo.modelo;

import com.uacm.dTamarindo.exceps.ExcepcionProducto;

public class InventarioOnLine extends InventarioGeneral{

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
			modificaProducto(producto);
			
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
				producto = buscaProducto(pedido.getProducto().getNombre()).get();
				producto.aumentaPiezas(pedido.getPiezasPedidas());
				
				modificaProducto(producto);
				bajaPedido(pedido);
				
				exito = true;
				
			} catch (ExcepcionProducto e) {
				
				e.printStackTrace();
				
			}
		}
		
		return exito;
	}
	
	

}
