package cl.pitstop.hibernateDao;

import java.util.List;

import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.DetachedCriteria;

import cl.pitstop.dao.VentaDao;
import cl.pitstop.pojos.Venta;

public class VentaHibernateDao extends AbstractDao implements VentaDao {

	public VentaHibernateDao(){
		super(Venta.class);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Venta> ventaAll(){
		return (List<Venta>) super.findAll();
	}
	
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Venta> ventaAllAndDetail(){
		DetachedCriteria criteria = DetachedCriteria.forClass(this.getEntityClass(), "venta");
		criteria.createCriteria("venta.ventaProducto", CriteriaSpecification.INNER_JOIN);
		criteria.createCriteria("venta.ventaServicio", CriteriaSpecification.INNER_JOIN);
		return (List<Venta>) this.findAllByCriteria(criteria);
	}
		
	@SuppressWarnings("deprecation")
	public void updVenta(Venta venta){
		super.update(venta);
	}
	
	public void delVenta(Venta venta){
		super.delete(venta);
	}


	@Override
	@SuppressWarnings("deprecation")
	public void crearVenta(Venta venta) {
		super.insert(venta);
		
	}
	
}

