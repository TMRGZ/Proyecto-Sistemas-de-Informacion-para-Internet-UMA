package com.SII.vista;

import com.SII.entidades.Usuario;
import com.SII.negocio.NegocioUsuario;
import com.SII.negocio.excepciones.AcoesException;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;

@Named(value = "infoSesion")
@SessionScoped
public class InfoSesion implements Serializable {
    @EJB
    private NegocioUsuario negocioUsuario;

    private Usuario usuario;


    public InfoSesion() {
    }

    public synchronized String home() {
        return usuario == null ? null : usuario.getRol() == 1 ? "adminpage.xhtml" : "userpage.xhtml";
    }

    public synchronized String invalidarSesion() {
        if (usuario != null) {
            usuario = null;
            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        }
        return "inicio.xhtml";
    }

    public synchronized void refrescarUsuario() {
        try {
            if (usuario != null) {
                usuario = negocioUsuario.refrescarUsuario(usuario);
            }
        } catch (AcoesException ignored) {

        }
    }

    public synchronized Usuario getUsuario() {
        return usuario;
    }

    public synchronized void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
