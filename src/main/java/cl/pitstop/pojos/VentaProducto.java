package cl.pitstop.pojos;

import java.io.Serializable;

@SuppressWarnings("serial")
public class VentaProducto implements Serializable{
	
	private Integer id;
	private Venta venta;
	private Producto producto;
	private Integer cantidad;
	
	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public VentaProducto() {
		super();
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

}
