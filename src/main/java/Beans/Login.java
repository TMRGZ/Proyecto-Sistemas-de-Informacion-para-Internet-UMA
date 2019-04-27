/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Entidades.Usuario;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author francis
 */
@Named(value = "login")
@RequestScoped
public class Login {

    private String usuario;
    private String password;
    private List<Usuario> usuarios;


    @Inject
    private ControlAutorizacion ctrl;

    /**
     * Creates a new instance of Login
     */
    public Login() {
        usuarios = new ArrayList<>();
        usuarios.add(new Usuario(new BigDecimal(1), "admin", "admin"));
        usuarios.add(new Usuario(new BigDecimal(2), "user", "user"));

    }

    public String getUsuario() {
        return usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String autenticar() {
        // Implementar este método
        FacesContext ctx = FacesContext.getCurrentInstance();

        for (Usuario usuario1 : usuarios) {
            if (usuario1.getNombreUsuario().equalsIgnoreCase(usuario) && usuario1.getContrasena().equals(password)) {
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
