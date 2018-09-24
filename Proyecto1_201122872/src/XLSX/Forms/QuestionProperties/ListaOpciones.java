/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XLSX.Forms.QuestionProperties;


import XLSX.Forms.Opcion;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ramonella
 */
public class ListaOpciones {
    
   public  List<Opcion> lOpciones;
   List<Opcion> aux;
    
    public ListaOpciones(){
        this.lOpciones= new ArrayList<>();
        this.aux= new ArrayList<>();
    }
    
    public void insertar(Opcion p){
        this.lOpciones.add(p);
    }
   
    public void  obtenerListado(){
        Opcion temp;
        for (int i = 0; i < lOpciones.size(); i++) {
            temp= lOpciones.get(i);
            if(!existeEnAux(temp.nombre_lista)){
                aux.add(temp);
            }
        }
    }
    
    public String obtenerDeclacionesLista(){
        //lOpciones.remove(lOpciones.size()-1);
        obtenerListado();
        Opcion temp;
        String cad=""; 
        for (int i = 0; i < aux.size(); i++) {
            temp= aux.get(i);
            cad+="Opciones "+ temp.nombre_lista+" = nuevo Opciones();\n";
        }
        
        for (int i = 0; i < lOpciones.size(); i++) {
            temp= lOpciones.get(i);
            cad+=temp.obtenerIngreso()+"\n";
        }
        return cad;
    }
    
    
    public boolean existeEnAux(String t){
        Opcion temp;
        for (int i = 0; i < aux.size(); i++) {
            temp= aux.get(i);
            if(temp.nombre_lista.equalsIgnoreCase((t))){
                return true;
            }
        }
        return false;
    }
    
    
}
