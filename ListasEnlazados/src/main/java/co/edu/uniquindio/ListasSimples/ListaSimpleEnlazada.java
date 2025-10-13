package co.edu.uniquindio.ListasSimples;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListaSimpleEnlazada<T extends Comparable<? super T>> implements Iterable<T> {

    private Nodo<T> primero;
    private int tam;

    private static class Nodo<T> {
        private T dato;
        private Nodo<T> proximo;

        public Nodo(T dato) {
            this.dato = dato;
            this.proximo = null;
        }

        public T getDato() { return dato; }
        public Nodo<T> getProximo() { return proximo; }
        public void setProximo(Nodo<T> proximo) { this.proximo = proximo; }
    }

    public ListaSimpleEnlazada() {
        primero = null;
        tam = 0;
    }

    public void agregarPrimero(T dato){
        Nodo<T> newNodo = new Nodo<>(dato);
        newNodo.setProximo(primero);
        primero = newNodo;
        tam++;
    }

    public void agregarUltimo(T dato){
        Nodo<T> newNodo = new Nodo<>(dato);
        if(primero == null){
            primero = newNodo;
        } else {
            Nodo<T> actual = primero;
            while(actual.getProximo() != null){
                actual = actual.getProximo();
            }
            actual.setProximo(newNodo);
        }
        tam++;
    }

    public void agregarSegunPosicion(T dato, int posicion) {
        if (posicion < 0 || posicion > tam) throw new IndexOutOfBoundsException("Posición inválida");
        if (posicion == 0) {
            agregarPrimero(dato);
            return;
        }
        Nodo<T> nuevo = new Nodo<>(dato);
        Nodo<T> actual = primero;
        for (int i = 0; i < posicion - 1; i++) {
            actual = actual.getProximo();
        }
        nuevo.setProximo(actual.getProximo());
        actual.setProximo(nuevo);
        tam++;
    }

    public void mostrar(){
        Nodo<T> actual = primero;
        System.out.print("[");
        while(actual != null){
            System.out.print(actual.getDato());
            if(actual.getProximo() != null) System.out.print(" ");
            actual = actual.getProximo();
        }
        System.out.println("]");
    }

    public int size(){ return tam; }

    public void sort() {
        if (tam <= 1) return;
        boolean cambiado;
        do {
            cambiado = false;
            Nodo<T> actual = primero;
            while (actual != null && actual.getProximo() != null) {
                if (actual.getDato().compareTo(actual.getProximo().getDato()) > 0) {
                    T temp = actual.dato;
                    actual.dato = actual.getProximo().dato;
                    actual.getProximo().dato = temp;
                    cambiado = true;
                }
                actual = actual.getProximo();
            }
        } while (cambiado);
    }

    /**
     * Método para obtener numeros que estan en posiciones impares
     * @return
     */
    public ListaSimpleEnlazada<T> obtenerElementosPosicionesImpares(){
        ListaSimpleEnlazada<T> impares = new ListaSimpleEnlazada<>();
        Nodo<T> actual = primero;
        int posicion = 0;

        while (actual != null) {
            if(posicion % 2 != 0){
                impares.agregarUltimo(actual.getDato());
            }
            actual = actual.getProximo();
            posicion++;
        }
        return impares;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Nodo<T> actual = primero;

            @Override
            public boolean hasNext() {
                return actual != null;
            }

            @Override
            public T next() {
                if (!hasNext()) throw new NoSuchElementException();
                T dato = actual.getDato();
                actual = actual.getProximo();
                return dato;
            }
        };
    }
}
