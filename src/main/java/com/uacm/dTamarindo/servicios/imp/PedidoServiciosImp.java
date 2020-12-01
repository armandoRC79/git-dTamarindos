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
	
	
	
	public boolean altaPedido(List <Producto> producto, Usuario usuario) {
		return false;
	}
	
	public boolean bajaPedido(Pedido pedido) {
		return false;
	}
	
	public boolean modificaPedido(Pedido pedido) {
		return false;
	}

	public Optional<Pedido> buscaPedido(String idPedido){
		
		return null;
	}
	
	public boolean registraPedido(List<Producto> producto, 
			Usuario usuario, int piezas){
		
		return false;
	}
	
	
	
	
}
