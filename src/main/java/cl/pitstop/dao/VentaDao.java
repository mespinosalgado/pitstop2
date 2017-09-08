package cl.pitstop.dao;

import java.util.List;

import cl.pitstop.pojos.Venta;

public interface VentaDao extends GenericDao {
	
	public List<Venta> ventaAll();
	
	public List<Venta> ventaAllAndDetail();
	
	public void crearVenta(Venta ventas);
	
}
