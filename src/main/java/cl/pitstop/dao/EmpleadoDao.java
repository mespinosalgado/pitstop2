package cl.pitstop.dao;

import java.util.List;

import cl.pitstop.pojos.Empleado;

public interface EmpleadoDao extends GenericDao {
	
	public List<Empleado> empleadoAll();
	
	public void crearEmpleado(Empleado empleados);
	
	
	

}
