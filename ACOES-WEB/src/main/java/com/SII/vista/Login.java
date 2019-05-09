/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SII.vista;


import com.SII.entidades.Usuario;
import com.SII.negocio.NegocioUsuario;
import com.SII.negocio.excepciones.AcoesException;
import com.SII.negocio.excepciones.ContrasennaInvalidaException;
import com.SII.negocio.excepciones.CuentaInexistenteException;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;


@Named(value = "login")
@RequestScoped
public class Login {
    @Inject
    private InfoSesion sesion;

    @Inject
    private NegocioUsuario negocioUsuario;

    private Usuario usuario;


    /**
     * Creates a new instance of Login
     */
    public Login() {
        usuario = new Usuario();
    }


    public String autenticar() {
        try {
            negocioUsuario.compruebaLogin(usuario);
            sesion.setUsuario(negocioUsuario.refrescarUsuario(usuario));
            return sesion.getUsuario().getRol() == 1 ? "adminpage.xhtml" : "userpage.xhtml";

        } catch (CuentaInexistenteException e) {
            FacesMessage fm = new FacesMessage("la cuenta no existe");
            FacesContext.getCurrentInstance().addMessage("login:user", fm);
        } catch (ContrasennaInvalidaException e) {
            FacesMessage fm = new FacesMessage("La contraseña no es correcta");
            FacesContext.getCurrentInstance().addMessage("login:user", fm);
        } catch (AcoesException e) {
            FacesMessage fm = new FacesMessage("Error " + e);
            FacesContext.getCurrentInstance().addMessage("login:user", fm);
        }
        return null;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
