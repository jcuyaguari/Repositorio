package com.inbox.Business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.inbox.DAO.FacturaHome;
import com.inbox.Model.Factura;

@Stateless
public class FacturaON implements FacturaONLocal, FacturaONRemoto {
	@Inject
	FacturaHome facDAO;

	@Override
	public void crear(Factura fac) {
		facDAO.persist(fac);
	}

	@Override
	public List<Factura> read() {
		return facDAO.findAll();
	}

	@Override
	public void update(Factura fac) {
		facDAO.merge(fac);
	}

	@Override
	public void delete(Factura fac) {
		facDAO.remove(fac);
	}
	
}
