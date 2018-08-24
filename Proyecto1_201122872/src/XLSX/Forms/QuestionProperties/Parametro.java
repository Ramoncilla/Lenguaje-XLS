/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XLSX.Forms.QuestionProperties;

import XLSX.AnalizerXML.SimpleNode;


/**
 *
 * @author Ramonella
 */
public class Parametro {

    SimpleNode nodoParametro;
    public String cad_min;
    public String cad_max;
    public String cad_fila;
    public String iniciar;
    public String finalizar;
    public String opcion;
    
    public Parametro(SimpleNode nodo) {
        this.nodoParametro = nodo;
        this.cad_min= "";
        this.cad_max="";
        this.cad_fila="";
        this.iniciar="";
        this.finalizar="";
        this.opcion="";
        
    }
    
    
    public boolean activar(){
        SimpleNode temp;
        boolean band=false;
        for (int i = 0; i < this.nodoParametro.jjtGetNumChildren(); i++) {
            temp=(SimpleNode) this.nodoParametro.jjtGetChild(i).jjtGetChild(0);
            if(temp.toString().equalsIgnoreCase("cad_min")){
                this.cad_min = temp.jjtGetChild(0).toString();
                band= true;
                
            }
            if(temp.toString().equalsIgnoreCase("cad_max")){
                this.cad_max = temp.jjtGetChild(0).toString();
                band= true;
                 
            }
            if(temp.toString().equalsIgnoreCase("cad_fila")){
                this.cad_fila = temp.jjtGetChild(0).toString();
                band= true;
                 
            }
            if(temp.toString().equalsIgnoreCase("iniciar")){
                this.iniciar = temp.jjtGetChild(0).toString();
                band= true;
            }
            if(temp.toString().equalsIgnoreCase("finalizar")){
                this.finalizar = temp.jjtGetChild(0).toString();
                band= true;
            }
            if(temp.toString().equalsIgnoreCase("opcion2")){
                this.opcion = temp.jjtGetChild(0).toString();
                band= true;
            }
            
        }
        if((!(this.finalizar.equalsIgnoreCase("")))&& (this.iniciar.equalsIgnoreCase(""))){
            this.iniciar="0";
        }
        
        return band;
    }
    
    
    public void imprimirParametro(){
        System.out.println("+++++++++++++++++++++  Parametro ++++++++++++++++++++++");
        System.out.println("cad_min:    "+ this.cad_min);
        System.out.println("cad_max:     "+ this.cad_max);
        System.out.println("cad_fila:  "+ this.cad_fila);
         System.out.println("iniciar:  "+ this.iniciar);
          System.out.println("finalizar:  "+ this.finalizar);
           System.out.println("opcion:  "+ this.opcion);
        System.out.println("+++++++++++++++++++++  Fin parametro ++++++++++++++++++++++");
    }
    
    
    
}
