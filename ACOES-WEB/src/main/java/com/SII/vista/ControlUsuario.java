/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SII.vista;


import com.SII.entidades.Becado;
import com.SII.entidades.Beneficiario;
import com.SII.entidades.Socio;
import com.SII.entidades.Usuario;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named(value = "ctrlUsuario")
@SessionScoped
public class ControlUsuario implements Serializable {

    private Usuario usuario;
    private Socio socio;
    private Beneficiario beneficiario;
    private Becado becado;

    public ControlUsuario() {
        Beneficiario beneficiario = new Beneficiario("2", "1-2", "Julian Muñoz", "Socio pero niño");
        Socio socio = new Socio(1, beneficiario.getNombre(), "69Z", "C/Alcampo", "Ibi", "03440", "Alicante", 666666666, "pepa@pepa.es");
        Becado becado = new Becado("CodigoBecadoAqui");

        Usuario usuario = new Usuario(0,"Ejemplo",  "pass", 0);
        beneficiario.setBecado(becado);
        usuario.setBeneficiarioCodigo(beneficiario);
        usuario.setSocio(socio);
        this.usuario = usuario;
        this.socio = usuario.getSocio();
        this.beneficiario = usuario.getBeneficiarioCodigo();
        this.becado = this.beneficiario.getBecado();

    }


    public String verPerfil(Usuario usuario) {
        /*this.usuario = usuario;
        this.socio = usuario.getSocio();
        this.becado = usuario.getBeneficiarioCodigo().getBecado();
        this.beneficiario = usuario.getBeneficiarioCodigo();*/
        return "perfilusuario.xhtml";
    }

    public String modificar() {
        return "perfilUsuario.xhtml";
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    public Beneficiario getBeneficiario() {
        return beneficiario;
    }

    public void setBeneficiario(Beneficiario beneficiario) {
        this.beneficiario = beneficiario;
    }

    public Becado getBecado() {
        return becado;
    }

    public void setBecado(Becado becado) {
        this.becado = becado;
    }

}