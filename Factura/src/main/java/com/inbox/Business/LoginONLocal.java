package com.inbox.Business;

import java.util.List;

import javax.ejb.Local;

import com.inbox.Model.Usuariosistema;

@Local
public interface LoginONLocal {
	public void crear(Usuariosistema user);
	public Usuariosistema read(Usuariosistema user);
}
