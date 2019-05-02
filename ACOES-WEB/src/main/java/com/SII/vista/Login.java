/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SII.vista;


import com.SII.entidades.Usuario;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;


@Named(value = "login")
@RequestScoped
public class Login {

    private String usuario;
    private String password;
    private List<Usuario> usuarios;

    private EntityManagerFactory emf;
    private EntityManager em;


    @Inject
    private ControlAutorizacion ctrl;

    /**
     * Creates a new instance of Login
     */
    public Login() {
        usuarios = new ArrayList<>();
        usuarios.add(new Usuario("user", 0, "user", '0'));
        usuarios.add(new Usuario("admin", 1, "admin", '1'));
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String autenticar() {
        // Implementar este método
        FacesContext ctx = FacesContext.getCurrentInstance();

        for (Usuario usuario1 : usuarios) {
            if (usuario1.getNombreUsuario().equalsIgnoreCase(usuario) && usuario1.getContrasenna().equals(password)) {
                ctrl.setUsuario(usuario1);
            }
        }

        if (ctrl.getUsuario() == null) {
            ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario o contraseña no correctos", "Usuario o contraseña no correctos"));
            return null;
        }


        return ctrl.home();
    }
}
