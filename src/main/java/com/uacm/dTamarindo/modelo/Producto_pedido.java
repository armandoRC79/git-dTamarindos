package com.uacm.dTamarindo.modelo;

import javax.persistence.Id;
import javax.persistence.JoinColumn;

import org.hibernate.annotations.ManyToAny;


public class Producto_pedido {
	@Id
    private Long idProducto;

    @Id
    private Long idPedido;

    private int piezas;

    @ManyToAny
    @JoinColumn(name = "idProducto", referencedColumnName = "id", nullable = false, updatable = false)
    private Producto produto;

    @ManyToAny
    @JoinColumn(name = "idPedido", referencedColumnName = "id", nullable = false, updatable = false)
    private Pedido pedido;

    public Producto_pedido() {

    }
    
    public Producto_pedido(Long idProducto, Long idPedido, int piezas) {
        this.idProducto = idProducto;
        this.idPedido = idPedido;
        this.piezas = piezas;
    }

	public Long getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}

	public Long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}

	public int getPiezas() {
		return piezas;
	}

	public void setPiezas(int piezas) {
		this.piezas = piezas;
	}

	public Producto getProduto() {
		return produto;
	}

	public void setProduto(Producto produto) {
		this.produto = produto;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}


}
