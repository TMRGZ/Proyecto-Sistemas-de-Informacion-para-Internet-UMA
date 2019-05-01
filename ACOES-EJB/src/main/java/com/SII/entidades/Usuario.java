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
import java.math.BigDecimal;
import java.util.Set;

/**
 *
 * @author MiguelRuiz
 */
@Entity
@Table(name = "USUARIO")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
        @NamedQuery(name = "Usuario.findByIdUsuario", query = "SELECT u FROM Usuario u WHERE u.idUsuario = :idUsuario"),
        @NamedQuery(name = "Usuario.findByNombreUsuario", query = "SELECT u FROM Usuario u WHERE u.nombreUsuario = :nombreUsuario"),
        @NamedQuery(name = "Usuario.findByContrasenna", query = "SELECT u FROM Usuario u WHERE u.contrasenna = :contrasenna"),
        @NamedQuery(name = "Usuario.findByRol", query = "SELECT u FROM Usuario u WHERE u.rol = :rol")})
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_USUARIO")
    private BigDecimal idUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "NOMBRE_USUARIO")
    private String nombreUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "CONTRASENNA")
    private String contrasenna;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ROL")
    private Rol rol;
    @ManyToMany(mappedBy = "usuarioSet")
    private Set<Notificacion> notificacionSet;
    @JoinColumn(name = "BENEFICIARIO_CODIGO", referencedColumnName = "CODIGO")
    @OneToOne(optional = false)
    private Beneficiario beneficiarioCodigo;
    @JoinColumn(name = "SOCIO_NUMERO", referencedColumnName = "NUMERO")
    @OneToOne(optional = false)
    private Socio socioNumero;

    public Usuario(BigDecimal idUsuario, String nombreUsuario, String contrasenna, Rol rol) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.contrasenna = contrasenna;
        this.rol = rol;
    }

    public Usuario() {
    }

    public Usuario(BigDecimal idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario(BigDecimal idUsuario, String nombreUsuario, String contrasenna) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.contrasenna = contrasenna;
        this.rol = null;
    }

    public Rol getRol() {
        return rol;
    }

    public BigDecimal getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(BigDecimal idUsuario) {
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

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public enum Rol {
        ADMINISTRADOR,
        NORMAL
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
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        return (this.idUsuario != null || other.idUsuario == null) && (this.idUsuario == null || this.idUsuario.equals(other.idUsuario));
    }

    @Override
    public String toString() {
        return "Entidades.Usuario[ idUsuario=" + idUsuario + " ]";
    }

}
