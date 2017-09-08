package cl.pitstop.action;

import cl.pitstop.pojos.Cliente;
import cl.pitstop.pojos.Cotizacion;
import cl.pitstop.pojos.Venta;
import cl.pitstop.dao.ClienteDao;
import cl.pitstop.dao.CotizacionDao;
import cl.pitstop.dao.VentaDao;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

	@SuppressWarnings("serial")
	public class VentaAction extends BaseAction {
		
	        Logger log = org.apache.log4j.Logger.getLogger(VentaAction.class);
	    
		private Cliente cliente;
		private ClienteDao clienteDao;
		private List<Cotizacion> cotizaciones;
		private Cotizacion cotizacion;
		private CotizacionDao cotizacionDao;
		private List<Venta> ventas;
		private Venta venta;
		private VentaDao ventaDao;
		
		private Integer ventaId;
		private Integer cotizacionId;
		private Integer clienteId;
		
		private String fecha;
		private Integer valor;
		private String observacion;
		private String tipoPago;
		
		
		private String mensaje;
		private String result;
		
		@Override
		public String execute(){
			return SUCCESS;
		}
		
		public String VentaMenu(){
	                HttpServletRequest request = ServletActionContext.getRequest();                
	                log.info("venta session" + request.getSession().getAttribute("venta"));
	                return SUCCESS;
		}
		
		public String listVenta(){
			List<Venta> ventas = this.ventaDao.ventaAll();
			log.info("venta:"+ventas);
			this.getRequest().getSession().setAttribute("venta", ventas);
			return SUCCESS;
		}
		
		public String crearVentaProducto(){
		try{
			Venta ventas = new Venta();	
			
			Venta cotizaciones = this.cotizacionDao.findById(this.cotizacionId);
			System.out.println(cotizaciones);
			Venta clientes = this.cotizacionDao.findById(this.clienteId);
			System.out.println(clientes);
			ventas.setValor(this.valor);
			ventas.setObservacion(this.observacion);
			ventas.setFecha(this.fecha);
			ventas.setTipoPago(this.tipoPago);
			this.ventaDao.insert(ventas);
	                
			result = "ok";
				
		}catch(Exception e){
			e.printStackTrace();
		}
		return SUCCESS;
		}

		public Logger getLog() {
			return log;
		}

		public void setLog(Logger log) {
			this.log = log;
		}

		public Cliente getCliente() {
			return cliente;
		}

		public void setCliente(Cliente cliente) {
			this.cliente = cliente;
		}

		public ClienteDao getClienteDao() {
			return clienteDao;
		}

		public void setClienteDao(ClienteDao clienteDao) {
			this.clienteDao = clienteDao;
		}

		public List<Cotizacion> getCotizaciones() {
			return cotizaciones;
		}

		public void setCotizaciones(List<Cotizacion> cotizaciones) {
			this.cotizaciones = cotizaciones;
		}

		public Cotizacion getCotizacion() {
			return cotizacion;
		}

		public void setCotizacion(Cotizacion cotizacion) {
			this.cotizacion = cotizacion;
		}

		public CotizacionDao getCotizacionDao() {
			return cotizacionDao;
		}

		public void setCotizacionDao(CotizacionDao cotizacionDao) {
			this.cotizacionDao = cotizacionDao;
		}

		public List<Venta> getVentas() {
			return ventas;
		}

		public void setVentas(List<Venta> ventas) {
			this.ventas = ventas;
		}

		public Venta getVenta() {
			return venta;
		}

		public void setVenta(Venta venta) {
			this.venta = venta;
		}

		public VentaDao getVentaDao() {
			return ventaDao;
		}

		public void setVentaDao(VentaDao ventaDao) {
			this.ventaDao = ventaDao;
		}

		public Integer getVentaId() {
			return ventaId;
		}

		public void setVentaId(Integer ventaId) {
			this.ventaId = ventaId;
		}

		public Integer getCotizacionId() {
			return cotizacionId;
		}

		public void setCotizacionId(Integer cotizacionId) {
			this.cotizacionId = cotizacionId;
		}

		public Integer getClienteId() {
			return clienteId;
		}

		public void setClienteId(Integer clienteId) {
			this.clienteId = clienteId;
		}

		public String getFecha() {
			return fecha;
		}

		public void setFecha(String fecha) {
			this.fecha = fecha;
		}

		public Integer getValor() {
			return valor;
		}

		public void setValor(Integer valor) {
			this.valor = valor;
		}

		public String getObservacion() {
			return observacion;
		}

		public void setObservacion(String observacion) {
			this.observacion = observacion;
		}

		public String getTipoPago() {
			return tipoPago;
		}

		public void setTipoPago(String tipoPago) {
			this.tipoPago = tipoPago;
		}

		public String getMensaje() {
			return mensaje;
		}

		public void setMensaje(String mensaje) {
			this.mensaje = mensaje;
		}

		public String getResult() {
			return result;
		}

		public void setResult(String result) {
			this.result = result;
		}

		
		
	}