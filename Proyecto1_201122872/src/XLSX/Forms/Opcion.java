/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XLSX.Forms;

import XLSX.AnalizerXML.SimpleNode;
import XLSX.Forms.QuestionProperties.Multimedia;
import proyecto1_201122872.Constantes;

/**
 *
 * @author Ramonella
 */
public class Opcion {
    public String nombre_lista;
    public String nombre;
    public String etiqueta;
    public Multimedia multi;
    
    
    public Opcion(){
        this.nombre_lista = null;
        this.nombre = null;
        this.etiqueta = null;
        this.multi= null;
    }
    
    
    public boolean esOpcionVacia(){
        return (this.nombre_lista == null ||
        this.nombre == null ||
        this.etiqueta == null);
    }
    
    
    public String obtenerIngreso(){
        String cod="";
        if(nombre_lista!= null){
            if(nombre!= null && etiqueta!= null && multi!= null){
                nombre= nombre.replace("\"", "");
                nombre= "\""+nombre+"\"";
                etiqueta= etiqueta.replace("\"", "");
                etiqueta= "\""+etiqueta+"\"";
                multi.ruta= multi.ruta.replace("\"", "");
                multi.ruta= "\""+multi.ruta+"\"";
                cod= nombre_lista+".insertar("+nombre+","+etiqueta+","+multi.ruta+");";
                return cod;
            }else if(nombre!= null && etiqueta!= null){
                nombre= nombre.replace("\"", "");
                nombre= "\""+nombre+"\"";
                etiqueta= etiqueta.replace("\"", "");
                etiqueta= "\""+etiqueta+"\"";
                
                cod= nombre_lista+".insertar("+nombre+","+etiqueta+",\"\");";
                return cod;
            }

        }
        return cod;
    }
    
    
    public void imprimir(){
        System.out.println("----------------------------- Imprimir Opcione ---------------------------------");
        System.out.println("Nombre lista:  "+ this.nombre_lista);
        System.out.println("Nombre:   "+ this.nombre);
        System.out.println("Etiqueta:  "+ this.etiqueta);
         if(multi!= null){
             multi.imprimirMultimedia();
         }
    }
    
    
    public void insertarPropiedad(SimpleNode nodo){
        String nombrePropiedad = nodo.toString().toUpperCase();//.replace("<", "").replace(">", "").toUpperCase();
        int noElementos = nodo.jjtGetNumChildren();

        if (noElementos > 0) {
            Object elemento = nodo.jjtGetChild(0).toString(); //this.obtenerElemento((SimpleNode)nodoPropiedad.jjtGetChild(1));
           // System.out.println(elemento);
            switch (nombrePropiedad) {
                case Constantes.NOMBRE_LISTA: {
                    if(!(elemento.toString().equalsIgnoreCase(""))){
                        this.nombre_lista = elemento.toString();
                    }
                    break;
                }
                
                case Constantes.NOMBRE: {
                    if(nodo.jjtGetChild(0).jjtGetNumChildren()> 0){
                         elemento = nodo.jjtGetChild(0).jjtGetChild(0).toString();
                    if(!(elemento.toString().equalsIgnoreCase(""))){
                       this.nombre = elemento.toString();
                    } 
                    }else{
                        System.out.println("nooo");
                    }
                   
                    break;
                }
                
                case Constantes.ETIQUETA: {
                    if(!(elemento.toString().equalsIgnoreCase(""))){
                       this.etiqueta = elemento.toString();
                    }
                    break;
                }
                
                 case Constantes.MULTIMEDIA: {
                     Multimedia a = new Multimedia((SimpleNode)nodo);
                    boolean b = a.asignarValores();
                    if(b){
                        this.multi = a;
                    }
                    break;
                }
                 
                
            
            }
            
        }
        
    }
    
}
