package cl.pitstop.dao;

import java.util.List;

import cl.pitstop.pojos.Producto;

public interface ProductoDao extends GenericDao {
	
	public List<Producto> productoAll();

	public void crearProducto(Producto productos);
}
