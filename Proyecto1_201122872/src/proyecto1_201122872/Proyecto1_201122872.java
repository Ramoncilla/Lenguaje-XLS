/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1_201122872;

import XLSX.AnalizerFileXML;
import XLSX.ReadExcel;
import java.util.List;

/**
 *
 * @author Ramonella
 */
public class Proyecto1_201122872 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //ReadExcel n = new ReadExcel ();
        //System.out.println(n.convertSheet("bin-CoDe", "C:\\Users\\Ramonella\\Desktop\\ejemplo.xlsx")); 
        
        ReadExcel reader = new ReadExcel();
        AnalizerFileXML parserAnalizer = new AnalizerFileXML();
        List<String> rutas = reader.generateXML("/home/alina/Descargas/Impresion.xlsx");
        parserAnalizer.Analizer(rutas);
        
        
        
    
    }
    
}
