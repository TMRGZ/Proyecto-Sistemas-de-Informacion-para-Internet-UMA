package com.SII.negocio;

import com.SII.entidades.Beneficiario;
import com.SII.entidades.Proyecto;
import com.SII.negocio.excepciones.AcoesException;

import javax.ejb.Local;
import java.util.List;
import java.util.Set;

@Local
public interface NegocioProy {
    void annadirProy(Proyecto p) throws AcoesException;

    void modificarProy(Proyecto p) throws AcoesException;

    void eliminarProy(Proyecto p) throws AcoesException;

    List<Proyecto> getProys();

    void annadirBen(Proyecto p, Beneficiario b) throws AcoesException;

    Set<Beneficiario> getBeneficiarios(Proyecto p) throws AcoesException;

    void eliminarBen(Proyecto proyecto, Beneficiario b) throws AcoesException;
}
