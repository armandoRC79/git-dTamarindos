package com.uacm.dTamarindo.modelo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface InventarioRepository extends JpaRepository<Usuario, Long>{
	List<Producto> buscaProductos();
	List<Pedido> buscaPedidos();
}
