package cl.pitstop.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cl.pitstop.dao.ClienteDao;
import cl.pitstop.dao.EmpleadoDao;
import cl.pitstop.dao.ProductoDao;
import cl.pitstop.dao.RevisionDao;
import cl.pitstop.dao.VehiculoDao;
import cl.pitstop.dao.VentaDao;
import cl.pitstop.dao.VentaProductoDao;
import cl.pitstop.dao.VentaServicioDao;
import cl.pitstop.pojos.Cliente;
import cl.pitstop.pojos.Empleado;
import cl.pitstop.pojos.Producto;
import cl.pitstop.pojos.Revision;
import cl.pitstop.pojos.Vehiculo;
import cl.pitstop.pojos.Venta;
import cl.pitstop.pojos.VentaProducto;
import cl.pitstop.pojos.VentaServicio;

@SuppressWarnings("serial")
public class MenuAction extends BaseAction {

	private ProductoDao productoDao;
	private VentaDao ventaDao;
	private RevisionDao revisionDao;
	private VehiculoDao vehiculoDao;
	private ClienteDao clienteDao;
	private EmpleadoDao empleadoDao;
	private VentaProductoDao ventaProductoDao;
	private VentaServicioDao ventaServicioDao;

	public String adminMenu(){
		
		List<Producto> productos = (List<Producto>) productoDao.findAll();
		Producto proConsolidate = new Producto();
		Integer count = 0;
		if(productos != null){
			for(Producto pro : productos){
				if(pro.getStock() <= 8){
					count++;
				}
			}
		}
		proConsolidate.setStock(count);
		this.getRequest().getSession().setAttribute("productoDashBoard", proConsolidate);
		
		List<Venta> ventas = (List<Venta>) ventaDao.findAll();
		Integer total = 0;
		Date now = new Date();
		Integer year = now.getYear() + 1900;
		Integer month = now.getMonth() + 1;
		if(ventas != null){
			for(Venta ven : ventas){
				Integer elementMont = Integer.parseInt(ven.getFecha().split("-")[1]);
				Integer elementYear = Integer.parseInt(ven.getFecha().split("-")[0]);
				
				if(elementMont.equals(month) && elementYear.equals(year)){
					if(ven.getTipo().equals("Venta")){
						total = total + ven.getValor();
					}
				}
			}
		}
		this.getRequest().getSession().setAttribute("totalDashBoard", total);
		
		List<Revision> revisiones = (List<Revision>) revisionDao.findAll();
		List<Revision> revisionesNo = new ArrayList<Revision>();
		Integer totalRev = 0;
		if(revisiones != null){
			for(Revision rev : revisiones){
				Integer elementMont = Integer.parseInt(rev.getFecha().split("/")[1]);
				Integer elementYear = Integer.parseInt(rev.getFecha().split("/")[2]);
				
				if(elementMont.equals(month) && elementYear.equals(year)){
					totalRev++;
				}
				
				if(!rev.getAprobacion()){
					rev.setVehiculo((Vehiculo)this.vehiculoDao.findById(rev.getVehiculo().getId()));
					rev.getVehiculo().setCliente((Cliente)clienteDao.findById(rev.getVehiculo().getCliente().getId()));
					rev.setEmpleado((Empleado)this.empleadoDao.findById(rev.getEmpleado().getId()));
					revisionesNo.add(rev);
				}
			}
		}
		this.getRequest().getSession().setAttribute("totalRevDashBoard", totalRev);
		this.getRequest().getSession().setAttribute("revListDashBoard", revisionesNo);
		
		if(ventas != null){
			try{
				Date ahora = new Date();
				
				Integer mes1 = ahora.getMonth() + 1;
				Integer mes2, mes3;
				
				Integer anio1 = ahora.getYear() +1900;
				Integer anio2, anio3;
				
				if(mes1 == 1){
					mes2 = 12; mes3 = 11;
					anio3 = anio2 = anio1 -1;
				}else if(mes1 == 2){
					mes2 = 1; mes3 = 12;
					anio2 = anio1;
					anio3 = anio1 -1;		
				}else{
					mes2 = mes1 -1; mes3 = mes1 -2;
					anio3 = anio2 = anio1;
				}
				
				
				Integer totalServicios1 = 0;
				Integer totalProductos1 = 0;
				Integer total1 = 0;
				
				Integer totalServicios2 = 0;
				Integer totalProductos2 = 0;
				Integer total2 = 0;
				
				Integer totalServicios3 = 0;
				Integer totalProductos3 = 0;
				Integer total3 = 0;
				
				List<VentaProducto> productosTotales = (List<VentaProducto>) this.ventaProductoDao.findAll();
				List<VentaServicio> serviciosTotales = (List<VentaServicio>) this.ventaServicioDao.findAll();
				
				for(Venta ven : ventas){
					
					if(Integer.parseInt(ven.getFecha().split("-")[1]) == mes1 && Integer.parseInt(ven.getFecha().split("-")[0]) == anio1){
						for(VentaProducto v : productosTotales){
							if(v.getVenta().getId() == ven.getId()){
								totalProductos1 = totalProductos1 + v.getCantidad();
							}
						}
						
						for(VentaServicio v : serviciosTotales){
							if(v.getVenta().getId() == ven.getId()){
								totalServicios2 = totalServicios2 + v.getCantidad();
							}
						}
					}
					if(Integer.parseInt(ven.getFecha().split("-")[1]) == mes2 && Integer.parseInt(ven.getFecha().split("-")[0]) == anio2){
						for(VentaProducto v : productosTotales){
							if(v.getVenta().getId() == ven.getId()){
								totalProductos2 = totalProductos2 + v.getCantidad();
							}
						}
						
						for(VentaServicio v : serviciosTotales){
							if(v.getVenta().getId() == ven.getId()){
								totalServicios1 = totalServicios1 + v.getCantidad();
							}
						}
					}
					if(Integer.parseInt(ven.getFecha().split("-")[1]) == mes3 && Integer.parseInt(ven.getFecha().split("-")[0]) == anio3){
						for(VentaProducto v : productosTotales){
							if(v.getVenta().getId() == ven.getId()){
								totalProductos3 = totalProductos3 + v.getCantidad();
							}
						}
						
						for(VentaServicio v : serviciosTotales){
							if(v.getVenta().getId() == ven.getId()){
								totalServicios3 = totalServicios3 + v.getCantidad();
							}
						}
					}
				}
				
				total1 = totalServicios1 + totalProductos1;
				total2 = totalServicios2 + totalProductos2;
				total3 = totalServicios3 + totalProductos3;
				
				List<Integer> graficoServicios = new ArrayList<Integer>();
				graficoServicios.add(totalServicios1);
				graficoServicios.add(totalServicios2);
				graficoServicios.add(totalServicios3);
				List<Integer> graficoProductos = new ArrayList<Integer>();
				graficoProductos.add(totalProductos1);
				graficoProductos.add(totalProductos2);
				graficoProductos.add(totalProductos3);
				List<Integer> graficoTotal = new ArrayList<Integer>();
				graficoTotal.add(total1);
				graficoTotal.add(total2);
				graficoTotal.add(total3);
				List<String> graficoMeses = new ArrayList<String>();
				graficoMeses.add(findNameOfMonth(mes1));
				graficoMeses.add(findNameOfMonth(mes2));
				graficoMeses.add(findNameOfMonth(mes3));
				
				this.getRequest().getSession().setAttribute("graficoMes", "Ultimos 3 Meses");
				this.getRequest().getSession().setAttribute("graficoMeses", graficoMeses);
				this.getRequest().getSession().setAttribute("graficoServicios", graficoServicios);
				this.getRequest().getSession().setAttribute("graficoProductos", graficoProductos);
				this.getRequest().getSession().setAttribute("graficoTotal", graficoTotal);
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}
		
		
		return SUCCESS;
	}
	
	public String findNameOfMonth(Integer month){
		
		if(month == 1){
			return  "'Enero'";
		}else if(month == 2){
			return  "'Febrero'";
		}else if(month == 3){
			return  "'Marzo'";
		}else if(month == 4){
			return  "'Abril'";
		}else if(month == 5){
			return  "'Mayo'";
		}else if(month == 6){
			return  "'Junio'";
		}else if(month == 7){
			return  "'Julio'";
		}else if(month == 8){
			return  "'Agosto'";
		}else if(month == 9){
			return  "'Septiembre'";
		}else if(month == 10){
			return  "'Octubre'";
		}else if(month == 11){
			return  "'Noviembre'";
		}else if(month == 12){
			return  "'Diciembre'";
		}
		
		return null;
	}

	public ProductoDao getProductoDao() {
		return productoDao;
	}

	public void setProductoDao(ProductoDao productoDao) {
		this.productoDao = productoDao;
	}

	public VentaDao getVentaDao() {
		return ventaDao;
	}

	public void setVentaDao(VentaDao ventaDao) {
		this.ventaDao = ventaDao;
	}

	public RevisionDao getRevisionDao() {
		return revisionDao;
	}

	public void setRevisionDao(RevisionDao revisionDao) {
		this.revisionDao = revisionDao;
	}

	public VehiculoDao getVehiculoDao() {
		return vehiculoDao;
	}

	public void setVehiculoDao(VehiculoDao vehiculoDao) {
		this.vehiculoDao = vehiculoDao;
	}

	public ClienteDao getClienteDao() {
		return clienteDao;
	}

	public void setClienteDao(ClienteDao clienteDao) {
		this.clienteDao = clienteDao;
	}

	public EmpleadoDao getEmpleadoDao() {
		return empleadoDao;
	}

	public void setEmpleadoDao(EmpleadoDao empleadoDao) {
		this.empleadoDao = empleadoDao;
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
