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
public class Multimedia {

    
    SimpleNode nodoMultimedia;
    public String tipoMultimedia;
    public String ruta;
    public String activar;
    
    public Multimedia(SimpleNode nodo) {
        this.nodoMultimedia = nodo;
        this.tipoMultimedia="";
        this.ruta="";
        this.activar="falso";
    }
    
    public void imprimirMultimedia(){
        System.out.println("+++++++++++++++++++++  Multimedia ++++++++++++++++++++++");
        System.out.println("Ruta:    "+ this.ruta);
        System.out.println("Activar:     "+ this.activar);
        System.out.println("TipoMultimedia:  "+ this.tipoMultimedia);
        System.out.println("+++++++++++++++++++++  Fin Multemedia ++++++++++++++++++++++");
    }
    
    public boolean asignarValores(){
        SimpleNode nodoREP;
        if(nodoMultimedia.jjtGetNumChildren()>0){
            this.tipoMultimedia= nodoMultimedia.jjtGetChild(0).toString();
            nodoREP= (SimpleNode)this.nodoMultimedia.jjtGetChild(1);
            int no = nodoREP.jjtGetNumChildren();
            if(no ==2){
                //cadena y rep2
                if(nodoREP.jjtGetChild(0).toString().equalsIgnoreCase("cadena") &&
                        nodoREP.jjtGetChild(1).toString().equalsIgnoreCase("REP2")){
                    this.ruta = nodoREP.jjtGetChild(0).jjtGetChild(0).toString();
                    this.activar= nodoREP.jjtGetChild(1).jjtGetChild(0).toString();
                    return true;
                    
                }
                //rep2 y cadena
                if(nodoREP.jjtGetChild(1).toString().equalsIgnoreCase("cadena") &&
                        nodoREP.jjtGetChild(0).toString().equalsIgnoreCase("REP2")){
                    this.ruta = nodoREP.jjtGetChild(1).jjtGetChild(0).toString();
                    this.activar= nodoREP.jjtGetChild(0).jjtGetChild(0).toString();
                    return true;
                    
                }
            }else{
                if(nodoREP.jjtGetChild(0).toString().equalsIgnoreCase("cadena")){
                    this.ruta = nodoREP.jjtGetChild(0).jjtGetChild(0).toString();
                    return true;
                }
            }
            
            
        }
        return false;
    }
    
}
