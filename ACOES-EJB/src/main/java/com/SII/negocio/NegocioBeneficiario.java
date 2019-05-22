/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SII.negocio;

import com.SII.entidades.Beneficiario;
import com.SII.entidades.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author juan_
 */
@Stateless
public class NegocioBeneficiario implements NegocioBeneficiarioLocal {
    
    @PersistenceContext (unitName = "ACOES")
    private EntityManager em;


    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void anadirBeneficiario(Beneficiario b) {
        if (b.getBeneficiarioCodigo() != null){
            em.persist(b);
        }else{
            
            Usuario u = new Usuario();
            u.setNombreUsuario(b.getNombre()+b.getApellidos());
            u.setContrasenna(b.getNombre()+b.getApellidos());
            u.setRol(0);
            u.setBeneficiario(b);
            em.persist(u);
            b.setUsuarioNombreUsuario(u);
            b.setBeneficiarioCodigo(b);
           
            em.persist(b);
        }
        
    }

    @Override
    public void modificarBeneficiario(Beneficiario b) {
         
        em.merge(b);
    }

    @Override
    public void borrarBeneficiario(Beneficiario b) {
        Beneficiario bene = em.find(Beneficiario.class, b.getCodigo());
        em.remove(bene);
    }

    @Override
    public List<Beneficiario> getListaBeneficiario() {
        return em.createQuery("select a from Beneficiario a", Beneficiario.class).getResultList();
    }
}
