package co.edu.uniquindio.ListasCircularesDoblementeEnlazadas;

public class ListaDoblementeCircular<T extends Comparable<? super T>> {

    private Nodo<T> cabeza;
    private int tam;

    private static class Nodo<T> {
        private T dato;
        private Nodo<T> previo;
        private Nodo<T> siguiente;

        public Nodo(T dato) {
            this.dato = dato;
        }
    }

    public ListaDoblementeCircular() {
        cabeza = null;
        tam = 0;
    }

    public void agregar(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        if (cabeza == null) {
            cabeza = nuevo;
            cabeza.siguiente = cabeza;
            cabeza.previo = cabeza;
        } else {
            Nodo<T> ultimo = cabeza.previo;
            ultimo.siguiente = nuevo;
            nuevo.previo = ultimo;
            nuevo.siguiente = cabeza;
            cabeza.previo = nuevo;
        }
        tam++;
    }

    public void agregarSegunPosicion(T dato, int posicion) {
        if (posicion < 0 || posicion > tam) throw new IndexOutOfBoundsException("Posición inválida");
        Nodo<T> nuevo = new Nodo<>(dato);
        if (cabeza == null) {
            cabeza = nuevo;
            cabeza.siguiente = cabeza;
            cabeza.previo = cabeza;
        } else if (posicion == 0) {
            Nodo<T> ultimo = cabeza.previo;
            nuevo.siguiente = cabeza;
            nuevo.previo = ultimo;
            cabeza.previo = nuevo;
            ultimo.siguiente = nuevo;
            cabeza = nuevo;
        } else {
            Nodo<T> actual = cabeza;
            for (int i = 0; i < posicion; i++) {
                actual = actual.siguiente;
            }
            Nodo<T> anterior = actual.previo;
            nuevo.siguiente = actual;
            nuevo.previo = anterior;
            anterior.siguiente = nuevo;
            actual.previo = nuevo;
            if (posicion == tam) cabeza.previo = nuevo;
        }
        tam++;
    }

    public void mostrar() {
        if (cabeza == null) {
            System.out.println("[]");
            return;
        }
        Nodo<T> actual = cabeza;
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
            Nodo<T> actual = cabeza;
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
