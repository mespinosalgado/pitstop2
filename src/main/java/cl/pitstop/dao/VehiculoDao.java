package cl.pitstop.dao;

import java.util.List;
import cl.pitstop.pojos.Vehiculo;

public interface VehiculoDao extends GenericDao {
	
	public List<Vehiculo> vehiculoAll();
	
	public void crearVehiculo(Vehiculo vehiculo);
	
	public Vehiculo buscarVehiculoPorPatente(String patente);
	
}
