package Entidades;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Time;
import java.util.Arrays;
import java.util.Objects;

@Entity
public class Becado {
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

        Becado becado = (Becado) o;

        if (!Objects.equals(codigo, becado.codigo)) return false;
        if (!Objects.equals(estado, becado.estado)) return false;
        if (!Objects.equals(beca, becado.beca)) return false;
        if (!Objects.equals(agente, becado.agente)) return false;
        if (!Arrays.equals(foto, becado.foto)) return false;
        if (!Objects.equals(fechaNacimiento, becado.fechaNacimiento))
            return false;
        if (!Objects.equals(fechaAcoes, becado.fechaAcoes)) return false;
        if (!Objects.equals(proyecto, becado.proyecto)) return false;
        if (!Objects.equals(fechaAltaProyecto, becado.fechaAltaProyecto))
            return false;
        if (!Objects.equals(fechaSalidaActua, becado.fechaSalidaActua))
            return false;
        if (!Objects.equals(fechaAlta, becado.fechaAlta)) return false;
        if (!Objects.equals(fechaSalidaAcoes, becado.fechaSalidaAcoes))
            return false;
        if (!Objects.equals(gradoCurso, becado.gradoCurso)) return false;
        if (!Objects.equals(coloniaProcedencia, becado.coloniaProcedencia))
            return false;
        if (!Objects.equals(coloniaActual, becado.coloniaActual))
            return false;
        return Objects.equals(observaciones, becado.observaciones);

    }

    @Override
    public String toString() {
        return "Becado{" +
                "codigo='" + codigo + '\'' +
                ", estado='" + estado + '\'' +
                ", beca='" + beca + '\'' +
                ", agente='" + agente + '\'' +
                ", foto=" + Arrays.toString(foto) +
                ", fechaNacimiento=" + fechaNacimiento +
                ", fechaAcoes=" + fechaAcoes +
                ", proyecto='" + proyecto + '\'' +
                ", fechaAltaProyecto=" + fechaAltaProyecto +
                ", fechaSalidaActua=" + fechaSalidaActua +
                ", fechaAlta=" + fechaAlta +
                ", fechaSalidaAcoes=" + fechaSalidaAcoes +
                ", gradoCurso='" + gradoCurso + '\'' +
                ", coloniaProcedencia='" + coloniaProcedencia + '\'' +
                ", coloniaActual='" + coloniaActual + '\'' +
                ", observaciones='" + observaciones + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        int result = codigo != null ? codigo.hashCode() : 0;
        result = 31 * result + (estado != null ? estado.hashCode() : 0);
        result = 31 * result + (beca != null ? beca.hashCode() : 0);
        result = 31 * result + (agente != null ? agente.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(foto);
        result = 31 * result + (fechaNacimiento != null ? fechaNacimiento.hashCode() : 0);
        result = 31 * result + (fechaAcoes != null ? fechaAcoes.hashCode() : 0);
        result = 31 * result + (proyecto != null ? proyecto.hashCode() : 0);
        result = 31 * result + (fechaAltaProyecto != null ? fechaAltaProyecto.hashCode() : 0);
        result = 31 * result + (fechaSalidaActua != null ? fechaSalidaActua.hashCode() : 0);
        result = 31 * result + (fechaAlta != null ? fechaAlta.hashCode() : 0);
        result = 31 * result + (fechaSalidaAcoes != null ? fechaSalidaAcoes.hashCode() : 0);
        result = 31 * result + (gradoCurso != null ? gradoCurso.hashCode() : 0);
        result = 31 * result + (coloniaProcedencia != null ? coloniaProcedencia.hashCode() : 0);
        result = 31 * result + (coloniaActual != null ? coloniaActual.hashCode() : 0);
        result = 31 * result + (observaciones != null ? observaciones.hashCode() : 0);
        return result;
    }
}
