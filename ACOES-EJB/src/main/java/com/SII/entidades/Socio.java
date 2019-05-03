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
        @NamedQuery(name = "Socio.findAll", query = "SELECT s FROM Socio s"),
        @NamedQuery(name = "Socio.findByNumero", query = "SELECT s FROM Socio s WHERE s.numero = :numero"),
        @NamedQuery(name = "Socio.findByNombre", query = "SELECT s FROM Socio s WHERE s.nombre = :nombre"),
        @NamedQuery(name = "Socio.findByApellidos", query = "SELECT s FROM Socio s WHERE s.apellidos = :apellidos"),
        @NamedQuery(name = "Socio.findByEstado", query = "SELECT s FROM Socio s WHERE s.estado = :estado"),
        @NamedQuery(name = "Socio.findByNif", query = "SELECT s FROM Socio s WHERE s.nif = :nif"),
        @NamedQuery(name = "Socio.findByDireccion", query = "SELECT s FROM Socio s WHERE s.direccion = :direccion"),
        @NamedQuery(name = "Socio.findByPoblacion", query = "SELECT s FROM Socio s WHERE s.poblacion = :poblacion"),
        @NamedQuery(name = "Socio.findByCodigoPostal", query = "SELECT s FROM Socio s WHERE s.codigoPostal = :codigoPostal"),
        @NamedQuery(name = "Socio.findByProvincia", query = "SELECT s FROM Socio s WHERE s.provincia = :provincia"),
        @NamedQuery(name = "Socio.findByTelefono", query = "SELECT s FROM Socio s WHERE s.telefono = :telefono"),
        @NamedQuery(name = "Socio.findByTelefonoMovil", query = "SELECT s FROM Socio s WHERE s.telefonoMovil = :telefonoMovil"),
        @NamedQuery(name = "Socio.findByCorreoElectronico", query = "SELECT s FROM Socio s WHERE s.correoElectronico = :correoElectronico"),
        @NamedQuery(name = "Socio.findByAgente", query = "SELECT s FROM Socio s WHERE s.agente = :agente"),
        @NamedQuery(name = "Socio.findByRelacion", query = "SELECT s FROM Socio s WHERE s.relacion = :relacion"),
        @NamedQuery(name = "Socio.findByCertificado", query = "SELECT s FROM Socio s WHERE s.certificado = :certificado"),
        @NamedQuery(name = "Socio.findBySector", query = "SELECT s FROM Socio s WHERE s.sector = :sector"),
        @NamedQuery(name = "Socio.findByFechaAlta", query = "SELECT s FROM Socio s WHERE s.fechaAlta = :fechaAlta"),
        @NamedQuery(name = "Socio.findByFechaBaja", query = "SELECT s FROM Socio s WHERE s.fechaBaja = :fechaBaja"),
        @NamedQuery(name = "Socio.findByObservaciones", query = "SELECT s FROM Socio s WHERE s.observaciones = :observaciones")})
public class Socio implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    private Integer numero;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    private String nombre;
    @Size(max = 30)
    private String apellidos;
    @Size(max = 30)
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    private String nif;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    private String poblacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_POSTAL")
    private String codigoPostal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    private String provincia;
    @Basic(optional = false)
    @NotNull
    private Integer telefono;
    @Column(name = "TELEFONO_MOVIL")
    private Integer telefonoMovil;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "CORREO_ELECTRONICO")
    private String correoElectronico;
    @Size(max = 40)
    private String agente;
    @Size(max = 40)
    private String relacion;
    @Size(max = 40)
    private String certificado;
    @Size(max = 40)
    private String sector;
    @Column(name = "FECHA_ALTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAlta;
    @Column(name = "FECHA_BAJA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaBaja;
    @Size(max = 80)
    private String observaciones;
    @OneToMany(mappedBy = "socioNumero")
    private Set<Becado> becadoSet;
    @JoinColumn(name = "USUARIO_NOMBRE_USUARIO", referencedColumnName = "NOMBRE_USUARIO")
    @OneToOne
    private Usuario usuarioNombreUsuario;
    @OneToOne(mappedBy = "socioNumero")
    private Usuario usuario;

    public Socio() {
    }

    public Socio(int numero) {
        this.numero = numero;
    }

    public Socio(int numero, String nombre, String nif, String direccion, String poblacion, String codigoPostal, String provincia, Integer telefono, String correoElectronico) {
        this.numero = numero;
        this.nombre = nombre;
        this.nif = nif;
        this.direccion = direccion;
        this.poblacion = poblacion;
        this.codigoPostal = codigoPostal;
        this.provincia = provincia;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public Integer getTelefonoMovil() {
        return telefonoMovil;
    }

    public void setTelefonoMovil(Integer telefonoMovil) {
        this.telefonoMovil = telefonoMovil;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getAgente() {
        return agente;
    }

    public void setAgente(String agente) {
        this.agente = agente;
    }

    public String getRelacion() {
        return relacion;
    }

    public void setRelacion(String relacion) {
        this.relacion = relacion;
    }

    public String getCertificado() {
        return certificado;
    }

    public void setCertificado(String certificado) {
        this.certificado = certificado;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Date getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(Date fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @XmlTransient
    public Set<Becado> getBecadoSet() {
        return becadoSet;
    }

    public void setBecadoSet(Set<Becado> becadoSet) {
        this.becadoSet = becadoSet;
    }

    public Usuario getUsuarioNombreUsuario() {
        return usuarioNombreUsuario;
    }

    public void setUsuarioNombreUsuario(Usuario usuarioNombreUsuario) {
        this.usuarioNombreUsuario = usuarioNombreUsuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Socio socio = (Socio) o;
        return Objects.equals(numero, socio.numero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero);
    }

    @Override
    public String toString() {
        return "Entidades.Socio[ numero=" + numero + " ]";
    }

}
