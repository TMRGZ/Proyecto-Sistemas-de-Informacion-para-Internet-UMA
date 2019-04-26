/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * @author francis
 */
@Named(value = "login")
@RequestScoped
public class Login {

    private String usuario;


    @Inject
    private ControlAutorizacion ctrl;

    /**
     * Creates a new instance of Login
     */
    public Login() {

    }

    public String getUsuario() {
        return usuario;
    }


    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }


    public String autenticar() {
        // Implementar este método
        FacesContext ctx = FacesContext.getCurrentInstance();


        ctrl.setUsuario(usuario);

        if (ctrl.getUsuario() == null || ctrl.getUsuario().trim().length() == 0) {
            ctrl.setUsuario(null);
            ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario o contraseña no correctos", "Usuario o contraseña no correctos"));
            return null;
        }


        return ctrl.home();
    }
}
