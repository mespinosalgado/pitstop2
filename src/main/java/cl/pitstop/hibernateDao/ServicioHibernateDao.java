package cl.pitstop.hibernateDao;

import java.util.List;

import cl.pitstop.dao.ServicioDao;
import cl.pitstop.pojos.Servicio;


public class ServicioHibernateDao extends AbstractDao implements ServicioDao {
	
	public ServicioHibernateDao(){
		super(Servicio.class);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Servicio> servicioAll(){
		return (List<Servicio>) super.findAll();
	}
		
	@SuppressWarnings("deprecation")
	public void updServicio(Servicio servicio){
		super.update(servicio);
	}
	
	public void delProducto(Servicio servicio){
		super.delete(servicio);
	}


	@Override
	@SuppressWarnings("deprecation")
	public void crearServicio(Servicio servicio) {
		super.insert(servicio);
		
	}
	
}
