package com.inbox.Business;

import java.util.List;

import javax.ejb.Remote;

import com.inbox.Model.Factura;

@Remote
public interface FacturaONRemoto {
	
	public void crear(Factura fac);
	
	public List <Factura> read();
	
	public void update(Factura fac);
	
	public void delete(Factura fac);

}
