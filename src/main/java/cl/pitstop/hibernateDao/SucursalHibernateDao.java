package cl.pitstop.hibernateDao;

import java.util.List;

import org.hibernate.criterion.Order;

import cl.pitstop.dao.SucursalDao;
import cl.pitstop.pojos.Sucursal;

public class SucursalHibernateDao extends AbstractDao implements SucursalDao {
	

	public SucursalHibernateDao(){
		super(Sucursal.class);
	}
	
	private static Order _order = Order.asc("nombreSucursal");
	

	@Override
	@SuppressWarnings("unchecked")
	public List<Sucursal> sucursalAll(){
		return (List<Sucursal>) super.findAll(SucursalHibernateDao._order);
	}
	
	@SuppressWarnings("deprecation")
	public void updSucursal(Sucursal sucursal){
		super.update(sucursal);
	}
	
	public void delSucursal(Sucursal sucursal){
		super.delete(sucursal);
	}

	@Override
	@SuppressWarnings("deprecation")
	public void crearSucursal(Sucursal sucursal) {
		super.insert(sucursal);
		
	}
	


}