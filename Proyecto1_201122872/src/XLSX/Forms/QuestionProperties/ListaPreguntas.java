/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XLSX.Forms.QuestionProperties;


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
}
