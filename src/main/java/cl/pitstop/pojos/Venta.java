package cl.pitstop.pojos;

import java.io.Serializable;
import java.util.List;


@SuppressWarnings("serial")
public class Venta implements Serializable{
	
	private Integer id;
	private Cliente cliente;
	private String fecha;
	private Integer valor;
	private String observacion;
	private String tipoPago;
	private String tipo;
	private List<VentaProducto> ventaProducto;
	private List<VentaServicio> ventaServicio;
	
	public Venta() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getTipoPago() {
		return tipoPago;
	}

	public void setTipoPago(String tipoPago) {
		this.tipoPago = tipoPago;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Venta [id=" + id  + ", cliente="
				+ cliente + ", fecha=" + fecha + ", valor=" + valor
				+ ", observacion=" + observacion + ", tipoPago=" + tipoPago
				+ "]";
	}

	public List<VentaProducto> getVentaProducto() {
		return ventaProducto;
	}

	public void setVentaProducto(List<VentaProducto> ventaProducto) {
		this.ventaProducto = ventaProducto;
	}

	public List<VentaServicio> getVentaServicio() {
		return ventaServicio;
	}

	public void setVentaServicio(List<VentaServicio> ventaServicio) {
		this.ventaServicio = ventaServicio;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
