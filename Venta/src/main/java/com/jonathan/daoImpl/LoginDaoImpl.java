package com.jonathan.daoImpl;

import org.hibernate.Session;

import com.jonathan.dao.LoginDao;
import com.jonathan.modelo.Usuarios;
import com.jonathan.util.HibernateUtil;

public class LoginDaoImpl implements LoginDao {

	@Override
	public Usuarios buscarUsuario(Usuarios usuarios) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Usuarios usuarioL = null;
		String sql = "from Usuarios where usLogin=:usu and usPassword=:pass";
		try {
			session.getTransaction().begin();
			usuarioL = (Usuarios) session.createQuery(sql)
					.setParameter("usu", usuarios.getUsLogin())
					.setParameter("pass", usuarios.getUsPassword())
					.uniqueResult();
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.out.println("Error de Logeo " + e.getMessage());
		}
		session.close();
		return usuarioL;
	}

}
