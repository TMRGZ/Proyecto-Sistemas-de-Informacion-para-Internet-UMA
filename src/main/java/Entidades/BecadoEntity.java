package Entidades;

import javax.persistence.*;
import java.sql.Time;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "BECADO", schema = "ACOES", catalog = "")
public class BecadoEntity {
    private String codigo;
    private String estado;
    private String beca;
    private String agente;
    private byte[] foto;
    private Time fechaNacimiento;
    private Time fechaAcoes;
    private String proyecto;
    private Time fechaAltaProyecto;
    private Time fechaSalidaActua;
    private Time fechaAlta;
    private Time fechaSalidaAcoes;
    private String gradoCurso;
    private String coloniaProcedencia;
    private String coloniaActual;
    private String observaciones;

    @Id
    @Column(name = "CODIGO")
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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
    @Column(name = "BECA")
    public String getBeca() {
        return beca;
    }

    public void setBeca(String beca) {
        this.beca = beca;
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
    @Column(name = "FOTO")
    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    @Basic
    @Column(name = "FECHA_NACIMIENTO")
    public Time getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Time fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Basic
    @Column(name = "FECHA_ACOES")
    public Time getFechaAcoes() {
        return fechaAcoes;
    }

    public void setFechaAcoes(Time fechaAcoes) {
        this.fechaAcoes = fechaAcoes;
    }

    @Basic
    @Column(name = "PROYECTO")
    public String getProyecto() {
        return proyecto;
    }

    public void setProyecto(String proyecto) {
        this.proyecto = proyecto;
    }

    @Basic
    @Column(name = "FECHA_ALTA_PROYECTO")
    public Time getFechaAltaProyecto() {
        return fechaAltaProyecto;
    }

    public void setFechaAltaProyecto(Time fechaAltaProyecto) {
        this.fechaAltaProyecto = fechaAltaProyecto;
    }

    @Basic
    @Column(name = "FECHA_SALIDA_ACTUA")
    public Time getFechaSalidaActua() {
        return fechaSalidaActua;
    }

    public void setFechaSalidaActua(Time fechaSalidaActua) {
        this.fechaSalidaActua = fechaSalidaActua;
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
    @Column(name = "FECHA_SALIDA_ACOES")
    public Time getFechaSalidaAcoes() {
        return fechaSalidaAcoes;
    }

    public void setFechaSalidaAcoes(Time fechaSalidaAcoes) {
        this.fechaSalidaAcoes = fechaSalidaAcoes;
    }

    @Basic
    @Column(name = "GRADO_CURSO")
    public String getGradoCurso() {
        return gradoCurso;
    }

    public void setGradoCurso(String gradoCurso) {
        this.gradoCurso = gradoCurso;
    }

    @Basic
    @Column(name = "COLONIA_PROCEDENCIA")
    public String getColoniaProcedencia() {
        return coloniaProcedencia;
    }

    public void setColoniaProcedencia(String coloniaProcedencia) {
        this.coloniaProcedencia = coloniaProcedencia;
    }

    @Basic
    @Column(name = "COLONIA_ACTUAL")
    public String getColoniaActual() {
        return coloniaActual;
    }

    public void setColoniaActual(String coloniaActual) {
        this.coloniaActual = coloniaActual;
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
        BecadoEntity that = (BecadoEntity) o;
        return Objects.equals(codigo, that.codigo) &&
                Objects.equals(estado, that.estado) &&
                Objects.equals(beca, that.beca) &&
                Objects.equals(agente, that.agente) &&
                Arrays.equals(foto, that.foto) &&
                Objects.equals(fechaNacimiento, that.fechaNacimiento) &&
                Objects.equals(fechaAcoes, that.fechaAcoes) &&
                Objects.equals(proyecto, that.proyecto) &&
                Objects.equals(fechaAltaProyecto, that.fechaAltaProyecto) &&
                Objects.equals(fechaSalidaActua, that.fechaSalidaActua) &&
                Objects.equals(fechaAlta, that.fechaAlta) &&
                Objects.equals(fechaSalidaAcoes, that.fechaSalidaAcoes) &&
                Objects.equals(gradoCurso, that.gradoCurso) &&
                Objects.equals(coloniaProcedencia, that.coloniaProcedencia) &&
                Objects.equals(coloniaActual, that.coloniaActual) &&
                Objects.equals(observaciones, that.observaciones);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(codigo, estado, beca, agente, fechaNacimiento, fechaAcoes, proyecto, fechaAltaProyecto, fechaSalidaActua, fechaAlta, fechaSalidaAcoes, gradoCurso, coloniaProcedencia, coloniaActual, observaciones);
        result = 31 * result + Arrays.hashCode(foto);
        return result;
    }
}
