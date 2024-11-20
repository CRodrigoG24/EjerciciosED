public class Generica {
    
    class Nodo{
        int info;
        Nodo sig;
    }

    private Nodo raiz;

    public Generica(){
        raiz = null;
    }


    // Retorna el número de nodos en la lista.
    public int cantidad(){
        int cant = 0;
        Nodo reco = raiz;
        while (reco != null){
            reco = reco.sig;
            cant++;
        }
        return cant;
    }

    public void insertar(int pos,int x){
        if (pos <= cantidad() + 1){
            Nodo nuevo = new Nodo();
            nuevo.info = x;
            if (pos == 1){
                nuevo.sig = raiz;
                raiz = nuevo;
            } else if(pos ==cantidad()+ 1){
                Nodo reco = raiz;
                while (reco.sig != null){
                    reco = reco.sig;
                }
                reco.sig = nuevo;
                nuevo.sig = null;
            } else {
                Nodo reco = raiz;
                for (int f = 1 ; f<=pos - 2;f++){
                    reco = reco.sig;
                }
                Nodo siguiente = reco.sig;
                reco.sig = nuevo;
                nuevo.sig = siguiente;
            }
        }
    }

    //EXTRAER Y ELIMINAR UN NODO DE UNA POS ESPECIFICA Y DEVUELVE EL VALOR
    public int extraer(int pos){
        if (pos <= cantidad()){
            int informacion;
            if (pos == 1){
                informacion = raiz.info;
                raiz = raiz.sig;
            }else{
                Nodo reco = raiz;
                for (int f = 1;f<=pos-2;f++){
                    reco =reco.sig;
                }
                Nodo siguiente = reco.sig;
                reco.sig = siguiente.sig;
                informacion = siguiente.info;
            }
            return informacion;
        }else{
            return Integer.MAX_VALUE;
        }
    }

    //EXTRAER Y ELIMINAR UN NODO DE UNA POS ESPECIFICA SIN DEVOLVER VALOR
    public void borrar(int pos){
        if (pos <= cantidad()){
            int informacion;
            if (pos == 1){
                raiz = raiz.sig;
            }else{
                Nodo reco = raiz;
                for (int f = 1;f<=pos-2;f++){
                    reco =reco.sig;
                }
                Nodo siguiente = reco.sig;
                reco.sig = siguiente.sig;
                
            }
        }
    }

    //INTERCAMBIAR
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

    //Verifica si la lista está ordenada de menor a mayor.
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

    //Recorre la lista buscando un nodo con el valor x y devuelve true si lo encuentra.
    public boolean existe(int x) {
        Nodo reco = raiz;
        while (reco != null) {
            if (reco.info == x)
                return true;
            reco = reco.sig;
        }
        return false;
    }

    // Retorna true si la lista está vacía, es decir, si raiz es null.
    public boolean vacia() {
        return raiz == null;
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
        Generica gen = new Generica();
        gen.insertar(1, 10);
        gen.insertar(2, 20);
        gen.insertar(3, 30);
        gen.insertar(4, 14);
        gen.insertar(5, 150);
        gen.imprimir();

        System.out.println("___________________");
        gen.borrar(1);
        gen.imprimir();
        System.out.println("___________________");
        gen.extraer(2);
        gen.imprimir();
        System.out.println("___________________");
        gen.intercambiar(3, 1);
        gen.imprimir();
        System.out.println("___________________");
        System.out.println("______existe 10_____________");
        if (gen.existe(10)){
            System.out.println("si");}
        else{
            System.out.println("no");}
        System.out.println("___________________");
        //System.out.println("pos del mayor:" + gen.posMayor());
        System.out.println("___________________");
        System.out.println("_______ordenada____________");
        if (gen.ordenada()){
            System.out.println("si");}
        else{
            System.out.println("no");}





    }

}
