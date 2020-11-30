package com.uacm.dTamarindo.modelo;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.uacm.dTamarindo.exceps.ExcepcionProducto;

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
    
    
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "pedido")
	private List<Producto_pedido> producto;
	
	
	@ManyToOne
	private Usuario usuario;
	
	public Pedido(){
		this.fecha = Calendar.getInstance().getTime();
	}
	
	public Date getDate() {
		return fecha;
	}
	
	public List<Producto_pedido> getProducto(){
		return producto;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	
	public void setProducto(List<Producto_pedido> producto) {
		this.producto = producto;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}