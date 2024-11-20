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

    public int retornar(){
       if (!esVacia()){
        return raiz.info;
       } else {
        return Integer.MAX_VALUE;
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

    public static void main(String[]ar){
        Cola cola1 = new Cola();

        cola1.insertar(10);
        cola1.insertar(20);
        cola1.insertar(758);
        cola1.imprimir();

        System.out.println("Extraer uno:" + cola1.extraer());
        cola1.imprimir();

        System.out.println("Mostrar el ultimo:" + cola1.retornar());
        cola1.imprimir();
    }
    
}
