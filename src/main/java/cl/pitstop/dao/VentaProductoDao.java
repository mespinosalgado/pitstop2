package cl.pitstop.dao;

import java.util.List;

import cl.pitstop.pojos.VentaProducto;

public interface VentaProductoDao extends GenericDao {
	
	public List<VentaProducto> ventaProductoAll();
	
}
