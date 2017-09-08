package cl.pitstop.pojos;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Proveedor implements Serializable{
	
	private Integer id;
	private String rutEmpresa;
	private String rutFormat;
	private String nombre;
	private Integer telefono;
	private String correo;
	
	public Proveedor() {
		super();
	}

	public Proveedor(Integer id, String rutEmpresa, String nombre,
			Integer telefono, String correo) {
		super();
		this.id = id;
		this.rutEmpresa = rutEmpresa;
		this.nombre = nombre;
		this.telefono = telefono;
		this.correo = correo;
	}
	
	public Proveedor(String rutEmpresa, String nombre,
			Integer telefono, String correo) {
		super();
		this.rutEmpresa = rutEmpresa;
		this.nombre = nombre;
		this.telefono = telefono;
		this.correo = correo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRutEmpresa() {
		return rutEmpresa;
	}

	public void setRutEmpresa(String rutEmpresa) {
		this.rutEmpresa = rutEmpresa;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getTelefono() {
		return telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getRutFormat() {
		return rutFormat;
	}

	public void setRutFormat(String rutFormat) {
		this.rutFormat = rutFormat;
	}
	
	
	
	
	
	
	
	

}
