package com.inbox.Model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the usuariosistema database table.
 * 
 */
@Entity
@NamedQuery(name="Usuariosistema.findAll", query="SELECT u FROM Usuariosistema u")
public class Usuariosistema implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	private Integer userId;

	@Column(name="user_apellidos")
	private String userApellidos;

	@Column(name="user_cedula")
	private String userCedula;

	@Column(name="user_celular")
	private String userCelular;

	@Column(name="user_codigo")
	private String userCodigo;

	@Column(name="user_email")
	private String userEmail;

	@Column(name="user_nombres")
	private String userNombres;

	@Column(name="user_password")
	private String userPassword;

	@Column(name="user_tipodoc")
	private String userTipodoc;

	//bi-directional many-to-one association to Factura
	@OneToMany(mappedBy="usuariosistema", fetch=FetchType.EAGER)
	private List<Factura> facturas;

	//bi-directional many-to-one association to Rolsistema
	@ManyToOne
	@JoinColumn(name="rol_id_fk")
	private Rolsistema rolsistema;

	public Usuariosistema() {
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserApellidos() {
		return this.userApellidos;
	}

	public void setUserApellidos(String userApellidos) {
		this.userApellidos = userApellidos;
	}

	public String getUserCedula() {
		return this.userCedula;
	}

	public void setUserCedula(String userCedula) {
		this.userCedula = userCedula;
	}

	public String getUserCelular() {
		return this.userCelular;
	}

	public void setUserCelular(String userCelular) {
		this.userCelular = userCelular;
	}

	public String getUserCodigo() {
		return this.userCodigo;
	}

	public void setUserCodigo(String userCodigo) {
		this.userCodigo = userCodigo;
	}

	public String getUserEmail() {
		return this.userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserNombres() {
		return this.userNombres;
	}

	public void setUserNombres(String userNombres) {
		this.userNombres = userNombres;
	}

	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserTipodoc() {
		return this.userTipodoc;
	}

	public void setUserTipodoc(String userTipodoc) {
		this.userTipodoc = userTipodoc;
	}

	public List<Factura> getFacturas() {
		return this.facturas;
	}

	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}

	public Factura addFactura(Factura factura) {
		getFacturas().add(factura);
		factura.setUsuariosistema(this);

		return factura;
	}

	public Factura removeFactura(Factura factura) {
		getFacturas().remove(factura);
		factura.setUsuariosistema(null);

		return factura;
	}

	public Rolsistema getRolsistema() {
		return this.rolsistema;
	}

	public void setRolsistema(Rolsistema rolsistema) {
		this.rolsistema = rolsistema;
	}

}