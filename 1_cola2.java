public class cola2 {

    class Nodo {
        int info;
        Nodo sig;
    }

    private Nodo raiz, fondo;

    // Constructor
    cola2() {
        raiz = null;
        fondo = null;
    }

    // Verifica si la cola está vacía
    public boolean vacia() {
        return raiz == null;
    }

    // Inserta un elemento en la cola
    public void insertar(int info) {
        Nodo nuevo = new Nodo();
        nuevo.info = info;
        nuevo.sig = null;

        if (vacia()) {
            raiz = nuevo;
            fondo = nuevo;
        } else {
            fondo.sig = nuevo;
            fondo = nuevo;
        }
    }

    // Extrae (elimina) el primer elemento de la cola
    public int extraer() {
        if (!vacia()) {
            int informacion = raiz.info;
            if (raiz == fondo) {
                raiz = null;
                fondo = null;
            } else {
                raiz = raiz.sig;
            }
            return informacion;
        } else {
            return Integer.MAX_VALUE;
        }
    }

    // Imprime todos los elementos de la cola
    public void imprimir() {
        Nodo reco = raiz;
        System.out.println("Listado de todos los elementos de la cola:");
        while (reco != null) {
            System.out.print(reco.info + " - ");
            reco = reco.sig;
        }
        System.out.println();
    }

    // Invierte el orden de los elementos de la cola
    public void invertir() {
        if (raiz == null || raiz.sig == null) return;

        Nodo previo = null;
        Nodo siguiente = null;
        Nodo actual = raiz;
        fondo = raiz;

        while (actual != null) {
            siguiente = actual.sig;
            actual.sig = previo;
            previo = actual;
            actual = siguiente;
        }
        raiz = previo;
    }

    // Método principal para pruebas
    public static void main(String[] ar) {
        cola2 cola1 = new cola2();
        cola1.insertar(5);
        cola1.insertar(10);
        cola1.insertar(50);
        cola1.insertar(6);
        cola1.insertar(15);
        cola1.insertar(100);

        cola1.imprimir();
        cola1.invertir();
        cola1.imprimir();
    }
}
