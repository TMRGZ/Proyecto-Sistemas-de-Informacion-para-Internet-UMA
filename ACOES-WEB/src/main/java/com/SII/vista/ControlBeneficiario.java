/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SII.vista;


import com.SII.entidades.Beneficiario;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author juan_
 */
@Named(value = "controlben")
@RequestScoped
public class ControlBeneficiario implements Serializable {

    private Set<Beneficiario> beneficiarios = new HashSet<>();

    private Beneficiario beneficiario;
    private Beneficiario beneficiarioadd = new Beneficiario();

    public ControlBeneficiario() {
        beneficiarios.add(new Beneficiario("1", "1-1", "paco", "Niño"));
        beneficiarios.add(new Beneficiario("2", "1-2", "Julian Muñoz", "Socio"));
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public String buscar(Beneficiario ben) {
        this.beneficiario = ben;
        return "infobeneficiarios.xhtml";
    }

    public Set<Beneficiario> getBeneficiarios() {
        return beneficiarios;
    }

    public Beneficiario getBeneficiario() {
        return beneficiario;
    }

    public String modificar() {
        return "listabeneficiarios.xhtml";
    }

    public String borrar(Beneficiario ben) {
        beneficiarios.remove(ben);
        return "listabeneficiarios.xhtml";
    }

    public Beneficiario getbeneficiarioadd() {
        return beneficiarioadd;
    }

    public String add() {
        beneficiarios.add(beneficiarioadd);
        return "listabeneficiarios.xhtml";
    }
}
