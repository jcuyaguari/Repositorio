package com.michis.app.modelo;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author juan
 */
@Entity
@Table(name = "sintomas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sintomas.findAll", query = "SELECT s FROM Sintomas s")
    , @NamedQuery(name = "Sintomas.findBySinId", query = "SELECT s FROM Sintomas s WHERE s.sinId = :sinId")
    , @NamedQuery(name = "Sintomas.findBySinDescripcion", query = "SELECT s FROM Sintomas s WHERE s.sinDescripcion = :sinDescripcion")})
public class Sintomas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sin_id")
    private Integer sinId;
    @Column(name = "sin_descripcion")
    private String sinDescripcion;
    @JoinColumn(name = "sin_paciente_fk", referencedColumnName = "paci_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Paciente sinPacienteFk;

    public Sintomas() {
    }

    public Sintomas(Integer sinId) {
        this.sinId = sinId;
    }

    public Integer getSinId() {
        return sinId;
    }

    public void setSinId(Integer sinId) {
        this.sinId = sinId;
    }

    public String getSinDescripcion() {
        return sinDescripcion;
    }

    public void setSinDescripcion(String sinDescripcion) {
        this.sinDescripcion = sinDescripcion;
    }

    public Paciente getSinPacienteFk() {
        return sinPacienteFk;
    }

    public void setSinPacienteFk(Paciente sinPacienteFk) {
        this.sinPacienteFk = sinPacienteFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sinId != null ? sinId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sintomas)) {
            return false;
        }
        Sintomas other = (Sintomas) object;
        if ((this.sinId == null && other.sinId != null) || (this.sinId != null && !this.sinId.equals(other.sinId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "comsultorio.Sintomas[ sinId=" + sinId + " ]";
    }
    
}
