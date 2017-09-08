package cl.pitstop.action;

import cl.pitstop.pojos.Cliente;
import cl.pitstop.pojos.Empleado;
import cl.pitstop.pojos.Revision;
import cl.pitstop.pojos.Usuario;
import cl.pitstop.pojos.Vehiculo;
import cl.pitstop.dao.ClienteDao;
import cl.pitstop.dao.EmpleadoDao;
import cl.pitstop.dao.RevisionDao;
import cl.pitstop.dao.UsuarioDao;
import cl.pitstop.dao.VehiculoDao;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

@SuppressWarnings("serial")
public class ClienteAction extends BaseAction {
	
    Logger log = org.apache.log4j.Logger.getLogger(ClienteAction.class);
    
	private Cliente cliente;
	private ClienteDao clienteDao;
	private VehiculoDao vehiculoDao;
	private RevisionDao revisionDao;
	private EmpleadoDao empleadoDao;
	private UsuarioDao usuarioDao;
	private List<Cliente> clientes;
	
	private Integer clienteId;
	private String direcciones;
	private String rut;
	private String nombre;
	private String apellidos;
	private Integer telefono;
	private Integer celular;
	private String correo;
	private Integer id;
	
	private String mensaje;
	private String result;
	
	private String patente;
	private String marca;
	private String modelo;
	private Integer ano;
	private Integer kilometraje;
	private Integer mecanicoId;
	private Integer vehiculoId;
	private String fecha;
	private String observacion;
	private String hora;
	private Boolean aprobacion;
	
	private String simpleErrors = StringUtils.EMPTY;
	
	public String ingresos(){
		try{
			List<Cliente> clientes = (List<Cliente>) this.clienteDao.findAll();
			List<Cliente> clientesFinal = new ArrayList<Cliente>();
			if(clientes != null){
				for(Cliente e: clientes){
					e.setRutFormat(e.getRut().replace("-", "").replace(".", ""));
					clientesFinal.add(e);
				}
			}
			
			List<Vehiculo> vehiculos = this.vehiculoDao.vehiculoAll();
			List<Vehiculo> vehiculosFinal = new ArrayList<Vehiculo>();
			if(clientes != null){
				for(Vehiculo e: vehiculos){
					e.setPatenteFormat(e.getPatente().replace("-", "").replace(".", ""));
					vehiculosFinal.add(e);
				}
			}
			
			List<Revision> revisiones = (List<Revision>) this.revisionDao.findAll();
			List<Revision> revisionesFinal = new ArrayList<Revision>();
			if(revisiones != null){
				for(Revision r : revisiones){
					r.setVehiculo((Vehiculo)this.vehiculoDao.findById(r.getVehiculo().getId()));
					r.getVehiculo().setCliente((Cliente)clienteDao.findById(r.getVehiculo().getCliente().getId()));
					r.setEmpleado((Empleado)this.empleadoDao.findById(r.getEmpleado().getId()));
					revisionesFinal.add(r);
				}
			}
			
			List<Usuario> usuarios = this.usuarioDao.buscarAll();
			List<Empleado> empleados = new ArrayList<Empleado>();
			for(Usuario u : usuarios){
				if(u.getRole().getId() == 2){
					empleados.add((Empleado)this.empleadoDao.findById(u.getEmpleado().getId()));
				}
			}
			
			this.getRequest().getSession().setAttribute("mecanicos", empleados);
			this.getRequest().getSession().setAttribute("clientes", clientesFinal);
			this.getRequest().getSession().setAttribute("vehiculos", vehiculosFinal);
			this.getRequest().getSession().setAttribute("revisiones", revisionesFinal);
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
        return SUCCESS;
	}
	
	
	public String crearCliente(){
        try{
			Cliente clientes = new Cliente();
			clientes.setRut(this.rut);
			clientes.setNombre(this.nombre);
			clientes.setApellidos(this.apellidos);
			clientes.setDirecciones(this.direcciones);
			clientes.setTelefono(this.telefono);
			clientes.setCelular(this.celular);
			clientes.setCorreo(this.correo);
			this.clienteDao.insert(clientes);
	        
				
		}catch(Exception e){
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String editarCliente(){
        try{
			Cliente clientes = clienteDao.findById(id);
			clientes.setNombre(this.nombre);
			clientes.setApellidos(this.apellidos);
			clientes.setDirecciones(this.direcciones);
			clientes.setTelefono(this.telefono);
			clientes.setCelular(this.celular);
			clientes.setCorreo(this.correo);
			this.clienteDao.update(clientes);
	        
				
		}catch(Exception e){
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String buscarClientePorRut(){
		try{
			Cliente clientes = clienteDao.buscarClientePorRut(this.rut);
			if(clientes != null){
				StringBuffer buffer = new StringBuffer();
				buffer.append("OK");
				simpleErrors = buffer.toString();
			}
	    }catch(Exception e){
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String buscarVehiculoPorPatente(){
		try{
			Vehiculo vehiculo = vehiculoDao.buscarVehiculoPorPatente(this.patente);
			if(vehiculo != null){
				StringBuffer buffer = new StringBuffer();
				buffer.append("OK");
				simpleErrors = buffer.toString();
			}
	    }catch(Exception e){
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String crearVehiculo(){
        try{
			Cliente clientes = clienteDao.buscarClientePorRut(rut);
			Vehiculo vehiculo = new Vehiculo();
			vehiculo.setCliente(clientes);
			vehiculo.setAno(this.ano);
			vehiculo.setKilometraje(this.kilometraje);
			vehiculo.setMarca(this.marca);
			vehiculo.setModelo(this.modelo);
			vehiculo.setPatente(this.patente);
			this.vehiculoDao.insert(vehiculo);
	        
				
		}catch(Exception e){
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String editarVehiculo(){
        try{
			Vehiculo vehiculo = vehiculoDao.findById(id);
			vehiculo.setAno(this.ano);
			vehiculo.setKilometraje(this.kilometraje);
			vehiculo.setMarca(this.marca);
			vehiculo.setModelo(this.modelo);
			this.vehiculoDao.update(vehiculo);
	    }catch(Exception e){
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String crearRevision(){
        try{
			Revision revision = new Revision();
			revision.setAprobacion(false);
			revision.setFecha(fecha);
			revision.setHora(hora);
			revision.setObservacion(observacion);
			revision.setEmpleado((Empleado)this.empleadoDao.findById(this.mecanicoId));
			revision.setVehiculo(this.vehiculoDao.buscarVehiculoPorPatente(patente));
			this.revisionDao.insert(revision);
	     
        }catch(Exception e){
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String editarRevision(){
		try{
			Revision revision = this.revisionDao.findById(this.id);
			revision.setAprobacion(this.aprobacion);
			revision.setFecha(this.fecha);
			revision.setHora(this.hora);
			revision.setObservacion(this.observacion);
			revision.setEmpleado((Empleado)this.empleadoDao.findById(this.mecanicoId));
			this.revisionDao.update(revision);
	     
        }catch(Exception e){
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String cargaEditar(){
	this.cliente = this.clienteDao.findById(this.clienteId);
	return SUCCESS;
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

	public Integer getClienteId() {
		return clienteId;
	}

	public void setClienteId(Integer clienteId) {
		this.clienteId = clienteId;
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSimpleErrors() {
		return simpleErrors;
	}

	public void setSimpleErrors(String simpleErrors) {
		this.simpleErrors = simpleErrors;
	}

	public VehiculoDao getVehiculoDao() {
		return vehiculoDao;
	}

	public void setVehiculoDao(VehiculoDao vehiculoDao) {
		this.vehiculoDao = vehiculoDao;
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

	public RevisionDao getRevisionDao() {
		return revisionDao;
	}

	public void setRevisionDao(RevisionDao revisionDao) {
		this.revisionDao = revisionDao;
	}

	public EmpleadoDao getEmpleadoDao() {
		return empleadoDao;
	}

	public void setEmpleadoDao(EmpleadoDao empleadoDao) {
		this.empleadoDao = empleadoDao;
	}

	public UsuarioDao getUsuarioDao() {
		return usuarioDao;
	}

	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}

	public Integer getMecanicoId() {
		return mecanicoId;
	}

	public void setMecanicoId(Integer mecanicoId) {
		this.mecanicoId = mecanicoId;
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

	public Integer getVehiculoId() {
		return vehiculoId;
	}

	public void setVehiculoId(Integer vehiculoId) {
		this.vehiculoId = vehiculoId;
	}

	public Boolean getAprobacion() {
		return aprobacion;
	}

	public void setAprobacion(Boolean aprobacion) {
		this.aprobacion = aprobacion;
	}
	

}
