package co.edu.uniquindio.ListasDoblementeEnlazadas;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListaDobleEnlazada<T extends Comparable<? super T>>  implements  Iterable<T>{

    private Nodo<T> primero;
    private Nodo<T> ultimo;
    private int tam;

    private static class Nodo<T> {
        private T dato;
        private Nodo<T> previo;
        private Nodo<T> siguiente;

        public Nodo(T dato) {
            this.dato = dato;
        }
    }

    public ListaDobleEnlazada() {
        primero = ultimo = null;
        tam = 0;
    }

    public void agregarPrimero(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        if (primero == null) {
            primero = ultimo = nuevo;
        } else {
            nuevo.siguiente = primero;
            primero.previo = nuevo;
            primero = nuevo;
        }
        tam++;
    }

    public void agregarUltimo(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        if (ultimo == null) {
            primero = ultimo = nuevo;
        } else {
            ultimo.siguiente = nuevo;
            nuevo.previo = ultimo;
            ultimo = nuevo;
        }
        tam++;
    }

    public void agregarSegunPosicion(T dato, int posicion) {
        if (posicion < 0 || posicion > tam) throw new IndexOutOfBoundsException("Posición inválida");
        if (posicion == 0) {
            agregarPrimero(dato);
            return;
        }
        if (posicion == tam) {
            agregarUltimo(dato);
            return;
        }
        Nodo<T> nuevo = new Nodo<>(dato);
        Nodo<T> actual = primero;
        for (int i = 0; i < posicion; i++) {
            actual = actual.siguiente;
        }
        nuevo.previo = actual.previo;
        nuevo.siguiente = actual;
        actual.previo.siguiente = nuevo;
        actual.previo = nuevo;
        tam++;
    }

    public void mostrar() {
        Nodo<T> actual = primero;
        System.out.print("[");
        while (actual != null) {
            System.out.print(actual.dato);
            if (actual.siguiente != null) System.out.print(" ");
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
            Nodo<T> actual = primero;
            while (actual != null && actual.siguiente != null) {
                if (actual.dato.compareTo(actual.siguiente.dato) > 0) {
                    T temp = actual.dato;
                    actual.dato = actual.siguiente.dato;
                    actual.siguiente.dato = temp;
                    cambiado = true;
                }
                actual = actual.siguiente;
            }
        } while (cambiado);
    }

    /**
     * Método imprimirHaciaAtras
     */
    public void imprimirHaciaAtras(){
        Nodo<T> actual = ultimo;
        System.out.println("[");
        while (actual != null){
            System.out.println(actual.dato);
            if (actual.previo != null) System.out.println(" ");
                actual = actual.previo;
        }
        System.out.println("]");
    }

    /**
     * Personas que tiene cedula con cantidd par
     */
    public ListaDobleEnlazada<Persona> obtenerPersonasCedulaPar(){
        ListaDobleEnlazada<Persona> cedulaPar = new ListaDobleEnlazada<>();
        Nodo<T> actual = primero;

        while (actual != null){
            if (actual.dato instanceof  Persona persona){
                if(persona.getCedula().length() % 2 == 0){
                    cedulaPar.agregarUltimo(persona);
                }
            }
            actual = actual.siguiente;
        }
        return cedulaPar;
    }

    @Override
    public Iterator<T> iterator(){
        return new Iterator<T>() {
            private Nodo<T> actual = primero;

            @Override
            public boolean hasNext() {
                return actual != null;
            }

            @Override
            public T next() {
                if (!hasNext()) throw new NoSuchElementException();
                T dato = actual.dato;
                actual = actual.siguiente;
                return dato;
            }
        };
    }
}
