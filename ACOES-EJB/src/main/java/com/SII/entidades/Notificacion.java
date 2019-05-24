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
import java.util.Date;
import java.util.Set;

/**
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
    @Column(name = "ID", nullable = false, precision = 0, scale = -127)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Basic(optional = false)
    @Column(name = "USUARIO_RECEPTOR", nullable = false)
    private String usuarioReceptor;
    @Basic(optional = false)
    @Column(name = "USUARIO_EMISOR", nullable = false)
    private String usuarioEmisor;
    @Basic(optional = false)
    @Column(name = "FECHA", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "CONTENIDO", length = 200)
    private String contenido;
    @JoinTable(name = "RELATION_6", joinColumns = {
            @JoinColumn(name = "NOTIFICACION_ID", referencedColumnName = "ID", nullable = false)}, inverseJoinColumns = {
            @JoinColumn(name = "USUARIO_NOMBRE_USUARIO", referencedColumnName = "NOMBRE_USUARIO", nullable = false)})
    @ManyToMany
    private Set<Usuario> usuarioSet;

    public Notificacion() {
    }

    public Notificacion(Long id) {
        this.id = id;
    }

    public Notificacion(Long id, String usuarioReceptor, String usuarioEmisor, Date fecha) {
        this.id = id;
        this.usuarioReceptor = usuarioReceptor;
        this.usuarioEmisor = usuarioEmisor;
        this.fecha = fecha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsuarioReceptor() {
        return usuarioReceptor;
    }

    public void setUsuarioReceptor(String usuarioReceptor) {
        this.usuarioReceptor = usuarioReceptor;
    }

    public String getUsuarioEmisor() {
        return usuarioEmisor;
    }

    public void setUsuarioEmisor(String usuarioEmisor) {
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
        return (this.id != null || other.id == null) && (this.id == null || this.id.equals(other.id));
    }

    @Override
    public String toString() {
        return "javaapplication2.Notificacion[ id=" + id + " ]";
    }

}
