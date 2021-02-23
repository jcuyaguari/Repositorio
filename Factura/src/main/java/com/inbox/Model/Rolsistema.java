package com.inbox.Model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the rolsistema database table.
 * 
 */
@Entity
@NamedQuery(name="Rolsistema.findAll", query="SELECT r FROM Rolsistema r")
public class Rolsistema implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="rol_id")
	private Integer rolId;

	@Column(name="rol_codigo")
	private String rolCodigo;

	@Column(name="rol_descripcion")
	private String rolDescripcion;

	@Column(name="rol_estado")
	private String rolEstado;

	@Temporal(TemporalType.DATE)
	@Column(name="rol_fechafin")
	private Date rolFechafin;

	@Temporal(TemporalType.DATE)
	@Column(name="rol_fechainicio")
	private Date rolFechainicio;

	//bi-directional many-to-one association to Usuariosistema
	@OneToMany(mappedBy="rolsistema", fetch=FetchType.EAGER)
	private List<Usuariosistema> usuariosistemas;

	public Rolsistema() {
	}

	public Integer getRolId() {
		return this.rolId;
	}

	public void setRolId(Integer rolId) {
		this.rolId = rolId;
	}

	public String getRolCodigo() {
		return this.rolCodigo;
	}

	public void setRolCodigo(String rolCodigo) {
		this.rolCodigo = rolCodigo;
	}

	public String getRolDescripcion() {
		return this.rolDescripcion;
	}

	public void setRolDescripcion(String rolDescripcion) {
		this.rolDescripcion = rolDescripcion;
	}

	public String getRolEstado() {
		return this.rolEstado;
	}

	public void setRolEstado(String rolEstado) {
		this.rolEstado = rolEstado;
	}

	public Date getRolFechafin() {
		return this.rolFechafin;
	}

	public void setRolFechafin(Date rolFechafin) {
		this.rolFechafin = rolFechafin;
	}

	public Date getRolFechainicio() {
		return this.rolFechainicio;
	}

	public void setRolFechainicio(Date rolFechainicio) {
		this.rolFechainicio = rolFechainicio;
	}

	public List<Usuariosistema> getUsuariosistemas() {
		return this.usuariosistemas;
	}

	public void setUsuariosistemas(List<Usuariosistema> usuariosistemas) {
		this.usuariosistemas = usuariosistemas;
	}

	public Usuariosistema addUsuariosistema(Usuariosistema usuariosistema) {
		getUsuariosistemas().add(usuariosistema);
		usuariosistema.setRolsistema(this);

		return usuariosistema;
	}

	public Usuariosistema removeUsuariosistema(Usuariosistema usuariosistema) {
		getUsuariosistemas().remove(usuariosistema);
		usuariosistema.setRolsistema(null);

		return usuariosistema;
	}

}