/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Entidades.Beneficiario;
import java.util.ArrayList;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author juan_
 */
@Named(value = "controlben")
@RequestScoped
public class controlbeneficiario {
    private ArrayList<Beneficiario> beneficiarios = new ArrayList<>();

    public controlbeneficiario (){
        beneficiarios.add(new Beneficiario("1","1-1","paco","N"));
         beneficiarios.add(new Beneficiario("2","1-2","Julian Muñoz","S"));
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    public String buscar(){
        return "infobeneficiarios.xhtml";
}

    public ArrayList<Beneficiario> getBeneficiarios(){
        return beneficiarios;
    }
}

