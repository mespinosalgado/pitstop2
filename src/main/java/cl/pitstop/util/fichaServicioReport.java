package cl.pitstop.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import cl.pitstop.action.BaseAction;
import cl.pitstop.dao.ClienteDao;
import cl.pitstop.dao.EmpleadoDao;
import cl.pitstop.dao.RevisionDao;
import cl.pitstop.dao.UsuarioDao;
import cl.pitstop.dao.VehiculoDao;
import cl.pitstop.pojos.Cliente;
import cl.pitstop.pojos.Empleado;
import cl.pitstop.pojos.Revision;
import cl.pitstop.pojos.Vehiculo;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

@SuppressWarnings("serial")
public class fichaServicioReport extends BaseAction {
	public InputStream inputStream;
	private ClienteDao clienteDao;
	private VehiculoDao vehiculoDao;
	private RevisionDao revisionDao;
	private EmpleadoDao empleadoDao;
	private UsuarioDao usuarioDao;
	private Revision rev;
	
	public Revision getRev() {
		return rev;
	}

	public void setRev(Revision rev) {
		this.rev = rev;
	}

	private Integer revisionId;
	
	private Map<String, Object> parameters;
	
	public String pdf(){
		try{
			this.getResponse().setHeader("Cache-Control", "cache");
			this.getResponse().setHeader("Pragma", "cache");
			
			rev = this.revisionDao.findById(revisionId);
			Empleado emp  = this.empleadoDao.findById(rev.getEmpleado().getId());
			Vehiculo veh = this.vehiculoDao.findById(rev.getVehiculo().getId());
			Cliente cli = this.clienteDao.findById(veh.getCliente().getId());
			
			this.parameters = new HashMap<String, Object>();
			parameters.put("numeroFicha", rev.getId().toString());
			parameters.put("fecha", rev.getFecha());
			parameters.put("nombreCliente", cli.getNombre() + " " + cli.getApellidos());
			parameters.put("telefonoCliente", cli.getTelefono().toString());
			parameters.put("correoCliente", cli.getCorreo());
			parameters.put("mecanicoNombre", emp.getNombre() + " " + emp.getApellidos());
			parameters.put("patente", veh.getPatente());
			parameters.put("marca", veh.getMarca());
			parameters.put("modelo", veh.getModelo());
			parameters.put("anio", veh.getAno().toString());
			parameters.put("kilometros", veh.getKilometraje().toString());
			parameters.put("observacion", rev.getObservacion());
			
			ServletContext context = ServletActionContext.getServletContext();
			String path = context.getRealPath("/WEB-INF/");
			System.out.println("path : " + path);
            JasperReport jasReport = JasperCompileManager.compileReport(path+"/ingresoVehiculo.jrxml");
            System.out.println("Jasper Report : " + jasReport);
           
            JasperPrint jasPrint = JasperFillManager.fillReport(jasReport,parameters,new JREmptyDataSource());//, mapParam, con);
            System.out.println("Jasper Print : " + jasPrint);

            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            JasperExportManager.exportReportToPdfFile(jasPrint, path+"/demo.pdf");
            JasperExportManager.exportReportToPdfStream(jasPrint, baos);
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            inputStream = bais;
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return SUCCESS;
	}

	public ClienteDao getClienteDao() {
		return clienteDao;
	}

	public void setClienteDao(ClienteDao clienteDao) {
		this.clienteDao = clienteDao;
	}

	public VehiculoDao getVehiculoDao() {
		return vehiculoDao;
	}

	public void setVehiculoDao(VehiculoDao vehiculoDao) {
		this.vehiculoDao = vehiculoDao;
	}

	public RevisionDao getRevisionDao() {
		return revisionDao;
	}

	public void setRevisionDao(RevisionDao revisionDao) {
		this.revisionDao = revisionDao;
	}

	public EmpleadoDao getEmpleadoDao() {
		return empleadoDao;
	}

	public void setEmpleadoDao(EmpleadoDao empleadoDao) {
		this.empleadoDao = empleadoDao;
	}

	public UsuarioDao getUsuarioDao() {
		return usuarioDao;
	}

	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}

	public Integer getRevisionId() {
		return revisionId;
	}

	public void setRevisionId(Integer revisionId) {
		this.revisionId = revisionId;
	}

	public Map<String, Object> getParameters() {
		return parameters;
	}

	public void setParameters(Map<String, Object> parameters) {
		this.parameters = parameters;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	
}
