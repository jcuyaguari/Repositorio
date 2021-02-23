package com.jonathan.bean;

import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.SelectEvent;

import com.jonathan.modelo.DetalleVenta;
import com.jonathan.modelo.Producto;
import com.jonathan.modelo.Usuarios;
import com.jonathan.modelo.Venta;
import com.jonathan.service.ProductoService;
import com.jonathan.service.VentaService;
import com.jonathan.serviceImpl.ProductoServiceImpl;
import com.jonathan.serviceImpl.VentaServiceImpl;

@ManagedBean(name = "ventaBean")
@SessionScoped
public class VentaBean implements Serializable{

	private static final long serialVersionUID = 5932711591737039058L;
	
	private Venta venta = new Venta();
	private List<Venta> ventas;
	private List<DetalleVenta> detalleVentas;
	private DetalleVenta detalleVenta = new DetalleVenta();
	private Producto producto = new Producto();
	private List<Producto> productos;
	
	@ManagedProperty("#{loginBean}")
	private LoginBean loginBean;

	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}
	
	/*----------------------------------------*/

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public VentaBean() {
		this.ventas = new ArrayList<Venta>();
		this.detalleVentas = new ArrayList<DetalleVenta>();
		this.productos = new ArrayList<Producto>();
	}

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

	public List<Venta> getVentas() {
		return ventas;
	}

	public void setVentas(List<Venta> ventas) {
		this.ventas = ventas;
	}

	public List<DetalleVenta> getDetalleVentas() {
		return detalleVentas;
	}

	public void setDetalleVentas(List<DetalleVenta> detalleVentas) {
		this.detalleVentas = detalleVentas;
	}

	public DetalleVenta getDetalleVenta() {
		return detalleVenta;
	}

	public void setDetalleVenta(DetalleVenta detalleVenta) {
		this.detalleVenta = detalleVenta;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public List<Producto> getProductos() {
		ProductoService productoService = new ProductoServiceImpl();
		this.productos = productoService.findAll();
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	
	public String nuevaVenta(){
		this.venta.setVenFecha(new Date());
		return "/views/nventa.xhtml";
	}
	
	public void btnCreate(ActionEvent actionEvent) {
		venta.setUsuarios(new Usuarios(loginBean.getUsuarios().getUsId()));
		venta.setVenFecha(new Date());
		VentaService ventaService = new VentaServiceImpl();
		String msg = "";
		if(ventaService.create(this.venta)){
			msg = "Venta Exitosa";
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
			FacesContext.getCurrentInstance().addMessage(null, message);
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("ventaBean");
			FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
		} else {
			msg = "Error al crear la venta";
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null);
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}
	
	public void onCellEdit(CellEditEvent event) {
		Object oldValue = event.getOldValue();
		Object newValue = event.getNewValue();
		detalleVenta = detalleVentas.get(event.getRowIndex());

		if (newValue != null && !newValue.equals(oldValue)) {
			RequestContext requestContext = RequestContext.getCurrentInstance();
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Cantidad modificada", "De: " + oldValue + ", A: "
							+ newValue);
			FacesContext.getCurrentInstance().addMessage(null, msg);
			update(event.getRowIndex(), detalleVenta);
			detalleVenta.setDvTotal(redondear(detalleVenta.getDvTotal()));
			venta.setVenMonto(redondear(getmtotal()));
			requestContext.update("detalleFactura");
		}
	}
	
	public static double redondear(double numero)
    {
        return Math.rint(numero*100)/100;
    }
	
	public void update(int index, DetalleVenta d) {
		detalleVentas.set(index, d);
	}
	
	public void btnCancelar(ActionEvent actionEvent) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("ventaBean");
	}
	
	public void agregarDetalle() {
		DetalleVenta detal = new DetalleVenta();
		detal.setProducto(producto);
		detal.setVenta(venta);
		detal.setDvCantidad(1);
		detal.setDvPrecioart(this.producto.getProdPrecio());
		detal.setDvTotal(redondear(detal.getDvTotal()));
		this.detalleVentas.add(detal);
		this.venta.setDetalleVentas(detalleVentas);
		venta.setVenMonto(redondear(getmtotal()));
	}
	
	public double getmtotal() {
		double mtotal = 0.0;
		for (int i = 0; i < this.detalleVentas.size(); i++) {
			mtotal = mtotal + detalleVentas.get(i).getDvTotal();
		}
		return mtotal;
	}
	
	public void quitar(DetalleVenta d){
		detalleVentas.remove(d);
		venta.setVenMonto(redondear(getmtotal()));
	}
	
	public void onRowSelectForm(SelectEvent event) {
		FacesMessage msg = new FacesMessage("Seleccionado",((Producto) event.getObject()).getProdNombre());
		FacesContext.getCurrentInstance().addMessage(null, msg);
		agregarDetalle();
	}

	public void onRowUnSelectForm(SelectEvent event) {
		FacesMessage msg = new FacesMessage("No Seleccionado",
				(event.getObject()).toString());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

}
