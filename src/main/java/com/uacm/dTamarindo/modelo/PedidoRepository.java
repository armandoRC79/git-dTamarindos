package com.uacm.dTamarindo.modelo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Usuario, Long>{
	Pedido buscaPorUsuario(String nombre, Long idPedido);
}
