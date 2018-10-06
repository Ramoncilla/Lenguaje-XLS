/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XLSX.Forms;

import XLSX.AnalizerXML.SimpleNode;
import XLSX.Forms.QuestionProperties.ListaPreguntas;
import java.util.ArrayList;
import java.util.List;
import proyecto1_201122872.Constantes;

/**
 *
 * @author Ramonella
 */
public class Ciclo extends basePregunta {
    
    public List<basePregunta> preguntas;
    public Question  propiedadesInicio;
    public Question propiedadesFin;
   
 
    public Ciclo(){
        this.preguntas= new ArrayList<>();
        this.propiedadesInicio= new Question();
        this.propiedadesFin = new Question();
        
    }
         
    @Override
    public void mostrarDatos() {
        System.out.println("Imprimiendo  ciclo ***********************************   ");
        System.out.println("Inicio Ciclo :  "); 
        this.propiedadesInicio.mostrarDatos();
        basePregunta temp;
        for (int i = 0; i <preguntas.size(); i++) {
            temp= preguntas.get(i);
            if(temp instanceof Question){
                Question q = (Question)temp;
                q.mostrarDatos();
                
            }
            if(temp instanceof Agrupacion){
                Agrupacion g = (Agrupacion)temp;
                g.mostrarDatos();
            }
            
        }
        System.out.println("Fin Ciclo:   ");
        this.propiedadesFin.mostrarDatos();
        System.out.println("Fin de imprimir Ciclo  ******************************   ");
    }
   
     @Override
    public String generarLlamadaSimple(){
        /*String cadena="";
        String llamadaGrupo = ""+this.propiedadesInicio.idPregunta.toString()+"();\n";
        cadena += this.getCodigoPre(propiedadesInicio);
        cadena += this.getAplicable(llamadaGrupo, propiedadesInicio);
        cadena += this.getCodigoPost(propiedadesInicio);
       return cadena;*/
        
       String r = obtenerCiclo();
       return r;
    }
    
    
    private String obtenerCiclo(){
        String cadena="";
        String llamadaGrupo = ""+this.propiedadesInicio.idPregunta.toString()+"();\n";
        cadena += this.getCodigoPre(propiedadesInicio);
        cadena += this.getAplicable(llamadaGrupo, propiedadesInicio);
        cadena += this.getCodigoPost(propiedadesInicio);
        String codigoFor="";
        if(propiedadesInicio.repeticion!= null){
            String nombreCiclo = "varCiclo"+Constantes.obtenerCont();
            String codigoRepeticiones = buscarLlamadaPreguntas(propiedadesInicio.repeticion.toString());
            codigoFor+="Para (entero "+ nombreCiclo+"=0; "+nombreCiclo+"< "+ codigoRepeticiones+";"+nombreCiclo+"++){\n";
            codigoFor+=cadena+"\n}";
        }else{
            String nombreCiclo = "varCiclo"+Constantes.obtenerCont();
            codigoFor+="Para (entero "+ nombreCiclo+"=0; "+nombreCiclo+"< 1;"+nombreCiclo+"++){\n";
            codigoFor+=cadena+"\n}";
        }   
       return codigoFor; 
    }
    
    
    
    @Override
    public String generarCodigo(ListaPreguntas p){
        
        String llamadasPreguntasAgrupacion = generarCodigoLlamadaPreguntas(p);
        String clasesPreguntas = generarCodigoPreguntas(p);
       
        
        String contenidoGrupo ="$$--------------------------- Inicio Ciclo "+ propiedadesInicio.idPregunta.toString()+"------------------\n";
        contenidoGrupo+="Grupo "+ propiedadesInicio.idPregunta.toString()+"(){ \n"
                + "Respuesta resp; \n";
        contenidoGrupo+=llamadasPreguntasAgrupacion;
        contenidoGrupo+="\n}\n";
        
       return clasesPreguntas +"\n"+ contenidoGrupo;
    }
    
    
    private String generarCodigoLlamadaPreguntas(ListaPreguntas p){
        String contGrupo="";
        String llamadaInicio ="Mensaje(\" Inicio de Ciclo "+ propiedadesInicio.idPregunta.toString() + "\");\n";
        String llamadaFin= "";
        String cadena ="Mensaje( \"Fin de Ciclo "+ propiedadesFin.idPregunta.toString() + "\");\n";
        llamadaFin += this.getCodigoPre(propiedadesFin);
        llamadaFin += this.getAplicable(cadena, propiedadesFin);
        llamadaFin += this.getCodigoPost(propiedadesFin);
        contGrupo+=llamadaInicio;
        basePregunta temp;
        for (int i = 0; i < this.preguntas.size(); i++) { 
            temp=this.preguntas.get(i);
             contGrupo+=temp.generarLlamadaSimple()+"\n";
        }
        contGrupo+=llamadaFin+"\n";
        return contGrupo +"\n\n";
    }
    
    
    private String generarCodigoPreguntas(ListaPreguntas p){
        
      // String notaInicio= propiedadesInicio.generarCodigo(p)+"\n";
       // String notaFinal= propiedadesFin.generarCodigo(p)+"\n";
        String pregunta = "$$--------------------------- Inicio Ciclo "+ propiedadesInicio.idPregunta.toString()+"------------------\n";
        pregunta="";
        basePregunta temp;
        for (int i = 0; i < this.preguntas.size(); i++) {
            temp=this.preguntas.get(i);
             pregunta+=temp.generarCodigo(p);
        }
          pregunta+="$$--------------------------- Fin Ciclo "+ propiedadesInicio.idPregunta.toString()+"------------------\n";
        return pregunta +"\n\n";
    }
    
    
  
     private String getAplicable(String llamadaGrupo, Question preg) {
        String cod = llamadaGrupo;//this.LlamadaPregunta();
        if (preg.aplicable != null) {
            String c = this.buscarLlamadaPreguntas(preg.aplicable.toString());
            String cod2 = "Si( " + c + "){\n" + cod + "\n}\n";
            return cod2;
        }

        return cod;
    }

    private String getCodigoPre(Question preg) {
        if (preg.codigo_pre != null) {
            String c = this.buscarLlamadaPreguntas(preg.codigo_pre.toString());
            return c + "\n";
        }
        return "";

    }

    private String getCodigoPost(Question preg) {
        if (preg.codigo_post != null) {
            String c = this.buscarLlamadaPreguntas(preg.codigo_post.toString());
            return c + "\n";
        }
        return "";

    }
    
    
    
       private String buscarLlamadaPreguntas(String cadena) {
        String ret = cadena.trim().toLowerCase();
        boolean b = (ret.startsWith("\"") && ret.endsWith("\""));
        List<String> preg = this.obtenerIdPreguntas(ret);
        String llamadaPregunta = "";
        String temp = "";
        for (int i = 0; i < preg.size(); i++) {
            temp = preg.get(i);
            llamadaPregunta = temp + ".respuestas";//this.preguntas.obtenerLlamadaPregunta(temp);
            if (!(llamadaPregunta.equalsIgnoreCase(""))) {
                String v = "#[" + temp.toLowerCase() + "]";
                if (b) {
                    ret = ret.replace(v, "\" + " + llamadaPregunta + "+ \"");
                } else {
                    ret = ret.replace(v, llamadaPregunta);
                }

            }
        }
        return ret;
    }
       
       
       public List<String> obtenerIdPreguntas(String cadena) {
        List<String> lista = new ArrayList<>();
        char c;
        String cadTemp = "";
        boolean b1 = false;
        boolean b2 = false;
        for (int i = 0; i < cadena.length(); i++) {
            c = cadena.charAt(i);
            if (c == 35) {
                b1 = true;
                b2 = false;
                cadTemp = "";
            }
            if (b1 == true && c == 91) {
                b1 = false;
                b2 = true;
            }
            if (b2 == true && c != 91 && c != 93) {
                cadTemp += c + "";
            }
            if (b2 == true && c == 93) {
                lista.add(cadTemp);
                cadTemp = "";
                b1 = false;
                b2 = false;
            }
        }

        return lista;
    }
    
    
    
    
}
