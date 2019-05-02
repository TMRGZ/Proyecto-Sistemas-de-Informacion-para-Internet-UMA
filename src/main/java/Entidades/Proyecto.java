/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 * @author MiguelRuiz
 */
@Entity
@Table(name = "PROYECTO")
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
    @Column(name = "CODIGO")
    private BigDecimal codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "PRESUPUESTO")
    private BigInteger presupuesto;
    @Column(name = "COMBUSTIBLE")
    private BigInteger combustible;
    @Column(name = "MANTENIMIENTO")
    private BigInteger mantenimiento;
    @Column(name = "CONTENEDOR")
    private BigInteger contenedor;
    @Size(max = 80)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @ManyToMany(mappedBy = "proyectoList")
    private List<Beneficiario> beneficiarioList;

    public Proyecto() {
    }

    public Proyecto(BigDecimal codigo) {
        this.codigo = codigo;
    }

    public Proyecto(BigDecimal codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public BigDecimal getCodigo() {
        return codigo;
    }

    public void setCodigo(BigDecimal codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigInteger getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(BigInteger presupuesto) {
        this.presupuesto = presupuesto;
    }

    public BigInteger getCombustible() {
        return combustible;
    }

    public void setCombustible(BigInteger combustible) {
        this.combustible = combustible;
    }

    public BigInteger getMantenimiento() {
        return mantenimiento;
    }

    public void setMantenimiento(BigInteger mantenimiento) {
        this.mantenimiento = mantenimiento;
    }

    public BigInteger getContenedor() {
        return contenedor;
    }

    public void setContenedor(BigInteger contenedor) {
        this.contenedor = contenedor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Beneficiario> getBeneficiarioList() {
        return beneficiarioList;
    }

    public void setBeneficiarioList(List<Beneficiario> beneficiarioList) {
        this.beneficiarioList = beneficiarioList;
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
        return "Entidades.Proyecto[ codigo=" + codigo + " ]";
    }

}
