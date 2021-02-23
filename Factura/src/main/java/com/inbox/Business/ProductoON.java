package com.inbox.Business;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import com.inbox.DAO.ProductoHome;
import com.inbox.Model.Producto;

/**
 * Session Bean implementation class ProductoON
 */
@Stateless
public class ProductoON implements ProductoONRemote, ProductoONLocal {
	
	@Inject
	ProductoHome productoDAO;
    /**
     * Default constructor. 
     */
    public ProductoON() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void crear(Producto prod) {
		productoDAO.persist(prod);
		
	}

	@Override
	public List<Producto> read() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Producto prod) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Producto prod) {
		// TODO Auto-generated method stub
		
	}

}
