package cl.pitstop.dao;

import java.util.List;

import cl.pitstop.pojos.Servicio;

public interface ServicioDao extends GenericDao {
	
	public List<Servicio> servicioAll();
	
	public void crearServicio(Servicio servicio);
}
