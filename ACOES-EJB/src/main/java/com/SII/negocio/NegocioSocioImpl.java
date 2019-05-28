/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SII.negocio;

import com.SII.negocio.excepciones.SocioInexistenteException;
import com.SII.entidades.Becado;
import com.SII.entidades.Socio;
import com.SII.entidades.Usuario;
import com.SII.negocio.excepciones.AcoesException;
import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Iván
 */
public class NegocioSocioImpl implements NegocioSocio{
    
    @PersistenceContext(unitName = "ACOES")
    private EntityManager em;
    @EJB
    private NegocioPerfil negocioPerfil;
    
    @Override
    public void anadirSocio(Socio s) throws AcoesException {
        em.persist(s);
    }

    @Override
    public void borrarSocio(Socio s) throws AcoesException {
        Socio aux = em.find(Socio.class, s.getNumero());
        if (aux == null) {
            throw new SocioInexistenteException();
        }
        em.remove(em.merge(s));
    }

    @Override
    public void modificarSocio(Socio s) throws AcoesException {
         Socio aux = em.find(Socio.class, s.getNumero());

        if (aux == null) {
            throw new SocioInexistenteException();
        }

        aux.setNumero(s.getNumero());
        aux.setNombre(s.getNombre());
        aux.setNif(s.getNif());
        aux.setDireccion(s.getDireccion());
        aux.setPoblacion(s.getPoblacion());
        aux.setCodigoPostal(s.getCodigoPostal());
        aux.setProvincia(s.getProvincia());
        aux.setTelefono(s.getTelefono());
        aux.setCorreoElectronico(s.getCorreoElectronico());
       

        em.merge(aux);
    }

    @Override
    public void apadrinar(Socio s, Becado b) throws AcoesException {
        Socio aux = em.find(Socio.class, s.getNumero());
        if (aux == null) {
            throw new SocioInexistenteException();
        }
        aux.getBecadoSet().add(b);
        em.merge(aux);
        
    }

    @Override
    public void desapadrinar(Socio s, Becado b) throws AcoesException {
        Socio aux = em.find(Socio.class, s.getNumero());
        if (aux == null) {
            throw new SocioInexistenteException();
        }
        aux.getBecadoSet().remove(b);
        em.merge(aux);
    }

    @Override
    public Socio buscar(Usuario u) throws AcoesException {
        Socio socio = em.find(Socio.class, u.getSocio().getNumero());
        if (socio == null) {
            throw new SocioInexistenteException();
        }
        return socio;
    }

    
}
