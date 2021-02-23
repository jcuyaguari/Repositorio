package com.jonathan.bean;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpSession;

public class AuthorizationListener implements PhaseListener {

	private static final long serialVersionUID = -6803217321351122027L;

	@Override
	public void afterPhase(PhaseEvent event) {
		FacesContext facesContext = event.getFacesContext();
		String currentPage = facesContext.getViewRoot().getViewId();
		boolean isLoginPage = (currentPage.lastIndexOf("/inicio.xhtml") > -1) ? true : false;
		HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
		Object usuario = session.getAttribute("usuLogin");
		
		if(!isLoginPage && usuario == null){
			NavigationHandler navigationHandler = facesContext.getApplication().getNavigationHandler();
			navigationHandler.handleNavigation(facesContext, null, "/inicio.xhtml");
		}
	}

	@Override
	public void beforePhase(PhaseEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}

}
