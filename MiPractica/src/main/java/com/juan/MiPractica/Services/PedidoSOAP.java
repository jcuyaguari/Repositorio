package com.juan.MiPractica.Services;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;

import com.juan.MiPractica.ON.FerreteriaON;

@WebService
public class PedidoSOAP {
	@Inject
	FerreteriaON FerreteriaON;
	
	@WebMethod
	public String pedido(int idproducto, int stock) {
		
	return null;
	}
	
}
