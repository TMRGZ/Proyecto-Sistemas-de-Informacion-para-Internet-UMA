package Entidades;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Beneficiario {
    private String codigo;
    private String identificador;
    private String nombre;
    private String tipo;
    private String apellidos;
    private String observaciones;
    private Long numeroCuenta;

    @Id
    @Column(name = "CODIGO")
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Basic
    @Column(name = "IDENTIFICADOR")
    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
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
    @Column(name = "TIPO")
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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
    @Column(name = "OBSERVACIONES")
    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @Basic
    @Column(name = "NUMERO_CUENTA")
    public Long getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(Long numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Beneficiario that = (Beneficiario) o;

        if (!Objects.equals(codigo, that.codigo)) return false;
        if (!Objects.equals(identificador, that.identificador))
            return false;
        if (!Objects.equals(nombre, that.nombre)) return false;
        if (!Objects.equals(tipo, that.tipo)) return false;
        if (!Objects.equals(apellidos, that.apellidos)) return false;
        if (!Objects.equals(observaciones, that.observaciones))
            return false;
        return Objects.equals(numeroCuenta, that.numeroCuenta);

    }

    @Override
    public int hashCode() {
        int result = codigo != null ? codigo.hashCode() : 0;
        result = 31 * result + (identificador != null ? identificador.hashCode() : 0);
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (tipo != null ? tipo.hashCode() : 0);
        result = 31 * result + (apellidos != null ? apellidos.hashCode() : 0);
        result = 31 * result + (observaciones != null ? observaciones.hashCode() : 0);
        result = 31 * result + (numeroCuenta != null ? numeroCuenta.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Beneficiario{" +
                "codigo='" + codigo + '\'' +
                ", identificador='" + identificador + '\'' +
                ", nombre='" + nombre + '\'' +
                ", tipo='" + tipo + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", observaciones='" + observaciones + '\'' +
                ", numeroCuenta=" + numeroCuenta +
                '}';
    }
}
