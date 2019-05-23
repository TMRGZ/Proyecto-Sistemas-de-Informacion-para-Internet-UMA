package com.SII.negocio;

import com.SII.entidades.Beneficiario;
import com.SII.entidades.Proyecto;
import com.SII.negocio.excepciones.AcoesException;
import com.SII.negocio.excepciones.ProyInexistenteException;
import com.SII.negocio.excepciones.ProyRepException;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Set;

@Stateless
public class NegocioProyImpl implements NegocioProy {

    @PersistenceContext(unitName = "ACOES")
    private EntityManager em;

    @Override
    public void annadirProy(Proyecto p) throws AcoesException {
        Proyecto aux = em.find(Proyecto.class, p.getCodigo());
        if (aux != null) {
            throw new ProyRepException();
        }
        em.persist(p);
    }

    @Override
    public void modificarProy(Proyecto p) throws AcoesException {
        Proyecto aux = em.find(Proyecto.class, p.getCodigo());
        if (aux == null) {
            throw new ProyInexistenteException();
        }
        em.merge(p);
    }

    @Override
    public void eliminarProy(Proyecto p) throws AcoesException {
        Proyecto aux = em.find(Proyecto.class, p.getCodigo());
        if (aux == null) {
            throw new ProyInexistenteException();
        }
        em.remove(em.merge(p));
    }

    @Override
    public List<Proyecto> getProys() {
        return em.createQuery("SELECT p FROM Proyecto p", Proyecto.class).getResultList();
    }

    @Override
    public void annadirBen(Proyecto p, Beneficiario b) throws AcoesException {
        Proyecto aux = em.find(Proyecto.class, p.getCodigo());
        Beneficiario aux2 = em.find(Beneficiario.class, b.getCodigo());
        if (aux == null || aux2 == null) {
            throw new ProyInexistenteException();
        }
        Set<Beneficiario> beneficiarios = aux.getBeneficiarioSet();
        beneficiarios.add(aux2);
        Set<Proyecto> proyectos = aux2.getProyectoSet();
        proyectos.add(aux);

        em.merge(aux);
        em.merge(aux2);
    }


    @Override
    public void eliminarBen(Proyecto p, Beneficiario b) throws AcoesException {
        Proyecto aux = em.find(Proyecto.class, p.getCodigo());
        Beneficiario aux2 = em.find(Beneficiario.class, b.getCodigo());
        if (aux == null || aux2 == null) {
            throw new ProyInexistenteException();
        }
        Set<Beneficiario> beneficiarios = aux.getBeneficiarioSet();
        beneficiarios.remove(aux2);
        Set<Proyecto> proyectos = aux2.getProyectoSet();
        proyectos.remove(aux);

    }

    @Override
    public Set<Beneficiario> getBeneficiarios(Proyecto p) throws AcoesException {
        Proyecto aux = em.find(Proyecto.class, p.getCodigo());
        if (aux == null) {
            throw new ProyInexistenteException();
        }

        return aux.getBeneficiarioSet();

    }


}
