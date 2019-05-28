package com.SII.negocio;

import com.SII.entidades.Becado;
import com.SII.entidades.Socio;
import com.SII.entidades.Usuario;
import com.SII.negocio.excepciones.AcoesException;

import javax.ejb.Local;
import java.util.List;
import java.util.Set;

@Local
public interface NegocioSocio {
    void anadirSocio(Socio s) throws AcoesException;

    void modificarSocio(Socio s) throws AcoesException;

    void borrarSocio(Socio s) throws AcoesException;
    Socio buscar(Usuario u) throws AcoesException;
    void apadrinar(Socio s,Becado b) throws AcoesException;
    void desapadrinar(Socio s,Becado b) throws AcoesException;

    
}
