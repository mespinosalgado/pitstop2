package cl.pitstop.pojos;

import java.io.Serializable;



@SuppressWarnings("serial")
public class Vehiculo implements Serializable {
	
	private Integer id;
	private Cliente cliente;
	private String patente;
	private String patenteFormat;
	private String marca;
	private String modelo;
	private Integer ano;
	private Integer kilometraje;
	
	public Vehiculo() {
		super();
	}

	public Vehiculo(Integer id, Cliente cliente, String patente, String marca,
			String modelo, Integer ano, Integer kilometraje) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.patente = patente;
		this.marca = marca;
		this.modelo = modelo;
		this.ano = ano;
		this.kilometraje = kilometraje;
	}
	
	public Vehiculo(Cliente cliente, String patente, String marca,
			String modelo, Integer ano, Integer kilometraje) {
		super();
		this.cliente = cliente;
		this.patente = patente;
		this.marca = marca;
		this.modelo = modelo;
		this.ano = ano;
		this.kilometraje = kilometraje;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public Integer getKilometraje() {
		return kilometraje;
	}

	public void setKilometraje(Integer kilometraje) {
		this.kilometraje = kilometraje;
	}

	@Override
	public String toString() {
		return "Vehiculo [id=" + id + ", cliente=" + cliente + ", patente="
				+ patente + ", marca=" + marca + ", modelo=" + modelo
				+ ", ano=" + ano + ", kilometraje=" + kilometraje + "]";
	}

	public String getPatenteFormat() {
		return patenteFormat;
	}

	public void setPatenteFormat(String patenteFormat) {
		this.patenteFormat = patenteFormat;
	}

	
	
}
