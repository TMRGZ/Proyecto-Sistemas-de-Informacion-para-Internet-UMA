package com.SII.vista;


import com.SII.entidades.Proyecto;
import com.SII.negocio.NegocioProy;
import com.SII.negocio.excepciones.AcoesException;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named(value = "ctrlproyectos")
@RequestScoped
public class ControlProyecto implements Serializable {

    private Proyecto proyecto;
    private int modo;
    @EJB
    private NegocioProy negproy;

    public ControlProyecto() {
        proyecto = new Proyecto();
    }


    public String addProyecto() {

        try {
            negproy.AnnadirProy(proyecto);
        } catch (AcoesException e) {
            FacesMessage fm = new FacesMessage("Existe un Proyecto con el mismo código");
            FacesContext.getCurrentInstance().addMessage("adminproject:addproy", fm);
        }
        return "projects.xhtml";
    }

    public String updProyecto() {
        try {
            negproy.ModificarProy(proyecto);
        } catch (AcoesException e) {
            FacesMessage fm = new FacesMessage("Proyecto Inexistente");
            FacesContext.getCurrentInstance().addMessage("adminproject:modproy", fm);
        }
        return "projects.xhtml";
    }

    public String remProyecto(Proyecto p) {
        try {
            negproy.EliminarProy(p);
        } catch (AcoesException e) {
            FacesMessage fm = new FacesMessage("Proyecto Inexistente");
            FacesContext.getCurrentInstance().addMessage("projects:remproy", fm);
        }
        return "projects.xhtml";
    }

    public List<Proyecto> getProyectos() {

        return negproy.getProys();
    }


    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public int getModo() {
        return modo;
    }

    public void setModo(int modo) {
        this.modo = modo;
    }

    public String administrar(int modo, Proyecto p) {
        this.modo = modo;
        this.setProyecto(p);
        return "adminproject.xhtml";
    }
}
