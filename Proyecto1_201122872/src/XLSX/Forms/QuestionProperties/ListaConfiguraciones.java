/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XLSX.Forms.QuestionProperties;

import XLSX.Forms.Configuracion;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ramonella
 */
public class ListaConfiguraciones {
    
    
    public List<Configuracion> lConfiguraciones;
    
    public ListaConfiguraciones(){
        this.lConfiguraciones = new ArrayList<>();
    }
    
    
    public void insertar(Configuracion c){
        this.lConfiguraciones.add(c);
    }
    
    
}
