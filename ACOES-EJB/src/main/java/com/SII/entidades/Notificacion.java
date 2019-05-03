/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SII.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author MiguelRuiz
 */
@Entity
@Table(name = "NOTIFICACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Notificacion.findAll", query = "SELECT n FROM Notificacion n")
    , @NamedQuery(name = "Notificacion.findById", query = "SELECT n FROM Notificacion n WHERE n.id = :id")
    , @NamedQuery(name = "Notificacion.findByUsuarioReceptor", query = "SELECT n FROM Notificacion n WHERE n.usuarioReceptor = :usuarioReceptor")
    , @NamedQuery(name = "Notificacion.findByUsuarioEmisor", query = "SELECT n FROM Notificacion n WHERE n.usuarioEmisor = :usuarioEmisor")
    , @NamedQuery(name = "Notificacion.findByFecha", query = "SELECT n FROM Notificacion n WHERE n.fecha = :fecha")
    , @NamedQuery(name = "Notificacion.findByContenido", query = "SELECT n FROM Notificacion n WHERE n.contenido = :contenido")})
public class Notificacion implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "USUARIO_RECEPTOR")
    private Integer usuarioReceptor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "USUARIO_EMISOR")
    private Integer usuarioEmisor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Size(max = 200)
    @Column(name = "CONTENIDO")
    private String contenido;
    @JoinTable(name = "USUARIO_NOTIFICACION", joinColumns = {
        @JoinColumn(name = "NOTIFICACION_ID", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "USUARIO_ID_USUARIO", referencedColumnName = "ID_USUARIO")})
    @ManyToMany
    private Set<Usuario> usuarioSet;

    public Notificacion() {
    }

    public Notificacion(Integer id) {
        this.id = id;
    }

    public Notificacion(Integer id, Integer usuarioReceptor, Integer usuarioEmisor, Date fecha) {
        this.id = id;
        this.usuarioReceptor = usuarioReceptor;
        this.usuarioEmisor = usuarioEmisor;
        this.fecha = fecha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUsuarioReceptor() {
        return usuarioReceptor;
    }

    public void setUsuarioReceptor(Integer usuarioReceptor) {
        this.usuarioReceptor = usuarioReceptor;
    }

    public Integer getUsuarioEmisor() {
        return usuarioEmisor;
    }

    public void setUsuarioEmisor(Integer usuarioEmisor) {
        this.usuarioEmisor = usuarioEmisor;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
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
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.SII.entidades.Notificacion[ id=" + id + " ]";
    }
    
}
