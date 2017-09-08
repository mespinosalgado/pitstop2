package cl.pitstop.pojos;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Usuario implements Serializable{
	
	private Integer id;
	private Role role;
	private Empleado empleado;
	private String userName;
	private String password;
	
	public Usuario() {
    }

	public Usuario(Integer id, Role role, Empleado empleado, String userName,
			String password) {
		super();
		this.id = id;
		this.role = role;
		this.empleado = empleado;
		this.userName = userName;
		this.password = password;
	}
	
	public Usuario(Empleado empleado, Role role, String userName,
			String password) {
		super();
		this.empleado = empleado;
		this.role = role;
		this.userName = userName;
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	
	

}
