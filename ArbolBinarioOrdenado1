public class ArbolBinarioOrdenado2 {
    class Nodo {
        int info;
        Nodo izq, der;
    }
    Nodo raiz;
    int cant;
    int altura;

    //-----------------------------------------------------------------------------------------------------

    public ArbolBinarioOrdenado2() {
        raiz = null;
    }

    // Método para insertar un nodo en el árbol, verificando que no exista previamente
    public void insertar(int info) {
        if (!existe(info)) {
            Nodo nuevo = new Nodo();
            nuevo.info = info;
            nuevo.izq = null;
            nuevo.der = null;
            if (raiz == null)
                raiz = nuevo;
            else {
                Nodo anterior = null, reco;
                reco = raiz;
                while (reco != null) {
                    anterior = reco;
                    if (info < reco.info)
                        reco = reco.izq;
                    else
                        reco = reco.der;
                }
                if (info < anterior.info)
                    anterior.izq = nuevo;
                else
                    anterior.der = nuevo;
            }
        }
    }


    // Método para verificar si el nodo existe
    public boolean existe(int info) {
        Nodo reco = raiz;
        while (reco != null) {
            if (info == reco.info)
                return true;
            else if (info > reco.info)
                reco = reco.der;
            else
                reco = reco.izq;
        }
        return false;
    }

    //-----------------------------------------------------------------------------------------------------

    // Método para retornar la cantidad de nodos
    private void cantidad(Nodo reco) {
        if (reco != null) {
            cant++; // Incrementa el contador por cada nodo visitado
            cantidad(reco.izq); // Recorre el subárbol izquierdo
            cantidad(reco.der); // Recorre el subárbol derecho
        }
    }
    
    public int cantidad() {
        cant = 0; // Inicializa el contador
        cantidad(raiz); // Llama al método recursivo
        return cant; // Devuelve la cantidad total de nodos
    }
    
    //-----------------------------------------------------------------------------------------------------

    // 2. Método para retornar la cantidad de nodos hoja (nodos sin hijos)
    private void cantidadNodosHoja(Nodo reco) {
        if (reco != null) {
            if (reco.izq == null && reco.der == null)
                cant++; // Cuenta el nodo si es hoja
            cantidadNodosHoja(reco.izq); // Recorre subárbol izquierdo
            cantidadNodosHoja(reco.der); // Recorre subárbol derecho
        }
    }

    public int cantidadNodosHoja() {
        cant = 0; // Inicializa el contador
        cantidadNodosHoja(raiz); // Llama al método recursivo
        return cant; // Devuelve el total de nodos hoja
    }

    //-----------------------------------------------------------------------------------------------------

    // Método para imprimir en entre orden
    private void imprimirEntre(Nodo reco) {
        if (reco != null) {
            imprimirEntre(reco.izq);
            System.out.print(reco.info + " ");
            imprimirEntre(reco.der);
        }
    }

    public void imprimirEntre() {
        imprimirEntre(raiz);
        System.out.println();
    }

    //-----------------------------------------------------------------------------------------------------

    // Método para imprimir en entre orden junto al nivel
    private void imprimirEntreConNivel(Nodo reco, int nivel) {
        if (reco != null) {
            imprimirEntreConNivel(reco.izq, nivel + 1); // Recorre subárbol izquierdo, aumentando el nivel
            System.out.print(reco.info + " (" + nivel + ") - "); // Imprime el nodo con su nivel
            imprimirEntreConNivel(reco.der, nivel + 1); // Recorre subárbol derecho
        }
    }

    public void imprimirEntreConNivel() {
        imprimirEntreConNivel(raiz, 1); // Llama al método con nivel inicial 1
        System.out.println();
    }


    //-----------------------------------------------------------------------------------------------------

     // 5. Método para retornar la altura del árbol
     private void retornarAltura(Nodo reco, int nivel) {
        if (reco != null) {
            retornarAltura(reco.izq, nivel + 1); // Recorre subárbol izquierdo, aumentando el nivel
            if (nivel > altura) // Actualiza la altura si el nivel actual es mayor
                altura = nivel;
            retornarAltura(reco.der, nivel + 1); // Recorre subárbol derecho
        }
    }

    public int retornarAltura() {
        altura = 0; // Inicializa la altura en 0
        retornarAltura(raiz, 1); // Llama al método recursivo
        return altura; // Devuelve la altura del árbol
    }

    //-----------------------------------------------------------------------------------------------------

     // 6. Método para imprimir el mayor valor del árbol
     public void mayorValor() {
        if (raiz != null) {
            Nodo reco = raiz;
            while (reco.der != null) // Desciende por el subárbol derecho
                reco = reco.der;
            System.out.println("Mayor valor del árbol: " + reco.info); // Imprime el mayor valor
        }
    }

    //-----------------------------------------------------------------------------------------------------

    // 7. Método para borrar el nodo con el menor valor del árbol
    public void borrarMenor() {
        if (raiz != null) {
            if (raiz.izq == null) // Si el subárbol izquierdo está vacío, la raíz es el menor
                raiz = raiz.der; // La raíz apunta al subárbol derecho
            else {
                Nodo atras = raiz;
                Nodo reco = raiz.izq;
                while (reco.izq != null) { // Desciende por la izquierda
                    atras = reco;
                    reco = reco.izq;
                }
                atras.izq = reco.der; // Elimina el menor enlazando al siguiente nodo
            }
        }
    }

    /*
     * public void borrarMayor() {
    if (raiz != null) {
        if (raiz.der == null) { // Si el subárbol derecho está vacío, la raíz es el mayor
            raiz = raiz.izq; // La raíz apunta al subárbol izquierdo
        } else {
            Nodo atras = raiz;
            Nodo reco = raiz.der;
            while (reco.der != null) { // Desciende por la derecha
                atras = reco;
                reco = reco.der;
            }
            atras.der = reco.izq; // Elimina el mayor enlazando al siguiente nodo
        }
    }
}
     */
    
    //-----------------------------------------------------------------------------------------------------

    // Método principal para probar la clase
    public static void main(String[] args) {
        ArbolBinarioOrdenado2 abo = new ArbolBinarioOrdenado2();
        abo.insertar(100);
        abo.insertar(50);
        abo.insertar(25);
        abo.insertar(75);
        abo.insertar(150);

        System.out.println("Impresión en entreorden:");
        abo.imprimirEntre();

        System.out.println("Cantidad de nodos del árbol: " + abo.cantidad());
        System.out.println("Cantidad de nodos hoja: " + abo.cantidadNodosHoja());

        System.out.println("Impresión en entre orden junto al nivel del nodo:");
        abo.imprimirEntreConNivel();

        System.out.println("Altura del árbol: " + abo.retornarAltura());

        abo.mayorValor();

        abo.borrarMenor();
        System.out.println("Luego de borrar el menor:");
        abo.imprimirEntre();
    }
}
