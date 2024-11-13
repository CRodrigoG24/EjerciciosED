public class ArbolBinarioOrdenado {

        //CREAMOS CLASE NODO CON SUS ATRIBUTOS Y CONSTRUCTOR
        class Nodo {
            int dato;
            Nodo izquierda, derecha;

            public Nodo(int dato){
                this.dato = dato;
                this.izquierda = null;
                this.derecha = null;
            }
        }

        //DEFINIMOS LA RAIZ
        Nodo raiz;

        //CONSTRUCTOR
        public ArbolBinarioOrdenado(){
            //INICIALIZA RAIZ
            raiz = null; //Arbol inicia vacio
        }

        //---------------------------------------------------------------------------------------------
        //METODO PARA INSERTAR VALOR
        public void insertar(int dato){
            raiz = insertarRec(raiz, dato);
        }

        //METODO RECURSIVO PARA INSERTAR VALOR EN EL ARBOL - VA A RETORNAR UN NODO
        public Nodo insertarRec(Nodo raiz, int dato){
            //Si el arbol esta vacio, se crea un nuevo nodo y se devuelve
            if (raiz == null){
                raiz = new Nodo(dato);
                return raiz;
            }

            //Si el valor insertado es menor que el nodo actual, va al subarbol izquierdo
            if (dato < raiz.dato){
                raiz.izquierda = insertarRec(raiz.izquierda, dato);
            }

            //Si  el valor insertado es mayor que el nodo actual, va al subarbol derecho
            else if (dato > raiz.dato){
                raiz.derecha = insertarRec(raiz.derecha, dato);
            }

            //Devuelve la raiz sin cambios
            return raiz;
        }

        //---------------------------------------------------------------------------------------------
        //METODO PARA RECORRER EN PREORDEN 
        //útil si deseas procesar primero el nodo actual antes de examinar sus hijos
        public void preorden(Nodo nodo){
            if (nodo != null){
                System.out.println(nodo.dato + " - "); //Visita la raiz ****
                preorden(nodo.izquierda); //Recorre el subarbol izquierdo
                preorden(nodo.derecha); //Recorre el subarbol derecho
            }
        }

        //METODO PARA RECORRER EN ENTREORDEN
        public void entreorden(Nodo nodo){
            if (nodo != null){
                entreorden(nodo.izquierda); //Recorre el subarbol izquierdo
                System.out.print(nodo.dato + " - "); //Visita la raiz ****
                entreorden(nodo.derecha); //Recorre el subarbol derecho
            }
        }

        //METODO PARA RECORRER EN POSTORDEN
        public void postorden(Nodo nodo){
            postorden(nodo.izquierda); //Recorre el subarbol izquierdo
            postorden(nodo.derecha); //Recorre el subarbol derecho
            System.out.println(nodo.dato + " - "); //Visita la raiz ****
        }

        public static void main(String[]args){
            ArbolBinarioOrdenado arbol = new ArbolBinarioOrdenado();
    
            arbol.insertar(50);
            arbol.insertar(30);
            arbol.insertar(20);
            arbol.insertar(40);
            arbol.insertar(70);
            arbol.insertar(60);
            arbol.insertar(80);
    
            System.out.println("Recorrido entreorden: ");
            arbol.entreorden(arbol.raiz); //Imprime los nodos en orden ascendente
        }
   }

