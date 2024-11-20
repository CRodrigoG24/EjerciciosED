import java.util.Scanner;

public class Cola {

    class Nodo{
        int info;
        Nodo sig;
    }

    private Nodo raiz, fondo;

    public Cola(){
        raiz = null;
        fondo = null;
    }

    public boolean esVacia(){
        return raiz == null;
    }

    public void insertar(int info){
        Nodo nuevo = new Nodo();
        nuevo.info = info;
        nuevo.sig = null;

        if (esVacia()){
            raiz = nuevo;
            fondo = nuevo;
        } else{
            fondo.sig = nuevo;
            fondo = nuevo;
        }
    }

    public int extraer(){
        if (!esVacia()){
            int informacion = raiz.info;
            if (raiz == fondo){
                raiz = null;
                fondo = null;
            } else {
                raiz = raiz.sig;
            }
            return informacion;
        } else{
            return Integer.MAX_VALUE;
        }
    }


    public int cantidad() {
        int count = 0;
        Nodo actual = raiz;
        while (actual != null) {
            count++;
            actual = actual.sig;
        }
        return count;
    }


    public int verPrimero() {
        if (!esVacia()) {
            return raiz.info;
        } else {
            return Integer.MAX_VALUE; // Indica que la cola está vacía
        }
    }

    public int retornar(){
       if (!esVacia()){
        return raiz.info;
       } else {
        return Integer.MAX_VALUE;
       }
    }


    public void vaciar() {
        raiz = null;
        fondo = null;
    }

    public void invertir() {
        if (raiz != null && raiz.sig != null) {
            Nodo previo = null;
            Nodo actual = raiz;
            Nodo siguiente;
            fondo = raiz;

            while (actual != null) {
                siguiente = actual.sig;
                actual.sig = previo;
                previo = actual;
                actual = siguiente;
            }
            raiz = previo;
        }
    }


    public void imprimir(){
        Nodo reco = raiz; //AVANZA DESDE LA CIMA
        System.out.println("Elementos de la pila: ");

        while (reco != null){
            System.out.print(reco.info + " - ");
            reco = reco.sig;
        }
        System.out.println();
    }

   
 public static void main(String[] ar) {
        Cola cola = new Cola();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nMenú de opciones:");
            System.out.println("1. Insertar en la cola");
            System.out.println("2. Extraer de la cola");
            System.out.println("3. Ver el primer elemento");
            System.out.println("4. Ver cantidad de elementos");
            System.out.println("5. Vaciar la cola");
            System.out.println("6. Invertir la cola");
            System.out.println("7. Imprimir la cola");
            System.out.println("8. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese un número para insertar: ");
                    int num = scanner.nextInt();
                    cola.insertar(num);
                    System.out.println("Elemento insertado.");
                    break;
                case 2:
                    int extraido = cola.extraer();
                    if (extraido == Integer.MAX_VALUE) {
                        System.out.println("La cola está vacía.");
                    } else {
                        System.out.println("Elemento extraído: " + extraido);
                    }
                    break;
                case 3:
                    int primero = cola.verPrimero();
                    if (primero == Integer.MAX_VALUE) {
                        System.out.println("La cola está vacía.");
                    } else {
                        System.out.println("Primer elemento: " + primero);
                    }
                    break;
                case 4:
                    System.out.println("Cantidad de elementos en la cola: " + cola.cantidad());
                    break;
                case 5:
                    cola.vaciar();
                    System.out.println("Cola vaciada.");
                    break;
                case 6:
                    cola.invertir();
                    System.out.println("Cola invertida.");
                    break;
                case 7:
                    cola.imprimir();
                    break;
                case 8:
                    System.out.println("Saliendo de la aplicación.");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 8);

        scanner.close();
    }
    
}
