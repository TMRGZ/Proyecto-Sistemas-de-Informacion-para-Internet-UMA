/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SII.vista;


import com.SII.entidades.*;
import com.SII.negocio.NegocioSocio;
import com.SII.negocio.excepciones.AcoesException;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.*;
import javax.ejb.EJB;
import javax.inject.Inject;

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
        
        for(Beneficiario b : ba.getListaBeneficiarios()){
            if(b.getBeneficiario().getTipo().equals("Niño")){
                nc.apadrinar(s, b.getBecado());
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
        List<Becado> lista = new ArrayList<>(socio.getBecadoSet());
        return lista;
    }


}
