package com.uacm.dTamarindo.modelo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Usuario, Long> {
	Producto BuscaPorNombre(String nombre);
	List<Producto> BuscaTodos();
}
