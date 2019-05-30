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
import com.SII.negocio.NegocioSocio;
import com.SII.negocio.excepciones.AcoesException;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named(value = "ctrlsocio")
@SessionScoped
public class ControlSocio implements Serializable {

    @EJB
    private NegocioSocio nc;
    @Inject
    private InfoSesion sesion;
    @Inject
    private BeneficiarioAux ba;


    public String apadrinar() throws AcoesException {

        Socio s = sesion.getUsuario().getSocio();
        boolean apadrinado = false;
        for (Beneficiario b : ba.getListaBeneficiarios()) {
            if (b.getBeneficiario().getTipo().equals("Niño") && !apadrinado && b.getBecado().getSocioNumero() == null) {
                nc.apadrinar(s, b.getBecado());
                apadrinado = true;
            }
        }

        return "listaapadrinados.xhtml";

    }

    public String desapadrinar(Beneficiario b) throws AcoesException {

        Socio s = sesion.getUsuario().getSocio();
        nc.desapadrinar(s, b.getBecado());

        return "listaapadrinados.xhtml";
    }

    public List<Becado> buscar(Usuario u) throws AcoesException {
        Socio socio = nc.buscar(u);
        return new ArrayList<>(socio.getBecadoSet());
    }


}
