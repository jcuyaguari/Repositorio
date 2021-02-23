package com.inbox.Business;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import com.inbox.DAO.UsuariosistemaHome;
import com.inbox.Model.Usuariosistema;

/**
 * Session Bean implementation class LoginON
 */
@Stateless
public class LoginON implements LoginONRemote, LoginONLocal {
	@Inject
	UsuariosistemaHome userDAO;
    /**
     * Default constructor. 
     */
    public LoginON() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void crear(Usuariosistema user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Usuariosistema read(Usuariosistema user) {
		return userDAO.findByPassword(user);
	}

	
}
