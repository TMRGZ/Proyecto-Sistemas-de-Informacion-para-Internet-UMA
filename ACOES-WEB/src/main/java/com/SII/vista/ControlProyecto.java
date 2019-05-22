package com.SII.vista;


import com.SII.entidades.Proyecto;
import com.SII.negocio.NegocioProy;
import com.SII.negocio.excepciones.AcoesException;
import com.SII.negocio.excepciones.ProyInexistenteException;
import com.SII.negocio.excepciones.ProyRepException;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named(value = "ctrlproyectos")
@RequestScoped
public class ControlProyecto implements Serializable {

    @Inject
    private NegocioProy negproy;
    @Inject
    private InfoSesion sesion;

    private Proyecto proyecto;
    private Modo modo;

    public ControlProyecto() {
        proyecto = new Proyecto();
        modo = Modo.VER;
    }

    public String ver(Proyecto proyecto) {
        this.proyecto = proyecto;
        setModo(Modo.VER);
        return "detailsproject.xhtml";
    }

    public String annadir() {
        setModo(Modo.INSERTAR);
        return "adminproject.xhtml";
    }

    public String modificar(Proyecto proyecto) {
        this.proyecto = proyecto;
        setModo(Modo.MODIFICAR);
        return "adminproject.xhtml";
    }

    public String ejecutarAccion() {
        try {
            switch (modo) {
                case MODIFICAR:
                    negproy.modificarProy(proyecto);
                    break;
                case INSERTAR:
                    negproy.annadirProy(proyecto);
                    break;
            }
            sesion.refrescarUsuario();
            return "projects.xhtml";

        } catch (ProyInexistenteException e) {
            FacesMessage fm = new FacesMessage("Proyecto Inexistente");
            FacesContext.getCurrentInstance().addMessage("adminproject:modproy", fm);
            return null;

        } catch (ProyRepException e) {
            FacesMessage fm = new FacesMessage("Existe un Proyecto con el mismo código");
            FacesContext.getCurrentInstance().addMessage("adminproject:addproy", fm);
            return null;

        } catch (AcoesException e) {
            return "inicio.xhtml";
        }
    }

    public String getAccion() {
        switch (modo) {
            case VER:
                return "Ver";
            case MODIFICAR:
                return "Modificar";
            case INSERTAR:
                return "Añadir";
        }
        return null;
    }

    public Modo getModo() {
        return modo;
    }

    public void setModo(Modo modo) {
        this.modo = modo;
    }

    public String remProyecto(Proyecto p) {
        try {
            negproy.eliminarProy(p);
        } catch (AcoesException e) {
            FacesMessage fm = new FacesMessage("Proyecto Inexistente");
            FacesContext.getCurrentInstance().addMessage("projects:remproy", fm);
        }
        return null;
    }

    public List<Proyecto> getProyectos() {
        return negproy.getProys();
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public enum Modo {
        MODIFICAR,
        VER,
        INSERTAR
    }


}
