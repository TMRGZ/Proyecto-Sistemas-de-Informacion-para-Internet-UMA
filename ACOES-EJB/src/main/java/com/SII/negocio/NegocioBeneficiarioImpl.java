/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SII.negocio;

import com.SII.entidades.Beneficiario;
import com.SII.entidades.Usuario;
import com.SII.negocio.excepciones.AcoesException;
import com.SII.negocio.excepciones.BeneficiarioInexistenteException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author juan_
 */
@Stateless
public class NegocioBeneficiarioImpl implements NegocioBeneficiario {

    @PersistenceContext(unitName = "ACOES")
    private EntityManager em;
    @EJB
    private NegocioUsuario negocioUsuario;

    @Override
    public void anadirBeneficiario(Usuario u) throws AcoesException {
        negocioUsuario.registrarUsuario(u);
    }

    @Override
    public void modificarBeneficiario(Beneficiario b) throws AcoesException {
        Beneficiario aux = em.find(Beneficiario.class, b.getCodigo());

        if (aux == null) {
            throw new BeneficiarioInexistenteException();
        }

        aux.setIdentificador(b.getIdentificador());
        aux.setNombre(b.getNombre());
        aux.setApellidos(b.getApellidos());
        aux.setNumeroCuenta(b.getNumeroCuenta());
        aux.setTipo(b.getTipo());
        aux.setObservaciones(b.getObservaciones());

        em.merge(aux);
    }

    @Override
    public void borrarBeneficiario(Beneficiario b) throws AcoesException {
        Beneficiario aux = em.find(Beneficiario.class, b.getCodigo());

        if (aux == null) {
            throw new BeneficiarioInexistenteException();
        }
        em.remove(em.merge(b));
    }

    @Override
    public List<Beneficiario> getListaBeneficiario() {
        return em.createQuery("select a from Beneficiario a", Beneficiario.class).getResultList();
    }
}
