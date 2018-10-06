/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnalizadorExpresion;

import Expresion.SimpleNode;
import Expresion.analizadorExpresion;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 *
 * @author Ramonella
 */
public class AnalizarExpresion {
    
        public  void Parser(String cadena){
        InputStream is = new ByteArrayInputStream(cadena.getBytes());
        analizadorExpresion analizar = new analizadorExpresion(is);
        try {
            SimpleNode n = analizar.Start();
            n.dump("");
           System.out.println("--------- Analizador Finalizado --------------");
        } catch (Exception e) {
           System.out.println("Un error en la sintaxis.");
           System.out.println(e.getMessage());
           
       }
    }
        
        
   
    
    
    
}
