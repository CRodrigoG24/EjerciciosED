public class ListaGenerica {

    // Clase interna Nodo que representa un nodo de la lista
    class Nodo {
        int info;
        Nodo sig;
    }

    // Raíz de la lista
    private Nodo raiz;

    // Constructor que inicializa la lista vacía
    public ListaGenerica() {
        raiz = null;
    }

    // Método para insertar un nodo en una posición específica
    void insertar(int pos, int x) {
        if (pos <= cantidad() + 1) {
            Nodo nuevo = new Nodo();
            nuevo.info = x;
            if (pos == 1) {
                nuevo.sig = raiz;
                raiz = nuevo;
            } else if (pos == cantidad() + 1) {
                Nodo reco = raiz;
                while (reco.sig != null) {
                    reco = reco.sig;
                }
                reco.sig = nuevo;
                nuevo.sig = null;
            } else {
                Nodo reco = raiz;
                for (int f = 1; f <= pos - 2; f++)
                    reco = reco.sig;
                Nodo siguiente = reco.sig;
                reco.sig = nuevo;
                nuevo.sig = siguiente;
            }
        }
    }

    // Método para extraer (y eliminar) un nodo de una posición específica
    public int extraer(int pos) {
        if (pos <= cantidad()) {
            int informacion;
            if (pos == 1) {
                informacion = raiz.info;
                raiz = raiz.sig;
            } else {
                Nodo reco = raiz;
                for (int f = 1; f <= pos - 2; f++)
                    reco = reco.sig;
                Nodo prox = reco.sig;
                reco.sig = prox.sig;
                informacion = prox.info;
            }
            return informacion;
        } else {
            return Integer.MAX_VALUE;
        }
    }

    // Método para borrar un nodo en una posición específica
    public void borrar(int pos) {
        if (pos <= cantidad()) {
            if (pos == 1) {
                raiz = raiz.sig;
            } else {
                Nodo reco = raiz;
                for (int f = 1; f <= pos - 2; f++)
                    reco = reco.sig;
                Nodo prox = reco.sig;
                reco.sig = prox.sig;
            }
        }
    }

    // Método para intercambiar la información de dos nodos en posiciones específicas
    public void intercambiar(int pos1, int pos2) {
        if (pos1 <= cantidad() && pos2 <= cantidad()) {
            Nodo reco1 = raiz;
            for (int f = 1; f < pos1; f++)
                reco1 = reco1.sig;

            Nodo reco2 = raiz;
            for (int f = 1; f < pos2; f++)
                reco2 = reco2.sig;

            int aux = reco1.info;
            reco1.info = reco2.info;
            reco2.info = aux;
        }
    }

    // Método para encontrar el valor mayor en la lista
    public int mayor() {
        if (!vacia()) {
            int may = raiz.info;
            Nodo reco = raiz.sig;
            while (reco != null) {
                if (reco.info > may)
                    may = reco.info;
                reco = reco.sig;
            }
            return may;
        } else {
            return Integer.MAX_VALUE;
        }
    }

    // Método para encontrar la posición del valor mayor en la lista
    public int posMayor() {
        if (!vacia()) {
            int may = raiz.info;
            int x = 1;
            int pos = x;
            Nodo reco = raiz.sig;
            x = 2;
            while (reco != null) {
                if (reco.info > may) {
                    may = reco.info;
                    pos = x;
                }
                reco = reco.sig;
                x++;
            }
            return pos;
        } else {
            return Integer.MAX_VALUE;
        }
    }

    // Método para contar la cantidad de nodos en la lista
    public int cantidad() {
        int cant = 0;
        Nodo reco = raiz;
        while (reco != null) {
            reco = reco.sig;
            cant++;
        }
        return cant;
    }

    // Método para verificar si la lista está ordenada de menor a mayor
    public boolean ordenada() {
        if (cantidad() > 1) {
            Nodo reco1 = raiz;
            Nodo reco2 = raiz.sig;
            while (reco2 != null) {
                if (reco2.info < reco1.info) {
                    return false;
                }
                reco2 = reco2.sig;
                reco1 = reco1.sig;
            }
        }
        return true;
    }

    // Método para verificar si un valor específico existe en la lista
    public boolean existe(int x) {
        Nodo reco = raiz;
        while (reco != null) {
            if (reco.info == x)
                return true;
            reco = reco.sig;
        }
        return false;
    }

    // Método para verificar si la lista está vacía
    public boolean vacia() {
        return raiz == null;
    }

    // Método para imprimir todos los valores de la lista
    public void imprimir() {
        Nodo reco = raiz;
        while (reco != null) {
            System.out.print(reco.info + "-");
            reco = reco.sig;
        }
        System.out.println();
    }

    // Método principal para pruebas
    public static void main(String[] ar) {
        ListaGenerica lg = new ListaGenerica();
        lg.insertar(1, 10);
        lg.insertar(2, 20);
        lg.insertar(3, 30);
        lg.insertar(2, 15);
        lg.insertar(1, 115);
        lg.imprimir();
        System.out.println("Luego de Borrar el primero");
        lg.borrar(1);
        lg.imprimir();
        System.out.println("Luego de Extraer el segundo");
        lg.extraer(2);
        lg.imprimir();
        System.out.println("Luego de Intercambiar el primero con el tercero");
        lg.intercambiar(1, 3);
        lg.imprimir();
        if (lg.existe(10)) 
            System.out.println("Se encuentra el 10 en la lista");
        else
            System.out.println("No se encuentra el 10 en la lista");
        System.out.println("La posición del mayor es: " + lg.posMayor());
        if (lg.ordenada())
            System.out.println("La lista está ordenada de menor a mayor");
        else
            System.out.println("La lista no está ordenada de menor a mayor");
    }
}
