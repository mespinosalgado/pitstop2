package cl.pitstop.action;

import cl.pitstop.pojos.Cliente;

import cl.pitstop.pojos.Vehiculo;
import cl.pitstop.dao.ClienteDao;
import cl.pitstop.dao.VehiculoDao;
	

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

	@SuppressWarnings("serial")
	public class VehiculoAction extends BaseAction {
		
	        Logger log = org.apache.log4j.Logger.getLogger(VehiculoAction.class);
	    
		private Cliente cliente;
		private ClienteDao clienteDao;
		private List<Cliente> clientes;
		private Vehiculo vehiculo;
		private VehiculoDao vehiculoDao;
		private List<Vehiculo> vehiculos;
		
		private Integer clienteId;
		private Integer vehiculoId;
		private String patente;
		private String marca;
		private String modelo;
		private Integer kilometraje;
		private Integer ano;
		
		private String mensaje;
		private String result;
		
		@Override
		public String execute(){
			return SUCCESS;
		}
		
		public String VehiculoMenu(){
	                HttpServletRequest request = ServletActionContext.getRequest();                
	                log.info("vehiculo session" + request.getSession().getAttribute("vehiculo"));
	                return SUCCESS;
		}
		
		public String listVehiculo(){
			List<Vehiculo> vehiculos = this.vehiculoDao.vehiculoAll();
			log.info("vehiculo:"+vehiculos);
			this.getRequest().getSession().setAttribute("vehiculo", vehiculos);
			return SUCCESS;
		}
		
		public String crearVehiculo(){
	            HttpServletRequest request = ServletActionContext.getRequest();
	            
	            log.debug("Inicio de crearVehiculo");
	            
	            log.info("Inicio de crearCliente");
		try{
			Vehiculo vehiculos = new Vehiculo();
			/*Cliente cliente = this.clienteDao.findById(this.clienteId);
			System.out.println(cliente);*/
			
			Cliente clienteSession = (Cliente) request.getSession().getAttribute("cliente");
			log.info("clienteSession:" + clienteSession);
			vehiculos.setPatente(this.patente);
			vehiculos.setMarca(this.marca);
			vehiculos.setModelo(this.modelo);
			vehiculos.setKilometraje(this.kilometraje);	
			vehiculos.setAno(ano);
			vehiculos.setCliente(clienteSession);
			log.info("Before Saved - vehiculos:" + vehiculos);
			this.vehiculoDao.insert(vehiculos);
	                
			result = "ok";
				
		}catch(Exception e){
			e.printStackTrace();
		}
		return SUCCESS;
		}

		public String cargaEditar(){
		this.vehiculo = this.vehiculoDao.findById(this.vehiculoId);
		return SUCCESS;
		}

		public Logger getLog() {
			return log;
		}

		public void setLog(Logger log) {
			this.log = log;
		}

		public Cliente getCliente() {
			return cliente;
		}

		public void setCliente(Cliente cliente) {
			this.cliente = cliente;
		}

		public ClienteDao getClienteDao() {
			return clienteDao;
		}

		public void setClienteDao(ClienteDao clienteDao) {
			this.clienteDao = clienteDao;
		}

		public List<Cliente> getClientes() {
			return clientes;
		}

		public void setClientes(List<Cliente> clientes) {
			this.clientes = clientes;
		}

		public Vehiculo getVehiculo() {
			return vehiculo;
		}

		public void setVehiculo(Vehiculo vehiculo) {
			this.vehiculo = vehiculo;
		}

		public VehiculoDao getVehiculoDao() {
			return vehiculoDao;
		}

		public void setVehiculoDao(VehiculoDao vehiculoDao) {
			this.vehiculoDao = vehiculoDao;
		}

		public List<Vehiculo> getVehiculos() {
			return vehiculos;
		}

		public void setVehiculos(List<Vehiculo> vehiculos) {
			this.vehiculos = vehiculos;
		}

		public Integer getClienteId() {
			return clienteId;
		}

		public void setClienteId(Integer clienteId) {
			this.clienteId = clienteId;
		}

		public Integer getVehiculoId() {
			return vehiculoId;
		}

		public void setVehiculoId(Integer vehiculoId) {
			this.vehiculoId = vehiculoId;
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

		public Integer getKilometraje() {
			return kilometraje;
		}

		public void setKilometraje(Integer kilometraje) {
			this.kilometraje = kilometraje;
		}

		public Integer getAno() {
			return ano;
		}

		public void setAno(Integer ano) {
			this.ano = ano;
		}

		public String getMensaje() {
			return mensaje;
		}

		public void setMensaje(String mensaje) {
			this.mensaje = mensaje;
		}

		public String getResult() {
			return result;
		}

		public void setResult(String result) {
			this.result = result;
		}
		

}
