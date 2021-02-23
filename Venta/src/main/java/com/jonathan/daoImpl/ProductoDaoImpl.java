package com.jonathan.daoImpl;

import java.util.List;

import org.hibernate.Session;

import com.jonathan.dao.ProductoDao;
import com.jonathan.modelo.Producto;
import com.jonathan.util.HibernateUtil;

public class ProductoDaoImpl implements ProductoDao{

	@SuppressWarnings("unchecked")
	@Override
	public List<Producto> findAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Producto> productos = null;
		try {
			session.getTransaction().begin();
			productos = session.createCriteria(Producto.class).list();
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
		session.close();
		return productos;
	}

}
