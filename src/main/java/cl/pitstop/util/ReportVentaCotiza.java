package cl.pitstop.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import cl.pitstop.action.BaseAction;
import cl.pitstop.dao.ClienteDao;
import cl.pitstop.dao.EmpleadoDao;
import cl.pitstop.dao.ProductoDao;
import cl.pitstop.dao.RevisionDao;
import cl.pitstop.dao.ServicioDao;
import cl.pitstop.dao.UsuarioDao;
import cl.pitstop.dao.VehiculoDao;
import cl.pitstop.dao.VentaDao;
import cl.pitstop.dao.VentaProductoDao;
import cl.pitstop.dao.VentaServicioDao;
import cl.pitstop.pojos.Venta;
import cl.pitstop.pojos.VentaProducto;
import cl.pitstop.pojos.VentaServicio;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

@SuppressWarnings("serial")
public class ReportVentaCotiza extends BaseAction {
	public InputStream inputStream;
	private ClienteDao clienteDao;
	private VehiculoDao vehiculoDao;
	private RevisionDao revisionDao;
	private EmpleadoDao empleadoDao;
	private UsuarioDao usuarioDao;
	private VentaDao ventaDao;
	private VentaServicioDao ventaServicioDao;
	private VentaProductoDao ventaProductoDao;
	private ProductoDao productoDao;
	private ServicioDao servicioDao;
	private Venta ven;
	
	public Venta getVen() {
		return ven;
	}

	public void setVen(Venta ven) {
		this.ven = ven;
	}

	private Integer ventaId;
	
	@SuppressWarnings("rawtypes")
	private Map parameters;
	
	@SuppressWarnings("unchecked")
	public String pdf(){
		try{
			this.getResponse().setHeader("Cache-Control", "cache");
			this.getResponse().setHeader("Pragma", "cache");
			
			this.parameters = new HashMap<String, Object>();
			
			Venta venta = this.ventaDao.findById(this.ventaId);
			
			parameters.put("numero", venta.getId().toString());
			parameters.put("formaPago", venta.getTipoPago());
			parameters.put("subTotal", venta.getValor().toString());
			parameters.put("descuento", "0");
			parameters.put("total", venta.getValor().toString());
			parameters.put("observacion", venta.getObservacion());
			
			
			List<VentaProducto> productos = this.ventaProductoDao.ventaProductoAll();
			List<VentaServicio> servicios = this.ventaServicioDao.ventaServicioAll();
			Integer contador = 1;
			if(productos != null){
				for(VentaProducto p : productos){
					if(contador > 11){
						break;
					}
					if(p.getVenta().getId().equals(this.ventaId)){
						parameters.put("cantidad"+contador, p.getCantidad().toString());
						
						parameters.put("producto"+contador, p.getProducto().getDescripcion());
						parameters.put("precio"+contador,  p.getProducto().getValor().toString());
						Integer total =  p.getProducto().getValor() * p.getCantidad();
						parameters.put("total"+contador, total.toString());
						
						contador++;
					}
				}
			}
			
			if(servicios != null){
				for(VentaServicio p : servicios){
					if(contador > 11){
						break;
					}
					if(p.getVenta().getId().equals(this.ventaId)){
						parameters.put("cantidad"+contador, p.getCantidad().toString());
						
						parameters.put("producto"+contador, p.getServicio().getNombreServicio());
						parameters.put("precio"+contador,  p.getServicio().getValorServicio().toString());
						Integer total =  p.getServicio().getValorServicio() * p.getCantidad();
						parameters.put("total"+contador, total.toString());
						
						contador++;
					}
				}
			}
			
			ServletContext context = ServletActionContext.getServletContext();
			String path = context.getRealPath("/WEB-INF/");
			System.out.println("path : " + path);
            JasperReport jasReport = JasperCompileManager.compileReport(path+"/venta.jrxml");
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

	public RevisionDao getvenisionDao() {
		return revisionDao;
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

	public Integer getventaId() {
		return ventaId;
	}

	public void setventaId(Integer ventaId) {
		this.ventaId = ventaId;
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

	public RevisionDao getRevisionDao() {
		return revisionDao;
	}

	public void setRevisionDao(RevisionDao revisionDao) {
		this.revisionDao = revisionDao;
	}

	public VentaDao getVentaDao() {
		return ventaDao;
	}

	public void setVentaDao(VentaDao ventaDao) {
		this.ventaDao = ventaDao;
	}

	public VentaServicioDao getVentaServicioDao() {
		return ventaServicioDao;
	}

	public void setVentaServicioDao(VentaServicioDao ventaServicioDao) {
		this.ventaServicioDao = ventaServicioDao;
	}

	public VentaProductoDao getVentaProductoDao() {
		return ventaProductoDao;
	}

	public void setVentaProductoDao(VentaProductoDao ventaProductoDao) {
		this.ventaProductoDao = ventaProductoDao;
	}

	public Integer getVentaId() {
		return ventaId;
	}

	public void setVentaId(Integer ventaId) {
		this.ventaId = ventaId;
	}
	
	
	
}
