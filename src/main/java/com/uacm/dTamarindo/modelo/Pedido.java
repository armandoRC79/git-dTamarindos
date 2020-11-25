package com.uacm.dTamarindo.modelo;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
	private Date fecha;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "invoice")
	private List<Producto> productos;
	
	@ManyToOne
	private Usuario usuario;
	
	public Pedido(){
		super();
		this.setFecha(Calendar.getInstance().getTime());
	}
	
	public Date getDate() {
		return fecha;
	}
	
	public List<Producto> getProducto(){
		return productos;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setProducto(List<Producto> producto) {
		this.productos = producto;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
