package cl.pitstop.pojos;

import java.io.Serializable;


@SuppressWarnings("serial")
public class Cotizacion implements Serializable {
	
	private Integer id;
	private Revision revision;
	private Servicio servicio;
	private Producto producto;
	private Venta venta;
	private String fecha;
	private boolean aprobacion;
	private String observacion;
	private Integer valor;
	private Integer cantProd;
	private Integer cantServ;
	
	
	
	public Cotizacion() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Cotizacion(Integer id, Revision revision, Servicio servicio, Venta venta,
			Producto producto, String fecha, boolean aprobacion,
			String observacion, Integer valor, Integer cantProd, Integer cantServ) {
		super();
		this.id = id;
		this.revision = revision;
		this.servicio = servicio;
		this.producto = producto;
		this.venta = venta;
		this.fecha = fecha;
		this.aprobacion = aprobacion;
		this.observacion = observacion;
		this.valor = valor;
		this.cantProd = cantProd;
		this.cantServ = cantServ;
	}
	
	public Cotizacion(Revision revision, Servicio servicio, Venta venta,
			Producto producto, String fecha, boolean aprobacion,
			String observacion, Integer valor, Integer cantProd, Integer cantServ) {
		super();
		this.revision = revision;
		this.servicio = servicio;
		this.producto = producto;
		this.venta = venta;
		this.fecha = fecha;
		this.aprobacion = aprobacion;
		this.observacion = observacion;
		this.valor = valor;
		this.cantProd = cantProd;
		this.cantServ = cantServ;
	}

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Revision getRevision() {
		return revision;
	}


	public void setRevision(Revision revision) {
		this.revision = revision;
	}


	public Servicio getServicio() {
		return servicio;
	}


	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}


	public Producto getProducto() {
		return producto;
	}


	public void setProducto(Producto producto) {
		this.producto = producto;
	}


	public String getFecha() {
		return fecha;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
	}


	public boolean isAprobacion() {
		return aprobacion;
	}


	public void setAprobacion(boolean aprovacion) {
		this.aprobacion = aprovacion;
	}


	public String getObservacion() {
		return observacion;
	}


	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}


	public Integer getValor() {
		return valor;
	}


	public void setValor(Integer valor) {
		this.valor = valor;
	}

	public Integer getCantProd() {
		return cantProd;
	}

	public void setCantProd(Integer cantProd) {
		this.cantProd = cantProd;
	}


	public Integer getCantServ() {
		return cantServ;
	}


	public void setCantServ(Integer cantServ) {
		this.cantServ = cantServ;
	}

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

	@Override
	public String toString() {
		return "Cotizacion [id=" + id + ", revision=" + revision
				+ ", servicio=" + servicio + ", producto=" + producto
				+ ", venta=" + venta + ", fecha=" + fecha + ", aprobacion="
				+ aprobacion + ", observacion=" + observacion + ", valor="
				+ valor + ", cantProd=" + cantProd + ", cantServ=" + cantServ
				+ "]";
	}
		

}

