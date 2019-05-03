package com.SII.negocio;

import com.SII.entidades.Usuario;

import javax.ejb.Local;

@Local
public interface NegocioUsuario {
    void registrarUsuario(Usuario usuario) throws Exception;

    void compruebaLogin(Usuario usuario) throws Exception;

    Usuario refrescarUsuario(Usuario usuario) throws Exception;
}
