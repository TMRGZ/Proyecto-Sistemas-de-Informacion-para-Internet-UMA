/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SII.negocio;

import com.SII.entidades.Becado;
import com.SII.entidades.Beneficiario;
import com.SII.entidades.Usuario;
import com.SII.negocio.excepciones.AcoesException;

import javax.ejb.Local;
import java.util.List;

/**
 * @author juan_
 */
@Local
public interface NegocioBeneficiario {

    void anadirBeneficiario(Beneficiario b) throws AcoesException;

    void modificarBeneficiario(Beneficiario b,Beneficiario bene) throws AcoesException;

    void borrarBeneficiario(Beneficiario b) throws AcoesException;

    List<Beneficiario> getListaBeneficiario();

    List<Becado> getListaBecados();

    void anadirColaboracion(Beneficiario b) throws AcoesException;

    void anadirBecado(Becado b);
    public void Notificar(Usuario u);

    public Beneficiario BuscarResponsable(Long clavePrimaria);

    public boolean EsResponsable(Beneficiario b);
}
