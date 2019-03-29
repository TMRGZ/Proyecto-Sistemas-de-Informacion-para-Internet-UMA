package Entidades;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Proyecto {
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

        Proyecto proyecto = (Proyecto) o;

        if (codigo != proyecto.codigo) return false;
        if (!Objects.equals(nombre, proyecto.nombre)) return false;
        if (!Objects.equals(presupuesto, proyecto.presupuesto))
            return false;
        if (!Objects.equals(combustible, proyecto.combustible))
            return false;
        if (!Objects.equals(mantenimiento, proyecto.mantenimiento))
            return false;
        if (!Objects.equals(contenedor, proyecto.contenedor)) return false;
        return Objects.equals(descripcion, proyecto.descripcion);

    }

    @Override
    public int hashCode() {
        int result = (int) (codigo ^ (codigo >>> 32));
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (presupuesto != null ? presupuesto.hashCode() : 0);
        result = 31 * result + (combustible != null ? combustible.hashCode() : 0);
        result = 31 * result + (mantenimiento != null ? mantenimiento.hashCode() : 0);
        result = 31 * result + (contenedor != null ? contenedor.hashCode() : 0);
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Proyecto{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", presupuesto=" + presupuesto +
                ", combustible=" + combustible +
                ", mantenimiento=" + mantenimiento +
                ", contenedor=" + contenedor +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
