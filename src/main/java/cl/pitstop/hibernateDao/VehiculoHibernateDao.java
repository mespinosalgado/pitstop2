package cl.pitstop.hibernateDao;

import java.util.List;

import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import cl.pitstop.dao.VehiculoDao;
import cl.pitstop.pojos.Vehiculo;

public class VehiculoHibernateDao extends AbstractDao implements VehiculoDao {

	public VehiculoHibernateDao(){
		super(Vehiculo.class);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Vehiculo> vehiculoAll(){
		DetachedCriteria criteria = DetachedCriteria.forClass(this.getEntityClass(), "vehiculo");
		criteria.createCriteria("vehiculo.cliente", CriteriaSpecification.INNER_JOIN);
		return (List<Vehiculo>) this.findAllByCriteria(criteria);
	}
	
	@Override
	public Vehiculo buscarVehiculoPorPatente(String patente){
		DetachedCriteria criteria = DetachedCriteria.forClass(this.getEntityClass(), "vehiculo");
		criteria.add(Restrictions.eq("vehiculo.patente", patente.toLowerCase()).ignoreCase());
		return (Vehiculo) this.findByCriteria(criteria);
	}
		
	@SuppressWarnings("deprecation")
	public void updVehiculo(Vehiculo vehiculo){
		super.update(vehiculo);
	}
	
	public void delVehiculo(Vehiculo vehiculo){
		super.delete(vehiculo);
	}


	@Override
	@SuppressWarnings("deprecation")
	public void crearVehiculo(Vehiculo vehiculo) {
		super.insert(vehiculo);
		
	}
	
}

