public class Pila {

    //--------------------------------------------------
    //CLASE NODO
    class Nodo{
        int info;
        Nodo sig;
    }

    //--------------------------------------------------
    //RAIZ
    private Nodo raiz; //SERA LA CIMA EN NUESTRA LISTA PILA

    //--------------------------------------------------
    //CONSTRUCTOR
    public Pila(){
        raiz = null;
    }

    //--------------------------------------------------
    //INSERTAR
    public void insertar(int x){
        Nodo nuevo = new Nodo();
        nuevo.info = x;

        if (raiz == null){
            nuevo.sig = null;
            raiz = nuevo;
        } else {
            nuevo.sig = raiz;
            raiz = nuevo;
        }
    }

    //--------------------------------------------------
    //EXTRAER (ELIMINA EL VALOR EN LA CIMA)
    public int extraer(){
        if (raiz != null){
            int informacion = raiz.info;
            raiz = raiz.sig;
            return informacion;
        } else {
            return Integer.MAX_VALUE;
        }
    }

    //--------------------------------------------------
    //RETORNAR (DEVUELVE LA CIMA SIN ELIMINARLA)
    public int retornar(){
        if (raiz != null){
            int informacion = raiz.info;
            return informacion;
        } else{
            return Integer.MAX_VALUE;
        }
    }

    //--------------------------------------------------
    //RETORNAR ULTIMO NODO 
    public int retornarUltimo(){
        if (raiz != null){
            Nodo reco = raiz;
            int informacion = reco.info;
            while (reco.sig != null){
                reco = reco.sig;
                informacion = reco.info;
            }
            return informacion;
        } else{
            return Integer.MAX_VALUE;
        }
    }

    //--------------------------------------------------
    //RETORNAR CANTIDAD DE NODOS
    public int cantidad(){
        Nodo reco = raiz;
        int cant = 0;
        while (reco != null){
            reco = reco.sig;
            cant ++;
        } 
        return cant;
    }

    //--------------------------------------------------
    //BUSCAR INT X
    public boolean buscarInt(int x){
        Nodo reco = raiz;
        while (reco != null){
            if (reco.info == x){
                return true;
            } 
            reco = reco.sig;  
        }
        return false;
    }

    //--------------------------------------------------
    //INICIAR EN CERO
    public void inicializarEnCero(){
        Nodo reco = raiz;
        while (reco != null){
            reco.info = 0;
            reco = reco.sig; 
        }
    }

    //--------------------------------------------------
    //INDICA SI ESTA VACIA O NO
    public Boolean esVacia(){
        if (raiz == null){
            return true;
        } else {
            return false;
        }
    }


    //--------------------------------------------------
    //IMPRIMIR
    public void imprimir(){
        Nodo reco = raiz; //AVANZA DESDE LA CIMA
        System.out.println("Elementos de la pila: ");

        while (reco != null){
            System.out.print(reco.info + " - ");
            reco = reco.sig;
        }
        System.out.println();
    }


    //--------------------------------------------------
    //METODO MAIN
    public static void main(String[]args){
        Pila pila1 = new Pila();

        System.out.println("_______________________________");
        System.out.println("La pila esta vacia?:" + pila1.esVacia());

        pila1.insertar(5);
        pila1.insertar(10);
        pila1.insertar(50);
        pila1.insertar(78);
        pila1.insertar(15);
        System.out.println("_______________________________");
        pila1.imprimir();

        System.out.println("_______________________________");
        System.out.println("Extraemos de la pila:" + pila1.extraer());
        pila1.imprimir();

        System.out.println("_______________________________");
        System.out.println("Retornamos el primero de la pila: " + pila1.retornar());
        pila1.imprimir();

        System.out.println("_______________________________");
        System.out.println("Cantidad de nodos: " + pila1.cantidad());

        /*System.out.println("_______________________________");
        pila1.inicializarEnCero();
        pila1.imprimir();*/

        System.out.println("_______________________________");
        System.out.println("Ulimo nodo:" + pila1.retornarUltimo());

        System.out.println("_______________________________");
        System.out.println("La pila esta vacia?:" + pila1.esVacia());

        System.out.println("_______________________________");
        System.out.println("Buscar 5:" + pila1.buscarInt(5));
        System.out.println("Buscar 63:" + pila1.buscarInt(63));
      
    }

}
