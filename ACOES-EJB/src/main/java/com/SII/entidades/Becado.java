/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SII.entidades;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author MiguelRuiz
 */
@Entity
@Table(name = "BECADO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Becado.findAll", query = "SELECT b FROM Becado b")
    , @NamedQuery(name = "Becado.findByCodigo", query = "SELECT b FROM Becado b WHERE b.codigo = :codigo")
    , @NamedQuery(name = "Becado.findByEstado", query = "SELECT b FROM Becado b WHERE b.estado = :estado")
    , @NamedQuery(name = "Becado.findByBeca", query = "SELECT b FROM Becado b WHERE b.beca = :beca")
    , @NamedQuery(name = "Becado.findByAgente", query = "SELECT b FROM Becado b WHERE b.agente = :agente")
    , @NamedQuery(name = "Becado.findByFechaNacimiento", query = "SELECT b FROM Becado b WHERE b.fechaNacimiento = :fechaNacimiento")
    , @NamedQuery(name = "Becado.findByFechaAcoes", query = "SELECT b FROM Becado b WHERE b.fechaAcoes = :fechaAcoes")
    , @NamedQuery(name = "Becado.findByProyecto", query = "SELECT b FROM Becado b WHERE b.proyecto = :proyecto")
    , @NamedQuery(name = "Becado.findByFechaAltaProyecto", query = "SELECT b FROM Becado b WHERE b.fechaAltaProyecto = :fechaAltaProyecto")
    , @NamedQuery(name = "Becado.findByFechaSalidaActua", query = "SELECT b FROM Becado b WHERE b.fechaSalidaActua = :fechaSalidaActua")
    , @NamedQuery(name = "Becado.findByFechaAlta", query = "SELECT b FROM Becado b WHERE b.fechaAlta = :fechaAlta")
    , @NamedQuery(name = "Becado.findByFechaSalidaAcoes", query = "SELECT b FROM Becado b WHERE b.fechaSalidaAcoes = :fechaSalidaAcoes")
    , @NamedQuery(name = "Becado.findByGradoCurso", query = "SELECT b FROM Becado b WHERE b.gradoCurso = :gradoCurso")
    , @NamedQuery(name = "Becado.findByColoniaProcedencia", query = "SELECT b FROM Becado b WHERE b.coloniaProcedencia = :coloniaProcedencia")
    , @NamedQuery(name = "Becado.findByColoniaActual", query = "SELECT b FROM Becado b WHERE b.coloniaActual = :coloniaActual")
    , @NamedQuery(name = "Becado.findByObservaciones", query = "SELECT b FROM Becado b WHERE b.observaciones = :observaciones")})
public class Becado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODIGO", nullable = false, length = 20)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigo;
    @Column(name = "ESTADO", length = 30)
    private String estado;
    @Column(name = "BECA", length = 30)
    private String beca;
    @Column(name = "AGENTE", length = 30)
    private String agente;
    @Lob
    @Column(name = "FOTO")
    private Serializable foto;
    @Column(name = "FECHA_NACIMIENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaNacimiento;
    @Column(name = "FECHA_ACOES")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAcoes;
    @Column(name = "PROYECTO", length = 30)
    private String proyecto;
    @Column(name = "FECHA_ALTA_PROYECTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAltaProyecto;
    @Column(name = "FECHA_SALIDA_ACTUA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaSalidaActua;
    @Column(name = "FECHA_ALTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAlta;
    @Column(name = "FECHA_SALIDA_ACOES")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaSalidaAcoes;
    @Column(name = "GRADO_CURSO", length = 30)
    private String gradoCurso;
    @Column(name = "COLONIA_PROCEDENCIA", length = 30)
    private String coloniaProcedencia;
    @Column(name = "COLONIA_ACTUAL", length = 30)
    private String coloniaActual;
    @Column(name = "OBSERVACIONES", length = 80)
    private String observaciones;
    @JoinColumn(name = "CODIGO", referencedColumnName = "CODIGO", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Beneficiario beneficiario;
    @JoinColumn(name = "SOCIO_NUMERO", referencedColumnName = "NUMERO", nullable = true)
    @ManyToOne(optional = true)
    private Socio socioNumero;

    public Becado() {
    }

    public Becado(Long codigo) {
        this.codigo = codigo;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getBeca() {
        return beca;
    }

    public void setBeca(String beca) {
        this.beca = beca;
    }

    public String getAgente() {
        return agente;
    }

    public void setAgente(String agente) {
        this.agente = agente;
    }

    public Serializable getFoto() {
        return foto;
    }

    public void setFoto(Serializable foto) {
        this.foto = foto;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Date getFechaAcoes() {
        return fechaAcoes;
    }

    public void setFechaAcoes(Date fechaAcoes) {
        this.fechaAcoes = fechaAcoes;
    }

    public String getProyecto() {
        return proyecto;
    }

    public void setProyecto(String proyecto) {
        this.proyecto = proyecto;
    }

    public Date getFechaAltaProyecto() {
        return fechaAltaProyecto;
    }

    public void setFechaAltaProyecto(Date fechaAltaProyecto) {
        this.fechaAltaProyecto = fechaAltaProyecto;
    }

    public Date getFechaSalidaActua() {
        return fechaSalidaActua;
    }

    public void setFechaSalidaActua(Date fechaSalidaActua) {
        this.fechaSalidaActua = fechaSalidaActua;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Date getFechaSalidaAcoes() {
        return fechaSalidaAcoes;
    }

    public void setFechaSalidaAcoes(Date fechaSalidaAcoes) {
        this.fechaSalidaAcoes = fechaSalidaAcoes;
    }

    public String getGradoCurso() {
        return gradoCurso;
    }

    public void setGradoCurso(String gradoCurso) {
        this.gradoCurso = gradoCurso;
    }

    public String getColoniaProcedencia() {
        return coloniaProcedencia;
    }

    public void setColoniaProcedencia(String coloniaProcedencia) {
        this.coloniaProcedencia = coloniaProcedencia;
    }

    public String getColoniaActual() {
        return coloniaActual;
    }

    public void setColoniaActual(String coloniaActual) {
        this.coloniaActual = coloniaActual;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Beneficiario getBeneficiario() {
        return beneficiario;
    }

    public void setBeneficiario(Beneficiario beneficiario) {
        this.beneficiario = beneficiario;
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
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Becado)) {
            return false;
        }
        Becado other = (Becado) object;
        return (this.codigo != null || other.codigo == null) && (this.codigo == null || this.codigo.equals(other.codigo));
    }

    @Override
    public String toString() {
        return "javaapplication2.Becado[ codigo=" + codigo + " ]";
    }
    
}
