package co.edu.uniquindio.ListasCirculares;

public class ListaCircularSimple<T extends Comparable<? super T>> {

    private Nodo<T> ultimo;
    private int tam;

    private static class Nodo<T> {
        private T dato;
        private Nodo<T> siguiente;

        public Nodo(T dato) {
            this.dato = dato;
        }
    }

    public ListaCircularSimple() {
        ultimo = null;
        tam = 0;
    }

    public void agregar(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        if (ultimo == null) {
            ultimo = nuevo;
            ultimo.siguiente = ultimo;
        } else {
            nuevo.siguiente = ultimo.siguiente;
            ultimo.siguiente = nuevo;
            ultimo = nuevo;
        }
        tam++;
    }

    public void insertar(T dato, int posicion) {
        if (posicion < 0 || posicion > tam) throw new IndexOutOfBoundsException("Posición inválida");
        Nodo<T> nuevo = new Nodo<>(dato);

        if (ultimo == null){
            ultimo = nuevo;
            ultimo.siguiente = ultimo;
        } else if (posicion == 0) {
            nuevo.siguiente = ultimo.siguiente;
            ultimo.siguiente = nuevo;
        } else {
            Nodo<T> actual = ultimo.siguiente;
            for (int i = 0; i < posicion -1; i++){
                actual = actual.siguiente;
            }
            nuevo.siguiente = actual.siguiente;
            actual.siguiente = nuevo;
            if (actual == ultimo){
                ultimo = nuevo;
            }
        }
        tam++;
    }

    /**
     * Metodo buscar
     */
    public boolean buscar(T dato){
        if(ultimo == null) return false;
        Nodo<T> actual = ultimo.siguiente;
        do {
            if (actual.dato.equals(dato)) return true;
            actual = actual.siguiente;
        } while (actual != ultimo.siguiente);
        return false;
    }

    public void mostrar() {
        if (ultimo == null) {
            System.out.println("[]");
            return;
        }
        Nodo<T> actual = ultimo.siguiente;
        System.out.print("[");
        for (int i = 0; i < tam; i++) {
            System.out.print(actual.dato);
            if (i < tam - 1) System.out.print(" ");
            actual = actual.siguiente;
        }
        System.out.println("]");
    }

    public int size(){ return tam; }

    public void sort() {
        if (tam <= 1) return;
        boolean cambiado;
        do {
            cambiado = false;
            Nodo<T> actual = ultimo.siguiente;
            for (int i = 0; i < tam - 1; i++) {
                Nodo<T> siguiente = actual.siguiente;
                if (actual.dato.compareTo(siguiente.dato) > 0) {
                    T temp = actual.dato;
                    actual.dato = siguiente.dato;
                    siguiente.dato = temp;
                    cambiado = true;
                }
                actual = siguiente;
            }
        } while (cambiado);
    }
}
