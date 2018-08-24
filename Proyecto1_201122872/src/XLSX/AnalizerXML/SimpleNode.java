/* Generated By:JJTree: Do not edit this line. SimpleNode.java Version 4.3 */
 /* JavaCCOptions:MULTI=false,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package XLSX.AnalizerXML;

import XLSX.Forms.Agrupacion;
import XLSX.Forms.Question;
import XLSX.Forms.QuestionProperties.ListaOpciones;
import XLSX.Forms.QuestionProperties.ListaPreguntas;
import XLSX.Forms.basePregunta;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import proyecto1_201122872.Constantes;

public class SimpleNode implements Node {

    protected Node parent;
    protected Node[] children;
    protected int id;
    protected Object value;
    protected grammarXLSX parser;
    protected String name;
    protected int lin = 0;
    protected int col = 0;
    private ListaPreguntas preguntas = new ListaPreguntas();
    private ListaOpciones opciones = new ListaOpciones();
    public static Stack<basePregunta> pila;

    public SimpleNode(int i) {
        id = i;
    }

    public SimpleNode(grammarXLSX p, int i) {
        this(i);
        parser = p;
    }

    public void jjtOpen() {
    }

    public void jjtClose() {
    }

    public void jjtSetParent(Node n) {
        parent = n;
    }

    public Node jjtGetParent() {
        return parent;
    }

    public void jjtAddChild(Node n, int i) {
        if (children == null) {
            children = new Node[i + 1];
        } else if (i >= children.length) {
            Node c[] = new Node[i + 1];
            System.arraycopy(children, 0, c, 0, children.length);
            children = c;
        }
        children[i] = n;
    }

    public Node jjtGetChild(int i) {
        return children[i];
    }

    public int jjtGetNumChildren() {
        return (children == null) ? 0 : children.length;
    }

    public void jjtSetValue(Object value) {
        this.value = value;
    }

    public Object jjtGetValue() {
        return value;
    }

    /* You can override these two methods in subclasses of SimpleNode to
     customize the way the node appears when the tree is dumped.  If
     your output uses more than one line you should override
     toString(String), otherwise overriding toString() is probably all
     you need to do. */
    // public String toString() { return grammarXLSXTreeConstants.jjtNodeName[id]; }
    public String toString(String prefix) {
        return prefix + toString();
    }

    /* Override this method if you want to customize how the node dumps
     out its children. */
    private boolean esInicioAgrupacion(SimpleNode nodo) {
        for (int i = 0; i < nodo.children.length; i++) {
            String g = nodo.jjtGetChild(i).jjtGetChild(0).toString();
            String v = "";
            if (nodo.jjtGetChild(i).jjtGetChild(0).jjtGetNumChildren() > 0) {
                v = nodo.jjtGetChild(i).jjtGetChild(0).jjtGetChild(0).toString();
            }
            if (g.equalsIgnoreCase(Constantes.TIPO)
                    && v.equalsIgnoreCase(Constantes.INICIAR_AGRUPACION)) {
                return true;
            }
        }
        return false;
    }

    private boolean esFinAgrupacion(SimpleNode nodo) {
        for (int i = 0; i < nodo.children.length; i++) {
            String g = nodo.jjtGetChild(i).jjtGetChild(0).toString();
            String v = "";
            if (nodo.jjtGetChild(i).jjtGetChild(0).jjtGetNumChildren() > 0) {
                v = nodo.jjtGetChild(i).jjtGetChild(0).jjtGetChild(0).toString();
            }
            if (g.equalsIgnoreCase(Constantes.TIPO)
                    && v.equalsIgnoreCase(Constantes.FINALIZAR_AGRUPACION)) {
                return true;
            }
        }
        return false;
    }

    /*
    private Question createQuestion(SimpleNode nodeQuestion) {
        Question preguntaNueva;
        Agrupacion grupoNuevo;
        
        if(esInicioAgrupacion(nodeQuestion)){
            
            
        }
        
        for (int i = 0; i < nodeQuestion.children.length; i++) {
            
            if(nodeQuestion.jjtGetChild(i).toString().equalsIgnoreCase(Constantes.TIPO) &&
                    nodeQuestion.jjtGetChild(i).jjtGetChild(0).toString().equalsIgnoreCase(Constantes.FINALIZAR_AGRUPACION)){
                bandera=false;
            }
            
            if(nodeQuestion.jjtGetChild(i).toString().equalsIgnoreCase(Constantes.TIPO) &&
                    nodeQuestion.jjtGetChild(i).jjtGetChild(0).toString().equalsIgnoreCase(Constantes.INICIAR_AGRUPACION)){
                
            }
            
            //nueva.insertarPropiedad((SimpleNode) nodeQuestion.jjtGetChild(i));
        }
       if (nueva.tienePropiedades()) {
            return nueva;
        }
        return null;
    }
     */
    private void createConfiguration(SimpleNode nodeConf) {

    }

    private void createOption(SimpleNode nodeOption) {

    }

    private basePregunta crearTipoNodo(SimpleNode nodo) {

        // basePregunta nueva;
        if (this.esInicioAgrupacion(nodo)) {
            Agrupacion g = new Agrupacion();
            return g;
        } else if (this.esFinAgrupacion(nodo)) {
            return new basePregunta();
        } else {
            Question nueva = new Question();
            for (int i = 0; i < nodo.jjtGetNumChildren(); i++) {
                nueva.insertarPropiedad((SimpleNode) nodo.jjtGetChild(i));
            }
            return nueva;
        }

    }

    public void ejecutar(String valor, Stack<basePregunta>  p) {
        this.preguntas = new ListaPreguntas();
        this.pila = p;
        pila.push(preguntas);
        this.dump(valor);
        preguntas.mostrarDatos();
        System.out.println("GGGGGGGGGGGGGGGGGGGGGGGGGGGGGG " + preguntas.lPreguntas.size());

    }

    public void dump(String prefix) {
        System.out.println(toString(prefix));
        if (children != null) {
            for (int i = 0; i < children.length; ++i) {
                SimpleNode n = (SimpleNode) children[i];
                if (n != null) {
                    if (n.toString().equals("PREGUNTA")) {
                        basePregunta p = crearTipoNodo((SimpleNode) n.jjtGetChild(1));
                        if (p != null) {
                            // System.out.println("Pregunta tiene:   " + preguntaNueva.noPropiedades());
                            if (this.esInicioAgrupacion((SimpleNode) n.jjtGetChild(1))) {
                                pila.push(p);
                                //ystem.out.println("se ha insertado una agrupacion");
                            } else if (this.esFinAgrupacion((SimpleNode) n.jjtGetChild(1))) {
                                basePregunta lista = pila.pop();
                                basePregunta listaAnt = pila.get((pila.size()) - 1);
                                if (listaAnt instanceof ListaPreguntas) {
                                    ListaPreguntas l = (ListaPreguntas) listaAnt;
                                    l.lPreguntas.add(lista);

                                }
                                if (listaAnt instanceof Agrupacion) {
                                    Agrupacion l = (Agrupacion) listaAnt;
                                    l.preguntas.add(lista);
                                }

                                //System.out.println("se ha eliminado la agruapaion");
                            } else {
                                basePregunta lista = pila.get((pila.size()) - 1);
                                if (lista instanceof Agrupacion) {
                                    Agrupacion temp = (Agrupacion) lista;
                                    temp.preguntas.add(p);
                                    //  System.out.println("se ha insertado una pregunta en la agrupacion");
                                }
                                if (lista instanceof ListaPreguntas) {
                                    ListaPreguntas temp = (ListaPreguntas) lista;
                                    temp.lPreguntas.add(p);
                                    // System.out.println("se ha insertado una pregunta");
                                }
                            }
                        } else {
                            // System.out.println("Pregunta no tiene propiedades ");
                        }

                    }

                    if (n.toString().equalsIgnoreCase("OPCION")) {
                    }

                    if (n.toString().equalsIgnoreCase("CONFIGURACION")) {
                    }

                    n.dump(prefix + " ");

                }
            }
        }
    }

    public void setName(String s) {
        this.name = s;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        if (name != null) {
            return name;
        } else {
            return grammarXLSXTreeConstants.jjtNodeName[id];
        }
    }

    public void setPos(int linea, int columna) {
        this.lin = linea;
        this.col = columna;
    }

    @Override
    public int getId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

/* JavaCC - OriginalChecksum=614bd1fd146bf1360071e8eb7bbcb58e (do not edit this line) */
