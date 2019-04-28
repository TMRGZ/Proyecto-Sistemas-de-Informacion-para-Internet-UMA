package Beans;

import Entidades.Proyecto;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Named(value = "listaProyectos")
@ManagedBean
@RequestScoped
public class CatalogoProyectos implements Serializable {

    private List<Proyecto> proyectos;

    @PostConstruct
    public void init() {
        proyectos = new ArrayList<>();
        proyectos.add(new Proyecto(new BigDecimal(1), "Charla en la UMA"));
        proyectos.add(new Proyecto(new BigDecimal(2), "Adaptarse al sistema de los alumnos"));


    }

    public List<Proyecto> getProyectos() {
        return proyectos;
    }
}
