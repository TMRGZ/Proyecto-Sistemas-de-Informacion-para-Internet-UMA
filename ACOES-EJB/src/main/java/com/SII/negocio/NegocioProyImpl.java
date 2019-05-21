package com.SII.negocio;

import com.SII.entidades.Proyecto;
import com.SII.negocio.excepciones.AcoesException;
import com.SII.negocio.excepciones.ProyInexistenteException;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class NegocioProyImpl implements NegocioProy {

    @PersistenceContext(unitName = "ACOES")
    private EntityManager em;

    @Override
    public void annadirProy(Proyecto p) throws AcoesException {
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


}
