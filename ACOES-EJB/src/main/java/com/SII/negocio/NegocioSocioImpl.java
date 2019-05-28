/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SII.negocio;

import com.SII.negocio.excepciones.SocioInexistenteException;
import com.SII.entidades.Becado;
import com.SII.entidades.Beneficiario;
import com.SII.entidades.Socio;
import com.SII.entidades.Usuario;
import com.SII.negocio.excepciones.AcoesException;
import com.SII.negocio.excepciones.BeneficiarioInexistenteException;
import java.util.List;
import java.util.Set;
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
        negocioPerfil.registrarPerfil(s.getUsuarioNombreUsuario());
    }

    @Override
    public void borrarSocio(Socio s) throws AcoesException {
        negocioPerfil.eliminarPerfil(s.getUsuarioNombreUsuario());
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
        aux.getBecadoSet().add(b);
        em.merge(aux);
        
    }

    @Override
    public void desapadrinar(Socio s, Becado b) throws AcoesException {
        Socio aux = em.find(Socio.class, s.getNumero());
        aux.getBecadoSet().remove(b);
        em.merge(aux);
    }

    @Override
    public Socio buscar(Usuario u) throws AcoesException {
        Socio socio = em.find(Socio.class, u.getNombreUsuario());
        return socio;
    }

    
}
