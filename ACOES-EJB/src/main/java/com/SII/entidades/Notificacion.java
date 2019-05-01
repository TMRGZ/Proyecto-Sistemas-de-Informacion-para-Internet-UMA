/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SII.entidades;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.Set;

/**
 * @author MiguelRuiz
 */
@Entity
@Table(name = "NOTIFICACION")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Notificacion.findAll", query = "SELECT n FROM Notificacion n"),
        @NamedQuery(name = "Notificacion.findById", query = "SELECT n FROM Notificacion n WHERE n.id = :id"),
        @NamedQuery(name = "Notificacion.findByUsuarioReceptor", query = "SELECT n FROM Notificacion n WHERE n.usuarioReceptor = :usuarioReceptor"),
        @NamedQuery(name = "Notificacion.findByUsuarioEmisor", query = "SELECT n FROM Notificacion n WHERE n.usuarioEmisor = :usuarioEmisor"),
        @NamedQuery(name = "Notificacion.findByFecha", query = "SELECT n FROM Notificacion n WHERE n.fecha = :fecha")})
public class Notificacion implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "USUARIO_RECEPTOR")
    private BigInteger usuarioReceptor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "USUARIO_EMISOR")
    private BigInteger usuarioEmisor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @JoinTable(name = "USUARIO_NOTIFICACION", joinColumns = {
            @JoinColumn(name = "NOTIFICACION_ID", referencedColumnName = "ID")}, inverseJoinColumns = {
            @JoinColumn(name = "USUARIO_ID_USUARIO", referencedColumnName = "ID_USUARIO")})
    @ManyToMany
    private Set<Usuario> usuarioSet;

    public Notificacion() {
    }

    public Notificacion(BigDecimal id) {
        this.id = id;
    }

    public Notificacion(BigDecimal id, BigInteger usuarioReceptor, BigInteger usuarioEmisor, Date fecha) {
        this.id = id;
        this.usuarioReceptor = usuarioReceptor;
        this.usuarioEmisor = usuarioEmisor;
        this.fecha = fecha;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getUsuarioReceptor() {
        return usuarioReceptor;
    }

    public void setUsuarioReceptor(BigInteger usuarioReceptor) {
        this.usuarioReceptor = usuarioReceptor;
    }

    public BigInteger getUsuarioEmisor() {
        return usuarioEmisor;
    }

    public void setUsuarioEmisor(BigInteger usuarioEmisor) {
        this.usuarioEmisor = usuarioEmisor;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @XmlTransient
    public Set<Usuario> getUsuarioSet() {
        return usuarioSet;
    }

    public void setUsuarioSet(Set<Usuario> usuarioSet) {
        this.usuarioSet = usuarioSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Notificacion)) {
            return false;
        }
        Notificacion other = (Notificacion) object;
        return (this.id != null || other.id == null) && (this.id == null || this.id.equals(other.id));
    }

    @Override
    public String toString() {
        return "Entidades.Notificacion[ id=" + id + " ]";
    }

}
