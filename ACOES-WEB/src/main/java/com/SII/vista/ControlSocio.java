/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SII.vista;


import com.SII.entidades.*;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.*;

@Named(value = "ctrlsocio")
@SessionScoped
public class ControlSocio implements Serializable {

    private Set<Socio> socios;
    private Socio socio = new Socio();

    public ControlSocio() {
        socios = new HashSet<>();
        socio.setUsuario(new Usuario("user", "user", 0));
        socios.add(socio);
    }

    public List<Notificacion> getNotificaciones(Usuario u) {
        for (Socio s : socios) {
            if (s.getUsuario().equals(u)) {
                socio = s;
            }
        }
        if (socio.getUsuario().getNotificacionSet() == null) {
            socio.getUsuario().setNotificacionSet(new HashSet<>());
            socio.getUsuario().getNotificacionSet().add(new Notificacion(0, 0, 1, new Date(2, Calendar.AUGUST, 20)));
        }
        return new ArrayList<>(socio.getUsuario().getNotificacionSet());
    }

    public String apadrinar(Usuario u, Set<Beneficiario> listben) {
        for (Socio s : socios) {
            if (s.getUsuario().equals(u)) {
                socio = s;
            }
        }
        if (socio.getBecadoSet() == null) {
            socio.setBecadoSet(new HashSet<>());
        }


        for (Beneficiario beneficiario : listben) {
            if (beneficiario.getTipo().equals("Niño")) {
                Becado b = new Becado();
                b.setBeneficiario(beneficiario);
                socio.getBecadoSet().add(b);
            }
        }

        return "userpage.xhtml";
    }

    public Set<Becado> buscar(Usuario u) {
        for (Socio s : socios) {
            if (s.getUsuario().equals(u)) {
                socio = s;
            }
        }
        return socio.getBecadoSet();
    }


}
