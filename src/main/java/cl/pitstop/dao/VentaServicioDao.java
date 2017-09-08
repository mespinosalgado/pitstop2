package cl.pitstop.dao;

import java.util.List;

import cl.pitstop.pojos.VentaServicio;

public interface VentaServicioDao extends GenericDao {
	
	public List<VentaServicio> ventaServicioAll();
	
}
