package com.SII.negocio;

import com.SII.entidades.Usuario;
import com.SII.negocio.excepciones.AcoesException;

import java.util.List;

public interface NegocioPerfil {
    void eliminarPerfil(Usuario usuario) throws AcoesException;

    void modificarPerfil(Usuario usuario) throws AcoesException;

    void registrarPerfil(Usuario usuario) throws AcoesException;

    List<Usuario> getListaPerfiles();
}
