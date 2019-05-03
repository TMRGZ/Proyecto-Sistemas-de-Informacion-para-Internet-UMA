/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SII.vista;


import com.SII.entidades.Usuario;
import com.SII.negocio.NegocioUsuario;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;


@Named(value = "login")
@RequestScoped
public class Login {
    /*@Inject
    private ControlAutorizacion ctrl;*/

    @Inject
    private InfoSesion sesion;

    @Inject
    private NegocioUsuario negocioUsuario;

    private Usuario usuario;

    /**
     * Creates a new instance of Login
     */
    public Login() {
        /*usuarios = new ArrayList<>();
        usuarios.add(new Usuario("user", 0, "user", '0'));
        usuarios.add(new Usuario("admin", 1, "admin", '1'));*/
        usuario = new Usuario();
    }


    public String autenticar() {
        try {
            negocioUsuario.compruebaLogin(usuario);
            sesion.setUsuario(negocioUsuario.refrescarUsuario(usuario));
            return sesion.getUsuario().getRol() == '1' ? "adminpage.xhtml" : "userpage.xhtml";

        } catch (Exception e) {
            FacesMessage fm = new FacesMessage("Error en login");
            FacesContext.getCurrentInstance().addMessage("login:user", fm);
        }
        return null;

        /*FacesContext ctx = FacesContext.getCurrentInstance();

        for (Usuario usuario1 : usuarios) {
            if (usuario1.getNombreUsuario().equalsIgnoreCase(usuario) && usuario1.getContrasenna().equals(password)) {
                ctrl.setUsuario(usuario1);
            }
        }

        if (ctrl.getUsuario() == null) {
            ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario o contraseña no correctos", "Usuario o contraseña no correctos"));
            return null;
        }


        return ctrl.home();*/
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
