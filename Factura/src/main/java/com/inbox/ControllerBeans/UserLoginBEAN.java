package com.inbox.ControllerBeans;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import com.inbox.Business.LoginONLocal;
import com.inbox.Model.Usuariosistema;

@ManagedBean
@ViewScoped
public class UserLoginBEAN {
	
	@Inject
	private LoginONLocal  userLoginON;
	
	private Usuariosistema newUsuarioSistema;
	
	@PostConstruct
	public void init() {
		newUsuarioSistema = new Usuariosistema();
	}

	public Usuariosistema getNewUsuarioSistema() {
		return newUsuarioSistema;
	}

	public void setNewUsuarioSistema(Usuariosistema newUsuarioSistema) {
		this.newUsuarioSistema = newUsuarioSistema;
	}
	
	public String Login() {
		System.out.println("Se llama al login"+ newUsuarioSistema.getUserEmail());
		
		newUsuarioSistema = userLoginON.read(newUsuarioSistema);
		if (newUsuarioSistema!=null) {
			System.out.println("Entro al SISTEMA");
			return "index.xhtml";
		}else {
		System.out.println("ERROR de CONATRASEÑA");
		return "login.xhtml";
		}
	}
	

}
