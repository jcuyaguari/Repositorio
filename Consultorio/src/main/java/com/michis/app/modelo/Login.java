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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author juan
 */
@Entity
@Table(name = "login")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Login.findAll", query = "SELECT l FROM Login l")
    , @NamedQuery(name = "Login.findByLogId", query = "SELECT l FROM Login l WHERE l.logId = :logId")
    , @NamedQuery(name = "Login.findByLogUsuario", query = "SELECT l FROM Login l WHERE l.logUsuario = :logUsuario")
    , @NamedQuery(name = "Login.findByLogContrasena", query = "SELECT l FROM Login l WHERE l.logContrasena = :logContrasena")
    , @NamedQuery(name = "Login.findByLogHora", query = "SELECT l FROM Login l WHERE l.logHora = :logHora")})
public class Login implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "log_id")
    private Integer logId;
    @Column(name = "log_usuario")
    private String logUsuario;
    @Column(name = "log_contrasena")
    private String logContrasena;
    @Column(name = "log_hora")
    private String logHora;

    public Login() {
    }

    public Login(Integer logId) {
        this.logId = logId;
    }

    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public String getLogUsuario() {
        return logUsuario;
    }

    public void setLogUsuario(String logUsuario) {
        this.logUsuario = logUsuario;
    }

    public String getLogContrasena() {
        return logContrasena;
    }

    public void setLogContrasena(String logContrasena) {
        this.logContrasena = logContrasena;
    }

    public String getLogHora() {
        return logHora;
    }

    public void setLogHora(String logHora) {
        this.logHora = logHora;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (logId != null ? logId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Login)) {
            return false;
        }
        Login other = (Login) object;
        if ((this.logId == null && other.logId != null) || (this.logId != null && !this.logId.equals(other.logId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "comsultorio.Login[ logId=" + logId + " ]";
    }
    
}
