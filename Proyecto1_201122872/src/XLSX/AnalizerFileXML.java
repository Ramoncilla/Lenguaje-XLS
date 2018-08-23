/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XLSX;

import XLSX.AnalizerXML.ParseException;
import XLSX.AnalizerXML.SimpleNode;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import XLSX.AnalizerXML.grammarXLSX;
import java.util.List;

/**
 *
 * @author alina
 */
public class AnalizerFileXML {
    
    
   public void Analizer(List<String> paths) throws ParseException{
       String contentFile="";
       for (int i = 0; i < paths.size(); i++) {
           contentFile+=Leer_Archivo(paths.get(i))+"\n";
       }
       Parser(contentFile);
   } 
    
    
    
    private void Parser(String cadena) throws ParseException{
         InputStream is = new ByteArrayInputStream(cadena.getBytes());
        grammarXLSX analizar = new grammarXLSX(is);
        //try {
            SimpleNode n = analizar.Start();
            n.ejecutar("");
          //  n.dump("");
           System.out.println("--------- Analizador Finalizado --------------");
       /* } catch (Exception e) {
           System.out.println("Un error en la sintaxis.");
           System.out.println(e.getMessage());
           
       }*/
    }
    
    
    private String Leer_Archivo(String ruta) {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        String cadena = "";
        try {
            archivo = new File(ruta);
           // archivo = new File("/home/alina/Escritorio/ejemplo.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            // Lectura del fichero

            String linea;
            while ((linea = br.readLine()) != null) {
                cadena += linea + "\n";
            }
        } catch (Exception e) {
            System.out.println("NO se pudo abiri el archivo" + e);
        }
        return cadena;
    }
    
    
}
