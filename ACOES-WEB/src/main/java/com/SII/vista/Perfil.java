package com.SII.vista;

import com.SII.entidades.Becado;
import com.SII.entidades.Beneficiario;
import com.SII.entidades.Socio;
import com.SII.entidades.Usuario;
import com.SII.negocio.NegocioPerfil;
import com.SII.negocio.excepciones.AcoesException;

import javax.enterprise.context.RequestScoped;
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
            switch (modo) {
                case INSERTAR:
                    if (!repass.equals(usuario.getContrasenna())) return null;
                    negocioPerfil.registrarPerfil(usuario);
                    break;
                case MODIFICAR:
                    negocioPerfil.modificarPerfil(usuario);
                    break;
            }
            sesion.refrescarUsuario();
            return sesion.home();
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
        return usuario.getSocioNumero();
    }

    public void setSocio(Socio socio) {
        this.usuario.setSocioNumero(socio);
    }

    public Beneficiario getBeneficiario() {
        return usuario.getBeneficiarioCodigo();
    }

    public void setBeneficiario(Beneficiario beneficiario) {
        this.usuario.setBeneficiarioCodigo(beneficiario);
    }

    public Becado getBecado() {
        return usuario.getBeneficiarioCodigo() == null ? null : usuario.getBeneficiarioCodigo().getBecado();
    }

    public void setBecado(Becado becado) {
        this.usuario.getBeneficiarioCodigo().setBecado(becado);
    }

    public enum Modo {
        MODIFICAR,
        VER,
        INSERTAR
    }
}
