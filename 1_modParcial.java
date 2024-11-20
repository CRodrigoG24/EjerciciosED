// package parcial;

public class Ejercicio1 {
	class Nodo {
		int info;
		Nodo ant, sig;

		public Nodo(int info) {
			this.info = info;
			this.ant = this.sig = null; // esto es lo mismo que "this.ant = null" y "this.ant = null"
		}
	}

	private Nodo raiz;

	public Ejercicio1() {
		raiz = null;
	}

	public int cantidad() {
		Nodo reco = raiz;
		int cant = 0;

		while (reco != null) {
			reco = reco.sig;
			cant++;
		}

		return cant;
	}

	public void insertar(int x1, int x2) {
		Nodo nodo1 = new Nodo(x1);
		Nodo nodo2 = new Nodo(x2);

		if (this.cantidad() == 4 || this.cantidad() == 8) {
			Nodo actual = raiz;

			while (actual.sig != null) {
				actual = actual.sig;
			}

			actual.sig = nodo1;
			nodo1.ant = actual;

			actual = nodo1;

			actual.sig = nodo2;
			nodo2.ant = actual;
		} else {
			nodo2.sig = raiz;

			if (raiz != null) {
				raiz.ant = nodo2;
			}

			raiz = nodo2;

			nodo1.sig = raiz;
			raiz.ant = nodo1;
			raiz = nodo1;
		}
	}

	public void suma_par() {
		Nodo reco = raiz;
		int cant = 0;
		int suma = 0;

		while (reco != null) {
			cant++;

			if (cant % 2 == 0) {
				suma = suma + reco.info;
			}

			reco = reco.sig;
		}

		System.out.println("La suma de los nodo impares es:" + suma);
	}

	public void imprimir() {
		Nodo reco = raiz;

		System.out.print("La lista es:");

		while (reco != null) {
			System.out.print(reco.info + "-");
			reco = reco.sig;
		}

		System.out.println();
	}

	public void intercambiar_primero_ultimo() {
		Nodo primero = raiz;
		Nodo ultimo = raiz;

		while (ultimo.sig != null) {
			ultimo = ultimo.sig;
		}

		int aux = ultimo.info;

		ultimo.info = primero.info;
		primero.info = aux;

	}

	public void borrar_menor_primero() {
		Nodo actual = raiz.sig;
		Nodo anterior = raiz;
		Nodo reco = raiz;
		int num = reco.info;

		while (actual != null) {
			if (actual.info < num) {
				anterior.sig = actual.sig;

				if (actual.sig != null) {
					actual.sig.ant = anterior;
				}
			} else {
				anterior = actual;
			}
			
			actual = actual.sig;
		}
	}

	public void borrar_pares() {
		Nodo actual = raiz.sig;
		Nodo anterior = raiz;
		Nodo reco = raiz; // ¿?
		int num = reco.info; // ¿?

		while (actual != null) {
			if (actual.info % 2 == 0) {
				anterior.sig = actual.sig;

				if (actual.sig != null) {
					actual.sig.ant = anterior;
				}
			} else {
				anterior = actual;
			}

			actual = actual.sig;
		}
	}

	public boolean existe(int x) {
		Nodo reco = raiz;

		while (reco != null) {
			if (reco.info == x) {
				return true;
			}

			reco = reco.sig;
		}

		return false;
	}

	// ejercicio 3, espero q te sirva

	public void borrar_segundo_penultimo() {
		if (raiz == null) {
            System.out.println("La lista está vacía.");
            return;
        }
        if (raiz.sig == null) {
            raiz = null;
        } else {
            if (raiz.sig != null) {
                Nodo segundo = raiz.sig;
                raiz.sig = segundo.sig;

                if (segundo.sig != null) {
                    segundo.sig.ant = raiz;
                }
            }
            if (cantidad() > 2) {
                Nodo actual = raiz;

                while (actual.sig != null && actual.sig.sig != null) {
                    actual = actual.sig;
                }

                Nodo penultimo = actual;

                if (penultimo.ant != null) {
                    penultimo.ant.sig = penultimo.sig;
                }
                if (penultimo.sig != null) {
                    penultimo.sig.ant = penultimo.ant;
                }
            }
        }
	}

	// -

	public static void main(String[] args) {
		Ejercicio1 lg = new Ejercicio1();
		lg.insertar(1, 2); // 2 nodos - final
		lg.insertar(3, 4); // 4 nodos - principio
		lg.insertar(5, 6); // 6 nodos - final
		lg.insertar(7, 8);
		// 8 nodos - principio
		lg.imprimir(); // 7-8-3-4-1-2-5-6
		lg.suma_par();

		lg.borrar_pares();
		lg.imprimir();

		if (lg.existe(3)) {
			System.out.println("Se encuentra el 7 en la lista");
		} else {
			System.out.println("No se encuentra el 7 en la lista");
		}

		lg.intercambiar_primero_ultimo();
		lg.imprimir();
		lg.borrar_menor_primero();
		lg.imprimir();
	}
}
