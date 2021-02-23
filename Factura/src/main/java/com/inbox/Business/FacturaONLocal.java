package com.inbox.Business;

import java.util.List;

import javax.ejb.Local;

import com.inbox.Model.Factura;

@Local
public interface FacturaONLocal {
	
	public void crear(Factura fac);
	
	public List <Factura> read();
	
	public void update(Factura fac);
	
	public void delete(Factura fac);

}
