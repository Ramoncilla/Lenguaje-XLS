/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Errores;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author Ramonella
 */
public class listaErrores {

    public ArrayList<errorC> lErrores;

    public listaErrores() {
        this.lErrores = new ArrayList<>();
    }

    public void errorLexico(int lin, int col, String carc) {
        // public errorC(String tipo, int lin, int col, String msj, String c){
        errorC n = new errorC("Lexico", lin, col, "Caracter no valido "+ carc, carc);
        this.lErrores.add(n);
    }

     public void errorSintactico(String descripcion)
        {
            int fila = 0;
            int col = 0;
            errorC nuevo = new errorC("Sintactico",fila, col, descripcion,"");
            this.lErrores.add(nuevo);
        }
    
    
    public void moostrarErrores() {

        String errores = "<!DOCTYPE html>\n"
                + "<html>\n"
                + "<head>\n"
                + "<style>\n"
                + "#customers {\n"
                + "    font-family: \"Trebuchet MS\", Arial, Helvetica, sans-serif;\n"
                + "    border-collapse: collapse;\n"
                + "    width: 100%;\n"
                + "}\n"
                + "\n"
                + "#customers td, #customers th {\n"
                + "    border: 1px solid #ddd;\n"
                + "    padding: 8px;\n"
                + "}\n"
                + "\n"
                + "#customers tr:nth-child(even){background-color: #f2f2f2;}\n"
                + "\n"
                + "#customers tr:hover {background-color: #ddd;}\n"
                + "\n"
                + "#customers th {\n"
                + "    padding-top: 12px;\n"
                + "    padding-bottom: 12px;\n"
                + "    text-align: left;\n"
                + "    background-color: #4CAF50;\n"
                + "    color: white;\n"
                + "}\n"
                + "</style>\n"
                + "</head>\n"
                + "<body>\n"
                + "\n"
                + "<table id=\"customers\">";
        errores += "<tr>\n"
                + "<td>Tipo</td>\n"
                + "<td>Fila</td>\n"
                + "<td>Columna</td>\n"
                + "<td>Descripcion</td>\n"
                + "</tr>\n";
        for (int i = 0; i < this.lErrores.size(); i++) {
            errores += this.lErrores.get(i).htmlError();
        }
        errores += "</table></body></html>";
        Save(errores);
       

    }

    
    public static boolean Save(String texto)
	{
		try
		{
			FileOutputStream archivo = new FileOutputStream("C:\\Users\\Ramonella\\Documents\\erroresXLSX.html");
		
			for(int i=0;i<texto.length();i++)
			{
				archivo.write((int)texto.charAt(i));
			}
			archivo.close();
		}
		catch(FileNotFoundException ex)
		{
			return false;
		}
		catch(IOException ex)
		{
			return false;
		}
		catch(Exception ex)
		{
			return false;
		}
		return true;
	}
	
    
}
