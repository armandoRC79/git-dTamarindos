package com.uacm.dTamarindo.modelo;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
	private Date fecha;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "invoice")
	private Producto producto;
	
	@NotNull
	private int piezasPedidas;
	
	@ManyToOne
	private Usuario usuario;
	
	public Pedido(){
		this.fecha = Calendar.getInstance().getTime();
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
	
	public int getPiezasPedidas() {
		return this.piezasPedidas;
	}
	
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public void setPiezasPedidas(int piezasPedidas) {
		this.piezasPedidas = piezasPedidas;
	}
}
