/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Entidades.Socio;
import Entidades.Usuario;
import Entidades.Becado;
import Entidades.Beneficiario;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named(value = "ctrlsocio")
@SessionScoped
public class ControlSocio implements Serializable {
     
    private ArrayList<Socio> socios = new ArrayList<>();
    private Socio socio;
    
    public ControlSocio() {
        socios = new ArrayList<>();
        socio=new Socio();
        socio.setUsuario(new Usuario(new BigDecimal(1), "user", "user"));
        
    }
     
    /*public ArrayList<Notificaciones> getNotificaciones(Usuario u) {
         for(Socio s : socios){
             if(s.getUsuario().equals(u)){
                 socio=s;
             }
         }  
         return socio.getNotificaciones;
    } */
    
    public String apadrinar(Usuario u, ArrayList<Beneficiario> listben){
        boolean apadrinar=false;
        int i=0;
        for(Socio s : socios){
             if(s.getUsuario().equals(u)){
                 socio=s;
             }
        }

        return "userpage.xhtml";
    }
    
    public List<Becado> getBecados(){
        return socio.getBecadoList();
    }
    
     
}
