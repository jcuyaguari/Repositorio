package com.jonathan.serviceImpl;

import java.util.List;

import com.jonathan.dao.ProductoDao;
import com.jonathan.daoImpl.ProductoDaoImpl;
import com.jonathan.modelo.Producto;
import com.jonathan.service.ProductoService;

public class ProductoServiceImpl implements ProductoService {

	@Override
	public List<Producto> findAll() {
		ProductoDao productoDao = new ProductoDaoImpl();
		List<Producto> productos = productoDao.findAll();
		return productos;
	}

}
