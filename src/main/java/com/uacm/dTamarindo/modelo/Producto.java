package com.uacm.dTamarindo.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.uacm.dTamarindo.exceps.ExcepcionProducto;

import lombok.Data;

@Entity
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Producto {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private int piezas;
	

	@NotNull
    @Size(max = 100)
	private String nombre;
	
	@NotNull
    @Size(max = 200)
	private String descripcion;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "producto")
	private List<Producto_pedido> producto;
	
    
    public void setNombre(String nombre) {
    	this.nombre = nombre;
    }
    
    public void setDescripcion(String descripcion) {
    	this.descripcion = descripcion;
    }
    
    public void disminuyePiezas(int piezas) throws ExcepcionProducto {
    	if(piezas <= this.piezas)
    		if(piezas > 0)
    			this.piezas = this.piezas-piezas;
    		else 
    			throw new ExcepcionProducto("Asegurese de que la cantidad no sea negativa");
    	else
    		throw new ExcepcionProducto("El numero de piezas requeridas excede la existencia");
    }
    
    public void aumentaPiezas(int piezas) throws ExcepcionProducto {
    	if(piezas > 0)
    		this.piezas = this.piezas + piezas;
    	else
    		throw new ExcepcionProducto("No se admiten cantidades negativas de piezas");
    }
    
	public Long getId() {
		return id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	private String getDescripcion() {
		return descripcion;
	}
	
	private int getPiezas() {
		return piezas;
	}
}
