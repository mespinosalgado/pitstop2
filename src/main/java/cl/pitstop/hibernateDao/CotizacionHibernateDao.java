package cl.pitstop.hibernateDao;

import java.util.List;

import cl.pitstop.dao.CotizacionDao;
import cl.pitstop.pojos.Cotizacion;

public class CotizacionHibernateDao extends AbstractDao implements CotizacionDao {
	
	public CotizacionHibernateDao(){
		super(Cotizacion.class);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Cotizacion> cotizacionAll(){
		return (List<Cotizacion>) super.findAll();
	}
		
	@SuppressWarnings("deprecation")
	public void updCotizacion(Cotizacion cotizacion){
		super.update(cotizacion);
	}
	
	public void delCotizacion(Cotizacion cotizacion){
		super.delete(cotizacion);
	}


	@Override
	@SuppressWarnings("deprecation")
	public void crearCotizacion(Cotizacion cotizacion) {
		super.insert(cotizacion);
		
	}
	
}

