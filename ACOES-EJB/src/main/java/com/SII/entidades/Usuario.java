/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SII.entidades;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
        @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
        @NamedQuery(name = "Usuario.findByIdUsuario", query = "SELECT u FROM Usuario u WHERE u.idUsuario = :idUsuario"),
        @NamedQuery(name = "Usuario.findByNombreUsuario", query = "SELECT u FROM Usuario u WHERE u.nombreUsuario = :nombreUsuario"),
        @NamedQuery(name = "Usuario.findByContrasenna", query = "SELECT u FROM Usuario u WHERE u.contrasenna = :contrasenna"),
        @NamedQuery(name = "Usuario.findByRol", query = "SELECT u FROM Usuario u WHERE u.rol = :rol")})
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_USUARIO")
    private Integer idUsuario;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "NOMBRE_USUARIO")
    private String nombreUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    private String contrasenna;
    @Basic(optional = false)
    @NotNull
    private Character rol;
    @ManyToMany(mappedBy = "usuarioSet")
    private Set<Notificacion> notificacionSet;
    @OneToOne(mappedBy = "usuarioNombreUsuario")
    private Socio socio;
    @OneToMany(mappedBy = "usuarioNombreUsuario")
    private Set<Beneficiario> beneficiarioSet;
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

    public Usuario(String nombreUsuario, int idUsuario, String contrasenna, Character rol) {
        this.nombreUsuario = nombreUsuario;
        this.idUsuario = idUsuario;
        this.contrasenna = contrasenna;
        this.rol = rol;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
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

    public Character getRol() {
        return rol;
    }

    public void setRol(Character rol) {
        this.rol = rol;
    }

    @XmlTransient
    public Set<Notificacion> getNotificacionSet() {
        return notificacionSet;
    }

    public void setNotificacionSet(Set<Notificacion> notificacionSet) {
        this.notificacionSet = notificacionSet;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    @XmlTransient
    public Set<Beneficiario> getBeneficiarioSet() {
        return beneficiarioSet;
    }

    public void setBeneficiarioSet(Set<Beneficiario> beneficiarioSet) {
        this.beneficiarioSet = beneficiarioSet;
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
        return "Entidades.Usuario[ nombreUsuario=" + nombreUsuario + " ]";
    }

}