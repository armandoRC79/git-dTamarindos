package com.uacm.dTamarindo.modelo;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import lombok.Data;

@Entity
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private Date fecha;
	private Producto producto;
	private Usuario usuario;
	
	public Pedido(){
		super();
		this.setFecha(Calendar.getInstance().getTime());
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
	
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
