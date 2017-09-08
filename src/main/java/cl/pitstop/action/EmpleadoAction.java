package cl.pitstop.action;

import java.util.ArrayList;
import java.util.List;

import cl.pitstop.dao.EmpleadoDao;
import cl.pitstop.dao.RoleDao;
import cl.pitstop.dao.SucursalDao;
import cl.pitstop.dao.UsuarioDao;
import cl.pitstop.pojos.Empleado;
import cl.pitstop.pojos.Role;
import cl.pitstop.pojos.Sucursal;
import cl.pitstop.pojos.Usuario;

@SuppressWarnings("serial")
public class EmpleadoAction extends BaseAction {

	private EmpleadoDao empleadoDao;
	private SucursalDao sucursalDao;
	private UsuarioDao usuarioDao;
	private RoleDao roleDao;
	private Empleado empleado;
	private Usuario usuario;
	private Role role;
	private List<Empleado> empleados;
	private List<Sucursal> sucursales;
	private List<Role> roles;
	
	private Integer sucursalId; 
	private Integer empleadoId; 
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
	private boolean estado;
	private Integer rolId;
	private String userName;
	private Integer usuarioId;
	
	private String mensaje;
	private String result;
	
		
	public String listEmpleado(){
		try{
			List<Empleado> empleados = this.empleadoDao.empleadoAll();
			List<Sucursal> sucursales = this.sucursalDao.sucursalAll();
			List<Role> roles = this.roleDao.roleAll();
			List<Empleado> empleadosUsuarios = new ArrayList<Empleado>();
			if(empleados != null){
				for(Empleado e: empleados){
					e.setUsuario(this.usuarioDao.buscarPorEmpleado(e.getId()));
					e.setRutFormat(e.getRut().replace("-", "").replace(".", ""));
					empleadosUsuarios.add(e);
				}
			}
			this.getRequest().getSession().setAttribute("empleados", empleadosUsuarios);
			this.getRequest().getSession().setAttribute("sucursales", sucursales);
			this.getRequest().getSession().setAttribute("roles", roles);
		}catch(Exception e){
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	@Override
	public String execute(){
		return SUCCESS;
	}
	
	
	public String crearEmpleado(){
		try{
			Empleado empleados = new Empleado();
			
			Sucursal sucursal = this.sucursalDao.findById(this.sucursalId);
			empleados.setRut(this.rut);
			empleados.setNombre(this.nombre);
			empleados.setApellidos(this.apellidos);
			empleados.setDireccion(this.direccion);
			empleados.setSucursal(sucursal);
			empleados.setCargo(this.cargo);
			empleados.setJornada(this.jornada);
			empleados.setCelular(this.celular);
			empleados.setCorreo(this.correo);
			empleados.setEstado(true);
			
			this.empleadoDao.insert(empleados);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String cargaEditar(){
		this.empleado = this.empleadoDao.findById(this.empleadoId);
		return SUCCESS;
	}
	
	public String updEmpleado(){
		try{
			Empleado empleados = this.empleadoDao.findById(this.empleadoId);
			Sucursal sucursal = this.sucursalDao.findById(this.sucursalId);
			empleados.setRut(this.rut);
			empleados.setNombre(this.nombre);
			empleados.setApellidos(this.apellidos);
			empleados.setDireccion(this.direccion);
			empleados.setSucursal(sucursal);
			empleados.setCargo(this.cargo);
			empleados.setJornada(this.jornada);
			empleados.setCelular(this.celular);
			empleados.setCorreo(this.correo);
			empleados.setEstado(empleados.getEstado());
			this.empleadoDao.update(empleados);

			this.setMensaje("¡Usuario grabado con &eacutexito!");
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		return SUCCESS;
	}
	
	public String bloqueaEmpleado(){
		this.empleado = this.empleadoDao.findById(this.empleadoId);
		this.empleado.setEstado(false);
		this.empleadoDao.update(this.empleado);
		return SUCCESS;
	}
	
	public String desbloqueaEmpleado(){
		this.empleado = this.empleadoDao.findById(this.empleadoId);
		this.empleado.setEstado(true);
		this.empleadoDao.update(this.empleado);
		return SUCCESS;
	}
	
	public String delEmpleado(){
		try{
			this.empleado = this.empleadoDao.findById(this.empleadoId);
			this.usuario = this.usuarioDao.buscarPorEmpleado(this.empleadoId);
			if(this.usuario != null){
				this.usuarioDao.delete(this.usuario);
			}
			this.empleadoDao.delete(this.empleado);
		}catch(Exception e){
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String creaUsuario(){
		try{
			Usuario usuario = new Usuario();
			usuario.setEmpleado((Empleado) this.empleadoDao.findById(this.empleadoId));
			usuario.setRole((Role) this.roleDao.findById(this.rolId));
			usuario.setUserName(this.userName);
			usuario.setPassword("newUser2016");
			this.usuarioDao.insert(usuario);
		}catch(Exception e){
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String editarUsuario(){
		try{
			Usuario usuario = this.usuarioDao.findById(this.usuarioId);
			usuario.setRole((Role) this.roleDao.findById(this.rolId));
			usuario.setUserName(this.userName);
			this.usuarioDao.update(usuario);
		}catch(Exception e){
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public EmpleadoDao getEmpleadoDao() {
		return empleadoDao;
	}

	public void setEmpleadoDao(EmpleadoDao empleadoDao) {
		this.empleadoDao = empleadoDao;
	}

	public SucursalDao getSucursalDao() {
		return sucursalDao;
	}


	public void setSucursalDao(SucursalDao sucursalDao) {
		this.sucursalDao = sucursalDao;
	}


	public Integer getSucursalId() {
		return sucursalId;
	}

	public void setSucursalId(Integer sucursalId) {
		this.sucursalId = sucursalId;
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

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}


	public List<Sucursal> getSucursales() {
		return sucursales;
	}


	public void setSucursales(List<Sucursal> sucursales) {
		this.sucursales = sucursales;
	}


	public List<Empleado> getEmpleados() {
		return empleados;
	}


	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}


	public Empleado getEmpleado() {
		return empleado;
	}


	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}


	public Integer getEmpleadoId() {
		return empleadoId;
	}


	public void setEmpleadoId(Integer empleadoId) {
		this.empleadoId = empleadoId;
	}


	public String getResult() {
		return result;
	}


	public void setResult(String result) {
		this.result = result;
	}


	public Integer getTelefonoEmergencia() {
		return telefonoEmergencia;
	}


	public void setTelefonoEmergencia(Integer telefonoEmergencia) {
		this.telefonoEmergencia = telefonoEmergencia;
	}


	public String getMensaje() {
		return mensaje;
	}


	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public UsuarioDao getUsuarioDao() {
		return usuarioDao;
	}

	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}

	public RoleDao getRoleDao() {
		return roleDao;
	}

	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Integer getRolId() {
		return rolId;
	}

	public void setRolId(Integer rolId) {
		this.rolId = rolId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}


}

