package cl.pitstop.dao;

import java.util.List;

import cl.pitstop.pojos.Sucursal;

public interface SucursalDao extends GenericDao {
		
	public List<Sucursal> sucursalAll();
	
	public void crearSucursal(Sucursal sucursal);

}