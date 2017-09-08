package cl.pitstop.dao;

import java.util.List;

import cl.pitstop.pojos.Usuario;

public interface UsuarioDao  extends GenericDao {
	
	public List<Usuario> buscarAll();
	
	public void crearUsuario(Usuario usuario);
	
	public Usuario buscarPorUserPass(String username, String password);
	
	public Usuario buscarPorEmpleado(Integer empleadoId);
	
}
