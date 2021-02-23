package com.jonathan.serviceImpl;

import com.jonathan.dao.VentaDao;
import com.jonathan.daoImpl.VentaDaoImpl;
import com.jonathan.modelo.Venta;
import com.jonathan.service.VentaService;

public class VentaServiceImpl implements VentaService {

	@Override
	public boolean create(Venta venta) {
		VentaDao ventaDao = new VentaDaoImpl();
		boolean estado = false;
		if (ventaDao.create(venta)) {
			estado = true;
		} else {
			estado = false;
		}
		return estado;
	}

}
