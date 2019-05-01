package com.SII.vista;

import Entidades.Proyecto;
import Entidades.Usuario;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Named(value = "listaUsuarios")
@ManagedBean
@RequestScoped
public class CatalogoUsuarios implements Serializable {

    private List<Usuario> usuarios;
    private List<Proyecto> proyectos;

    @PostConstruct
    public void init() {
        usuarios = new ArrayList<>();
        usuarios.add(new Usuario(new BigDecimal(1), "user", "user"));
        usuarios.add(new Usuario(new BigDecimal(2), "admin", "admin"));
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }
}
