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
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author MiguelRuiz
 */
@Entity
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Proyecto.findAll", query = "SELECT p FROM Proyecto p"),
        @NamedQuery(name = "Proyecto.findByCodigo", query = "SELECT p FROM Proyecto p WHERE p.codigo = :codigo"),
        @NamedQuery(name = "Proyecto.findByNombre", query = "SELECT p FROM Proyecto p WHERE p.nombre = :nombre"),
        @NamedQuery(name = "Proyecto.findByPresupuesto", query = "SELECT p FROM Proyecto p WHERE p.presupuesto = :presupuesto"),
        @NamedQuery(name = "Proyecto.findByCombustible", query = "SELECT p FROM Proyecto p WHERE p.combustible = :combustible"),
        @NamedQuery(name = "Proyecto.findByMantenimiento", query = "SELECT p FROM Proyecto p WHERE p.mantenimiento = :mantenimiento"),
        @NamedQuery(name = "Proyecto.findByContenedor", query = "SELECT p FROM Proyecto p WHERE p.contenedor = :contenedor"),
        @NamedQuery(name = "Proyecto.findByDescripcion", query = "SELECT p FROM Proyecto p WHERE p.descripcion = :descripcion")})
public class Proyecto implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    private Integer codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    private String nombre;
    private Integer presupuesto;
    private Integer combustible;
    private Integer mantenimiento;
    private Integer contenedor;
    @Size(max = 80)
    private String descripcion;
    @ManyToMany(mappedBy = "proyectoSet")
    private Set<Beneficiario> beneficiarioSet;

    public Proyecto() {
    }

    public Proyecto(int codigo) {
        this.codigo = codigo;
    }

    public Proyecto(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Proyecto proyecto = (Proyecto) o;
        return Objects.equals(codigo, proyecto.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }

    @Override
    public String toString() {
        return "Entidades.Proyecto[ codigo=" + codigo + " ]";
    }

}
