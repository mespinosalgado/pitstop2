package cl.pitstop.pojos;

import java.io.Serializable;

@SuppressWarnings("serial")
public class VentaServicio implements Serializable{
	
	private Integer id;
	private Venta venta;
	private Servicio servicio;
	private Integer cantidad;
	
	public VentaServicio() {
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

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
}
