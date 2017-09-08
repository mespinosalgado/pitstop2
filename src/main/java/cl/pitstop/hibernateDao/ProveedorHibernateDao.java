package cl.pitstop.hibernateDao;

import java.util.List;

import org.hibernate.criterion.Order;
import cl.pitstop.dao.ProveedorDao;
import cl.pitstop.pojos.Proveedor;

public class ProveedorHibernateDao extends AbstractDao implements ProveedorDao {
	
	public ProveedorHibernateDao(){
		super(Proveedor.class);
	}
	
	private static Order _order = Order.asc("rutEmpresa");
	

	@Override
	@SuppressWarnings("unchecked")
	public List<Proveedor> proveedorAll(){
		return (List<Proveedor>) super.findAll(ProveedorHibernateDao._order);
	}
	
	@SuppressWarnings("deprecation")
	public void updProveedor(Proveedor proveedor){
		super.update(proveedor);
	}
	
	public void delProveedor(Proveedor proveedor){
		super.delete(proveedor);
	}

	@Override
	@SuppressWarnings("deprecation")
	public void crearProveedor(Proveedor proveedor) {
		super.insert(proveedor);
		
	}

}
