package com.uacm.dTamarindo.modelo;


import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Usuario, Long>{
	//Pedido findByUsuario(String nombre, Long idPedido);
	//List<Pedido> findall(); //Busca todos los pedidos 
}
