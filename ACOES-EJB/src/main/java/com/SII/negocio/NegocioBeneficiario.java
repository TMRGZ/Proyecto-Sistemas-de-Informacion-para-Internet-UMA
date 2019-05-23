/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SII.negocio;

import com.SII.entidades.Beneficiario;
import com.SII.negocio.excepciones.AcoesException;

import javax.ejb.Local;
import java.util.List;

/**
 *
 * @author juan_
 */
@Local
public interface NegocioBeneficiario {

    void anadirBeneficiario(Beneficiario b) throws AcoesException;

    void modificarBeneficiario(Beneficiario b) throws AcoesException;

    void borrarBeneficiario(Beneficiario b) throws AcoesException;

    List<Beneficiario> getListaBeneficiario();

    void anadirColaboracion(Beneficiario b) throws AcoesException;
}
