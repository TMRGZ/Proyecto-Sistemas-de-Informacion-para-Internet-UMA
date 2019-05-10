package com.SII.negocio;

import com.SII.entidades.Usuario;
import com.SII.negocio.excepciones.AcoesException;
import com.SII.negocio.excepciones.CuentaRepetidaException;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class NegocioPerfilImpl implements NegocioPerfil {
    @PersistenceContext(unitName = "ACOES")
    private EntityManager em;

    @Override
    public void eliminarPerfil(Usuario usuario) throws AcoesException {
        em.remove(em.merge(usuario));
    }

    @Override
    public void modificarPerfil(Usuario usuario) throws AcoesException {
        em.merge(usuario);
    }

    @Override
    public void registrarPerfil(Usuario usuario) throws AcoesException {
        Usuario user = em.find(Usuario.class, usuario.getNombreUsuario());

        if (user != null) {
            throw new CuentaRepetidaException();
        }
        em.persist(usuario);
    }

    @Override
    public List<Usuario> getListaPerfiles() {
        return em.createQuery("select a from Usuario a", Usuario.class).getResultList();
    }
}
