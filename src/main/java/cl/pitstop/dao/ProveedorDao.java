package cl.pitstop.dao;

import java.util.List;

import cl.pitstop.pojos.Proveedor;

public interface ProveedorDao extends GenericDao {
	
	public List<Proveedor> proveedorAll();
	
	public void crearProveedor(Proveedor proveedores);

}
