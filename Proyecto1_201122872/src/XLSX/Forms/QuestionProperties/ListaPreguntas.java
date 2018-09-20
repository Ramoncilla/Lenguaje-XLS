/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XLSX.Forms.QuestionProperties;


import XLSX.Forms.Agrupacion;
import XLSX.Forms.Ciclo;
import XLSX.Forms.Question;
import XLSX.Forms.basePregunta;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ramonella
 */
public class ListaPreguntas extends basePregunta {
    
    public List<basePregunta> lPreguntas;

    public ListaPreguntas() {
        this.lPreguntas = new ArrayList<>();
    }
    
    public void insertarPregunta(basePregunta nueva){
        this.lPreguntas.add(nueva);
    }
    
    /**
     *
     * @return
     */
    @Override
    public String generarCodigo(ListaPreguntas p){
        for (int i = 0; i < this.lPreguntas.size(); i++) {
            this.lPreguntas.get(i).generarCodigo(this);
        }return "";
    }
   
    @Override
    public void mostrarDatos(){
        basePregunta p;
        System.out.println("------------------------- IMPRIMIENDO LISTA DE PREGUNTAS -----------------------------");
        for (int i = 0; i < lPreguntas.size(); i++) {
            p = lPreguntas.get(i);
            p.mostrarDatos();
        }
        System.out.println("------------------------- FIN DE LISTA DE PREGUNTAS -----------------------------");
    }
    
    
    public String obtenerLlamadaPregunta(String pregunta){
        String llamada = "";
        basePregunta temp;
        for (int i = 0; i < this.lPreguntas.size(); i++) {
            temp = this.lPreguntas.get(i);
             if(temp instanceof Agrupacion){
                 Agrupacion agrup = (Agrupacion) temp;
                 String val = agrup.obtenerLlamadaPregunta(pregunta);
                 if(!(val.equalsIgnoreCase(""))){
                     llamada = agrup.propiedadesInicio.idPregunta.toString()+"()."+val;
                     break;
                 }
            }else if(temp instanceof Ciclo){
                Ciclo cic = (Ciclo) temp;
                String val = cic.obtenerLlamadaPregunta(pregunta);
                 if(!(val.equalsIgnoreCase(""))){
                     llamada =cic.propiedadesInicio.idPregunta.toString()+"()."+val;
                     break;
                 }
                
            }else{
                Question preg = (Question) temp;
                if(preg.idPregunta.toString().equalsIgnoreCase(pregunta)){
                    llamada = preg.idPregunta.toString()+"()";
                    break;
                }
            }
        }
        
        
        return llamada;
    }
    
    
    public String escribirPreguntas(ListaPreguntas preg, ListaConfiguraciones conf, ListaOpciones opciones, String nombreForm){
          String contGrupo="Formulario "+ nombreForm+"(){\n";
        String preguntas="";
        basePregunta temp;
        for (int i = 0; i < preg.lPreguntas.size(); i++) {
            temp=preg.lPreguntas.get(i);
             preguntas+=temp.generarCodigo(preg);
             contGrupo+=temp.generarLlamadaSimple()+"\n";
        }
        contGrupo+="\n}\n";
        
        return preguntas +"\n\n"+contGrupo;
    }
}
