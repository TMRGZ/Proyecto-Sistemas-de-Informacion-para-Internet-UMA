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
import java.util.Date;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author MiguelRuiz
 */
@Entity
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
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @JoinTable(name = "USUARIO_NOTIFICACION", joinColumns = {
            @JoinColumn(name = "NOTIFICACION_ID", referencedColumnName = "ID")}, inverseJoinColumns = {
            @JoinColumn(name = "USUARIO_NOMBRE_USUARIO", referencedColumnName = "NOMBRE_USUARIO")})
    @ManyToMany
    private Set<Usuario> usuarioSet;

    public Notificacion() {
    }

    public Notificacion(int id) {
        this.id = id;
    }

    public Notificacion(int id, int usuarioReceptor, int usuarioEmisor, Date fecha) {
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

    @XmlTransient
    public Set<Usuario> getUsuarioSet() {
        return usuarioSet;
    }

    public void setUsuarioSet(Set<Usuario> usuarioSet) {
        this.usuarioSet = usuarioSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notificacion that = (Notificacion) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Entidades.Notificacion[ id=" + id + " ]";
    }

}
