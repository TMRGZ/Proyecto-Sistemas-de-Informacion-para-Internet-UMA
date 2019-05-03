package com.SII.negocio;

import com.SII.entidades.Usuario;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashSet;
import java.util.Set;

@Stateless
public class NegocioUsuarioImpl implements NegocioUsuario {
    private Set<Usuario> usuarios;

    @PersistenceContext(unitName = "ACOES")
    private EntityManager em;

    public NegocioUsuarioImpl() {
        usuarios = new HashSet<>();
        usuarios.add(new Usuario(0,"user",  "user", 0));
        usuarios.add(new Usuario(1,"admin",  "admin", 1));
    }

    @Override
    public void registrarUsuario(Usuario usuario) throws Exception {
        if (!usuarios.add(usuario)) { // Falso si ya estaba en la lista
            throw new Exception("El usuario ya existe");
        }
    }

    @Override
    public void compruebaLogin(Usuario usuario) throws Exception {
        Usuario user = null;

        for (Usuario usuario1 : usuarios) { // Encuentra el usuario almacenado respecto al nombre de usuario
            if (usuario1.equals(usuario)) {
                user = usuario1;
            }
        }

        if (user == null) {
            throw new Exception("Usuario no existe");
        }

        if (!user.getContrasenna().equals(usuario.getContrasenna())) {
            throw new Exception("Contraseña erronea");
        }
    }

    @Override
    public Usuario refrescarUsuario(Usuario usuario) throws Exception {
        compruebaLogin(usuario);

        for (Usuario usuario1 : usuarios) {
            if (usuario.equals(usuario1)) {
                return usuario1;
            }
        }
        return null;
    }
}
