package com.uacm.dTamarindo.modelo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	public boolean validarUsuario();

}
