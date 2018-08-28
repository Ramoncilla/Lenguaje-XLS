/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XLSX.Forms;

import XLSX.AnalizerXML.SimpleNode;
import proyecto1_201122872.Constantes;
import XLSX.Forms.QuestionProperties.*;
import java.util.ArrayList;
import java.util.List;

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
    public Object nombreLista = null;

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
        nombreLista = null;
    }

    public boolean esPreguntaLlena() {
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
                && param != null
                && nombreLista!=null);
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
                      String [] val = elemento.toString().split("%");
                      if(val.length>1){
                          this.tipo= val[0];
                          this.nombreLista = val[1];
                      }
                      else if(elemento.toString().toLowerCase().contains("fichero")){
                          String v = elemento.toString().toLowerCase().trim().replace("fichero", "");
                          this.tipo = "fichero";
                          this.nombreLista= v;
                      }
                      else{
                         this.tipo = elemento;  
                      }
                         
                    }
                    
                    break;
                }
            }
        } else {

        }

        //System.out.println("Propiedad "+ nodeQuestion.jjtGetChild(i).jjtGetChild(0).toString().replace("<","").replace(">", "")+":  "+nodeQuestion.jjtGetChild(i).jjtGetChild(1).jjtGetNumChildren());
    }
    
    
    
    
    
    
    
 /*---------------------- Despliegue de los datos -----------------------------*/
    
    @Override
    public void mostrarDatos() {
        System.out.println("IMPRIMIENDO  PREGUNTA -----------------------------");

        if (tipo != null) {
            System.out.println(" La pripiedad  tipo  es:  " +tipo );
        }
        
        if (tipo != null && this.nombreLista!= null) {
            System.out.println(" La pripiedad  tipo  es:  " +tipo +",  nombreLista "+ this.nombreLista.toString());
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


    
    
    /*==================================== GENERACION DE CODIGO =================================*/
    
    
     public String generarCodigo(ListaPreguntas listaP){
         
         String codigo="";
         if(this.idPregunta!= null){
             codigo+="Pregunta "+ this.idPregunta+"{\n";
             codigo+=this.getCodEtiqueta();
             codigo+=this.getCodRequeridoMsn();
             codigo+=this.getCodRuta();
             codigo+=this.getCodSugerir();
             
             codigo+=this.getCodMostrar();
             codigo+=this.getCodRespuesta();
             
             
             
             
              
             codigo+="}";
         }
        return codigo;
    }
    
    
    
    
    
    /******* Atributos **************/
    
    
    
    
    private String getCodEtiqueta(){
        if(this.etiqueta!= null){
            return "Cadena etiqueta = \" "+this.etiqueta+"\";\n";
        }
        return "";
    }
    
    private String getCodSugerir(){
         if(this.sugerir!= null){
            return "Cadena sugerir = \" "+this.sugerir+"\";\n";
        }
        return "";
    }
    
    private String getCodRequeridoMsn(){
         if(this.requeridoMsn!= null){
            return "Cadena requeridoMsn = \" "+this.requeridoMsn+"\";\n";
        }
        return "";
    }
    
       private String getCodRuta(){
         if(this.multi!= null){
             if((!(multi.ruta.equalsIgnoreCase(""))) && (multi.ruta!= null)){
                 return "Cadena ruta = \" "+this.multi.ruta+"\";\n";
             }
        }
        return "";
    }
    
       
    /******* Funciones   **************/
       
    private String getCodMostrar(){
        if(this.multi!= null){
            String cod = multi.obtenerCodigoMostrar();
            if(!(cod.equalsIgnoreCase(""))){
                return "publico Mostrar(){ \n"+cod+"}\n";
            }
        }
        return "";
    }   
       
    
    private String obtenerParametrosApariencia(String tipoMostrar){
        
                switch(tipoMostrar.toUpperCase()){
                  case Constantes.TEXTO:{
                    boolean b=false;
                    String cFila="";
                    String cMax="";
                    String cMin="";
                    
                    if(this.param.cad_fila.equalsIgnoreCase("")){
                        cFila="nada";
                    }else{
                        cFila = this.param.cad_fila;
                        b=true;
                    }
                    
                    if(this.param.cad_max.equalsIgnoreCase("")){
                        cMax="nada";
                    }else{
                        cMax = this.param.cad_max;
                        b=true;
                    }
                    
                    if(this.param.cad_min.equalsIgnoreCase("")){
                        cMin="nada";
                    }else{
                        cMin = this.param.cad_min;
                        b=true;
                    }
                    
                    if(b){
                        return (cMin+", "+cMax+", "+cFila);
                    }
                        
                    break;
                }
                  
                  case Constantes.RANGO:{
                      String pIniciar = "0";
                      String pFinalizar = this.param.finalizar;
                      if(!(this.param.iniciar.equalsIgnoreCase(""))){
                          pIniciar = this.param.iniciar;
                      }
                      return pIniciar+", "+pFinalizar;
                  }
                  
                  
                  case Constantes.CONDICION:{
                      String valor = "V_F";
                      if(this.param.opcion.equalsIgnoreCase("")){
                          return valor;
                      }else{
                          return this.param.opcion;
                      }
                  }
                  
                  
                  case Constantes.SELECCION_UNO:{
                      if(this.nombreLista!=null){
                          if(!(this.nombreLista.toString().equalsIgnoreCase(""))){
                              return this.nombreLista.toString();
                          }
                      }
                      break;
                  }
                  
                  
                  case Constantes.SELECCION_MULTIPLES:{
                      if(this.nombreLista!=null){
                          if(!(this.nombreLista.toString().equalsIgnoreCase(""))){
                              return this.nombreLista.toString();
                          }
                      }
                      break;
                  }
                  
                  case Constantes.FICHERO:{
                      if(this.nombreLista!=null){
                          if(!(this.nombreLista.toString().equalsIgnoreCase(""))){
                              return this.nombreLista.toString();
                          }
                      }
                      break;
                  }
                    
                }
        
        return "";
    }
    
    public String getCodLlamadaPregunta(){
        String llamada="";
        llamada = this.idPregunta.toString()+"().Respuesta(res."+this.obtenerParametroTipo()+").";
        String tipoTexto= this.tipo.toString().toUpperCase();
        if(this.apariencia!= null){
            llamada+="Apariencia().";
            tipoTexto = this.apariencia.toString().toUpperCase();
        }
        
            switch(tipoTexto){
                
                case Constantes.TEXTO:{
                    llamada+="Cadena";
                    break;
                }
                
                case Constantes.ENTERO:{
                    llamada+="Entero";
                    break;
                }
                
                case Constantes.DECIMAL:{
                    llamada+="Decimal";
                    break;
                }
                
                case Constantes.RANGO:{
                    llamada+="Rango";
                    break;
                }
                
                
                case Constantes.CONDICION:{
                    llamada+="Condicion";
                    break;
                }
                
                case Constantes.FECHA:{
                    llamada+="Fecha";
                    break;
                }
                
                case Constantes.HORA:{
                    llamada+="Hora";
                    break;
                }
                
                case Constantes.FECHAHORA:{
                    llamada+="FechaHora";
                    break;
                }
                
                case Constantes.SELECCION_UNO:{
                    llamada+="Seleccionar_1";
                    break;
                }
                
                case Constantes.SELECCION_MULTIPLES:{
                    llamada+="Seleccionar";
                    break;
                }
                
                case Constantes.NOTA:{
                    llamada+="Nota";
                    break;
                }
                
                case Constantes.FICHERO:{
                    llamada+="Fichero";
                    break;
                }
                
                default:{
                    System.out.println("Vino "+ tipoTexto);
                    llamada+="Cadena";
                    break;
                }
                
            }
            
            llamada+="("+this.obtenerParametrosApariencia(tipoTexto)+");";
        return llamada;
    }
      
    
    private String getCodRespuesta(){
        String visibilidad = "publico";
        String cadena = visibilidad + " Respuesta ( "+ this.tipo.toString()+" param_1){\n"
                + "     respuesta = param_1;"
                + "\n}";
        
        return cadena;
    }
    
    
    
    
    
    
     
    private String obtenerParametroTipo(){
        return "es"+this.tipo.toString();
    } 
    
    
    public List<String> obtenerPreguntas(String cadena){
        
        List<String> lista = new ArrayList<>();
        char c;
        String cadTemp="";
        boolean b1 = false;
        boolean b2 = false;
        for (int i = 0; i < cadena.length(); i++) {
            c= cadena.charAt(i);
            if(c==35){
                b1= true;
                b2= false;
                cadTemp="";
            }
            if(b1== true && c== 91){
                b1=false;
                b2 = true;
            }
            if(b2 == true && c!=91 && c!=93){
                cadTemp+=c+"";
            }
            if(b2==true && c ==93){
                System.out.println(cadTemp);
                cadTemp="";
                b1=false;
                b2=false;
            } 
        }
        
        return lista;
    }
    
    
    
}
