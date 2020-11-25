package com.uacm.dTamarindo.modelo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Usuario, Long>{
	Pedido buscaPorUsuario(String nombre, Long idPedido);
	List<Pedido> buscaPorUsuario(String nombre, String rol);
	List<Pedido> buscaTodos(String nombre);
}
