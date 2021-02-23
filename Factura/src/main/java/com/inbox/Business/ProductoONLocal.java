package com.inbox.Business;

import java.util.List;

import javax.ejb.Local;

import com.inbox.Model.Producto;

@Local
public interface ProductoONLocal {
	public void crear(Producto prod);
	
	public List <Producto> read();
	
	public void update(Producto prod);
	
	public void delete(Producto prod);
}
