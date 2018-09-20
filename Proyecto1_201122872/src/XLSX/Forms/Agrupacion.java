/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XLSX.Forms;

import XLSX.AnalizerXML.SimpleNode;
import XLSX.Forms.QuestionProperties.ListaPreguntas;
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
    
    
    public String obtenerLlamadaPregunta(String pregunta){
        String llamada="";
        basePregunta temp;
        for (int i = 0; i < this.preguntas.size(); i++) {
            temp = this.preguntas.get(i);
            if(temp instanceof Agrupacion){
                Agrupacion agrup = (Agrupacion) temp;
                String val = agrup.obtenerLlamadaPregunta(pregunta);
                 if(!(val.equalsIgnoreCase(""))){
                     llamada = agrup.propiedadesInicio.idPregunta.toString()+"()."+val;
                     break;
                 }
            }else if(temp instanceof Ciclo){
                Ciclo agrup = (Ciclo) temp;
                String val = agrup.obtenerLlamadaPregunta(pregunta);
                 if(!(val.equalsIgnoreCase(""))){
                     llamada = agrup.propiedadesInicio.idPregunta.toString()+"()."+val;
                     break;
                 }
                
            }else{
                Question preg = (Question)temp;
                if(preg.idPregunta.toString().equalsIgnoreCase(pregunta)){
                    llamada =preg.idPregunta.toString()+"()";
                    break;
                }
            }
              
        }
        
        
        return llamada;
    }
    
    
    
    /*--------------------- Generacion de codigo  ---------------------------------*/
    
    
    @Override
    public String generarLlamadaSimple(){
       return this.propiedadesInicio.idPregunta.toString()+"();\n";
    }
    
    @Override
    public String generarCodigo(ListaPreguntas p){
        
        String contGrupo="Grupo "+ this.propiedadesInicio.idPregunta.toString()+"{\n"
                + "Respueta resp;\n";
        String preguntas="";
        basePregunta temp;
        for (int i = 0; i < this.preguntas.size(); i++) {
            temp=this.preguntas.get(i);
             preguntas+=temp.generarCodigo(p);
             contGrupo+=temp.generarLlamadaSimple()+"\n";
        }
        contGrupo+="\n}\n";
        
        return preguntas +"\n\n"+contGrupo;
    }
}
