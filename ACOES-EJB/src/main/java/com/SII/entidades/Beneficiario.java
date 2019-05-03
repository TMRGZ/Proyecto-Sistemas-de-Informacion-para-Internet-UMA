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
    @NamedQuery(name = "Beneficiario.findAll", query = "SELECT b FROM Beneficiario b")
    , @NamedQuery(name = "Beneficiario.findByCodigo", query = "SELECT b FROM Beneficiario b WHERE b.codigo = :codigo")
    , @NamedQuery(name = "Beneficiario.findByIdentificador", query = "SELECT b FROM Beneficiario b WHERE b.identificador = :identificador")
    , @NamedQuery(name = "Beneficiario.findByNombre", query = "SELECT b FROM Beneficiario b WHERE b.nombre = :nombre")
    , @NamedQuery(name = "Beneficiario.findByTipo", query = "SELECT b FROM Beneficiario b WHERE b.tipo = :tipo")
    , @NamedQuery(name = "Beneficiario.findByApellidos", query = "SELECT b FROM Beneficiario b WHERE b.apellidos = :apellidos")
    , @NamedQuery(name = "Beneficiario.findByObservaciones", query = "SELECT b FROM Beneficiario b WHERE b.observaciones = :observaciones")
    , @NamedQuery(name = "Beneficiario.findByNumeroCuenta", query = "SELECT b FROM Beneficiario b WHERE b.numeroCuenta = :numeroCuenta")})
public class Beneficiario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false, length = 20)
    private String codigo;
    @Basic(optional = false)
    @Column(nullable = false, length = 30)
    private String identificador;
    @Basic(optional = false)
    @Column(nullable = false, length = 40)
    private String nombre;
    @Basic(optional = false)
    @Column(nullable = false, length = 30)
    private String tipo;
    @Column(length = 40)
    private String apellidos;
    @Column(length = 80)
    private String observaciones;
    @Column(name = "NUMERO_CUENTA")
    private Integer numeroCuenta;
    @JoinTable(name = "RELATION_3", joinColumns = {
            @JoinColumn(name = "BENEFICIARIO_CODIGO", referencedColumnName = "CODIGO", nullable = false)}, inverseJoinColumns = {
            @JoinColumn(name = "PROYECTO_CODIGO", referencedColumnName = "CODIGO", nullable = false)})
    @ManyToMany
    private Set<Proyecto> proyectoSet;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "beneficiario")
    private Becado becado;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "beneficiarioCodigo")
    private Beneficiario beneficiario;
    @JoinColumn(name = "BENEFICIARIO_CODIGO", referencedColumnName = "CODIGO", nullable = false)
    @OneToOne(optional = false)
    private Beneficiario beneficiarioCodigo;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "beneficiarioCodigo")
    private Usuario usuario;

    public Beneficiario() {
    }

    public Beneficiario(String codigo) {
        this.codigo = codigo;
    }

    public Beneficiario(String codigo, String identificador, String nombre, String tipo) {
        this.codigo = codigo;
        this.identificador = identificador;
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Integer getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(Integer numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    @XmlTransient
    public Set<Proyecto> getProyectoSet() {
        return proyectoSet;
    }

    public void setProyectoSet(Set<Proyecto> proyectoSet) {
        this.proyectoSet = proyectoSet;
    }

    public Becado getBecado() {
        return becado;
    }

    public void setBecado(Becado becado) {
        this.becado = becado;
    }

    public Beneficiario getBeneficiario() {
        return beneficiario;
    }

    public void setBeneficiario(Beneficiario beneficiario) {
        this.beneficiario = beneficiario;
    }

    public Beneficiario getBeneficiarioCodigo() {
        return beneficiarioCodigo;
    }

    public void setBeneficiarioCodigo(Beneficiario beneficiarioCodigo) {
        this.beneficiarioCodigo = beneficiarioCodigo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Beneficiario)) {
            return false;
        }
        Beneficiario other = (Beneficiario) object;
        return (this.codigo != null || other.codigo == null) && (this.codigo == null || this.codigo.equals(other.codigo));
    }

    @Override
    public String toString() {
        return "javaapplication1.Beneficiario[ codigo=" + codigo + " ]";
    }
    
}
