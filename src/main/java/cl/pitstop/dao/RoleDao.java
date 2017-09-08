package cl.pitstop.dao;

import java.util.List;

import cl.pitstop.pojos.Role;


public interface RoleDao extends GenericDao {
	
	public List<Role> roleAll();

}
