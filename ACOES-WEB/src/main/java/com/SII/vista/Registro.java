/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SII.vista;


import com.SII.entidades.Socio;
import com.SII.entidades.Usuario;
import java.math.BigDecimal;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Named(value = "register")
@RequestScoped
public class Registro {

    private String usuario;
    private String password;
    private String nPassword;
    private String nombre;
    private String Apellido;
    private String estado;
    private String NIF;
    private String direccion;
    private String CP;
    private String provincia;
    private String poblacion;
    private String telefono;
    private String telMovil;
    private String email;
    private List<Usuario> usuarios;


    /**
     * Creates a new instance of Login
     */
    public Registro() {
        usuarios = new ArrayList<>();
        usuarios.add(new Usuario("user", 0, "user", '0'));
        usuarios.add(new Usuario("admin", 1, "admin", '1'));
    }

    public String registrar() {
        FacesContext ctx = FacesContext.getCurrentInstance();

        if (usuario.length() == 0 || password.length() == 0 || nPassword.length() == 0 || Apellido.length() == 0 || estado.length() == 0 || NIF.length() == 0 || direccion.length() == 0 || CP.length() == 0 || provincia.length() == 0 || poblacion.length() == 0 || telefono.length() == 0 || telMovil.length() == 0 || email.length() == 0) {
            ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Campos requeridos vacios", "Campos requeridos vacios"));
            return null;
        }

        for (Usuario usuario1 : usuarios) { // Mira si ya está registrado
            if (usuario1.getNombreUsuario().equalsIgnoreCase(usuario)) {
                ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario ya registrado", "Usuario ya registrado"));
                return null;
            }
        }

        Usuario nuevoUsuario = new Usuario(usuario, usuarios.size(), password, '0');        
        Socio nuevoSocio = new Socio(new BigDecimal(nuevoUsuario.getIdUsuario()), nombre, NIF, direccion, poblacion, new BigInteger(CP), provincia, new BigInteger(telefono), email);
        nuevoSocio.setUsuario(nuevoUsuario);
        usuarios.add(nuevoUsuario);


        return "inicio.xhtml";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNIF() {
        return NIF;
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCP() {
        return CP;
    }

    public void setCP(String CP) {
        this.CP = CP;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTelMovil() {
        return telMovil;
    }

    public void setTelMovil(String telMovil) {
        this.telMovil = telMovil;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public String getnPassword() {
        return nPassword;
    }

    public void setnPassword(String nPassword) {
        this.nPassword = nPassword;
    }

}
