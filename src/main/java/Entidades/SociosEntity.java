package Entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.util.Objects;

@Entity
@Table(name = "SOCIOS", schema = "ACOES")
public class SociosEntity implements Serializable {
    private long numero;
    private String nombre;
    private String apellidos;
    private String estado;
    private String nif;
    private String direccion;
    private String poblacion;
    private Long codigoPostal;
    private String provincia;
    private Long telefono;
    private Long telefonoMovil;
    private String correoElectronico;
    private String agente;
    private String relacion;
    private String certificado;
    private String sector;
    private Time fechaAlta;
    private Time fechaBaja;
    private String observaciones;

    @Id
    @Column(name = "NUMERO")
    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    @Basic
    @Column(name = "NOMBRE")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "APELLIDOS")
    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    @Basic
    @Column(name = "ESTADO")
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Basic
    @Column(name = "NIF")
    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    @Basic
    @Column(name = "DIRECCION")
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Basic
    @Column(name = "POBLACION")
    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    @Basic
    @Column(name = "CODIGO_POSTAL")
    public Long getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(Long codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    @Basic
    @Column(name = "PROVINCIA")
    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    @Basic
    @Column(name = "TELEFONO")
    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    @Basic
    @Column(name = "TELEFONO_MOVIL")
    public Long getTelefonoMovil() {
        return telefonoMovil;
    }

    public void setTelefonoMovil(Long telefonoMovil) {
        this.telefonoMovil = telefonoMovil;
    }

    @Basic
    @Column(name = "CORREO_ELECTRONICO")
    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    @Basic
    @Column(name = "AGENTE")
    public String getAgente() {
        return agente;
    }

    public void setAgente(String agente) {
        this.agente = agente;
    }

    @Basic
    @Column(name = "RELACION")
    public String getRelacion() {
        return relacion;
    }

    public void setRelacion(String relacion) {
        this.relacion = relacion;
    }

    @Basic
    @Column(name = "CERTIFICADO")
    public String getCertificado() {
        return certificado;
    }

    public void setCertificado(String certificado) {
        this.certificado = certificado;
    }

    @Basic
    @Column(name = "SECTOR")
    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    @Basic
    @Column(name = "FECHA_ALTA")
    public Time getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Time fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    @Basic
    @Column(name = "FECHA_BAJA")
    public Time getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(Time fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    @Basic
    @Column(name = "OBSERVACIONES")
    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SociosEntity that = (SociosEntity) o;
        return numero == that.numero &&
                Objects.equals(nombre, that.nombre) &&
                Objects.equals(apellidos, that.apellidos) &&
                Objects.equals(estado, that.estado) &&
                Objects.equals(nif, that.nif) &&
                Objects.equals(direccion, that.direccion) &&
                Objects.equals(poblacion, that.poblacion) &&
                Objects.equals(codigoPostal, that.codigoPostal) &&
                Objects.equals(provincia, that.provincia) &&
                Objects.equals(telefono, that.telefono) &&
                Objects.equals(telefonoMovil, that.telefonoMovil) &&
                Objects.equals(correoElectronico, that.correoElectronico) &&
                Objects.equals(agente, that.agente) &&
                Objects.equals(relacion, that.relacion) &&
                Objects.equals(certificado, that.certificado) &&
                Objects.equals(sector, that.sector) &&
                Objects.equals(fechaAlta, that.fechaAlta) &&
                Objects.equals(fechaBaja, that.fechaBaja) &&
                Objects.equals(observaciones, that.observaciones);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero, nombre, apellidos, estado, nif, direccion, poblacion, codigoPostal, provincia, telefono, telefonoMovil, correoElectronico, agente, relacion, certificado, sector, fechaAlta, fechaBaja, observaciones);
    }
}
