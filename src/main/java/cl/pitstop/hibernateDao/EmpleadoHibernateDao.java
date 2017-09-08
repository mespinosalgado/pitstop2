package cl.pitstop.hibernateDao;

import java.util.List;

import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.DetachedCriteria;
import cl.pitstop.dao.EmpleadoDao;
import cl.pitstop.pojos.Empleado;

public class EmpleadoHibernateDao extends AbstractDao implements EmpleadoDao {
	public EmpleadoHibernateDao(){
		super(Empleado.class);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Empleado> empleadoAll(){
		DetachedCriteria criteria = DetachedCriteria.forClass(this.getEntityClass(), "empleado");
		criteria.createCriteria("empleado.sucursal", CriteriaSpecification.INNER_JOIN);
		return (List<Empleado>) this.findAllByCriteria(criteria);
	}
		
	@SuppressWarnings("deprecation")
	public void updEmpleado(Empleado empleado){
		super.update(empleado);
	}
	
	
	public void delEmpleado(Empleado empleado){
		super.delete(empleado);
	}


	@Override
	@SuppressWarnings("deprecation")
	public void crearEmpleado(Empleado empleado) {
		super.insert(empleado);
	}
	

}
