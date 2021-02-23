package com.juan.MiPractica.ON;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.juan.MiPractica.DAO.FerreteriaDAO;
import com.juan.MiPractica.DAO.ProductoDAO;
import com.juan.MiPractica.modelo.Fproducto;
import com.juan.MiPractica.modelo.Fproveedores;


@Stateless
public class FerreteriaON {

	@Inject
	FerreteriaDAO ferreteriaDAO;
	
	@Inject
	ProductoDAO productoDAO;
	
	public List<Fproducto> getInventario(){
		return ferreteriaDAO.getInventario();
		
	}
	
	public void insertarProducto(Fproducto producto) {
		productoDAO.insertarProdcutos(producto);
	}
	
	public List<Fproveedores> getProveedores(){
		return ferreteriaDAO.getproveedores();
		
	}
	
}
