package Beans;

import Entidades.Proyecto;

import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Named(value = "ctrlproyectos")
@ManagedBean
@RequestScoped
public class ControlProyecto implements Serializable {
    private List<Proyecto> proyectos;

    public ControlProyecto() {
        proyectos = new ArrayList<>();
        proyectos.add(new Proyecto(new BigDecimal(1), "Charla en la UMA"));
        proyectos.add(new Proyecto(new BigDecimal(2), "Adaptarse al sistema de los alumnos"));

    }

    public void addProyecto(String name) {
        proyectos.add(new Proyecto(new BigDecimal(proyectos.size()), name));
    }


    public String remProyecto(BigDecimal b) {
        for (Proyecto proyecto : proyectos) {
            if (proyecto.getCodigo().equals(b)) {
                proyectos.remove(proyecto);
                return null;
            }
        }
        return null;
    }

    public void updProyecto(Proyecto p) {
        proyectos.remove(p);
        proyectos.add(p);
    }

    public List<Proyecto> getProyectos() {
        return proyectos;
    }
}
