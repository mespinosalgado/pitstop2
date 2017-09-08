package cl.pitstop.action;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import cl.pitstop.dao.ClienteDao;
import cl.pitstop.dao.ProductoDao;
import cl.pitstop.dao.ServicioDao;
import cl.pitstop.dao.VentaDao;
import cl.pitstop.dao.VentaProductoDao;
import cl.pitstop.dao.VentaServicioDao;
import cl.pitstop.pojos.Cliente;
import cl.pitstop.pojos.Producto;
import cl.pitstop.pojos.Servicio;
import cl.pitstop.pojos.Venta;
import cl.pitstop.pojos.VentaProducto;
import cl.pitstop.pojos.VentaServicio;

@SuppressWarnings("serial")
public class CotizacionAction extends BaseAction {
	
	private ProductoDao productoDao;
	private ServicioDao servicioDao;
	private ClienteDao clienteDao;
	private VentaDao ventaDao;
	private VentaProductoDao ventaProductoDao;
	private VentaServicioDao ventaServicioDao;
	
	private Integer clienteId;
	private String tipo;
	private String ventaBag;
	private String tipoPago;
	private String observacion;
	private String fecha;
	private String total;
	
	private String simpleErrors = StringUtils.EMPTY;
	
	@SuppressWarnings("unchecked")
	public String CotizaMenu(){
		List<Producto> productos = (List<Producto>) productoDao.findAll();
		List<Servicio> servicios = (List<Servicio>) servicioDao.findAll();
		List<Cliente> clientes = (List<Cliente>) clienteDao.findAll();
		
		this.getRequest().getSession().setAttribute("productos", productos);
		this.getRequest().getSession().setAttribute("servicios", servicios);
		this.getRequest().getSession().setAttribute("clientes", clientes);
		
        return SUCCESS;
	}
	
	public String ingresarVenta(){
		StringBuffer buffer = new StringBuffer();
		try{
			Venta venta = new Venta();
			
			Cliente cliente = clienteDao.findById(clienteId);
			venta.setCliente(cliente);
			
			venta.setFecha(fecha);
			venta.setObservacion(observacion);
			venta.setTipo(tipo);
			venta.setTipoPago(tipoPago);
			venta.setValor(Integer.parseInt(total));
			
			ventaDao.insert(venta);
			
//			producto-2:1:::servicio-4:1:::
				
			String[] items = ventaBag.split(":::");
			
			for(String i : items){
				String[] item = i.split(":");
				String[] id = item[0].split("-");
				if(id[0].equals("producto")){
					Producto pro = productoDao.findById(Integer.parseInt(id[1]));
					VentaProducto ventaProducto = new VentaProducto();
					ventaProducto.setProducto(pro);
					ventaProducto.setVenta(venta);
					ventaProducto.setCantidad(Integer.parseInt(item[1]));
					pro.setStock(pro.getStock() - Integer.parseInt(item[1]));
					productoDao.update(pro);
					ventaProductoDao.insert(ventaProducto);
				}else{
					Servicio pro = servicioDao.findById(Integer.parseInt(id[1]));
					VentaServicio ventaServicio = new VentaServicio();
					ventaServicio.setServicio(pro);
					ventaServicio.setVenta(venta);
					ventaServicio.setCantidad(Integer.parseInt(item[1]));
					ventaServicioDao.insert(ventaServicio);
				}
			}
			
			buffer.append(tipo+" ingresado con exito");
				
			
	    }catch(Exception e){
	    	buffer.append("Error durante el proceso, favor reintentar");
			e.printStackTrace();
		}
		simpleErrors = buffer.toString();
		return SUCCESS;
	}
	
	public String ventaHisto(){
		List<Venta> ventas = this.ventaDao.ventaAll();
		this.getRequest().getSession().setAttribute("ventas", ventas);
		return SUCCESS;
	}

	public ProductoDao getProductoDao() {
		return productoDao;
	}

	public void setProductoDao(ProductoDao productoDao) {
		this.productoDao = productoDao;
	}

	public ServicioDao getServicioDao() {
		return servicioDao;
	}

	public void setServicioDao(ServicioDao servicioDao) {
		this.servicioDao = servicioDao;
	}

	public ClienteDao getClienteDao() {
		return clienteDao;
	}

	public void setClienteDao(ClienteDao clienteDao) {
		this.clienteDao = clienteDao;
	}

	public Integer getClienteId() {
		return clienteId;
	}

	public void setClienteId(Integer clienteId) {
		this.clienteId = clienteId;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getVentaBag() {
		return ventaBag;
	}

	public void setVentaBag(String ventaBag) {
		this.ventaBag = ventaBag;
	}

	public String getTipoPago() {
		return tipoPago;
	}

	public void setTipoPago(String tipoPago) {
		this.tipoPago = tipoPago;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getSimpleErrors() {
		return simpleErrors;
	}

	public void setSimpleErrors(String simpleErrors) {
		this.simpleErrors = simpleErrors;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public VentaDao getVentaDao() {
		return ventaDao;
	}

	public void setVentaDao(VentaDao ventaDao) {
		this.ventaDao = ventaDao;
	}

	public VentaProductoDao getVentaProductoDao() {
		return ventaProductoDao;
	}

	public void setVentaProductoDao(VentaProductoDao ventaProductoDao) {
		this.ventaProductoDao = ventaProductoDao;
	}

	public VentaServicioDao getVentaServicioDao() {
		return ventaServicioDao;
	}

	public void setVentaServicioDao(VentaServicioDao ventaServicioDao) {
		this.ventaServicioDao = ventaServicioDao;
	}
	
}