package cl.pitstop.pojos;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Empleado implements Serializable {
	
	private Integer id; 
	private String rutFormat;
	private String rut; 
	private Sucursal sucursal;
	private String cargo;
	private String nombre;
	private String apellidos;
	private String direccion;
	private Integer celular;
	private String jornada;
	private Integer telefonoEmergencia;
	private String correo;
	private Boolean estado;
	private Usuario usuario;
	
	public Empleado() {
		super();
    }
	
	public Empleado(Integer id, String rut, Sucursal sucursal, String cargo,
			String nombre, String apellidos, String direccion, Integer celular,
			String jornada, Integer telefonoEmergencia, String correo, boolean estado) {
		super();
		this.id = id;
		this.rut = rut;
		this.sucursal = sucursal;
		this.cargo = cargo;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.celular = celular;
		this.jornada = jornada;
		this.telefonoEmergencia = telefonoEmergencia;
		this.correo = correo;
		this.estado = estado;
	}

	public Empleado(String rut, Sucursal sucursal, String cargo,
			String nombre1, String apellidos, String direccion, Integer celular,
			String jornada, Integer telefonoEmergencia, String correo, boolean estado) {
		super();
		this.rut = rut;
		this.sucursal = sucursal;
		this.cargo = cargo;
		this.nombre = nombre1;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.celular = celular;
		this.jornada = jornada;
		this.telefonoEmergencia = telefonoEmergencia;
		this.correo = correo;
		this.estado = estado;
	}

	public boolean estadoEmpleado(String estado){
		String bloqueado = null;
		if( estado == bloqueado)
		return true;
		else{
		return false;
		}
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRut() {
		return rut;
	}
	public void setRut(String rut) {
		this.rut = rut;
	}
	public Sucursal getSucursal() {
		return sucursal;
	}
	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
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
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Integer getCelular() {
		return celular;
	}
	public void setCelular(Integer celular) {
		this.celular = celular;
	}
	public String getJornada() {
		return jornada;
	}
	public void setJornada(String jornada) {
		this.jornada = jornada;
	}

	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Integer getTelefonoEmergencia() {
		return telefonoEmergencia;
	}

	public void setTelefonoEmergencia(Integer telefonoEmergencia) {
		this.telefonoEmergencia = telefonoEmergencia;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public String getRutFormat() {
		return rutFormat;
	}

	public void setRutFormat(String rutFormat) {
		this.rutFormat = rutFormat;
	}
	
}
