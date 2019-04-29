/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Entidades.Beneficiario;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.ArrayList;

/**
 * @author juan_
 */
@Named(value = "controlben")
@RequestScoped
public class ControlBeneficiario {
    private ArrayList<Beneficiario> beneficiarios = new ArrayList<>();

    public ControlBeneficiario() {
        beneficiarios.add(new Beneficiario("1", "1-1", "paco", "N"));
        beneficiarios.add(new Beneficiario("2", "1-2", "Julian Muñoz", "S"));
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public String buscar() {
        return "infobeneficiarios.xhtml";
    }

    public ArrayList<Beneficiario> getBeneficiarios() {
        return beneficiarios;
    }
}

