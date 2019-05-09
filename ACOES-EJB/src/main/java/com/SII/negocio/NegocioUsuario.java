package com.SII.negocio;

import com.SII.entidades.Socio;
import com.SII.entidades.Usuario;
import com.SII.negocio.excepciones.AcoesException;

import javax.ejb.Local;

@Local
public interface NegocioUsuario {
    void registrarUsuario(Usuario usuario) throws AcoesException;

    void compruebaLogin(Usuario usuario) throws AcoesException;

    Usuario refrescarUsuario(Usuario usuario) throws AcoesException;

    void annadirSocioA(Usuario usuario, Socio socio) throws AcoesException;
}
