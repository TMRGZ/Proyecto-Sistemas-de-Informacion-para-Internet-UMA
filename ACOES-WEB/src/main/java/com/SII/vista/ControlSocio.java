/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SII.vista;


import com.SII.entidades.*;
import com.SII.negocio.NegocioSocioImpl;
import com.SII.negocio.excepciones.AcoesException;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Named(value = "ctrlsocio")
@SessionScoped
public class ControlSocio implements Serializable {

    private NegocioSocioImpl nc;

    public ControlSocio() {
        
    }

    public List<Notificacion> getNotificaciones(Usuario u) throws AcoesException {
        Socio socio = nc.buscar(u);
        if (socio.getUsuarioNombreUsuario().getNotificacionSet() == null) {
            socio.getUsuarioNombreUsuario().setNotificacionSet(new HashSet<>());        }
        return new ArrayList<>(socio.getUsuarioNombreUsuario().getNotificacionSet());
    }

    public String apadrinar(Usuario u, Set<Beneficiario> listben) throws AcoesException {
        Socio socio = nc.buscar(u);
        if (socio.getBecadoSet() == null) {
            socio.setBecadoSet(new HashSet<>());
        }


        for (Beneficiario beneficiario : listben) {
            if (beneficiario.getTipo().equals("Niño")) {
                Becado b = new Becado();
                b.setBeneficiario(beneficiario);
                nc.apadrinar(socio, b);
            }
        }

        return "listaapadrinados.xhtml";
    }

    public String desapadrinar(Usuario u, Set<Beneficiario> listben) throws AcoesException {
        
        Socio socio = nc.buscar(u);
        if (socio.getBecadoSet() == null) {
            socio.setBecadoSet(new HashSet<>());
        }


      

        return "listaapadrinados.xhtml";
    }
    
    public Set<Becado> buscar(Usuario u) throws AcoesException {
        Socio socio = nc.buscar(u);
        
        return socio.getBecadoSet();
    }


}
