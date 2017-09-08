package cl.pitstop.action;

import java.util.ArrayList;
import java.util.List;

import cl.pitstop.dao.ProveedorDao;
import cl.pitstop.pojos.Proveedor;

@SuppressWarnings("serial")
public class ProveedoresAction extends BaseAction {
	
	private ProveedorDao proveedorDao;
	private List<Proveedor> proveedores;
	
	private Integer id;
	private String rutEmpresa;
	private String nombre;
	private Integer telefono;
	private String correo;
	
	public String proveedores(){
		proveedores = (List<Proveedor>) this.proveedorDao.findAll();
		List<Proveedor> proveedorFinal = new ArrayList<Proveedor>();
		if(proveedores != null){
			for(Proveedor e: proveedores){
				e.setRutFormat(e.getRutEmpresa().replace("-", "").replace(".", ""));
				proveedorFinal.add(e);
			}
		}
		this.getRequest().getSession().setAttribute("proveedores", proveedorFinal);
		return SUCCESS;
	}
	
	public String crearProveedor(){
		try{
			Proveedor pro = new Proveedor();
			pro.setRutEmpresa(rutEmpresa);
			pro.setNombre(nombre);
			pro.setTelefono(telefono);
			pro.setCorreo(correo);
			this.proveedorDao.insert(pro);
		}catch(Exception e){
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String updateProveedor(){
		try{
			Proveedor pro = proveedorDao.findById(id);
			pro.setRutEmpresa(rutEmpresa);
			pro.setNombre(nombre);
			pro.setTelefono(telefono);
			pro.setCorreo(correo);
			this.proveedorDao.update(pro);
		}catch(Exception e){
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public ProveedorDao getProveedorDao() {
		return proveedorDao;
	}
	public void setProveedorDao(ProveedorDao proveedorDao) {
		this.proveedorDao = proveedorDao;
	}
	public List<Proveedor> getProveedores() {
		return proveedores;
	}
	public void setProveedores(List<Proveedor> proveedores) {
		this.proveedores = proveedores;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRutEmpresa() {
		return rutEmpresa;
	}
	public void setRutEmpresa(String rutEmpresa) {
		this.rutEmpresa = rutEmpresa;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getTelefono() {
		return telefono;
	}
	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	
	

}
