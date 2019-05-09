/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SII.entidades;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Set;

/**
 *
 * @author MiguelRuiz
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findByNombreUsuario", query = "SELECT u FROM Usuario u WHERE u.nombreUsuario = :nombreUsuario")
    , @NamedQuery(name = "Usuario.findByContrasenna", query = "SELECT u FROM Usuario u WHERE u.contrasenna = :contrasenna")
    , @NamedQuery(name = "Usuario.findByRol", query = "SELECT u FROM Usuario u WHERE u.rol = :rol")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "NOMBRE_USUARIO", nullable = false, length = 40)
    private String nombreUsuario;
    @Basic(optional = false)
    @Column(nullable = false, length = 40)
    private String contrasenna;
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer rol;
    @ManyToMany(mappedBy = "usuarioSet")
    private Set<Notificacion> notificacionSet;
    @JoinColumn(name = "BENEFICIARIO_CODIGO", referencedColumnName = "CODIGO")
    @OneToOne
    private Beneficiario beneficiarioCodigo;
    @JoinColumn(name = "SOCIO_NUMERO", referencedColumnName = "NUMERO")
    @OneToOne
    private Socio socioNumero;

    public Usuario() {
    }

    public Usuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public Usuario(String nombreUsuario, String contrasenna, Integer rol) {
        this.nombreUsuario = nombreUsuario;
        this.contrasenna = contrasenna;
        this.rol = rol;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasenna() {
        return contrasenna;
    }

    public void setContrasenna(String contrasenna) {
        this.contrasenna = contrasenna;
    }

    public Integer getRol() {
        return rol;
    }

    public void setRol(Integer rol) {
        this.rol = rol;
    }

    @XmlTransient
    public Set<Notificacion> getNotificacionSet() {
        return notificacionSet;
    }

    public void setNotificacionSet(Set<Notificacion> notificacionSet) {
        this.notificacionSet = notificacionSet;
    }

    public Beneficiario getBeneficiarioCodigo() {
        return beneficiarioCodigo;
    }

    public void setBeneficiarioCodigo(Beneficiario beneficiarioCodigo) {
        this.beneficiarioCodigo = beneficiarioCodigo;
    }

    public Socio getSocioNumero() {
        return socioNumero;
    }

    public void setSocioNumero(Socio socioNumero) {
        this.socioNumero = socioNumero;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nombreUsuario != null ? nombreUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        return (this.nombreUsuario != null || other.nombreUsuario == null) && (this.nombreUsuario == null || this.nombreUsuario.equals(other.nombreUsuario));
    }

    @Override
    public String toString() {
        return "javaapplication1.Usuario[ nombreUsuario=" + nombreUsuario + " ]";
    }
    
}
