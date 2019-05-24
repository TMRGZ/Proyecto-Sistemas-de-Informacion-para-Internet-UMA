package com.SII.vista;

import com.SII.entidades.*;
import com.SII.negocio.NegocioPerfil;
import com.SII.negocio.excepciones.AcoesException;
import com.SII.negocio.excepciones.ContrasennaInvalidaException;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named(value = "perfil")
@SessionScoped
public class Perfil implements Serializable {
    @Inject
    private InfoSesion sesion;
    @Inject
    private NegocioPerfil negocioPerfil;
    private Usuario usuario;
    private Modo modo;
    private String repass;

    public Perfil() {
        usuario = new Usuario();
        usuario.setSocio(new Socio());
        usuario.setBeneficiario(new Beneficiario());
        usuario.getBeneficiario().setBecado(new Becado());
        modo = Modo.VER;
    }

    public String eliminar(Usuario usuario) {
        try {
            negocioPerfil.eliminarPerfil(usuario);
            sesion.refrescarUsuario();
        } catch (AcoesException e) {
            return "inicio.xhtml";
        }
        return null;
    }

    public String modificar(Usuario usuario) {
        this.usuario = usuario;
        setModo(Modo.MODIFICAR);
        return "perfilusuario.xhtml";
    }

    public String ver(Usuario usuario) {
        this.usuario = usuario;
        setModo(usuario.equals(sesion.getUsuario()) ? Modo.MODIFICAR : Modo.VER);
        return "perfilusuario.xhtml";
    }

    public boolean esVer() {
        return this.modo == Modo.VER;
    }

    public String registrarUsuario() {
        setModo(Modo.INSERTAR);
        return "perfilusuario.xhtml";
    }

    public String ejecutarAccion() {
        try {
            if (!repass.equals(usuario.getContrasenna())) throw new ContrasennaInvalidaException();
            switch (modo) {
                case INSERTAR:
                    negocioPerfil.registrarPerfil(usuario);
                    break;
                case MODIFICAR:
                    negocioPerfil.modificarPerfil(usuario);
                    break;
            }
            sesion.refrescarUsuario();
            return sesion.home();
        } catch (ContrasennaInvalidaException e) {
            FacesMessage fm = new FacesMessage("Las contraseñas no coinciden");
            FacesContext.getCurrentInstance().addMessage("login:user", fm);
            return null;
        } catch (AcoesException e) {
            return "inicio.xhtml";
        }
    }

    public boolean estasAutorizadoParaEditar() {
        return sesion.getUsuario().getRol() == 1 || sesion.getUsuario().equals(usuario);
    }

    public List<Usuario> getListaPerfiles() {
        return negocioPerfil.getListaPerfiles();
    }

    public List<Notificacion> getNotifiaciones() {
        return new ArrayList<>(sesion.getUsuario().getNotificacionSet());
    }

    public String getAccion() {
        switch (modo) {
            case VER:
                return "Ver";
            case MODIFICAR:
                return "Modificar";
            case INSERTAR:
                return "Registrar";
        }
        return null;
    }

    public String getRepass() {
        return repass;
    }

    public void setRepass(String repass) {
        this.repass = repass;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Modo getModo() {
        return modo;
    }

    public void setModo(Modo modo) {
        this.modo = modo;
    }

    public enum Modo {
        MODIFICAR,
        VER,
        INSERTAR
    }
}
