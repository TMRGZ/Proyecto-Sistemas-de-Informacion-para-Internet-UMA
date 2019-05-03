package com.SII.vista;


import com.SII.entidades.Proyecto;
import com.SII.entidades.Usuario;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;
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
        usuarios.add(new Usuario("user", "user", 0));
        usuarios.add(new Usuario("admin", "admin", 1));
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }
}
