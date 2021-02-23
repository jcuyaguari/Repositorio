package com.jonathan.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

import com.jonathan.modelo.Producto;
import com.jonathan.service.ProductoService;
import com.jonathan.serviceImpl.ProductoServiceImpl;

@ManagedBean(name = "productoBean")
@RequestScoped
public class ProductoBean {

	private Producto producto = new Producto();
	private List<Producto> productos;

	public ProductoBean() {

	}

	@PostConstruct
	public void init() {
		ProductoService productoService = new ProductoServiceImpl();
		this.productos = productoService.findAll();
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	
	/*-----------------------Metodo onRowSelect--------------------*/
	public void onRowSelect(SelectEvent selectEvent) {
		System.out.println("Seleccionado");
	}

	public void onRowUnselect(UnselectEvent event) {
		System.out.println("No seleccionado");
	}

	public void onItemSelect(SelectEvent event) {
		producto.setProdId(Integer.parseInt(event.getObject().toString()));
	}
	/*--------------------------------------------------------------*/

}
