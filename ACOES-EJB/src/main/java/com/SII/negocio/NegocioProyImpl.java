package com.SII.negocio;

import com.SII.entidades.Proyecto;
import com.SII.negocio.excepciones.AcoesException;
import com.SII.negocio.excepciones.ProyInexistenteException;
import com.SII.negocio.excepciones.ProyRepException;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class NegocioProyImpl implements NegocioProy {

    @PersistenceContext(unitName = "ACOES")
    private EntityManager em;

    @Override
    public void AnnadirProy(Proyecto p) throws AcoesException {
        Proyecto aux = em.find(Proyecto.class, p.getCodigo());
        if (aux != null) {
            throw new ProyRepException();
        }

        em.persist(p);

    }

    @Override
    public void ModificarProy(Proyecto p) throws AcoesException {
        Proyecto aux = em.find(Proyecto.class, p.getCodigo());
        if (aux == null) {
            throw new ProyInexistenteException();
        }
        em.merge(p);
    }

    @Override
    public void EliminarProy(Proyecto p) throws AcoesException {
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
