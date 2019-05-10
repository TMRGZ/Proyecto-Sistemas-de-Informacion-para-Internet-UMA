package com.SII.vista;

import com.SII.entidades.Becado;
import com.SII.entidades.Beneficiario;
import com.SII.entidades.Socio;
import com.SII.entidades.Usuario;
import com.SII.negocio.NegocioPerfil;
import com.SII.negocio.excepciones.AcoesException;
import com.SII.negocio.excepciones.ContrasennaInvalidaException;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named(value = "perfil")
@RequestScoped
public class Perfil {
    @Inject
    private InfoSesion sesion;
    @Inject
    private NegocioPerfil negocioPerfil;
    private Usuario usuario;
    private Modo modo;
    private String repass;

    public Perfil() {
        usuario = new Usuario();
        modo = Modo.VER;
    }

    public String refrescar() {
        sesion.refrescarUsuario();
        return null;
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
        setModo(Modo.VER);
        return "perfilusuario.xhtml";
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

    public Socio getSocio() {
        return usuario.getSocio();
    }

    public void setSocio(Socio socio) {
        this.usuario.setSocio(socio);
    }

    public Beneficiario getBeneficiario() {
        return usuario.getBeneficiario();
    }

    public void setBeneficiario(Beneficiario beneficiario) {
        this.usuario.setBeneficiario(beneficiario);
    }

    public Becado getBecado() {
        return usuario.getBeneficiario() == null ? null : usuario.getBeneficiario().getBecado();
    }

    public void setBecado(Becado becado) {
        this.usuario.getBeneficiario().setBecado(becado);
    }

    public enum Modo {
        MODIFICAR,
        VER,
        INSERTAR
    }
}
