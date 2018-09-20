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
import XLSX.Forms.QuestionProperties.ListaConfiguraciones;
import XLSX.Forms.QuestionProperties.ListaOpciones;
import XLSX.Forms.QuestionProperties.ListaPreguntas;
import XLSX.Forms.basePregunta;
import java.io.IOException;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author alina
 */
public class AnalizerFileXML {
    public static ListaOpciones opciones = new ListaOpciones();
    public static ListaConfiguraciones configuraciones = new ListaConfiguraciones();
    
   public Formulario Analizer(List<String> paths) throws ParseException{
       String contentFile="";
       for (int i = 0; i < paths.size(); i++) {
           contentFile+=Leer_Archivo(paths.get(i))+"\n";
       }
       contentFile = contentFile.replace("“", "\"");
       contentFile = contentFile.replace("”", "\"");
       return  Parser(contentFile, paths.get(0));
   } 
    
    private Formulario Parser(String cadena, String nombreForm) throws ParseException{
        InputStream is = new ByteArrayInputStream(cadena.getBytes());
        grammarXLSX analizar = new grammarXLSX(is);
        Stack<basePregunta> pila = new Stack<>();
        ListaPreguntas preguntas = new ListaPreguntas();
   
        try {
            SimpleNode n = analizar.Start();
            n.ejecutar("",pila, opciones, configuraciones);
            System.out.println("--------- Analizador Finalizado --------------");
            System.out.println(pila.size());
            preguntas = (ListaPreguntas)pila.pop();
            preguntas.generarCodigo(preguntas);
            System.out.println("========================================================");
            Formulario f = new Formulario(preguntas,opciones,configuraciones, nombreForm);
           // preguntas.escribirPreguntas(preguntas, configuraciones, opciones);
            return f;
        } catch (Exception e) {
           System.out.println("Un error en la sintaxis.");
           System.out.println(e.getMessage());
           return null;
           
       }
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
        } catch (IOException e) {
            System.out.println("NO se pudo abiri el archivo" + e);
        }
        return cadena;
    }
    
    
}
