package cl.pitstop.dao;


import java.util.List;
import cl.pitstop.pojos.Cliente;

public interface ClienteDao extends GenericDao {
	
	public List<Cliente> clienteAll();
	
	public void crearCliente(Cliente clientes);
	
	public Cliente buscarClientePorRut(String rut);

	
}
