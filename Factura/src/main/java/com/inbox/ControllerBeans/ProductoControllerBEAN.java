package com.inbox.ControllerBeans;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import com.inbox.Business.ProductoONLocal;
import com.inbox.Model.Producto;

@ManagedBean
@ViewScoped
public class ProductoControllerBEAN {
	
	@Inject
	private ProductoONLocal productoON;
	
	private Producto newProducto;
	
	@PostConstruct
	public void init() {
		newProducto = new Producto();
	}

	public Producto getNewProducto() {
		return newProducto;
	}

	public void setNewProducto(Producto newProducto) {
		this.newProducto = newProducto;
	}
	
	public String guardarProducto() {
		productoON.crear(newProducto);
		return null;
	}
	
}
