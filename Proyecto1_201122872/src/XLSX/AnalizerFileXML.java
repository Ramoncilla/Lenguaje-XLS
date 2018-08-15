/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XLSX;

import XLSX.AnalizerXML.SimpleNode;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import XLSX.AnalizerXML.grammarXLSX;

/**
 *
 * @author alina
 */
public class AnalizerFileXML {
    
    
    public void Analizer(){
         InputStream is = new ByteArrayInputStream(Leer_Archivo().getBytes());
        grammarXLSX analizar = new grammarXLSX(is);
        try {
            SimpleNode n = analizar.Start();
            n.dump("");
           System.out.println("--------- Analizador Finalizado --------------");
        } catch (Exception e) {
           System.out.println("Un error en la sintaxis.");
           System.out.println(e.getMessage());
           
       }
    }
    
    
    public String Leer_Archivo() {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        String cadena = "";
        try {
            archivo = new File("/home/alina/Escritorio/ejemplo.txt");
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
