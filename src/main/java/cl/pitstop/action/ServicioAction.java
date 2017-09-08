package cl.pitstop.action;

import java.util.List;

import cl.pitstop.dao.ServicioDao;
import cl.pitstop.pojos.Servicio;

@SuppressWarnings("serial")
public class ServicioAction extends BaseAction {
	
	private ServicioDao servicioDao;
	private Servicio servicio;
	private List<Servicio> servicios;

	private Integer servicioId;
	private String nombreServicio;
	private Integer valorServicio;
	
	private String result;
	
	public String listServicios(){
		List<Servicio> servicios = this.servicioDao.servicioAll();
		System.out.println("srvicios:"+servicios);
		this.getRequest().getSession().setAttribute("servicios", servicios);
		return SUCCESS;
	}
	
	public String crearServicio(){
		try{
			Servicio servicios = new Servicio();
			servicios.setNombreServicio(this.nombreServicio);
			servicios.setValorServicio(this.valorServicio);

			this.servicioDao.insert(servicios);
			
			setResult("ok");
				
		}catch(Exception e){
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String updServicio(){
		try{
			Servicio servicios = this.servicioDao.findById(servicioId);
			servicios.setNombreServicio(this.nombreServicio);
			servicios.setValorServicio(this.valorServicio);

			this.servicioDao.update(servicios);
			
			setResult("ok");
				
		}catch(Exception e){
			e.printStackTrace();
		}
		return SUCCESS;
	}


	public ServicioDao getServicioDao() {
		return servicioDao;
	}

	public void setServicioDao(ServicioDao servicioDao) {
		this.servicioDao = servicioDao;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	public List<Servicio> getServicios() {
		return servicios;
	}

	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}

	public Integer getServicioId() {
		return servicioId;
	}

	public void setServicioId(Integer servicioId) {
		this.servicioId = servicioId;
	}

	public String getNombreServicio() {
		return nombreServicio;
	}

	public void setNombreServicio(String nombreServicio) {
		this.nombreServicio = nombreServicio;
	}

	public Integer getValorServicio() {
		return valorServicio;
	}

	public void setValorServicio(Integer valorServicio) {
		this.valorServicio = valorServicio;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
	
}