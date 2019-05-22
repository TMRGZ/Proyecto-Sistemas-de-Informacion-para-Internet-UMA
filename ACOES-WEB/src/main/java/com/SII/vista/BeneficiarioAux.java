/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SII.vista;

import com.SII.entidades.Beneficiario;
import com.SII.negocio.NegocioBeneficiario;
import com.SII.negocio.NegocioBeneficiarioLocal;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;


/**
 *
 * @author juan_
 */
@Named("bene")
@RequestScoped
public class BeneficiarioAux {
    
    @Inject 
    NegocioBeneficiarioLocal nb;
    
    private Beneficiario beneficiarioadd = new Beneficiario();
    private Beneficiario beneficiario;
    public BeneficiarioAux(){
        
    }
    
    public void borrar(Beneficiario b){
        
        nb.borrarBeneficiario(b);
    }
    
    public String anadir(){
        nb.anadirBeneficiario(beneficiarioadd);
        return "listabeneficiarios.xhtml";
    }
    public String buscar(Beneficiario b){
        beneficiario = b;
        return "infobeneficiarios.xhtml";
    }
    public String modificar(Beneficiario b){
        nb.modificarBeneficiario(b);
        return "listabeneficiarios.xhtml";
    }
    
    public List<Beneficiario> getListaBeneficairios(){
        return nb.getListaBeneficiario();
    }
    
    public Beneficiario getbeneficiarioadd() {
        return beneficiarioadd;
    }
    public Beneficiario getBeneficiario() {
        return beneficiario;
    }

}
