/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SII.negocio;

import com.SII.entidades.Becado;
import com.SII.entidades.Beneficiario;
import com.SII.entidades.Notificacion;
import com.SII.entidades.Usuario;
import com.SII.negocio.excepciones.AcoesException;
import com.SII.negocio.excepciones.BeneficiarioInexistenteException;
import java.util.ArrayList;
import java.util.Date;

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
    public void modificarBeneficiario(Beneficiario b, Beneficiario bene) throws AcoesException {
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
        aux.setBeneficiarioCodigo(bene);
        
        Becado auxBecado = aux.getBecado();

        if (auxBecado != null) {
            auxBecado.setAgente(b.getBecado().getAgente());
            auxBecado.setBeca(b.getBecado().getBeca());
            auxBecado.setColoniaActual(b.getBecado().getColoniaActual());
            auxBecado.setColoniaProcedencia(b.getBecado().getColoniaProcedencia());
            auxBecado.setEstado(b.getBecado().getEstado());
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
    
    public void Notificar(Usuario u){
        Usuario aux = em.find(Usuario.class, u.getNombreUsuario());
        Notificacion n = new Notificacion();
        n.setFecha(new Date());
        n.setContenido("Se le ha enviado una carta ");
        n.setUsuarioEmisor("Administrador");
        n.setUsuarioReceptor(u.getNombreUsuario());
        aux.getNotificacionSet().add(n);
        em.persist(n);
        em.merge(aux);
    }

    @Override
    public Beneficiario BuscarResponsable(Long clavePrimaria) {
      
      return em.find(Beneficiario.class, clavePrimaria);
    }

    @Override
    public boolean EsResponsable(Beneficiario b) {
        List<Beneficiario> l = new ArrayList<>();
        for (Beneficiario bene : this.getListaBeneficiario()){
            if(bene.getBeneficiarioCodigo()!=null)
            l.add(bene.getBeneficiarioCodigo());
        }
        return l.contains(b);
    }

}
