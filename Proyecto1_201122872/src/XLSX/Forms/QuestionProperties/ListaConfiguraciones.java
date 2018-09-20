/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XLSX.Forms.QuestionProperties;

import XLSX.Forms.Configuracion;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ramonella
 */
public class ListaConfiguraciones {
    
    
    public List<Configuracion> lConfiguraciones;
    public String titulo_form;
    public String id_form;
    public String estilo;
    
    
    public ListaConfiguraciones(){
        this.lConfiguraciones = new ArrayList<>();
        titulo_form="";
        id_form="";
        estilo="";
    }
    
    
    public void insertar(Configuracion c){
        this.lConfiguraciones.add(c);
    }
    
    public String getIdForm(){
        String nombre="";
        for (int i = 0; i < this.lConfiguraciones.size(); i++) {
            if(this.lConfiguraciones.get(i).idForm!=null){
                nombre = this.lConfiguraciones.get(i).idForm.toString();
            }
        }
        return nombre;
    }
    
    public String titulo_Form(){
        String nombre="";
        for (int i = 0; i < this.lConfiguraciones.size(); i++) {
            if(this.lConfiguraciones.get(i).titulo_formulario!=null){
                nombre = this.lConfiguraciones.get(i).titulo_formulario.toString();
            }
        }
        return nombre;
    }
    
    
    public String estiloForm(){
        String nombre="";
        for (int i = 0; i < this.lConfiguraciones.size(); i++) {
            if(this.lConfiguraciones.get(i).estilo!=null){
                nombre = this.lConfiguraciones.get(i).estilo.toString();
            }
        }
        return nombre;
    }
    
    public String obtenerImportaciones(){
        String importaciones="";
        Configuracion conf;
        for (int i = 0; i < this.lConfiguraciones.size(); i++) {
            conf = this.lConfiguraciones.get(i);
            if(conf.importar!= null){
                importaciones+=conf.importar.toString()+"\n";
            }
        }
        return importaciones;
    }
    
    
    public String obtenerCodigoGlobal(){
        String codigo="";
        Configuracion conf;
        for (int i = 0; i < this.lConfiguraciones.size(); i++) {
            conf = this.lConfiguraciones.get(i);
            if(conf.codigo_global!=null){
                codigo+=conf.codigo_global.toString()+"\n";
            }
        }
        return codigo;
    }
    
    
    public String obtenerCodigoPrincipal(){
      String codigo="";
        Configuracion conf;
        for (int i = 0; i < this.lConfiguraciones.size(); i++) {
            conf = this.lConfiguraciones.get(i);
            if(conf.codigo_principal!=null){
                codigo+=conf.codigo_principal.toString()+"\n";
            }
        }
        return codigo;  
    }
    
}
