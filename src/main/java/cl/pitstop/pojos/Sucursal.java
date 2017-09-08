package cl.pitstop.pojos;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Sucursal implements Serializable{
	
	private Integer id;
	private String direccion;
	private String nombreSucursal;
	
	
	public Sucursal() {
    }
	
	public Sucursal(Integer id, String direccion, String nombreSucursal) {
		super();
		this.id = id;
		this.direccion = direccion;
		this.nombreSucursal = nombreSucursal;
	}

	public Sucursal(String direccion, String nombreSucursal) {
		super();
		this.direccion = direccion;
		this.nombreSucursal = nombreSucursal;
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getNombreSucursal() {
		return nombreSucursal;
	}
	public void setNombreSucursal(String nombreSucursal) {
		this.nombreSucursal = nombreSucursal;
	}
	
	

}
