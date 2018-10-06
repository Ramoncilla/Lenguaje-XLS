/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Errores;

/**
 *
 * @author Ramonella
 */
public class errorC {
    
    public String tipo;
    public int linea;
    public int columna;
    public String mensaje;
    public String caracter;
    
    
    public errorC(String tipo, int lin, int col, String msj, String c){
        this.tipo= tipo;
        this.linea= lin;
        this.columna= col;
        this.mensaje= msj;
        this.caracter= c;  
    }
    
      public String htmlError()
        {
            String cad = "";

            cad = "<tr>\n" +
                "<td>"+this.tipo+"</td>\n" +
                "<td>"+(this.linea+1)+"</td>\n" +
                "<td>"+(this.columna+1)+"</td>\n" +
                "<td>" + this.mensaje + "</td>\n" +
                "</tr>\n";
            return cad;
        }
    
}
