/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SII.negocio;

import com.SII.entidades.Becado;
import com.SII.entidades.Beneficiario;
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
    private NegocioPerfil negocioPerfil;

    @Override
    public void anadirBeneficiario(Beneficiario b) throws AcoesException {
        negocioPerfil.registrarPerfil(b.getUsuarioNombreUsuario());
    }

    @Override
    public void borrarBeneficiario(Beneficiario b) throws AcoesException {
        negocioPerfil.eliminarPerfil(b.getUsuarioNombreUsuario());
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

        Becado auxBecado = aux.getBecado();

        if (auxBecado != null) {
            auxBecado.setAgente(b.getBecado().getAgente());

            aux.setBecado(auxBecado);
        }


        em.merge(aux);
    }

    @Override
    public List<Beneficiario> getListaBeneficiario() {
        return em.createQuery("select a from Beneficiario a", Beneficiario.class).getResultList();
    }



    @Override
    public void anadirColaboracion(Beneficiario b) {
        em.persist(b);
    }


    @Override
    public void anadirBecado(Becado b) {
        em.persist(b);
        em.merge(b.getBeneficiario());
    }

    @Override
    public List<Becado> getListaBecados() {
        return em.createQuery("select a from Becado a", Becado.class).getResultList();
    }


}
