package Entidades;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "PROYECTO", schema = "ACOES", catalog = "")
public class ProyectoEntity {
    private long codigo;
    private String nombre;
    private Long presupuesto;
    private Long combustible;
    private Long mantenimiento;
    private Long contenedor;
    private String descripcion;

    @Id
    @Column(name = "CODIGO")
    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
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
    @Column(name = "PRESUPUESTO")
    public Long getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(Long presupuesto) {
        this.presupuesto = presupuesto;
    }

    @Basic
    @Column(name = "COMBUSTIBLE")
    public Long getCombustible() {
        return combustible;
    }

    public void setCombustible(Long combustible) {
        this.combustible = combustible;
    }

    @Basic
    @Column(name = "MANTENIMIENTO")
    public Long getMantenimiento() {
        return mantenimiento;
    }

    public void setMantenimiento(Long mantenimiento) {
        this.mantenimiento = mantenimiento;
    }

    @Basic
    @Column(name = "CONTENEDOR")
    public Long getContenedor() {
        return contenedor;
    }

    public void setContenedor(Long contenedor) {
        this.contenedor = contenedor;
    }

    @Basic
    @Column(name = "DESCRIPCION")
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProyectoEntity that = (ProyectoEntity) o;
        return codigo == that.codigo &&
                Objects.equals(nombre, that.nombre) &&
                Objects.equals(presupuesto, that.presupuesto) &&
                Objects.equals(combustible, that.combustible) &&
                Objects.equals(mantenimiento, that.mantenimiento) &&
                Objects.equals(contenedor, that.contenedor) &&
                Objects.equals(descripcion, that.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, nombre, presupuesto, combustible, mantenimiento, contenedor, descripcion);
    }
}
