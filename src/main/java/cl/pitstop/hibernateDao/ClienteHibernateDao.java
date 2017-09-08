package cl.pitstop.hibernateDao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import cl.pitstop.dao.ClienteDao;
import cl.pitstop.pojos.Cliente;


public class ClienteHibernateDao extends AbstractDao implements ClienteDao {
	
	public ClienteHibernateDao(){
		super(Cliente.class);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Cliente> clienteAll(){
		return (List<Cliente>) super.findAll();
	}
		
	@SuppressWarnings("deprecation")
	public void updCliente(Cliente cliente){
		super.update(cliente);
	}
	
	@Override
	public Cliente buscarClientePorRut(String rut){
		DetachedCriteria criteria = DetachedCriteria.forClass(this.getEntityClass(), "cliente");
		criteria.add(Restrictions.eq("cliente.rut", rut.toLowerCase()).ignoreCase());
		return (Cliente) this.findByCriteria(criteria);
	}
	
	
	public void delCliente(Cliente cliente){
		super.delete(cliente);
	}


	@Override
	@SuppressWarnings("deprecation")
	public void crearCliente(Cliente cliente) {
		super.insert(cliente);
	}

}
