package cl.pitstop.hibernateDao;
import java.util.List;

import cl.pitstop.dao.RoleDao;
import cl.pitstop.pojos.Role;


public class RoleHibernateDao extends AbstractDao implements RoleDao {
	
	public RoleHibernateDao(){
		super(Role.class);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Role> roleAll(){
		return (List<Role>) super.findAll();
	}
	
	
	

}
