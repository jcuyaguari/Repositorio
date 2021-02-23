package com.inbox.Business;

import java.util.List;

import javax.ejb.Remote;

import com.inbox.Model.Producto;

@Remote
public interface ProductoONRemote {
	
	public void crear(Producto prod);
	
	public List <Producto> read();
	
	public void update(Producto prod);
	
	public void delete(Producto prod);
	
}
