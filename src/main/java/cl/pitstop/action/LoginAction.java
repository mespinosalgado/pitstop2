package cl.pitstop.action;

import cl.pitstop.dao.RoleDao;
import cl.pitstop.dao.UsuarioDao;
import cl.pitstop.dao.EmpleadoDao;
import cl.pitstop.pojos.Role;
import cl.pitstop.pojos.SystemParameter;
import cl.pitstop.pojos.Usuario;
import cl.pitstop.pojos.Empleado;
import java.util.Map;

import java.util.List;

@SuppressWarnings("serial")
public class LoginAction extends BaseAction {

	private RoleDao roleDao;
	private UsuarioDao usuarioDao;
	private EmpleadoDao empleadoDao;
	private Usuario usuario;
	private List<Role> roles;
	private List<Usuario> usuarios;
	private List<Empleado> empleados;

	private Integer roleId;
	private Integer usuarioId;
	private Integer empleadoId;
	private String userName;
	private String password;
	
	private Map<String, Object> session ;
	 
	@Override
	public void setSession(Map<String, Object> session) {
	 
	   this.session = session ;
	 
	}
	
	public LoginAction(){	
	}
	@Override
	public String execute(){
		System.out.println("execute");
		return SUCCESS;
	}

	public RoleDao getRoleDao() {
		return roleDao;
	}

	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	public UsuarioDao getUsuarioDao() {
		return usuarioDao;
	}

	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}

	public EmpleadoDao getEmpleadoDao() {
		return empleadoDao;
	}

	public void setEmpleadoDao(EmpleadoDao empleadoDao) {
		this.empleadoDao = empleadoDao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public List<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}

	public Integer getEmpleadoId() {
		return empleadoId;
	}

	public void setEmpleadoId(Integer empleadoId) {
		this.empleadoId = empleadoId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String login() {
		try{
			if ( userName != null && password != null )
			{
				Usuario user =  usuarioDao.buscarPorUserPass(userName, password);
				if ( user != null )
				{
					Empleado emp = empleadoDao.findById(user.getEmpleado().getId());
					if(emp.getEstado()){
						this.getRequest().getSession().setAttribute("activeRole", user.getRole().getRoleName());
						
						this.getRequest().getSession().setAttribute("userName", user.getUserName());
						
						SystemParameter system = new SystemParameter();
						system.setAllSee(user.getRole().getRoleName());
						
						this.getRequest().getSession().setAttribute("systemParameter", system);
						
						session.put("loginStatus", true);
						return SUCCESS;
					}else{

						this.getRequest().setAttribute("error", "Usuario Inactivo");
					}
				}else{

					this.getRequest().setAttribute("error", "Datos de acceso incorrectos");
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return ERROR;
	}
	
	public String logout() {
	    this.getRequest().getSession().invalidate();
	    return SUCCESS;
	}

}
