package com.juan.negocio;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.juan.datos.ProductosDAO;
import com.juan.datos.RecetaDAO;
import com.juan.modelo.Productos;
import com.juan.modelo.Receta;
import com.juan.modelo.RecetaDetalle;

@Stateless
public class RecetaON {

	@Inject
	ProductosDAO productosDAO;
	
	@Inject
	RecetaDAO recetaDao;
	
	public void insertarReceta(Receta receta) {
		recetaDao.insertarReceta(receta);
//		for (RecetaDetalle recetaDetalle : detalle) {
//			recetaDao.insertarDetalle(detalle);
//		}
		
	}
	
	public List<Receta> getRecetas(String codigo){
		
		return recetaDao.getReceta(codigo);
	}
	
	public List<Productos> getProductos(String filtro){
		
		return productosDAO.getProductos(filtro);
	}
}
