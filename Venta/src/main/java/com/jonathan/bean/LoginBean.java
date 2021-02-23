package com.jonathan.bean;

import java.awt.event.ActionEvent;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.primefaces.context.RequestContext;

import com.jonathan.modelo.Usuarios;
import com.jonathan.service.LoginService;
import com.jonathan.serviceImpl.LoginServiceImpl;
import com.jonathan.util.MyUtil;

@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = -4617293169094584172L;
	
	private Usuarios usuarios = new Usuarios();
	private LoginService loginService;

	public LoginBean() {
		this.loginService = new LoginServiceImpl();
		if (this.usuarios == null) {
			this.usuarios = new Usuarios();
		}
	}

	public Usuarios getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Usuarios usuarios) {
		this.usuarios = usuarios;
	}

	public LoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}
	
	public void login(ActionEvent actionEvent){
		RequestContext requestContext = RequestContext.getCurrentInstance();
		FacesMessage msg;
		boolean loggedIn;
		String ruta = "";
		this.usuarios = this.loginService.buscarUsuario(this.usuarios);
		if(this.usuarios != null){
			loggedIn = true;
//			loggedIn = loginService.estadoActivo(this.rygUsuarios);
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuLogin", this.usuarios.getUsNombres());
			msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Bienvenido",this.usuarios.getUsNombres());
			ruta = MyUtil.basePathLogin() + "views/principal.xhtml";
		}else{
			loggedIn = false;
			msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Error de Logeo","Usuario y/o Contraseña Incorrectos");
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
		requestContext.addCallbackParam("loggedIn", loggedIn);
		requestContext.addCallbackParam("ruta", ruta);
	}
	
	public void logout(){
		String ruta = MyUtil.basePathLogin() + "inicio.xhtml";
		RequestContext context = RequestContext.getCurrentInstance();
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
		session.invalidate();
		context.addCallbackParam("loggedOut", true);
		context.addCallbackParam("ruta", ruta);
	}
	
	public void logout2(ActionEvent actionEvent){
		String ruta = MyUtil.basePathLogin() + "inicio.xhtml";
		RequestContext context = RequestContext.getCurrentInstance();
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
		session.invalidate();
		context.addCallbackParam("loggedOut", true);
		context.addCallbackParam("ruta", ruta);
	}

}
