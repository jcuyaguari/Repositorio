package com.michis.app.modelo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author juan
 */
@Entity
@Table(name = "paciente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paciente.findAll", query = "SELECT p FROM Paciente p")
    , @NamedQuery(name = "Paciente.findByPaciId", query = "SELECT p FROM Paciente p WHERE p.paciId = :paciId")
    , @NamedQuery(name = "Paciente.findByPaciCedula", query = "SELECT p FROM Paciente p WHERE p.paciCedula = :paciCedula")
    , @NamedQuery(name = "Paciente.findByPaciNombre", query = "SELECT p FROM Paciente p WHERE p.paciNombre = :paciNombre")
    , @NamedQuery(name = "Paciente.findByPaciEdad", query = "SELECT p FROM Paciente p WHERE p.paciEdad = :paciEdad")
    , @NamedQuery(name = "Paciente.findByPaciFechanac", query = "SELECT p FROM Paciente p WHERE p.paciFechanac = :paciFechanac")
    , @NamedQuery(name = "Paciente.findByPaciPeso", query = "SELECT p FROM Paciente p WHERE p.paciPeso = :paciPeso")})
public class Paciente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "paci_id")
    private Integer paciId;
    @Column(name = "paci_cedula")
    private String paciCedula;
    @Column(name = "paci_nombre")
    private String paciNombre;
    @Column(name = "paci_edad")
    private Integer paciEdad;
    @Column(name = "paci_fechanac")
    @Temporal(TemporalType.DATE)
    private Date paciFechanac;
    @Column(name = "paci_peso")
    private String paciPeso;
    @OneToMany(mappedBy = "sinPacienteFk", fetch = FetchType.EAGER)
    private List<Sintomas> sintomasList;

    public Paciente() {
    }

    public Paciente(Integer paciId) {
        this.paciId = paciId;
    }

    public Integer getPaciId() {
        return paciId;
    }

    public void setPaciId(Integer paciId) {
        this.paciId = paciId;
    }

    public String getPaciCedula() {
        return paciCedula;
    }

    public void setPaciCedula(String paciCedula) {
        this.paciCedula = paciCedula;
    }

    public String getPaciNombre() {
        return paciNombre;
    }

    public void setPaciNombre(String paciNombre) {
        this.paciNombre = paciNombre;
    }

    public Integer getPaciEdad() {
        return paciEdad;
    }

    public void setPaciEdad(Integer paciEdad) {
        this.paciEdad = paciEdad;
    }

    public Date getPaciFechanac() {
        return paciFechanac;
    }

    public void setPaciFechanac(Date paciFechanac) {
        this.paciFechanac = paciFechanac;
    }

    public String getPaciPeso() {
        return paciPeso;
    }

    public void setPaciPeso(String paciPeso) {
        this.paciPeso = paciPeso;
    }

    @XmlTransient
    public List<Sintomas> getSintomasList() {
        return sintomasList;
    }

    public void setSintomasList(List<Sintomas> sintomasList) {
        this.sintomasList = sintomasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (paciId != null ? paciId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paciente)) {
            return false;
        }
        Paciente other = (Paciente) object;
        if ((this.paciId == null && other.paciId != null) || (this.paciId != null && !this.paciId.equals(other.paciId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "comsultorio.Paciente[ paciId=" + paciId + " ]";
    }
    
}
