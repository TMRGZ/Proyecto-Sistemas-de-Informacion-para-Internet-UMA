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
    public void anadirColaboracion(Beneficiario b) throws AcoesException {
        em.persist(b);
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
    public void modificarBecado(Beneficiario b){
        Becado aux = em.find(Becado.class, b.getBecado().getCodigo());
        
        aux.setAgente(b.getBecado().getAgente());
        
        em.merge(aux);
    }

    @Override
    public void borrarBeneficiario(Beneficiario b) throws AcoesException {
        negocioPerfil.eliminarPerfil(b.getUsuarioNombreUsuario());
    }

    @Override
    public List<Beneficiario> getListaBeneficiario() {
        return em.createQuery("select a from Beneficiario a", Beneficiario.class).getResultList();
    }
    @Override
    public void anadirBecado(Beneficiario b){
          Becado bec = new Becado(b.getCodigo());
          b.setBecado(bec);
          bec.setBeneficiario(b);
          em.persist(bec);
    }
}
