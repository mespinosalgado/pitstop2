package cl.pitstop.dao;

import java.util.List;

import cl.pitstop.pojos.Cotizacion;

public interface CotizacionDao extends GenericDao {
	
	public List<Cotizacion> cotizacionAll();

	public void crearCotizacion(Cotizacion cotizaciones);

}
