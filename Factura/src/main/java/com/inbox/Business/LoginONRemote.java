package com.inbox.Business;

import java.util.List;

import javax.ejb.Remote;

import com.inbox.Model.Usuariosistema;

@Remote
public interface LoginONRemote {
	public void crear(Usuariosistema user);
	public Usuariosistema read(Usuariosistema user);
}
