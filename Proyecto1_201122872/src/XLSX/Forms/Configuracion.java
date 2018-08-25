/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XLSX.Forms;

import XLSX.AnalizerXML.SimpleNode;
import proyecto1_201122872.Constantes;

/**
 *
 * @author Ramonella
 */
public class Configuracion {

    public Object titulo_formulario;
    public Object idForm;
    public Object estilo;
    public Object importar;
    public Object codigo_principal;
    public Object codigo_global;

    public Configuracion() {
        this.titulo_formulario = null;
        this.idForm = null;
        this.estilo = null;
        this.importar = null;
        this.codigo_principal = null;
        this.codigo_global = null;
    }

    public boolean esConfVacia() {
        return (this.titulo_formulario == null
                && this.idForm == null
                && this.estilo == null
                && this.importar == null
                && this.codigo_principal == null
                && this.codigo_global == null);
    }

    public void imprimir() {
        if (this.titulo_formulario != null) {
            System.out.println(" Propiedad   titulo_formulario    es  " +this.titulo_formulario);
        }
        if (this.idForm != null) {
            System.out.println(" Propiedad   idform    es  " +this.idForm);
        }
        if (this.estilo != null) {
            System.out.println(" Propiedad   estilo    es  " +this.estilo);
        }
        if (this.importar != null) {
            System.out.println(" Propiedad  importar     es  " + this.importar);
        }
        if (this.codigo_principal != null) {
            System.out.println(" Propiedad   codigo_principal    es  " + this.codigo_principal);
        }
        if (this.codigo_global != null) {
            System.out.println(" Propiedad  codigo_global     es  " +this.codigo_global);
        }
    }

    public void agregarPropiedad(SimpleNode nodo) {
        String nombrePropiedad = nodo.toString().toUpperCase();//.replace("<", "").replace(">", "").toUpperCase();
        int noElementos = nodo.jjtGetNumChildren();

        if (noElementos > 0) {
            Object elemento = nodo.jjtGetChild(0).toString(); //this.obtenerElemento((SimpleNode)nodoPropiedad.jjtGetChild(1));
            // System.out.println(elemento);
            switch (nombrePropiedad) {
                case Constantes.TITULO_FORMULARIO: {
                    if (!(elemento.toString().equalsIgnoreCase(""))) {
                        this.titulo_formulario = elemento;
                    }

                    break;
                }

                case Constantes.IDFORM: {
                    if (!(elemento.toString().equalsIgnoreCase(""))) {
                        this.idForm = elemento;
                    }
                    break;
                }

                case Constantes.ESTILO: {
                    if (!(elemento.toString().equalsIgnoreCase(""))) {
                        this.estilo = elemento;
                    }
                    break;
                }

                case Constantes.IMPORTAR: {
                    if (!(elemento.toString().equalsIgnoreCase(""))) {
                        this.importar = elemento;
                    }
                    break;
                }

                case Constantes.CODIGO_PRINCIPAL: {
                    if (!(elemento.toString().equalsIgnoreCase(""))) {
                        this.codigo_principal = elemento;
                    }
                    break;
                }

                case Constantes.CODIGO_GLOBAL: {
                    if (!(elemento.toString().equalsIgnoreCase(""))) {
                        this.codigo_global = elemento;
                    }
                    break;
                }
            }
        }
    }

}
