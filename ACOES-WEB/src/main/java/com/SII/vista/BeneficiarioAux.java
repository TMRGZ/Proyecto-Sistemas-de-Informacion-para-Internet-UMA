/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SII.vista;

import com.SII.entidades.Beneficiario;
import com.SII.entidades.Usuario;
import com.SII.negocio.NegocioBeneficiario;
import com.SII.negocio.excepciones.AcoesException;
import com.SII.negocio.excepciones.BeneficiarioInexistenteException;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;


/**
 * @author juan_
 */
@Named("bene")
@RequestScoped
public class BeneficiarioAux {

    @Inject
    private NegocioBeneficiario nb;
    @Inject
    private InfoSesion sesion;

    private Beneficiario beneficiario;
    private Modo modo;

    public BeneficiarioAux() {
        beneficiario = new Beneficiario();
        modo = Modo.VER;
    }

    public String borrar(Beneficiario b) {
        try {
            nb.borrarBeneficiario(b);
        } catch (AcoesException e) {
            FacesMessage fm = new FacesMessage("Beneficiario Inexistente");
            FacesContext.getCurrentInstance().addMessage("benef:remben", fm);
        }
        return null;
    }

    public String ver(Beneficiario beneficiario) {
        this.beneficiario = beneficiario;
        setModo(Modo.VER);
        return null; // Usar si implementas el ver detalles
    }

    public String annadir() {
        setModo(Modo.INSERTAR);
        return "adminbeneficiario.xhtml";
    }

    public String modificar(Beneficiario beneficiario) {
        this.beneficiario = beneficiario;
        setModo(Modo.MODIFICAR);
        return "adminbeneficiario.xhtml";
    }

    public String colaborar() throws AcoesException {
        this.beneficiario.setUsuarioNombreUsuario(sesion.getUsuario());
        this.beneficiario.setTipo("Socio");
        this.beneficiario.setIdentificador("test");
        this.beneficiario.setBeneficiarioCodigo(this.beneficiario);
        sesion.getUsuario().setBeneficiario(beneficiario);
        nb.anadirColaboracion(this.beneficiario);


        return sesion.home();
    }

    public String ejecutarAccion() {
        try {
            switch (modo) {
                case INSERTAR:
                    Usuario u = new Usuario();
                    u.setNombreUsuario(beneficiario.getNombre() + beneficiario.getApellidos());
                    u.setContrasenna(beneficiario.getNombre() + beneficiario.getApellidos());
                    u.setRol(0);
                    u.setBeneficiario(beneficiario);
                    beneficiario.setUsuarioNombreUsuario(u);
                    beneficiario.setBeneficiarioCodigo(beneficiario);
                    nb.anadirBeneficiario(beneficiario);
                    break;
                case MODIFICAR:
                    nb.modificarBeneficiario(beneficiario);
                    break;
            }
            sesion.refrescarUsuario();
            return "listabeneficiarios.xhtml";
        } catch (BeneficiarioInexistenteException e) {
            FacesMessage fm = new FacesMessage("Beneficiario Inexistente");
            FacesContext.getCurrentInstance().addMessage("adminbenef:modben", fm);
            return null;
        } catch (AcoesException e) {
            sesion.invalidarSesion();
            return "inicio.xhtml";
        }
    }

    public String getAccion() {
        switch (modo) {
            case VER:
                return "Ver";
            case MODIFICAR:
                return "Modificar";
            case INSERTAR:
                return "Añadir";
        }
        return null;
    }

    public List<Beneficiario> getListaBeneficiarios() {
        return nb.getListaBeneficiario();
    }

    public Beneficiario getBeneficiario() {
        return beneficiario;
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
