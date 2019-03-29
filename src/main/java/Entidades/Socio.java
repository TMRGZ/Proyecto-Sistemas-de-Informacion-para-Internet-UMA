package Entidades;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Time;
import java.util.Objects;

@Entity
public class Socio {
    private long numero;
    private String nombre;
    private String apellidos;
    private String estado;
    private String nif;
    private String direccion;
    private String poblacion;
    private long codigoPostal;
    private String provincia;
    private long telefono;
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
    public long getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(long codigoPostal) {
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
    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
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

        Socio socio = (Socio) o;

        if (numero != socio.numero) return false;
        if (codigoPostal != socio.codigoPostal) return false;
        if (telefono != socio.telefono) return false;
        if (!Objects.equals(nombre, socio.nombre)) return false;
        if (!Objects.equals(apellidos, socio.apellidos)) return false;
        if (!Objects.equals(estado, socio.estado)) return false;
        if (!Objects.equals(nif, socio.nif)) return false;
        if (!Objects.equals(direccion, socio.direccion)) return false;
        if (!Objects.equals(poblacion, socio.poblacion)) return false;
        if (!Objects.equals(provincia, socio.provincia)) return false;
        if (!Objects.equals(telefonoMovil, socio.telefonoMovil))
            return false;
        if (!Objects.equals(correoElectronico, socio.correoElectronico))
            return false;
        if (!Objects.equals(agente, socio.agente)) return false;
        if (!Objects.equals(relacion, socio.relacion)) return false;
        if (!Objects.equals(certificado, socio.certificado)) return false;
        if (!Objects.equals(sector, socio.sector)) return false;
        if (!Objects.equals(fechaAlta, socio.fechaAlta)) return false;
        if (!Objects.equals(fechaBaja, socio.fechaBaja)) return false;
        return Objects.equals(observaciones, socio.observaciones);

    }

    @Override
    public int hashCode() {
        int result = (int) (numero ^ (numero >>> 32));
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (apellidos != null ? apellidos.hashCode() : 0);
        result = 31 * result + (estado != null ? estado.hashCode() : 0);
        result = 31 * result + (nif != null ? nif.hashCode() : 0);
        result = 31 * result + (direccion != null ? direccion.hashCode() : 0);
        result = 31 * result + (poblacion != null ? poblacion.hashCode() : 0);
        result = 31 * result + (int) (codigoPostal ^ (codigoPostal >>> 32));
        result = 31 * result + (provincia != null ? provincia.hashCode() : 0);
        result = 31 * result + (int) (telefono ^ (telefono >>> 32));
        result = 31 * result + (telefonoMovil != null ? telefonoMovil.hashCode() : 0);
        result = 31 * result + (correoElectronico != null ? correoElectronico.hashCode() : 0);
        result = 31 * result + (agente != null ? agente.hashCode() : 0);
        result = 31 * result + (relacion != null ? relacion.hashCode() : 0);
        result = 31 * result + (certificado != null ? certificado.hashCode() : 0);
        result = 31 * result + (sector != null ? sector.hashCode() : 0);
        result = 31 * result + (fechaAlta != null ? fechaAlta.hashCode() : 0);
        result = 31 * result + (fechaBaja != null ? fechaBaja.hashCode() : 0);
        result = 31 * result + (observaciones != null ? observaciones.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Socio{" +
                "numero=" + numero +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", estado='" + estado + '\'' +
                ", nif='" + nif + '\'' +
                ", direccion='" + direccion + '\'' +
                ", poblacion='" + poblacion + '\'' +
                ", codigoPostal=" + codigoPostal +
                ", provincia='" + provincia + '\'' +
                ", telefono=" + telefono +
                ", telefonoMovil=" + telefonoMovil +
                ", correoElectronico='" + correoElectronico + '\'' +
                ", agente='" + agente + '\'' +
                ", relacion='" + relacion + '\'' +
                ", certificado='" + certificado + '\'' +
                ", sector='" + sector + '\'' +
                ", fechaAlta=" + fechaAlta +
                ", fechaBaja=" + fechaBaja +
                ", observaciones='" + observaciones + '\'' +
                '}';
    }
}
