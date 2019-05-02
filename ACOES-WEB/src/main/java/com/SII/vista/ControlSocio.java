/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SII.vista;


import com.SII.entidades.Becado;
import com.SII.entidades.Beneficiario;
import com.SII.entidades.Notificacion;
import com.SII.entidades.Socio;
import com.SII.entidades.Usuario;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named(value = "ctrlsocio")
@SessionScoped
public class ControlSocio implements Serializable {
     
    private ArrayList<Socio> socios = new ArrayList<>();
    private Socio socio=new Socio();
    
    public ControlSocio() {
        socios = new ArrayList<>();
        socio.setUsuario(new Usuario("user", 0, "user", '0'));
        socios.add(socio);
    }
     
    public List<Notificacion> getNotificaciones(Usuario u) {
         for(Socio s : socios){
             if(s.getUsuario().equals(u)){
                 socio=s;
             }
         }
         if(socio.getUsuario().getNotificacionSet() == null){
             socio.getUsuario().setNotificacionSet(new HashSet<Notificacion>());
             socio.getUsuario().getNotificacionSet().add(new Notificacion(0,0,1, new Date(2,12,20)));
         }
         List<Notificacion> res = new ArrayList<>(socio.getUsuario().getNotificacionSet());
         return res;
    } 
    
    public String apadrinar(Usuario u, ArrayList<Beneficiario> listben){
        boolean apadrinar=false;
        int i=0;
        for(Socio s : socios){
             if(s.getUsuario().equals(u)){
                 socio=s;
                 
             }
        }
        if(socio.getBecadoList()==null){
                    socio.setBecadoList(new ArrayList<>());
                    
                }
        while(!apadrinar && i<listben.size()){
            if(listben.get(i).getTipo()=="Niño"){
                Becado b= new Becado();
                b.setBeneficiario(listben.get(i));
                if(!socio.getBecadoList().contains(b)){
                    socio.getBecadoList().add(b);
                    apadrinar=true;
                }
            }
                    
            i++;
        }
        return "userpage.xhtml";
    }
    
    public List<Becado> buscar(Usuario u){
        for(Socio s : socios){
             if(s.getUsuario().equals(u)){
                 socio=s;
             }
        }
        return socio.getBecadoList();
    }
    
     
}
