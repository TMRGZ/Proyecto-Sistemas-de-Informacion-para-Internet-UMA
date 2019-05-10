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
@Table(name = "PROYECTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proyecto.findAll", query = "SELECT p FROM Proyecto p")
    , @NamedQuery(name = "Proyecto.findByCodigo", query = "SELECT p FROM Proyecto p WHERE p.codigo = :codigo")
    , @NamedQuery(name = "Proyecto.findByNombre", query = "SELECT p FROM Proyecto p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Proyecto.findByPresupuesto", query = "SELECT p FROM Proyecto p WHERE p.presupuesto = :presupuesto")
    , @NamedQuery(name = "Proyecto.findByCombustible", query = "SELECT p FROM Proyecto p WHERE p.combustible = :combustible")
    , @NamedQuery(name = "Proyecto.findByMantenimiento", query = "SELECT p FROM Proyecto p WHERE p.mantenimiento = :mantenimiento")
    , @NamedQuery(name = "Proyecto.findByContenedor", query = "SELECT p FROM Proyecto p WHERE p.contenedor = :contenedor")
    , @NamedQuery(name = "Proyecto.findByDescripcion", query = "SELECT p FROM Proyecto p WHERE p.descripcion = :descripcion")})
public class Proyecto implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "CODIGO", nullable = false, precision = 0, scale = -127)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigo;
    @Basic(optional = false)
    @Column(name = "NOMBRE", nullable = false, length = 50)
    private String nombre;
    @Column(name = "PRESUPUESTO")
    private Integer presupuesto;
    @Column(name = "COMBUSTIBLE")
    private Integer combustible;
    @Column(name = "MANTENIMIENTO")
    private Integer mantenimiento;
    @Column(name = "CONTENEDOR")
    private Integer contenedor;
    @Column(name = "DESCRIPCION", length = 80)
    private String descripcion;
    @ManyToMany(mappedBy = "proyectoSet")
    private Set<Beneficiario> beneficiarioSet;

    public Proyecto() {
    }

    public Proyecto(Long codigo) {
        this.codigo = codigo;
    }

    public Proyecto(Long codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(Integer presupuesto) {
        this.presupuesto = presupuesto;
    }

    public Integer getCombustible() {
        return combustible;
    }

    public void setCombustible(Integer combustible) {
        this.combustible = combustible;
    }

    public Integer getMantenimiento() {
        return mantenimiento;
    }

    public void setMantenimiento(Integer mantenimiento) {
        this.mantenimiento = mantenimiento;
    }

    public Integer getContenedor() {
        return contenedor;
    }

    public void setContenedor(Integer contenedor) {
        this.contenedor = contenedor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public Set<Beneficiario> getBeneficiarioSet() {
        return beneficiarioSet;
    }

    public void setBeneficiarioSet(Set<Beneficiario> beneficiarioSet) {
        this.beneficiarioSet = beneficiarioSet;
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
        if (!(object instanceof Proyecto)) {
            return false;
        }
        Proyecto other = (Proyecto) object;
        return (this.codigo != null || other.codigo == null) && (this.codigo == null || this.codigo.equals(other.codigo));
    }

    @Override
    public String toString() {
        return "javaapplication2.Proyecto[ codigo=" + codigo + " ]";
    }
    
}
