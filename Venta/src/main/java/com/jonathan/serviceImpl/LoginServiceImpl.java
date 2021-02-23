package com.jonathan.serviceImpl;

import com.jonathan.dao.LoginDao;
import com.jonathan.daoImpl.LoginDaoImpl;
import com.jonathan.modelo.Usuarios;
import com.jonathan.service.LoginService;

public class LoginServiceImpl implements LoginService {

	@Override
	public Usuarios buscarUsuario(Usuarios usuarios) {
		LoginDao loginDao = new LoginDaoImpl();
		Usuarios usuarios2 = null;
		usuarios2 = loginDao.buscarUsuario(usuarios);
		return usuarios2;
	}

}
