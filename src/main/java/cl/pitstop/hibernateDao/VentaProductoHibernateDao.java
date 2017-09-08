package cl.pitstop.hibernateDao;

import java.util.List;

import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.DetachedCriteria;

import cl.pitstop.dao.VentaProductoDao;
import cl.pitstop.pojos.VentaProducto;

public class VentaProductoHibernateDao extends AbstractDao implements VentaProductoDao {

	public VentaProductoHibernateDao(){
		super(VentaProducto.class);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<VentaProducto> ventaProductoAll(){
		
		DetachedCriteria criteria = DetachedCriteria.forClass(this.getEntityClass(), "ventaProducto");
		criteria.createCriteria("ventaProducto.producto", CriteriaSpecification.INNER_JOIN);
		criteria.createCriteria("ventaProducto.venta", CriteriaSpecification.INNER_JOIN);
	
		return (List<VentaProducto>) this.findAllByCriteria(criteria);
	}
	
}

