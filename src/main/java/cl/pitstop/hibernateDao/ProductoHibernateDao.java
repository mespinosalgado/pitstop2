package cl.pitstop.hibernateDao;

import java.util.List;

import org.hibernate.criterion.Order;

import cl.pitstop.dao.ProductoDao;
import cl.pitstop.pojos.Producto;



public class ProductoHibernateDao extends AbstractDao implements ProductoDao {
	
	public ProductoHibernateDao(){
		super(Producto.class);
	}
	
	private static Order _order = Order.asc("tipoProd");
	

	@Override
	@SuppressWarnings("unchecked")
	public List<Producto> productoAll(){
		return (List<Producto>) super.findAll(ProductoHibernateDao._order);
	}
		
	@SuppressWarnings("deprecation")
	public void updProducto(Producto producto){
		super.update(producto);
	}
	
	public void delProducto(Producto producto){
		super.delete(producto);
	}


	@Override
	@SuppressWarnings("deprecation")
	public void crearProducto(Producto producto) {
		super.insert(producto);
		
	}
	
}
