/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1_201122872;

import AnalizadorExpresion.AnalizarExpresion;
import Errores.listaErrores;
import XLSX.AnalizerFileXML;
import XLSX.AnalizerXML.ParseException;
import XLSX.ReadExcel;
import java.util.List;

/**
 *
 * @author Ramonella
 */
public class Proyecto1_201122872 {
    
    public static listaErrores erroresEjecucion= new listaErrores();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        // TODO code application logic here
        //ReadExcel n = new ReadExcel ();
        //System.out.println(n.convertSheet("bin-CoDe", "C:\\Users\\Ramonella\\Desktop\\ejemplo.xlsx")); 
      Principal p = new Principal();
       p.setVisible(true);
       
      // AnalizarExpresion exp = new AnalizarExpresion();
      // exp.Parser("25*10-23*78>89*12 && 8<10");
       //"25 2.5 \"alinaaaa\" verdadero falso nulo \"25/05/1992\" '23:59:59' '25/05/1992 23:59:59\"  "
       //'25/05/1992' '23:59:59' \"25/05/1992\" \"23:59:59\" 
        /*ReadExcel reader = new ReadExcel();
        AnalizerFileXML parserAnalizer = new AnalizerFileXML();
       List<String> rutas = reader.generateXML("C:\\Users\\Ramonella\\Desktop\\Libro2.xls");
        parserAnalizer.Analizer(rutas);
        String hola = "\"hola\"";
        System.out.println(hola.startsWith("\""));
        */
    
   
    
    }
    
}
