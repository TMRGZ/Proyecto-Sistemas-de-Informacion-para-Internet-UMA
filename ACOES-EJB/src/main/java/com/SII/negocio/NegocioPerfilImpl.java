package com.SII.negocio;

import com.SII.entidades.Beneficiario;
import com.SII.entidades.Socio;
import com.SII.entidades.Usuario;
import com.SII.negocio.excepciones.AcoesException;
import com.SII.negocio.excepciones.CuentaInexistenteException;
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
        if (em.find(Usuario.class, usuario.getNombreUsuario()) == null) {
            throw new CuentaInexistenteException();
        }

        em.remove(em.merge(usuario));
    }

    @Override
    public void modificarPerfil(Usuario usuario) throws AcoesException {
        Usuario aux = em.find(Usuario.class, usuario.getNombreUsuario());

        if (aux == null) {
            throw new CuentaInexistenteException();
        }

        Beneficiario auxBen = aux.getBeneficiario();
        Socio auxSoc = aux.getSocio();

        // Beneficiario
        if (auxBen != null) {
            auxBen.setNombre(usuario.getBeneficiario().getNombre());
            auxBen.setApellidos(usuario.getBeneficiario().getApellidos());
            auxBen.setNumeroCuenta(usuario.getBeneficiario().getNumeroCuenta());
            aux.setBeneficiario(auxBen);
        }

        // Socio
        if (auxSoc != null) {
            auxSoc.setNombre(usuario.getSocio().getNombre());
            auxSoc.setApellidos(usuario.getSocio().getApellidos());
            auxSoc.setDireccion(usuario.getSocio().getDireccion());
            auxSoc.setCodigoPostal(usuario.getSocio().getCodigoPostal());
            auxSoc.setEstado(usuario.getSocio().getEstado());
            auxSoc.setNif(usuario.getSocio().getNif());
            auxSoc.setPoblacion(usuario.getSocio().getPoblacion());
            auxSoc.setProvincia(usuario.getSocio().getProvincia());
            auxSoc.setTelefono(usuario.getSocio().getTelefono());
            auxSoc.setTelefonoMovil(usuario.getSocio().getTelefonoMovil());
            aux.setSocio(auxSoc);
        }

        em.merge(aux);
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
