package com.jonathan.daoImpl;

import org.hibernate.Session;

import com.jonathan.dao.VentaDao;
import com.jonathan.modelo.Venta;
import com.jonathan.util.HibernateUtil;

public class VentaDaoImpl implements VentaDao {

	@Override
	public boolean create(Venta venta) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		boolean estado = false;
		try {
			session.getTransaction().begin();
			session.save(venta);
			session.getTransaction().commit();
			estado = true;
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.out.println("Error al registrar venta " + e.getMessage());
			estado = false;
		}
		session.close();
		return estado;
	}

}
