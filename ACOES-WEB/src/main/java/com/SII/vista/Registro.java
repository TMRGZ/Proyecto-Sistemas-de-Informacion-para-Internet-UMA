/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SII.vista;


import com.SII.entidades.Socio;
import com.SII.entidades.Usuario;
import com.SII.negocio.NegocioUsuario;
import com.SII.negocio.excepciones.CuentaRepetidaException;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named(value = "registro")
@RequestScoped
public class Registro {

    @EJB
    private NegocioUsuario negocioUsuario;

    private Usuario usuario;
    private String repass;
    private Socio socio;
    private boolean registroOK;


    public Registro() {
        usuario = new Usuario();
        socio = new Socio();
    }

    public String registrarUsuario() throws Exception {
        try {
            if (!usuario.getContrasenna().equals(repass)) {
                FacesMessage fm = new FacesMessage("Las contraseñas deben coincidir");
                FacesContext.getCurrentInstance().addMessage("registro:repass", fm);
                return null;
            }
            usuario.setRol(0);
            negocioUsuario.registrarUsuario(usuario);
            negocioUsuario.annadirSocioA(usuario, socio);
            registroOK = true;
            return "inicio.xhtml";
        } catch (CuentaRepetidaException e) {
            FacesMessage fm = new FacesMessage("Existe un usuario con la misma cuenta");
            FacesContext.getCurrentInstance().addMessage("registro:user", fm);

        }
        return null;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getRepass() {
        return repass;
    }

    public void setRepass(String repass) {
        this.repass = repass;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    public boolean isRegistroOK() {
        return registroOK;
    }
}
