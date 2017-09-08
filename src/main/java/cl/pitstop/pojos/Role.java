package cl.pitstop.pojos;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Role implements Serializable{
	
	private Integer id;
	private String roleName;
	
	public Role() {
		super();
    }

	public Role(Integer id, String roleName) {
		super();
		this.id = id;
		this.roleName = roleName;
	}
	
	public Role(String roleName) {
		super();
		this.roleName = roleName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	
	
}
