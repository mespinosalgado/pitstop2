package cl.pitstop.hibernateDao;

import java.util.List;

import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.DetachedCriteria;

import cl.pitstop.dao.VentaServicioDao;
import cl.pitstop.pojos.VentaServicio;

public class VentaServicioHibernateDao extends AbstractDao implements VentaServicioDao {

	public VentaServicioHibernateDao(){
		super(VentaServicio.class);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<VentaServicio> ventaServicioAll(){
		DetachedCriteria criteria = DetachedCriteria.forClass(this.getEntityClass(), "ventaServicio");
		criteria.createCriteria("ventaServicio.servicio", CriteriaSpecification.INNER_JOIN);
		criteria.createCriteria("ventaServicio.venta", CriteriaSpecification.INNER_JOIN);
	
		return (List<VentaServicio>) this.findAllByCriteria(criteria);
	}
	
}

