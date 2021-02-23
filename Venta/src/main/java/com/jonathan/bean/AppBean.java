package com.jonathan.bean;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import com.jonathan.util.MyUtil;

@ManagedBean(name = "appBean")
@ApplicationScoped
public class AppBean {

	public AppBean() {

	}

	public String getBaseUrl() {
		return MyUtil.baseUrl();
	}

	public String getBasePath() {
		return MyUtil.basePath();
	}

	public String venta() {
		return "/views/nventa.xhtml";
	}

}
