/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XLSX.Forms;

import XLSX.AnalizerXML.SimpleNode;
import proyecto1_201122872.Constantes;
import XLSX.Forms.QuestionProperties.*;

/**
 *
 * @author Ramonella
 */
public class Question extends basePregunta {

    public Object tipo = null;
    public Object idPregunta = null;
    public Object etiqueta = null;
    public Object sugerir = null;
    public Object codigo_pre = null;
    public Object codigo_post = null;
    public Object restringir = null;
    public Object restringirMsn = null;
    public Object requerido = null;
    public Object requeridoMsn = null;
    public Object predeterminado = null;
    public Object aplicable = null;
    public Object lectura = null;
    public Object calculo = null;
    public Object repeticion = null;
    public Multimedia multi = null;
    public Object apariencia = null;
    public Parametro param = null;

    public Question() {
        tipo = null;
        idPregunta = null;
        etiqueta = null;
        sugerir = null;
        codigo_pre = null;
        codigo_post = null;
        restringir = null;
        restringirMsn = null;
        requerido = null;
        requeridoMsn = null;
        predeterminado = null;
        aplicable = null;
        lectura = null;
        calculo = null;
        repeticion = null;
        multi = null;
        apariencia = null;
        param = null;
    }

    private Object obtenerElemento(SimpleNode elementos) {
        String val = "";
        for (int i = 0; i < elementos.jjtGetNumChildren(); i++) {
            val += elementos.jjtGetChild(i).toString() + " ";
        }
        return val;
    }

    public boolean esPreguntaEnBlanco() {
        return (tipo != null
                && idPregunta != null
                && etiqueta != null
                && sugerir != null
                && codigo_pre != null
                && codigo_post != null
                && restringir != null
                && restringirMsn != null
                && requerido != null
                && requeridoMsn != null
                && predeterminado != null
                && aplicable != null
                && lectura != null
                && calculo != null
                && repeticion != null
                && multi != null
                && apariencia != null
                && param != null);
    }

    @Override
    public void mostrarDatos() {
        System.out.println("IMPRIMIENDO  PREGUNTA -----------------------------");

        if (tipo != null) {
            System.out.println(" La pripiedad  tipo  es:  " +tipo);
        }
        if (idPregunta != null) {
            System.out.println(" La pripiedad  idPregunta  es:  " +idPregunta);
        }
        if (etiqueta != null) {
            System.out.println(" La pripiedad  etiqueta  es:  " +etiqueta);
        }
        if (sugerir != null) {
            System.out.println(" La pripiedad  sugerir  es:  " +sugerir);
        }
        if (codigo_pre != null) {
            System.out.println(" La pripiedad   codigo_pre  es:  " +codigo_pre);
        }
        if (codigo_post != null) {
            System.out.println(" La pripiedad  codigo_post  es:  " +codigo_post);
        }
        if (restringir != null) {
            System.out.println(" La pripiedad  restringir  es:  " +restringir);
        }
        if (restringirMsn != null) {
            System.out.println(" La pripiedad  restringirMsn  es:  " +restringirMsn);
        }
        if (requerido != null) {
            System.out.println(" La pripiedad  requerido  es:  " +requerido);
        }
        if (requeridoMsn != null) {
            System.out.println(" La pripiedad  requeridoMsn  es:  " +requeridoMsn);
        }
        if (predeterminado != null) {
            System.out.println(" La pripiedad  predeterminado  es:  " +predeterminado);
        }
        if (aplicable != null) {
            System.out.println(" La pripiedad  aplicable  es:  " +aplicable);
        }
        if (lectura != null) {
            System.out.println(" La pripiedad lectura   es:  " +lectura);
        }
        if (calculo != null) {
            System.out.println(" La pripiedad  calculo  es:  " +calculo);
        }
        if (repeticion != null) {
            System.out.println(" La pripiedad  repeticion  es:  " +repeticion);
        }
        if (multi != null) {
            multi.imprimirMultimedia();
        }
        if (apariencia != null) {
            System.out.println(" La pripiedad  apariencia  es:  " +apariencia);
        }
        if (param != null) {
            param.imprimirParametro();
        }
        
        System.out.println(" FIN PREGUNTA -----------------------------");
    }

    public void insertarPropiedad(SimpleNode nodoPropiedad) {
        String nombrePropiedad = nodoPropiedad.jjtGetChild(0).toString().replace("<", "").replace(">", "").toUpperCase();
        int noElementos = nodoPropiedad.jjtGetChild(0).jjtGetNumChildren();

        if (noElementos > 0) {
            Object elemento = nodoPropiedad.jjtGetChild(0).jjtGetChild(0).toString(); //this.obtenerElemento((SimpleNode)nodoPropiedad.jjtGetChild(1));
           // System.out.println(elemento);
            switch (nombrePropiedad) {
                 case Constantes.APARIENCIA: {
                    if(!(elemento.toString().equalsIgnoreCase(""))){
                        this.apariencia = elemento;
                    }
                    break;
                }
                case Constantes.APLICABLE: {
                    if(!(elemento.toString().equalsIgnoreCase(""))){
                        this.aplicable = elemento;
                    }
                    
                    break;
                }
                case Constantes.CALCULO: {
                    
                    if(!(elemento.toString().equalsIgnoreCase(""))){
                       this.calculo = elemento;
                    }
                    
                    break;
                }

                case Constantes.CODIGO_POST: {
                    if(!(elemento.toString().equalsIgnoreCase(""))){
                        this.codigo_post = elemento;
                    }
                    
                    break;
                }

                case Constantes.CODIGO_PRE: {
                    if(!(elemento.toString().equalsIgnoreCase(""))){
                        this.codigo_pre = elemento;
                    }
                    
                    break;
                }

                case Constantes.ETIQUETA: {
                    if(!(elemento.toString().equalsIgnoreCase(""))){
                        this.etiqueta = elemento;
                    }
                    
                    break;
                }

                case Constantes.IDPREGUNTA: {
                    if(!(elemento.toString().equalsIgnoreCase(""))){
                        this.idPregunta = elemento;
                    }
                    
                    break;
                }

                case Constantes.LECTURA: {
                    String valor = elemento.toString();
                    switch (valor) {

                        case "0": {
                            this.lectura = "falso";
                            break;
                        }

                        case "1": {
                            this.lectura = "verdadero";
                            break;
                        }

                        case "verdadero": {
                            this.lectura = "verdadero";
                            break;
                        }

                        case "falso": {
                            this.lectura = "falso";
                            break;
                        }

                        default: {
                            this.lectura = "falso";
                           System.out.println("vinooo  en lectura   "+ elemento );
                            break;
                        }
                    }
                    break;
                }

                
                case Constantes.MULTIMEDIA: {
                    Multimedia a = new Multimedia((SimpleNode)nodoPropiedad.jjtGetChild(0));
                    boolean b = a.asignarValores();
                    if(b){
                        this.multi = a;
                    }
                    break;
                }

                case Constantes.PARAMETRO: {
                    Parametro a = new Parametro((SimpleNode)nodoPropiedad.jjtGetChild(0));
                    boolean b = a.activar();
                    if(b){
                        this.param = a;
                    }
                    break;
                }
                case Constantes.PREDETERMINADDO: {
                    if(!(elemento.toString().equalsIgnoreCase(""))){
                        this.predeterminado = elemento;
                    }
                    
                    break;
                }

                case Constantes.REPETICION: {
                    if(!(elemento.toString().equalsIgnoreCase(""))){
                        this.repeticion = elemento;
                    }
                   
                    break;
                }

                case Constantes.REQUERIDO: {
                    String valor = elemento.toString();
                    switch (valor) {

                        case "0": {
                            this.requerido = "falso";
                            break;
                        }

                        case "1": {
                            this.requerido = "verdadero";
                            break;
                        }

                        case "verdadero": {
                            this.requerido = "verdadero";
                            break;
                        }

                        case "falso": {
                            this.requerido = "falso";
                            break;
                        }

                        default: {
                            this.requerido = "falso";
                            System.out.println("vinooo  en requerido   "+ elemento );
                            break;
                        }
                    }
                    break;
                }

                case Constantes.REQUERIDOMSN: {
                    if(!(elemento.toString().equalsIgnoreCase(""))){
                        this.requeridoMsn = elemento;
                    }
                    
                    break;
                }

                case Constantes.RESTRINGIR: {
                    if(!(elemento.toString().equalsIgnoreCase(""))){
                       this.restringir = elemento;
                    }
                  
                    break;
                }

                case Constantes.RESTRINGIRMSN: {
                    if(!(elemento.toString().equalsIgnoreCase(""))){
                        this.restringirMsn = elemento;
                    }
                    
                    break;
                }

                case Constantes.SUGERIR: {
                    if(!(elemento.toString().equalsIgnoreCase(""))){
                        this.sugerir = elemento;
                    }
                    
                    break;
                }

                case Constantes.TIPO: {
                    if(!(elemento.toString().equalsIgnoreCase(""))){
                      this.tipo = elemento;  
                    }
                    
                    break;
                }
            }
        } else {

        }

        //System.out.println("Propiedad "+ nodeQuestion.jjtGetChild(i).jjtGetChild(0).toString().replace("<","").replace(">", "")+":  "+nodeQuestion.jjtGetChild(i).jjtGetChild(1).jjtGetNumChildren());
    }

}
