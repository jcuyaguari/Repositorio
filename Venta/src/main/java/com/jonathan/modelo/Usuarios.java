package com.jonathan.modelo;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios", catalog = "bd_venta")
public class Usuarios implements java.io.Serializable {

	private static final long serialVersionUID = -5039256458266363693L;
	
	private Integer usId;
	private String usLogin;
	private String usPassword;
	private String usNombres;
	private String usCodvendedor;
	private String usAnexo;
	private String usPerfil;
	private Integer usEstado;
	private Boolean usActivo;
	private Set<Venta> ventas = new HashSet<Venta>(0);

	public Usuarios() {
	}

	public Usuarios(int usId) {
		this.usId = usId;
	}

	public Usuarios(String usLogin, String usPassword, String usNombres,
			String usCodvendedor, String usAnexo, String usPerfil,
			Integer usEstado, Boolean usActivo, Set<Venta> ventas) {
		this.usLogin = usLogin;
		this.usPassword = usPassword;
		this.usNombres = usNombres;
		this.usCodvendedor = usCodvendedor;
		this.usAnexo = usAnexo;
		this.usPerfil = usPerfil;
		this.usEstado = usEstado;
		this.usActivo = usActivo;
		this.ventas = ventas;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "us_id", unique = true, nullable = false)
	public Integer getUsId() {
		return this.usId;
	}

	public void setUsId(Integer usId) {
		this.usId = usId;
	}

	@Column(name = "us_login", length = 15)
	public String getUsLogin() {
		return this.usLogin;
	}

	public void setUsLogin(String usLogin) {
		this.usLogin = usLogin;
	}

	@Column(name = "us_password", length = 15)
	public String getUsPassword() {
		return this.usPassword;
	}

	public void setUsPassword(String usPassword) {
		this.usPassword = usPassword;
	}

	@Column(name = "us_nombres", length = 45)
	public String getUsNombres() {
		return this.usNombres;
	}

	public void setUsNombres(String usNombres) {
		this.usNombres = usNombres;
	}

	@Column(name = "us_codvendedor", length = 10)
	public String getUsCodvendedor() {
		return this.usCodvendedor;
	}

	public void setUsCodvendedor(String usCodvendedor) {
		this.usCodvendedor = usCodvendedor;
	}

	@Column(name = "us_anexo", length = 6)
	public String getUsAnexo() {
		return this.usAnexo;
	}

	public void setUsAnexo(String usAnexo) {
		this.usAnexo = usAnexo;
	}

	@Column(name = "us_perfil", length = 15)
	public String getUsPerfil() {
		return this.usPerfil;
	}

	public void setUsPerfil(String usPerfil) {
		this.usPerfil = usPerfil;
	}

	@Column(name = "us_estado")
	public Integer getUsEstado() {
		return this.usEstado;
	}

	public void setUsEstado(Integer usEstado) {
		this.usEstado = usEstado;
	}

	@Column(name = "us_activo")
	public Boolean getUsActivo() {
		return this.usActivo;
	}

	public void setUsActivo(Boolean usActivo) {
		this.usActivo = usActivo;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuarios")
	public Set<Venta> getVentas() {
		return this.ventas;
	}

	public void setVentas(Set<Venta> ventas) {
		this.ventas = ventas;
	}

}
