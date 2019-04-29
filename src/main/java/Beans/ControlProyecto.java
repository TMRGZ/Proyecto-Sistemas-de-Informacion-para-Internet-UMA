package Beans;

import Entidades.Proyecto;

import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Named(value = "ctrlproyectos")
@ManagedBean
@SessionScoped
public class ControlProyecto implements Serializable {
    private List<Proyecto> proyectos;

    private Proyecto proyecto;

    public ControlProyecto() {
        proyectos = new ArrayList<>();
        proyectos.add(new Proyecto(new BigDecimal(0), "Charla en la UMA"));
        proyectos.add(new Proyecto(new BigDecimal(1), "Adaptarse al sistema de los alumnos"));

    }


    public String uploadProyecto() {
        if (proyectos.indexOf(proyecto) >= 0) {

            updProyecto(proyectos.get(proyectos.indexOf(proyecto)), proyecto.getNombre(), proyecto.getPresupuesto(), proyecto.getCombustible(),
                    proyecto.getContenedor(), proyecto.getMantenimiento(), proyecto.getDescripcion());
        } else {
            proyectos.add(proyecto);
        }
        return "projects.xhtml";
    }

    public String remProyecto(Proyecto p) {
        proyectos.remove(p);
        return null;
    }

    public void updProyecto(Proyecto p, String nombre, BigInteger presupuesto, BigInteger combustible, BigInteger contenedor, BigInteger mantenimiento, String descripcion) {
        Proyecto upd = proyectos.get(proyectos.indexOf(p));

        if (nombre != null) upd.setNombre(nombre);
        if (presupuesto != null) upd.setPresupuesto(presupuesto);
        if (combustible != null) upd.setCombustible(combustible);
        if (contenedor != null) upd.setContenedor(contenedor);
        if (descripcion != null) upd.setDescripcion(descripcion);
        if (mantenimiento != null) upd.setMantenimiento(mantenimiento);
    }

    public List<Proyecto> getProyectos() {
        return proyectos;
    }


    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public void setProyectoVacio() {
        setProyecto(new Proyecto());
    }
}
