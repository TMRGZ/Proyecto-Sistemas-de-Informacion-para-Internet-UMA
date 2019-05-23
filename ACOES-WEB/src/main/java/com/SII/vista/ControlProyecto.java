package com.SII.vista;


import com.SII.entidades.Beneficiario;
import com.SII.entidades.Proyecto;
import com.SII.negocio.NegocioProy;
import com.SII.negocio.excepciones.AcoesException;
import com.SII.negocio.excepciones.ProyInexistenteException;
import com.SII.negocio.excepciones.ProyRepException;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Named(value = "ctrlproyectos")
@SessionScoped
public class ControlProyecto implements Serializable {

    @EJB
    private NegocioProy negproy;
    @Inject
    private InfoSesion sesion;

    @Inject
    private BeneficiarioAux ba;

    private Proyecto proyecto;
    private Modo modo;

    public ControlProyecto() {
        proyecto = new Proyecto();
        modo = Modo.VER;
    }

    public List<Beneficiario> getParticipantes(Proyecto p) {
        try {
            this.proyecto = p;
            return new ArrayList<>(negproy.getBeneficiarios(proyecto));

        } catch (AcoesException e) {
            FacesMessage fm = new FacesMessage("Proyecto Inexistente");
            FacesContext.getCurrentInstance().addMessage("addbeneficiario:add", fm);
            return null;
        }
    }

    public List<Beneficiario> getRestantes(Proyecto p) {
        try {
            this.proyecto = p;
            Set<Beneficiario> ben = negproy.getBeneficiarios(proyecto);
            Set<Beneficiario> aux = new HashSet<>(ba.getListaBeneficiarios());
            aux.removeAll(ben);
            return new ArrayList<>(aux);
        } catch (AcoesException e) {
            FacesMessage fm = new FacesMessage("Proyecto Inexistente");
            FacesContext.getCurrentInstance().addMessage("addbeneficiario:rem", fm);
            return null;
        }
    }

    public String addBen(Beneficiario b) {
        try {
            negproy.annadirBen(proyecto, b);
            return null;
        } catch (AcoesException e) {
            FacesMessage fm = new FacesMessage("Proyecto Inexistente");
            FacesContext.getCurrentInstance().addMessage("addbeneficiario:add", fm);
            return null;
        }
    }

    public String remBen(Beneficiario b) {
        try {
            negproy.eliminarBen(proyecto, b);
            return null;
        } catch (AcoesException e) {
            FacesMessage fm = new FacesMessage("Proyecto Inexistente");
            FacesContext.getCurrentInstance().addMessage("addbeneficiario:rem", fm);
            return null;
        }
    }

    public String Beneficiarios(Proyecto proyecto) {
        this.proyecto = proyecto;
        sesion.refrescarUsuario();
        return "addbeneficiario.xhtml";
    }

    public String ver(Proyecto proyecto) {
        this.proyecto = proyecto;
        setModo(Modo.VER);
        return "detailsproject.xhtml";
    }

    public String modificar(Proyecto proyecto) {
        this.proyecto = proyecto;
        setModo(Modo.MODIFICAR);
        return "adminproject.xhtml";
    }

    public String annadir() {
        setModo(Modo.INSERTAR);
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
            FacesContext.getCurrentInstance().addMessage("adminproject:accion", fm);
            return null;

        } catch (ProyRepException e) {
            FacesMessage fm = new FacesMessage("Existe un Proyecto con el mismo código");
            FacesContext.getCurrentInstance().addMessage("adminproject:accion", fm);
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
