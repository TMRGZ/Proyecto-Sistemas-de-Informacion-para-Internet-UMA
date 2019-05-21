package com.SII.negocio;

import com.SII.entidades.Proyecto;
import com.SII.negocio.excepciones.AcoesException;

import javax.ejb.Local;
import java.util.List;

@Local
public interface NegocioProy {
    void AnnadirProy(Proyecto p) throws AcoesException;

    void ModificarProy(Proyecto p) throws AcoesException;

    void EliminarProy(Proyecto p) throws AcoesException;

    List<Proyecto> getProys();
}
