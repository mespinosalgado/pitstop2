package cl.pitstop.hibernateDao;

import java.util.List;


import org.hibernate.criterion.Order;

import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.DetachedCriteria;


import org.hibernate.criterion.Restrictions;

import cl.pitstop.dao.UsuarioDao;
import cl.pitstop.pojos.Usuario;

public class UsuarioHibernateDao extends AbstractDao implements UsuarioDao {
	
	public UsuarioHibernateDao(){
		super(Usuario.class);
	}
	
	private static Order _order = Order.asc("userName");
	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> buscarAll(){
		return (List<Usuario>) super.findAll(UsuarioHibernateDao._order);
	}

	
	@Override
	@SuppressWarnings("deprecation")
	public void crearUsuario(Usuario usuario) {
		super.insert(usuario);
	}
	
	@Override
	public Usuario buscarPorUserPass(String username, String password) {
		DetachedCriteria criteria = DetachedCriteria.forClass(this.getEntityClass(), "usuario");
		criteria.add(Restrictions.eq("usuario.userName", username.toLowerCase()).ignoreCase())
				.add(Restrictions.eq("usuario.password", password))
				.createCriteria("usuario.role", CriteriaSpecification.LEFT_JOIN)
				.createCriteria("usuario.empleado", CriteriaSpecification.LEFT_JOIN);
		return (Usuario) this.findByCriteria(criteria);
	}


	@Override
	public Usuario buscarPorEmpleado(Integer empleadoId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(this.getEntityClass(), "usuario");
		criteria.createCriteria("usuario.empleado", CriteriaSpecification.LEFT_JOIN)
				.createCriteria("usuario.role", CriteriaSpecification.LEFT_JOIN)
				.add(Restrictions.eq("usuario.empleado.id", empleadoId));
		return (Usuario) this.findByCriteria(criteria);
	}
}
