package cl.pitstop.pojos;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Servicio implements Serializable {
	
	private Integer id;
	private String nombreServicio;
	private Integer valorServicio;
	
	
	public Servicio() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Servicio(Integer id, String nombreServicio, Integer valorServicio) {
		super();
		this.id = id;
		this.nombreServicio = nombreServicio;
		this.valorServicio = valorServicio;
	}
	
	public Servicio(String nombreServicio, Integer valorServicio) {
		super();
		this.nombreServicio = nombreServicio;
		this.valorServicio = valorServicio;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNombreServicio() {
		return nombreServicio;
	}


	public void setNombreServicio(String nombreServicio) {
		this.nombreServicio = nombreServicio;
	}


	public Integer getValorServicio() {
		return valorServicio;
	}


	public void setValorServicio(Integer valorServicio) {
		this.valorServicio = valorServicio;
	}



	
}
