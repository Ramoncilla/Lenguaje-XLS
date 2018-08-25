/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XLSX.Forms;

import XLSX.AnalizerXML.SimpleNode;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ramonella
 */
public class Agrupacion extends basePregunta {
    
    public List<basePregunta> preguntas;
    public Question  propiedadesInicio;
    public Question propiedadesFin;
 
    public Agrupacion(){
        this.preguntas= new ArrayList<>();
        this.propiedadesInicio= new Question();
        this.propiedadesFin = new Question();
    }
    
    
    public void insertarPropiedades(SimpleNode nodo){
        
    }
    
    
    
    @Override
    public void mostrarDatos() {
        System.out.println("Imprimiendo  agrupacion ***********************************   ");
        System.out.println("Inicio Agrupacion :  ");
        this.propiedadesInicio.mostrarDatos();
        basePregunta temp;
        for (int i = 0; i <preguntas.size(); i++) {
            temp= preguntas.get(i);
            if(temp instanceof Question){
                Question q = (Question)temp;
                q.mostrarDatos();
                
            }
            if(temp instanceof Agrupacion){
                Agrupacion g = (Agrupacion)temp;
                g.mostrarDatos();
            }
            
        }
        System.out.println("Fin Agrupacion:   ");
        this.propiedadesFin.mostrarDatos();
        System.out.println("Fin de imprimir Agruapacion  ******************************   ");
    }
    
}
