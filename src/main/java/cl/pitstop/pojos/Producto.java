package cl.pitstop.pojos;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Producto implements Serializable {
	
	private Integer id; 
	private Proveedor proveedor;
	private Sucursal sucursal;
	private String codigo;
	private String descripcion;
	private String tipoProd;
	private Integer valor;
	private Integer stock;
	
	public Producto() {
		super();
    }
	
	public Producto(Integer id, Proveedor proveedor, Sucursal sucursal,
			String codigo, String descripcion, String tipoProd,
			Integer valor, Integer stock) {
		super();
		this.id = id;
		this.proveedor = proveedor;
		this.sucursal = sucursal;
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.tipoProd = tipoProd;
		this.valor = valor;
		this.stock = stock;
	}
	
	public Producto(Proveedor proveedor, Sucursal sucursal,
			String codigo, String descripcion, String tipoProd,
			Integer valor, Integer stock) {
		super();
		this.proveedor = proveedor;
		this.sucursal = sucursal;
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.tipoProd = tipoProd;
		this.valor = valor;
		this.stock = stock;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public Sucursal getSucursal() {
		return sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String gettipoProd() {
		return tipoProd;
	}

	public void settipoProd(String tipoProd) {
		this.tipoProd = tipoProd;
	}

	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public String getTipoProd() {
		return tipoProd;
	}

	public void setTipoProd(String tipoProd) {
		this.tipoProd = tipoProd;
	}
	
	
	
	
	

}
