/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XLSX;

import XLSX.Forms.QuestionProperties.ListaConfiguraciones;
import XLSX.Forms.QuestionProperties.ListaOpciones;
import XLSX.Forms.QuestionProperties.ListaPreguntas;

/**
 *
 * @author Ramonella
 */
public class Formulario {
    
    public ListaPreguntas preguntas;
    public ListaOpciones opciones;
    public ListaConfiguraciones configuraciones;
public String nombreForm;

    public Formulario(ListaPreguntas preguntas, ListaOpciones opciones, ListaConfiguraciones configuraciones, String nombreForm) {
        String nom = nombreForm.replace("\\","#");
        String []n= nom.split("#");
        this.preguntas = preguntas;
        this.opciones = opciones;
        this.configuraciones = configuraciones;
        this.nombreForm= n[n.length-1].replace(".xml", "");
    }

  
    public String generarCodigo(){
        
        String cla= "clase "+nombreForm+" publico{\n"
                + "principal(){\n"
                + "nuevo "+nombreForm+"();"
                + "\n}\n";
        cla+= preguntas.escribirPreguntas(preguntas, configuraciones, opciones, nombreForm)
         + "\n}";
        return cla;
    }
    
    
    
    
    
    
    
    
}
