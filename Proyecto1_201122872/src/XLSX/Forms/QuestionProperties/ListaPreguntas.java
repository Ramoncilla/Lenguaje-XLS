/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XLSX.Forms.QuestionProperties;

import XLSX.Forms.Configuration.Question;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ramonella
 */
public class ListaPreguntas {
    
    public List<Question> lPreguntas;

    public ListaPreguntas() {
        this.lPreguntas = new ArrayList<>();
    }
    
    public void insertarPregunta(Question nueva){
        this.lPreguntas.add(nueva);
    }
    
    
}
