/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;


import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;


@Named(value = "controlAutorizacion")
@SessionScoped
public class ControlAutorizacion implements Serializable {

    private String usuario;

    /**
     * Creates a new instance of ControlAutorizacion
     */
    public ControlAutorizacion() {
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String home() {
        return usuario == null ? null : usuario.equals("admin") ? "adminpage.xhtml" : "userpage.xhtml";
    }

    public String logout() {
        // Destruye la sesión (y con ello, el ámbito de este bean)
        FacesContext ctx = FacesContext.getCurrentInstance();
        ctx.getExternalContext().invalidateSession();
        usuario = null;
        return "inicio.xhtml";
    }
}
