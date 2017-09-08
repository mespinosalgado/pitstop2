package cl.pitstop.pojos;

import java.io.Serializable;


@SuppressWarnings("serial")
public class Revision implements Serializable{

	private Integer id;
	private Empleado empleado;
	private Vehiculo vehiculo;
	private String fecha;
	private String observacion;
	private String hora;
	private boolean aprobacion;
	
	
	public Revision() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Revision(Integer id, Empleado empleado, Vehiculo vehiculo,
			String fecha, String observacion, String hora) {
		super();
		this.id = id;
		this.empleado = empleado;
		this.vehiculo = vehiculo;
		this.fecha = fecha;
		this.observacion = observacion;
		this.hora = hora;
	}
	
	public Revision(Empleado empleado, Vehiculo vehiculo,
			String fecha, String observacion, String hora) {
		super();
		this.empleado = empleado;
		this.vehiculo = vehiculo;
		this.fecha = fecha;
		this.observacion = observacion;
		this.hora = hora;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}


	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}


	public String getFecha() {
		return fecha;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
	}


	public String getObservacion() {
		return observacion;
	}


	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}


	public String getHora() {
		return hora;
	}


	public void setHora(String hora) {
		this.hora = hora;
	}


	public boolean getAprobacion() {
		return aprobacion;
	}


	public void setAprobacion(boolean aprobacion) {
		this.aprobacion = aprobacion;
	}


	@Override
	public String toString() {
		return "Revision [id=" + id + ", empleado=" + empleado + ", vehiculo="
				+ vehiculo + ", fecha=" + fecha + ", observacion="
				+ observacion + ", hora=" + hora + ", aprobacion=" + aprobacion
				+ "]";
	}


	public Empleado getEmpleado() {
		return empleado;
	}


	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	
	
	
	
	
	
}
