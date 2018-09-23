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
    private ListaPreguntas preguntas;

    public Question() {
        this.preguntas = new ListaPreguntas();
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
                && nombreLista != null);
    }

    public void insertarPropiedad(SimpleNode nodoPropiedad) {
        String nombrePropiedad = nodoPropiedad.jjtGetChild(0).toString().replace("<", "").replace(">", "").toUpperCase();
        int noElementos = nodoPropiedad.jjtGetChild(0).jjtGetNumChildren();

        if (noElementos > 0) {
            Object elemento = nodoPropiedad.jjtGetChild(0).jjtGetChild(0).toString(); //this.obtenerElemento((SimpleNode)nodoPropiedad.jjtGetChild(1));
            switch (nombrePropiedad) {
                case Constantes.APARIENCIA: {
                    if (!(elemento.toString().equalsIgnoreCase(""))) {
                        this.apariencia = elemento;
                    }
                    break;
                }
                case Constantes.APLICABLE: {
                    if (!(elemento.toString().equalsIgnoreCase(""))) {
                        this.aplicable = elemento;
                    }

                    break;
                }
                case Constantes.CALCULO: {

                    if (!(elemento.toString().equalsIgnoreCase(""))) {
                        this.calculo = elemento;
                    }

                    break;
                }

                case Constantes.CODIGO_POST: {
                    if (!(elemento.toString().equalsIgnoreCase(""))) {
                        if(this.idPregunta!= null){
                            String g = this.idPregunta.toString()+".respuestas";
                             String val = elemento.toString().replace("@", g);
                              this.codigo_post = val;
                        }else{
                            this.codigo_post= elemento.toString();
                        }
                       
                    }

                    break;
                }

                case Constantes.CODIGO_PRE: {
                    if (!(elemento.toString().equalsIgnoreCase(""))) {
                           if(this.idPregunta!= null){
                            String g = this.idPregunta.toString()+".respuestas";
                             String val = elemento.toString().replace("@", g);
                              this.codigo_pre = val;
                        }else{
                            this.codigo_pre= elemento.toString();
                        }
                    }

                    break;
                }

                case Constantes.ETIQUETA: {
                    if (!(elemento.toString().equalsIgnoreCase(""))) {
                        this.etiqueta = elemento;
                    }

                    break;
                }

                case Constantes.IDPREGUNTA: {
                    if (!(elemento.toString().equalsIgnoreCase(""))) {
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
                        default: {
                            if (valor.equalsIgnoreCase("")) {
                                this.lectura = null;
                            } else {
                                this.lectura = valor;
                            }

                        }
                    }
                    break;
                }

                case Constantes.MULTIMEDIA: {
                    Multimedia a = new Multimedia((SimpleNode) nodoPropiedad.jjtGetChild(0));
                    boolean b = a.asignarValores();
                    if (b) {
                        this.multi = a;
                    }
                    break;
                }

                case Constantes.PARAMETRO: {
                    Parametro a = new Parametro((SimpleNode) nodoPropiedad.jjtGetChild(0));
                    boolean b = a.activar();
                    if (b) {
                        this.param = a;
                    }
                    break;
                }
                case Constantes.PREDETERMINADDO: {
                    if (!(elemento.toString().equalsIgnoreCase(""))) {
                        this.predeterminado = elemento;
                    }

                    break;
                }

                case Constantes.REPETICION: {
                    if (!(elemento.toString().equalsIgnoreCase(""))) {
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
                        default: {
                            if (valor.equalsIgnoreCase("")) {
                                this.requerido = null;
                            } else {
                                this.requerido = valor;
                            }

                            break;
                        }
                    }
                    break;
                }

                case Constantes.REQUERIDOMSN: {
                    if (!(elemento.toString().equalsIgnoreCase(""))) {
                        this.requeridoMsn = elemento;
                    }

                    break;
                }

                case Constantes.RESTRINGIR: {
                    if (!(elemento.toString().equalsIgnoreCase(""))) {
                        this.restringir = elemento;
                    }

                    break;
                }

                case Constantes.RESTRINGIRMSN: {
                    if (!(elemento.toString().equalsIgnoreCase(""))) {
                        this.restringirMsn = elemento;
                    }

                    break;
                }

                case Constantes.SUGERIR: {
                    if (!(elemento.toString().equalsIgnoreCase(""))) {
                        this.sugerir = elemento;
                    }

                    break;
                }

                case Constantes.TIPO: {
                    if (!(elemento.toString().equalsIgnoreCase(""))) {
                        String[] val = elemento.toString().split("%");
                        if (val.length > 1) {
                            this.tipo = val[0];
                            this.nombreLista = val[1];
                        } else if (elemento.toString().toLowerCase().contains("fichero")) {
                            String v = elemento.toString().toLowerCase().trim().replace("fichero", "");
                            this.tipo = "fichero";
                            this.nombreLista = v;
                        } else {
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

    @Override
    public void mostrarDatos() {
        System.out.println("IMPRIMIENDO  PREGUNTA -----------------------------");

        if (tipo != null) {
            System.out.println(" La pripiedad  tipo  es:  " + tipo);
        }

        if (tipo != null && this.nombreLista != null) {
            System.out.println(" La pripiedad  tipo  es:  " + tipo + ",  nombreLista " + this.nombreLista.toString());
        }

        if (idPregunta != null) {
            System.out.println(" La pripiedad  idPregunta  es:  " + idPregunta);
        }
        if (etiqueta != null) {
            System.out.println(" La pripiedad  etiqueta  es:  " + etiqueta);
        }
        if (sugerir != null) {
            System.out.println(" La pripiedad  sugerir  es:  " + sugerir);
        }
        if (codigo_pre != null) {
            System.out.println(" La pripiedad   codigo_pre  es:  " + codigo_pre);
        }
        if (codigo_post != null) {
            System.out.println(" La pripiedad  codigo_post  es:  " + codigo_post);
        }
        if (restringir != null) {
            System.out.println(" La pripiedad  restringir  es:  " + restringir);
        }
        if (restringirMsn != null) {
            System.out.println(" La pripiedad  restringirMsn  es:  " + restringirMsn);
        }
        if (requerido != null) {
            System.out.println(" La pripiedad  requerido  es:  " + requerido);
        }
        if (requeridoMsn != null) {
            System.out.println(" La pripiedad  requeridoMsn  es:  " + requeridoMsn);
        }
        if (predeterminado != null) {
            System.out.println(" La pripiedad  predeterminado  es:  " + predeterminado);
        }
        if (aplicable != null) {
            System.out.println(" La pripiedad  aplicable  es:  " + aplicable);
        }
        if (lectura != null) {
            System.out.println(" La pripiedad lectura   es:  " + lectura);
        }
        if (calculo != null) {
            System.out.println(" La pripiedad  calculo  es:  " + calculo);
        }
        if (repeticion != null) {
            System.out.println(" La pripiedad  repeticion  es:  " + repeticion);
        }
        if (multi != null) {
            multi.imprimirMultimedia();
        }
        if (apariencia != null) {
            System.out.println(" La pripiedad  apariencia  es:  " + apariencia);
        }
        if (param != null) {
            param.imprimirParametro();
        }

        System.out.println(" FIN PREGUNTA -----------------------------");
    }

    /*==================================== GENERACION DE CODIGO =================================*/
    @Override
    public String generarCodigo(ListaPreguntas listaP) {
        if (tipo.toString().equalsIgnoreCase(Constantes.INICIAR_AGRUPACION)) {
            String g = "Pregunta " + idPregunta + "(){\n"
                    + "Cadena etiqueta = \"Inicio de Agrupacion " + idPregunta + "\";\n"
                    + "Cadena ruta; \n"
                    + "publico Respuesta(){\n"
                    + "}\n"
                    + "\n"
                    + "}\n";
            return g;
        } else if (tipo.toString().equalsIgnoreCase(Constantes.FINALIZAR_AGRUPACION)) {
            String g = "Pregunta " + idPregunta + "(){\n"
                    + "Cadena etiqueta = \"Finalizar  Agrupacion " + idPregunta + "\";\n"
                    + "Cadena ruta; \n"
                    + "publico Respuesta(){\n"
                    + "}\n"
                    + "\n"
                    + "}\n";
            return g;
        }else if(tipo.toString().equalsIgnoreCase(Constantes.INICIAR_CICLO)){
             String g = "Pregunta " + idPregunta + "(){\n"
                    + "Cadena etiqueta = \"Inicio Ciclo " + idPregunta + "\";\n"
                    + "Cadena ruta; \n"
                    + "publico Respuesta(){\n"
                    + "}\n"
                    + "\n"
                    + "}\n";
            return g;
        }else if( tipo.toString().equalsIgnoreCase(Constantes.FINALIZAR_CICLO)){
             String g = "Pregunta " + idPregunta + "(){\n"
                    + "Cadena etiqueta = \"Finalizar ciclo " + idPregunta + "\";\n"
                    + "Cadena ruta; \n"
                    + "publico Respuesta(){\n"
                    + "}\n"
                    + "\n"
                    + "}\n";
            return g;
        }
        this.preguntas = listaP;
        String codigo = "";
        if (this.idPregunta != null) {
            codigo += "$$ ------------------ Inicio Pregunta " + this.idPregunta + " ------------------\n";
            codigo += "Pregunta " + this.idPregunta + "() {\n";
            codigo += this.generarAtributos();
            codigo += this.generarFunciones();
            codigo += "\n}\n\n";
            codigo += "$$ ------------------ Fin Pregunta " + this.idPregunta + " ---------------------\n";
        }
        return codigo;
    }

    /*======================================= GENERACION DE ATRIBUTOS A PREGUNTA =============================================================*/
    private String generarAtributos() {
        String atributos = "";
        atributos += this.getCodEtiqueta();
        atributos += this.getCodSugerir();
        atributos += this.getRequerido();
        atributos += this.getCodRequeridoMsn();
        atributos += this.getCodRuta();
        atributos += this.getPredeterminado();
        atributos += this.getLectura();
        //atributos += this.getApariencia();
        return atributos;
    }

    private String getCodEtiqueta() {
        if (this.etiqueta != null) {
            String c = this.buscarLlamadaPreguntas("\"" + this.etiqueta + "\"");
            String h = "Cadena etiqueta = " + c + ";\n";
            return h;
        }
        return "";
    }

    private String getCodSugerir() {
        if (this.sugerir != null) {
            String c = this.buscarLlamadaPreguntas("\"" + this.sugerir.toString() + "\"");
            String h = "Cadena sugerir = " + c + ";\n";
            return h;
        }
        return "";
    }

    private String getRequerido() {
        if (this.requerido != null) {
            String c = this.buscarLlamadaPreguntas(this.requerido.toString());
            String h = "Booleano requerido = " + c + ";\n";
            return h;
        }
        return "";
    }

    private String getCodRequeridoMsn() {
        if (this.requeridoMsn != null) {
            String c = this.buscarLlamadaPreguntas("\"" + this.requeridoMsn.toString() + "\"");
            String h = "Cadena requeridoMsn = " + c + ";\n";
            return h;
        }
        return "";
    }

    private String getCodRuta() {
        /* if(this.multi!= null){
             if((!(multi.ruta.equalsIgnoreCase(""))) && (multi.ruta!= null)){
                String c = this.buscarLlamadaPreguntas("\""+this.multi.ruta+"\"");
                String h = "Cadena ruta = "+c+";\n";
                return h;
             }
        }*/
        return "Cadena ruta; \n";
    }

    private String getPredeterminado() {
        String valPredeterminado = this.getValorPredeterminado();
        String tipoR = "";

        if (this.tipo != null) {
            String tipo1 = tipo.toString();

            if (tipo1.equalsIgnoreCase(Constantes.CALCULAR)) {

            }

            if (tipo1.equalsIgnoreCase(Constantes.CADENA)) {
                tipoR = Constantes.CADENA;
            }

            if (tipo1.equalsIgnoreCase(Constantes.ENTERO)) {
                tipoR = Constantes.ENTERO;
            }

            if (tipo1.equalsIgnoreCase(Constantes.DECIMAL)) {
                tipoR = Constantes.DECIMAL;
            }

            if (tipo1.equalsIgnoreCase(Constantes.RANGO)) {
                tipoR = Constantes.ENTERO;
            }

            if (tipo1.equalsIgnoreCase(Constantes.CONDICION)) {
                tipoR = Constantes.BOOLEANO;
            }

            if (tipo1.equalsIgnoreCase(Constantes.FECHA)) {
                tipoR = Constantes.FECHA;
            }

            if (tipo1.equalsIgnoreCase(Constantes.HORA)) {
                tipoR = Constantes.HORA;
            }

            if (tipo1.equalsIgnoreCase(Constantes.FECHAHORA)) {
                tipoR = Constantes.FECHAHORA;
            }

            if (tipo1.equalsIgnoreCase(Constantes.SELECCION_UNO)) {

            }

            if (tipo1.equalsIgnoreCase(Constantes.SELECCION_MULTIPLES)) {

            }

            if (tipo1.equalsIgnoreCase(Constantes.NOTA)) {

            }

            if (tipo1.equalsIgnoreCase(Constantes.FICHERO)) {

            }

            if (tipo1.equalsIgnoreCase(Constantes.INICIAR_AGRUPACION)) {

            }

            if (tipo1.equalsIgnoreCase(Constantes.FINALIZAR_AGRUPACION)) {

            }

            if (tipo1.equalsIgnoreCase(Constantes.INICIAR_CICLO)) {

            }

            if (tipo1.equalsIgnoreCase(Constantes.FINALIZAR_CICLO)) {

            }
        }

        if (!(tipoR.equalsIgnoreCase(""))) {
            if (!(valPredeterminado.equalsIgnoreCase(""))) {
                return tipoR + " respuestas = " + valPredeterminado + ";\n";
            } else {
                return tipoR + " respuestas;\n";
            }
        }
        return "";
    }

    private String getValorPredeterminado() {
        if (this.predeterminado != null) {
            if (this.tipo.toString().equalsIgnoreCase(Constantes.CADENA)) {
                String c = this.buscarLlamadaPreguntas("\"" + this.predeterminado + "\"");
                return c;
            } else if (this.tipo.toString().equalsIgnoreCase(Constantes.HORA)
                    || this.tipo.toString().equalsIgnoreCase(Constantes.FECHA)
                    || this.tipo.toString().equalsIgnoreCase(Constantes.FECHAHORA)) {
                String c = this.buscarLlamadaPreguntas(this.predeterminado.toString());
                return c;
            } else {
                String c = this.buscarLlamadaPreguntas(this.predeterminado.toString());
                return c;
            }
        }
        return "";
    }

    private String getAparienciaL() {
        if (this.apariencia != null) {
            String tipo1 = apariencia.toString();
            String tipoR = "";
            if (tipo1.equalsIgnoreCase(Constantes.CALCULAR)) {

            }
            if (tipo1.equalsIgnoreCase(Constantes.CADENA)) {
                tipoR = Constantes.CADENA;
            }

            if (tipo1.equalsIgnoreCase(Constantes.ENTERO)) {
                tipoR = Constantes.ENTERO;
            }

            if (tipo1.equalsIgnoreCase(Constantes.DECIMAL)) {
                tipoR = Constantes.DECIMAL;
            }

            if (tipo1.equalsIgnoreCase(Constantes.RANGO)) {
                tipoR = Constantes.RANGO;
            }

            if (tipo1.equalsIgnoreCase(Constantes.CONDICION)) {
                tipoR = Constantes.CONDICION;
            }

            if (tipo1.equalsIgnoreCase(Constantes.FECHA)) {
                tipoR = Constantes.FECHA;
            }

            if (tipo1.equalsIgnoreCase(Constantes.HORA)) {
                tipoR = Constantes.HORA;
            }

            if (tipo1.equalsIgnoreCase(Constantes.FECHAHORA)) {
                tipoR = Constantes.FECHAHORA;
            }

            if (tipo1.equalsIgnoreCase(Constantes.SELECCION_UNO)) {
                tipoR = Constantes.CADENA;
            }

            if (tipo1.equalsIgnoreCase(Constantes.SELECCION_MULTIPLES)) {
                tipoR = Constantes.CADENA;
            }

            if (tipo1.equalsIgnoreCase(Constantes.NOTA)) {

            }

            if (tipo1.equalsIgnoreCase(Constantes.FICHERO)) {

            }

            if (tipo1.equalsIgnoreCase(Constantes.INICIAR_AGRUPACION)) {

            }

            if (tipo1.equalsIgnoreCase(Constantes.FINALIZAR_AGRUPACION)) {

            }

            if (tipo1.equalsIgnoreCase(Constantes.INICIAR_CICLO)) {

            }

            if (tipo1.equalsIgnoreCase(Constantes.FINALIZAR_CICLO)) {

            }
            return tipoR;
        }
        return "";
    }

    private String getLectura() {
        if (this.lectura != null) {
            return "booleano lectura = " + this.buscarLlamadaPreguntas(this.lectura.toString()) + ";\n";
        }
        return "";
    }

    /*======================================= GENERACION DE FUNCIONES DE PREGUNTA ============================================================*/
 /*
      texto, entero, decimal, rango, condicional, fecha, hora, fechahora, selecciona_uno, selecciona_ultiples,  respuesta 
      
    nota, multimedia  respueta vacio
       
    multimedia mostrar
    
    calcular calculo
    
    
    
     */
    private String generarFunciones() {
        String valores = "";
        if (this.tipo.toString().equalsIgnoreCase((Constantes.NOTA))
                || this.tipo.toString().equalsIgnoreCase(Constantes.FICHERO)) {
            valores += this.getRespuestaVacio();
        } else {
            valores += this.getMetodoRespuesta();
        }
        if (this.tipo.toString().equalsIgnoreCase((Constantes.FICHERO))) {
            valores += this.getMetodoMostrar();
        }
        if (this.tipo.toString().equalsIgnoreCase(Constantes.CALCULAR)) {
            valores += this.getMetodoCalcular();
        }
        return valores;
    }

    private String getMetodoRespuesta() {
        String visibilidad = "publico";
        String cadena = visibilidad + " Respuesta ( " + this.tipo.toString() + " param_1){\n";
        if (this.restringir != null) {
            String condRequerido = this.getRestringir();
            cadena += "Si( " + condRequerido + "){\n"
                    + "     respuestas = param_1;"
                    + "\n}";
            if (this.restringirMsn != null) {
                cadena += "else {\n"
                        + "Mensaje( " + this.getRestringirMsn() + ");"
                        + "\n}"
                        + "\n}";
            } else {
                cadena += "\n}";
            }
        } else {
            cadena += "     respuestas = param_1;"
                    + "\n}";
        }
        return cadena;
    }

    private String getRespuestaVacio() {
        return "publico Respuesta(){\n}\n";
    }

    private String getMetodoMostrar() {
        if (this.multi != null) {
            String cod = multi.obtenerCodigoMostrar();
            cod = this.buscarLlamadaPreguntas(cod);
            if (!(cod.equalsIgnoreCase(""))) {
                return "publico Mostrar(){ \n" + cod + "}\n";
            }
        }
        return "";
    }

    private String getMetodoCalcular() {
        if (this.calculo != null) {
            String codOperacion = this.buscarLlamadaPreguntas(this.calculo.toString());
            String cod = "publico calcular(){\n"
                    + "respuestas = " + codOperacion + ";\n}\n";
            return cod;
        }
        return "";
    }

    private String getRestringir() {
        if (this.restringir != null) {
            String c = this.buscarLlamadaPreguntas(this.restringir.toString());
            return c;
        }
        return "";
    }

    private String getRestringirMsn() {
        if (this.restringirMsn != null) {
            String c = this.buscarLlamadaPreguntas("\"" + this.restringirMsn.toString() + "\"");
            return c;
        }
        return "";
    }


    /*======================================= GENERACION DE LLAMADA DE PREGUNTA ==============================================================*/
    @Override
    public String generarLlamadaSimple() {

        String cadena = "";
        cadena += this.getCodigoPre();
        cadena += this.getAplicable();
        cadena += this.getCodigoPost();

        return cadena;
    }

    
   
    
    
    private String getAplicable() {
        String cod = this.LlamadaPregunta();
        if (this.aplicable != null) {
            String c = this.buscarLlamadaPreguntas(this.aplicable.toString());
            String cod2 = "Si( " + c + "){\n" + cod + "\n}\n";
            return cod2;
        }

        return cod;
    }

    private String getCodigoPre() {
        if (this.codigo_pre != null) {
            String c = this.buscarLlamadaPreguntas(this.codigo_pre.toString());
            return c + "\n";
        }
        return "";

    }

    private String getCodigoPost() {
        if (this.codigo_post != null) {
            String c = this.buscarLlamadaPreguntas(this.codigo_post.toString());
            return c + "\n";
        }
        return "";

    }

    /*======================================= Extras ==========================================================================================*/
 /* Busca todas las coincidencias de #[id] dentro de una cadena y retonar una lista de todas las coincidenacias (id)*/
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

    /* Ingresa hola #[nombre] sale "hola"+ nombre() */
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

    private String obtenerParametrosApariencia(String tipoMostrar) {

        if (tipoMostrar.equalsIgnoreCase(Constantes.CADENA)) {

        } else if (tipoMostrar.equalsIgnoreCase(Constantes.RANGO)) {

        }
        switch (tipoMostrar.toUpperCase()) {
            case Constantes.CADENA: {
                String cFila = "nada";
                String cMax = "nada";
                String cMin = "nada";

                if (this.param.cad_fila.equalsIgnoreCase("")) {
                    cFila = "nada";
                } else {
                    cFila = this.param.cad_fila;
                }

                if (this.param.cad_max.equalsIgnoreCase("")) {
                    cMax = "nada";
                } else {
                    cMax = this.param.cad_max;
                }

                if (this.param.cad_min.equalsIgnoreCase("")) {
                    cMin = "nada";
                } else {
                    cMin = this.param.cad_min;
                }
                return (cMin + ", " + cMax + ", " + cFila);
            }

            case Constantes.RANGO: {
                String pIniciar = "0";
                String pFinalizar = this.param.finalizar;
                if (!(this.param.iniciar.equalsIgnoreCase(""))) {
                    pIniciar = this.param.iniciar;
                }
                return pIniciar + ", " + pFinalizar;
            }

            case Constantes.CONDICION: {
                String valor = "\"verdadero\", \"falso\"";
                if (this.param.opcion.equalsIgnoreCase("")) {
                    return valor;
                } else {
                    if (this.param.opcion.equalsIgnoreCase("Si_No")) {
                        return "\"Si\", \"No\"";
                    } else {
                        return valor;
                    }
                }
            }

            case Constantes.SELECCION_UNO: {
                if (this.nombreLista != null) {
                    if (!(this.nombreLista.toString().equalsIgnoreCase(""))) {
                        return this.nombreLista.toString();
                    }
                }
                break;
            }

            case Constantes.SELECCION_MULTIPLES: {
                if (this.nombreLista != null) {
                    if (!(this.nombreLista.toString().equalsIgnoreCase(""))) {
                        return this.nombreLista.toString();
                    }
                }
                break;
            }

            case Constantes.FICHERO: {
                if (this.nombreLista != null) {
                    if (!(this.nombreLista.toString().equalsIgnoreCase(""))) {
                        return this.nombreLista.toString();
                    }
                }
                break;
            }

        }

        return "";
    }

    private String LlamadaPregunta() {
        String llamada = "preg ";

        String tipoP = this.tipo.toString();

        if (tipoP.equalsIgnoreCase(Constantes.NOTA)) {
            llamada += this.idPregunta.toString() + "().Nota();";
            return llamada;
        } else if (tipoP.equalsIgnoreCase(Constantes.INICIAR_AGRUPACION)) {
            llamada += this.idPregunta.toString() + "().Nota();";
            return llamada;
        } else if (tipoP.equalsIgnoreCase(Constantes.INICIAR_CICLO)) {
            llamada += this.idPregunta.toString() + "().Nota();";
            return llamada;
        } else if (tipoP.equalsIgnoreCase(Constantes.FINALIZAR_AGRUPACION)) {
            llamada += this.idPregunta.toString() + "().Nota();";
            return llamada;
        } else if (tipoP.equalsIgnoreCase(Constantes.FINALIZAR_CICLO)) {
            llamada += this.idPregunta.toString() + "().Nota();";
            return llamada;
        } else {
            String param = "";
            if (tipoP.equalsIgnoreCase(Constantes.FICHERO)) {
                llamada += idPregunta.toString() + "().Respuesta().";
            } else {
                llamada += idPregunta.toString() + "().Respuesta(resp." + obtenerParametroTipo() + ").";
            }
            String apar = getAparienciaL();
            String tipoPr = obtenerParametroTipo().replace("es", "");
            String maneraVer = "";
            if (apar.equalsIgnoreCase("")) {
                maneraVer = tipoPr;
            } else {
                maneraVer = apar;
            }
            if (maneraVer.equalsIgnoreCase(Constantes.SELECCION_UNO)) {
                if (this.nombreLista != null) {
                    llamada += "Seleccionar_1(" + this.nombreLista.toString() + ");";
                    return llamada;
                } else {
                    llamada += "Seleccionar_1();";
                    return llamada;
                }

            } else if (maneraVer.equalsIgnoreCase(Constantes.SELECCION_MULTIPLES)) {
                if (this.nombreLista != null) {
                    llamada += "Seleccionar(" + this.nombreLista.toString() + ");";
                    return llamada;
                } else {
                    llamada += "Seleccionar();";
                    return llamada;
                }
            } else if (maneraVer.equalsIgnoreCase(Constantes.FICHERO)) {
                if (this.nombreLista != null) {
                    llamada += "Fichero(" + this.nombreLista.toString() + ");";
                    return llamada;
                } else {
                    llamada += "Fichero();";
                    return llamada;
                }
            } else {
                llamada += maneraVer;
            }
            llamada += "(" + this.obtenerParametrosApariencia(maneraVer) + ");";
            return llamada;
        }


        /*
        llamada = this.idPregunta.toString() + "().Respuesta(resp." + this.obtenerParametroTipo() + ").";
        String tipoTexto = this.tipo.toString().toUpperCase();

        switch (tipoTexto) {

            case Constantes.CADENA: {
                llamada += "Cadena";
                break;
            }

            case Constantes.ENTERO: {
                llamada += "Entero";
                break;
            }

            case Constantes.DECIMAL: {
                llamada += "Decimal";
                break;
            }

            case Constantes.RANGO: {
                llamada += "Rango";
                break;
            }

            case Constantes.CONDICION: {
                llamada += "Condicion";
                break;
            }

            case Constantes.FECHA: {
                llamada += "Fecha";
                break;
            }

            case Constantes.HORA: {
                llamada += "Hora";
                break;
            }

            case Constantes.FECHAHORA: {
                llamada += "FechaHora";
                break;
            }

            case Constantes.SELECCION_UNO: {
                if (this.nombreLista != null) {
                    llamada += "Seleccionar_1(" + this.nombreLista.toString() + ");";
                    return llamada;
                } else {
                    llamada += "Seleccionar_1();";
                    return llamada;
                }

                // break;
            }

            case Constantes.SELECCION_MULTIPLES: {
                if (this.nombreLista != null) {
                    llamada += "Seleccionar(" + this.nombreLista.toString() + ");";
                    return llamada;
                } else {
                    llamada += "Seleccionar();";
                    return llamada;
                }
                // break;
            }

            case Constantes.NOTA: {
                llamada = this.idPregunta.toString() + "().Nota();";
                return llamada;
            }

            case Constantes.FICHERO: {

                if (this.nombreLista != null) {
                    llamada += "Fichero(" + this.nombreLista.toString() + ");";
                    return llamada;
                } else {
                    llamada += "Fichero();";
                    return llamada;
                }
            }

            default: {
                llamada += "Cadena";
                break;
            }
        }
        llamada += "(" + this.obtenerParametrosApariencia(tipoTexto) + ");";*/
    }

    /*
    private String obtenerParametroTipo() {
        return "es" + this.tipo.toString();
    }*/
    private String obtenerParametroTipo() {
        String tipoR = "es";
        if (this.tipo != null) {
            String tipo1 = tipo.toString();

            if (tipo1.equalsIgnoreCase(Constantes.CALCULAR)) {

            }

            if (tipo1.equalsIgnoreCase(Constantes.CADENA)) {
                tipoR += Constantes.CADENA;
                return tipoR;
            }

            if (tipo1.equalsIgnoreCase(Constantes.ENTERO)) {
                tipoR += Constantes.ENTERO;
                return tipoR;
            }

            if (tipo1.equalsIgnoreCase(Constantes.DECIMAL)) {
                tipoR += Constantes.DECIMAL;
                return tipoR;
            }

            if (tipo1.equalsIgnoreCase(Constantes.RANGO)) {
                tipoR += Constantes.ENTERO;
                return tipoR;
            }

            if (tipo1.equalsIgnoreCase(Constantes.CONDICION)) {
                tipoR += Constantes.BOOLEANO;
                return tipoR;
            }

            if (tipo1.equalsIgnoreCase(Constantes.FECHA)) {
                tipoR += Constantes.FECHA;
                return tipoR;
            }

            if (tipo1.equalsIgnoreCase(Constantes.HORA)) {
                tipoR += Constantes.HORA;
                return tipoR;
            }

            if (tipo1.equalsIgnoreCase(Constantes.FECHAHORA)) {
                tipoR += Constantes.FECHAHORA;
                return tipoR;
            }

            if (tipo1.equalsIgnoreCase(Constantes.SELECCION_UNO)) {

            }

            if (tipo1.equalsIgnoreCase(Constantes.SELECCION_MULTIPLES)) {

            }

            if (tipo1.equalsIgnoreCase(Constantes.NOTA)) {

            }

            if (tipo1.equalsIgnoreCase(Constantes.FICHERO)) {

            }

            if (tipo1.equalsIgnoreCase(Constantes.INICIAR_AGRUPACION)) {

            }

            if (tipo1.equalsIgnoreCase(Constantes.FINALIZAR_AGRUPACION)) {

            }

            if (tipo1.equalsIgnoreCase(Constantes.INICIAR_CICLO)) {

            }

            if (tipo1.equalsIgnoreCase(Constantes.FINALIZAR_CICLO)) {

            }
        }

        return "";
    }

}
