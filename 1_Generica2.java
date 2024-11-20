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

    // Método para intercambiar la información de dos nodos en posiciones
    // específicas
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

    public static void mostrarMenu() {
        System.out.println("Seleccione una opción:");
        System.out.println("1. Insertar en una posición específica");
        System.out.println("2. Extraer un nodo de una posición específica");
        System.out.println("3. Borrar un nodo en una posición específica");
        System.out.println("4. Intercambiar dos nodos");
        System.out.println("5. Encontrar el mayor valor");
        System.out.println("6. Encontrar la posición del mayor valor");
        System.out.println("7. Contar la cantidad de nodos");
        System.out.println("8. Verificar si la lista está ordenada de menor a mayor");
        System.out.println("9. Verificar si un valor existe en la lista");
        System.out.println("10. Imprimir la lista");
        System.out.println("11. Salir");
    }

    // Metodo principal con el menu
    public static void main(String[] args) {
        ListaGenerica lista = new ListaGenerica();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            mostrarMenu();
            System.out.print("Opcion: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la posición: ");
                    int pos = scanner.nextInt();
                    System.out.print("Ingrese el valor: ");
                    int valor = scanner.nextInt();
                    lista.insertar(pos, valor);
                    System.out.println("Valor insertado en la posición " + pos);
                    break;

                case 2:
                    System.out.print("Ingrese la posición a extraer: ");
                    pos = scanner.nextInt();
                    int extraido = lista.extraer(pos);
                    if (extraido != Integer.MAX_VALUE) {
                        System.out.println("Valor extraído: " + extraido);
                    } else {
                        System.out.println("Posición inválida.");
                    }
                    break;

                case 3:
                    System.out.print("Ingrese la posición a borrar: ");
                    pos = scanner.nextInt();
                    lista.borrar(pos);
                    System.out.println("Nodo en la posición " + pos + " borrado.");
                    break;

                case 4:
                    System.out.print("Ingrese la primera posición: ");
                    int pos1 = scanner.nextInt();
                    System.out.print("Ingrese la segunda posición: ");
                    int pos2 = scanner.nextInt();
                    lista.intercambiar(pos1, pos2);
                    System.out.println("Nodos en las posiciones " + pos1 + " y " + pos2 + " intercambiados.");
                    break;

                case 5:
                    int mayor = lista.mayor();
                    if (mayor != Integer.MAX_VALUE) {
                        System.out.println("El mayor valor es: " + mayor);
                    } else {
                        System.out.println("La lista está vacía.");
                    }
                    break;

                case 6:
                    int posMayor = lista.posMayor();
                    if (posMayor != Integer.MAX_VALUE) {
                        System.out.println("La posición del mayor valor es: " + posMayor);
                    } else {
                        System.out.println("La lista está vacía.");
                    }
                    break;

                case 7:
                    int cantidad = lista.cantidad();
                    System.out.println("La cantidad de nodos en la lista es: " + cantidad);
                    break;

                case 8:
                    if (lista.ordenada()) {
                        System.out.println("La lista está ordenada de menor a mayor.");
                    } else {
                        System.out.println("La lista no está ordenada.");
                    }
                    break;

                case 9:
                    System.out.print("Ingrese el valor a buscar: ");
                    valor = scanner.nextInt();
                    if (lista.existe(valor)) {
                        System.out.println("El valor " + valor + " existe en la lista.");
                    } else {
                        System.out.println("El valor " + valor + " no existe en la lista.");
                    }
                    break;

                case 10:
                    System.out.println("Lista actual:");
                    lista.imprimir();
                    break;

                case 11:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opcion no valida. Intente nuevamente.");
            }

            System.out.println(); // Salto de linea para separar las iteraciones del menu
        } while (opcion != 11);

        scanner.close();
    }
}
