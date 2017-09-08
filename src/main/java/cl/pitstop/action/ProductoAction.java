package cl.pitstop.action;

import java.util.List;

import cl.pitstop.dao.ProductoDao;
import cl.pitstop.dao.ProveedorDao;
import cl.pitstop.dao.SucursalDao;
import cl.pitstop.pojos.Producto;
import cl.pitstop.pojos.Proveedor;
import cl.pitstop.pojos.Sucursal;

@SuppressWarnings("serial")
public class ProductoAction extends BaseAction {
	
	private ProductoDao productoDao;
	private SucursalDao sucursalDao;
	private ProveedorDao proveedorDao;
	private List<Producto> productos;
	private List<Proveedor> provedores;
	private List<Sucursal> sucursales;
	
	private Integer sucursalId;
	private Integer proveedorId; 
	private Integer productoId; 
	private Proveedor proveedor;
	private Sucursal sucursal;
	private String codigo;
	private String descripcion;
	private String tipoProd;
	private Integer valor;
	private Integer stock;
	private String result;
	private Integer id;
	
	public String listProductos(){
		List<Producto> productos = this.productoDao.productoAll();
		List<Proveedor> proveedores = (List<Proveedor>) this.proveedorDao.findAll();
		List<Sucursal> sucursales = (List<Sucursal>) this.sucursalDao.findAll();
		this.getRequest().getSession().setAttribute("productos", productos);
		this.getRequest().getSession().setAttribute("proveedores", proveedores);
		this.getRequest().getSession().setAttribute("sucursales", sucursales);
		return SUCCESS;
	}
	
	public String crearProducto(){
		try{
			Producto productos = new Producto();
			Sucursal sucursal = this.sucursalDao.findById(this.sucursalId);
			Proveedor proveedor = this.proveedorDao.findById(this.proveedorId);
			productos.setCodigo(this.codigo);
			productos.setDescripcion(this.descripcion);
			productos.settipoProd(this.tipoProd);
			productos.setValor(this.valor);
			productos.setSucursal(sucursal);
			productos.setStock(this.stock);
			productos.setProveedor(proveedor);
			
			this.productoDao.insert(productos);
				
		}catch(Exception e){
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String editarProducto(){
		try{
			Producto productos = this.productoDao.findById(this.id);
			Sucursal sucursal = this.sucursalDao.findById(this.sucursalId);
			Proveedor proveedor = this.proveedorDao.findById(this.proveedorId);
			productos.setDescripcion(this.descripcion);
			productos.settipoProd(this.tipoProd);
			productos.setValor(this.valor);
			productos.setSucursal(sucursal);
			productos.setStock(this.stock);
			productos.setProveedor(proveedor);
			
			this.productoDao.update(productos);
				
		}catch(Exception e){
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public ProductoDao getProductoDao() {
		return productoDao;
	}
	public void setProductoDao(ProductoDao productoDao) {
		this.productoDao = productoDao;
	}
	public ProveedorDao getProveedorDao() {
		return proveedorDao;
	}
	public void setProveedorDao(ProveedorDao proveedorDao) {
		this.proveedorDao = proveedorDao;
	}
	public List<Producto> getProductos() {
		return productos;
	}
	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	public List<Proveedor> getProvedores() {
		return provedores;
	}
	public void setProvedores(List<Proveedor> provedores) {
		this.provedores = provedores;
	}
	public Integer getProveedorId() {
		return proveedorId;
	}
	public void setProveedorId(Integer proveedorId) {
		this.proveedorId = proveedorId;
	}
	public Integer getProductoId() {
		return productoId;
	}
	public void setProductoId(Integer productoId) {
		this.productoId = productoId;
	}
	public Proveedor getProveedor() {
		return proveedor;
	}
	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	public Sucursal getSucursal() {
		return sucursal;
	}
	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getTipoProd() {
		return tipoProd;
	}
	public void setTipoProd(String tipoProd) {
		this.tipoProd = tipoProd;
	}
	public Integer getValor() {
		return valor;
	}
	public void setValor(Integer valor) {
		this.valor = valor;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public List<Sucursal> getSucursales() {
		return sucursales;
	}

	public void setSucursales(List<Sucursal> sucursales) {
		this.sucursales = sucursales;
	}

	public SucursalDao getSucursalDao() {
		return sucursalDao;
	}

	public void setSucursalDao(SucursalDao sucursalDao) {
		this.sucursalDao = sucursalDao;
	}

	public Integer getSucursalId() {
		return sucursalId;
	}

	public void setSucursalId(Integer sucursalId) {
		this.sucursalId = sucursalId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	


}
