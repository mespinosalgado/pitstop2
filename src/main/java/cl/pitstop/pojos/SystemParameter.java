package cl.pitstop.pojos;

public class SystemParameter {
	
	private Boolean seeIngresos;
	private Boolean seeVenta;
	private Boolean seeEmpleados;
	private Boolean seeProductos;
	private Boolean seeServicios;
	private Boolean seeProveedores;
	private Boolean seeVentaHistorica;
	
	public Boolean getSeeIngresos() {
		return seeIngresos;
	}
	public void setSeeIngresos(Boolean seeIngresos) {
		this.seeIngresos = seeIngresos;
	}
	public Boolean getSeeVenta() {
		return seeVenta;
	}
	public void setSeeVenta(Boolean seeVenta) {
		this.seeVenta = seeVenta;
	}
	public Boolean getSeeEmpleados() {
		return seeEmpleados;
	}
	public void setSeeEmpleados(Boolean seeEmpleados) {
		this.seeEmpleados = seeEmpleados;
	}
	public Boolean getSeeProductos() {
		return seeProductos;
	}
	public void setSeeProductos(Boolean seeProductos) {
		this.seeProductos = seeProductos;
	}
	public Boolean getSeeServicios() {
		return seeServicios;
	}
	public void setSeeServicios(Boolean seeServicios) {
		this.seeServicios = seeServicios;
	}
	public Boolean getSeeProveedores() {
		return seeProveedores;
	}
	public void setSeeProveedores(Boolean seeProveedores) {
		this.seeProveedores = seeProveedores;
	}
	public Boolean getSeeVentaHistorica() {
		return seeVentaHistorica;
	}
	public void setSeeVentaHistorica(Boolean seeVentaHistorica) {
		this.seeVentaHistorica = seeVentaHistorica;
	}
	
	public void setAllSee(String role){
		if(role.equals("Administrador")){
			this.seeIngresos = true;
			this.seeVenta = true;
			this.seeEmpleados = true;
			this.seeProductos = true;
			this.seeServicios = true;
			this.seeProveedores = true;
			this.seeVentaHistorica = true;
		}else if(role.equals("Mecanico")){
			this.seeIngresos = true;
			this.seeVenta = false;
			this.seeEmpleados = false;
			this.seeProductos = false;
			this.seeServicios = false;
			this.seeProveedores = false;
			this.seeVentaHistorica = false;
		}else if(role.equals("Vendedor")){
			this.seeIngresos = true;
			this.seeVenta = true;
			this.seeEmpleados = false;
			this.seeProductos = false;
			this.seeServicios = false;
			this.seeProveedores = false;
			this.seeVentaHistorica = true;
		}
	}

}
