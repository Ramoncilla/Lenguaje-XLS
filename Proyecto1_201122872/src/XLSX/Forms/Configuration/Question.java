/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XLSX.Forms.Configuration;

import XLSX.AnalizerXML.SimpleNode;
import XLSX.Forms.propertyBase;
import java.util.ArrayList;
import java.util.List;
import proyecto1_201122872.Constantes;
import XLSX.Forms.QuestionProperties.*;
/**
 *
 * @author Ramonella
 */
public class Question {
    
    List<propertyBase> propiedades;
    
    public Question(){
        this.propiedades = new ArrayList<>();
    }
    
    
    private Object obtenerElemento(SimpleNode elementos){
        String val="";
        for (int i = 0; i < elementos.jjtGetNumChildren(); i++) {
            val+=elementos.jjtGetChild(i).toString()+" ";
        }
        return val;
    }
    
    public int noPropiedades(){
        return this.propiedades.size();
    }
    
    public boolean tienePropiedades(){
        return (!(this.propiedades.isEmpty()));
    }
    
    public void insertarPropiedad(SimpleNode nodoPropiedad){
        String nombrePropiedad = nodoPropiedad.jjtGetChild(0).toString().replace("<", "").replace(">", "").toUpperCase();
        int noElementos = nodoPropiedad.jjtGetChild(1).jjtGetNumChildren();
        if(noElementos >0){
            Object elemento = this.obtenerElemento((SimpleNode)nodoPropiedad.jjtGetChild(1));
        switch (nombrePropiedad) {
            case Constantes.APARIENCIA:{
                Apariencia a = new Apariencia(elemento);
                propiedades.add(a);
                break;
            }
            case Constantes.APLICABLE:{
                Aplicable a = new Aplicable(elemento);
                this.propiedades.add(a);
                break;
            }
            case Constantes.CALCULO:{
                Calculo a = new Calculo(elemento);
                this.propiedades.add(a);
                break;
            }
            
            case Constantes.CODIGO_POST:{
                Codigo_Post a = new Codigo_Post(elemento);
                this.propiedades.add(a);
                break;
            }
            
            case Constantes.CODIGO_PRE:{
                Codigo_Pre a = new Codigo_Pre(elemento);
                this.propiedades.add(a);
                break;
            }
            
            case Constantes.ETIQUETA:{
                Etiqueta a = new Etiqueta(elemento);
                this.propiedades.add(a);
                break;
            }
            
            case Constantes.IDPREGUNTA:{
                IdPregunta a = new IdPregunta(elemento);
                this.propiedades.add(a);
                break;
            }
            
            case Constantes.LECTURA:{
                 Lectura a = new Lectura(elemento);
                this.propiedades.add(a);
                break;
            }
            
            case Constantes.MULTIMEDIA:{
                Multimedia a = new Multimedia(elemento);
                this.propiedades.add(a);
                break;
            }
            
            case Constantes.PARAMETRO:{
                Parametro a = new Parametro(elemento);
                this.propiedades.add(a);
                break;
            }
            
            case Constantes.PREDETERMINADDO:{
                Predeterminado a = new Predeterminado(elemento);
                this.propiedades.add(a);
                break;
            }
            
            case Constantes.REPETICION:{
                Repeticion a = new Repeticion(elemento);
                this.propiedades.add(a);
                break;
            }
            
            case Constantes.REQUERIDO:{
                Requerido a = new Requerido(elemento);
                this.propiedades.add(a);
                break;
            }
            
            case Constantes.REQUERIDOMSN:{
                RequeridoMsn a = new RequeridoMsn(elemento);
                this.propiedades.add(a);
                break;
            }
            
            case Constantes.RESTRINGIR:{
                Restringir a = new Restringir(elemento);
                this.propiedades.add(a);
                break;
            }
            
            case Constantes.RESTRINGIRMSN:{
                RestringirMsn a = new RestringirMsn(elemento);
                this.propiedades.add(a);
                break;
            }
            
            
            case Constantes.SUGERIR:{
                Sugerir a = new Sugerir(elemento);
                this.propiedades.add(a);
                break;
            }
            
            case Constantes.TIPO:{
                Tipo a = new Tipo(elemento);
                this.propiedades.add(a);
                break;
            }       
        }
        }else{
            
        }
       
        
        //System.out.println("Propiedad "+ nodeQuestion.jjtGetChild(i).jjtGetChild(0).toString().replace("<","").replace(">", "")+":  "+nodeQuestion.jjtGetChild(i).jjtGetChild(1).jjtGetNumChildren());
         
    }
    
    
    
    
}
