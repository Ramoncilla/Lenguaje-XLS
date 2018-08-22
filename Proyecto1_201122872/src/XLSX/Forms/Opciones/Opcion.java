/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XLSX.Forms.Opciones;

import XLSX.AnalizerXML.SimpleNode;
import XLSX.Forms.OpcionBase;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ramonella
 */
public class Opcion {
    
    List<OpcionBase> propiedadesOpcion;
    
    public Opcion(){
       this.propiedadesOpcion= new ArrayList<>();
    }
    
    public void insertarPropiedad(SimpleNode nodo){
        
    }
    
}
