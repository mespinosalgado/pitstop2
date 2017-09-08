package cl.pitstop.pojos;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Cliente implements Serializable {

	private Integer id;
	private String direcciones;
	private String rut;
	private String rutFormat;
	private String nombre;
	private String apellidos;
	private Integer telefono;
	private Integer celular;
	private String correo;
	
	public Cliente() {
		super();
	}

	public Cliente(Integer id, String direcciones, String rut, String nombre,
			String apellidos, Integer telefono, Integer celular, String correo) {
		super();
		this.id = id;
		this.direcciones = direcciones;
		this.rut = rut;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.celular = celular;
		this.correo = correo;
	}
	
	public Cliente(String direcciones, String rut, String nombre,
			String apellidos, Integer telefono, Integer celular, String correo) {
		super();
		this.direcciones = direcciones;
		this.rut = rut;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.celular = celular;
		this.correo = correo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDirecciones() {
		return direcciones;
	}

	public void setDirecciones(String direcciones) {
		this.direcciones = direcciones;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Integer getTelefono() {
		return telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	public Integer getCelular() {
		return celular;
	}

	public void setCelular(Integer celular) {
		this.celular = celular;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", direcciones=" + direcciones + ", rut="
				+ rut + ", nombre=" + nombre + ", apellidos=" + apellidos
				+ ", telefono=" + telefono + ", celular=" + celular
				+ ", correo=" + correo + "]";
	}

	public String getRutFormat() {
		return rutFormat;
	}

	public void setRutFormat(String rutFormat) {
		this.rutFormat = rutFormat;
	}
	
	
	
}
