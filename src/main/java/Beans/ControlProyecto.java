package Beans;

import Entidades.Proyecto;

import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Named(value = "ctrlproyectos")
@ManagedBean
@RequestScoped
public class ControlProyecto implements Serializable {
    private List<Proyecto> proyectos;

    private Proyecto proyecto;

    private boolean add;


    public ControlProyecto() {
        proyectos = new ArrayList<>();
        proyectos.add(new Proyecto(new BigDecimal(1), "Charla en la UMA"));
        proyectos.add(new Proyecto(new BigDecimal(2), "Adaptarse al sistema de los alumnos"));

    }

    public String AddOrModify(boolean add) {
        this.add = add;
        return "adminproject.xhtml";
    }

    public boolean esAdd() {
        return add;
    }

    public Proyecto addProyecto(String name) {
        Proyecto proyecto = new Proyecto(new BigDecimal(proyectos.size() + 1), name);
        proyectos.add(proyecto);
        return proyecto;
    }

    public void addProyecto(String nombre, BigInteger presupuesto, BigInteger combustible, BigInteger contenedor, BigInteger mantenimiento, String descripcion) {
        updProyecto(addProyecto(nombre), nombre, presupuesto, combustible, contenedor, mantenimiento, descripcion);
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

    public void setProyecto(Proyecto proyecto) { // Proyecto a mostrar
        this.proyecto = proyecto;
    }


}
