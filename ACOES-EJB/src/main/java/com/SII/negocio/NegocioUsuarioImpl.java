package com.SII.negocio;

import com.SII.entidades.Socio;
import com.SII.entidades.Usuario;
import com.SII.negocio.excepciones.AcoesException;
import com.SII.negocio.excepciones.ContrasennaInvalidaException;
import com.SII.negocio.excepciones.CuentaInexistenteException;
import com.SII.negocio.excepciones.CuentaRepetidaException;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class NegocioUsuarioImpl implements NegocioUsuario {


    @PersistenceContext(unitName = "ACOES")
    private EntityManager em;

    @Override
    public void registrarUsuario(Usuario usuario) throws AcoesException {
        Usuario user = em.find(Usuario.class, usuario.getNombreUsuario());

        if (user != null) {
            throw new CuentaRepetidaException();
        }
        em.persist(usuario);
    }


    @Override
    public void compruebaLogin(Usuario usuario) throws AcoesException {
        Usuario user = em.find(Usuario.class, usuario.getNombreUsuario());

        if (user == null) {
            throw new CuentaInexistenteException();
        }

        if (!user.getContrasenna().equals(usuario.getContrasenna())) {
            throw new ContrasennaInvalidaException();
        }
    }

    @Override
    public Usuario refrescarUsuario(Usuario usuario) throws AcoesException {
        compruebaLogin(usuario);
        return em.find(Usuario.class, usuario.getNombreUsuario());
    }

    @Override
    public void annadirSocioA(Usuario usuario, Socio socio) throws AcoesException {
        compruebaLogin(usuario);
        em.persist(socio);
        usuario.setSocioNumero(socio);
        em.merge(usuario);
    }
}
