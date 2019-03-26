package Entidades;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "BENEFICIARIO", schema = "ACOES")
public class BeneficiarioEntity {
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
        BeneficiarioEntity that = (BeneficiarioEntity) o;
        return Objects.equals(codigo, that.codigo) &&
                Objects.equals(identificador, that.identificador) &&
                Objects.equals(nombre, that.nombre) &&
                Objects.equals(tipo, that.tipo) &&
                Objects.equals(apellidos, that.apellidos) &&
                Objects.equals(observaciones, that.observaciones) &&
                Objects.equals(numeroCuenta, that.numeroCuenta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, identificador, nombre, tipo, apellidos, observaciones, numeroCuenta);
    }
}
