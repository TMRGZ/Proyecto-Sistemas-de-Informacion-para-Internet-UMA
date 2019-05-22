package com.SII.negocio;

import com.SII.entidades.Proyecto;
import com.SII.negocio.excepciones.AcoesException;

import javax.ejb.Local;
import java.util.List;

@Local
public interface NegocioProy {
    void annadirProy(Proyecto p) throws AcoesException;

    void modificarProy(Proyecto p) throws AcoesException;

    void eliminarProy(Proyecto p) throws AcoesException;

    List<Proyecto> getProys();
}
