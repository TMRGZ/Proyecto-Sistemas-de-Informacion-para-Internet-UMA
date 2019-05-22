/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SII.negocio;

import com.SII.entidades.Beneficiario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author juan_
 */
@Local
public interface NegocioBeneficiarioLocal {
    
     void anadirBeneficiario(Beneficiario b);
     void modificarBeneficiario(Beneficiario b);
     void borrarBeneficiario(Beneficiario b);
     List<Beneficiario> getListaBeneficiario();
}
