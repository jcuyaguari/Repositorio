package com.juan.MiPractica.Controler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import com.juan.MiPractica.ON.FerreteriaON;
import com.juan.MiPractica.modelo.Fproducto;
import com.juan.MiPractica.modelo.Fproveedores;

import javassist.expr.NewArray;

@ManagedBean
@ViewScoped
public class FerreteriaBeanController {

	@Inject
	FerreteriaON ferreteriaON;
	private String nomProveedor;
	private List<Fproducto> listaproducto = new ArrayList<Fproducto>();
	private Fproducto newprodcuto;
	private Fproveedores newproveedor;
	private List<Fproveedores> listaprovedor = new ArrayList<Fproveedores>();
		
	@PostConstruct
	public void init() {
		newprodcuto = new Fproducto();
		newproveedor = new Fproveedores();
		//listaprove = new ArrayList<Fproveedores>();
		getInventario();
		
		getProveedor();
	}

	public List<Fproducto> getListaproducto() {
		return listaproducto;
	}

	public void setListaproducto(List<Fproducto> listaproducto) {
		this.listaproducto = listaproducto;
	}

	public Fproducto getNewprodcuto() {
		return newprodcuto;
	}


	public void setNewprodcuto(Fproducto newprodcuto) {
		this.newprodcuto = newprodcuto;
	}

	public List<Fproveedores> getListaprovedor() {
		return listaprovedor;
	}


	public void setListaprovedor(List<Fproveedores> listaprovedor) {
		this.listaprovedor = listaprovedor;
	}


	public Fproveedores getNewproveedor() {
		return newproveedor;
	}

	public void setNewproveedor(Fproveedores newproveedor) {
		this.newproveedor = newproveedor;
	}

	public String getNomProveedor() {
		return nomProveedor;
	}

	public void setNomProveedor(String nomProveedor) {
		this.nomProveedor = nomProveedor;
	}

	public String getInventario() {
		listaproducto = ferreteriaON.getInventario();
		return null;
	}
	
	public String hola() {
		System.out.println("hola");
		
		return null;
	}
	
	public String guardarProducto() {
		newprodcuto.setProvId(newproveedor);
		ferreteriaON.insertarProducto(newprodcuto);
		return null;
	}
	
	public String getProveedor() {
		listaprovedor = ferreteriaON.getProveedores();
		return null;
	}
	
}
