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

    /**
     * Método para obtener personas con cedulas pares
     * @return
     */
    public ListaSimpleEnlazada<T> obtenerCedulasPares(){
        ListaSimpleEnlazada<T> listaCedulasPares = new ListaSimpleEnlazada<>();

        Nodo<T> actual = primero;
        while(actual != null){
            T dato = actual.getDato();
            if(dato instanceof Persona){
                Persona persona = (Persona)dato;
                if(persona.getCedula() == null && persona.getCedula().length() % 2 == 0){
                    listaCedulasPares.agregarUltimo(dato);
                }
            }
            actual = actual.getProximo();
        }
        return listaCedulasPares;
    }

    /**
     * Método para eliminar numeros pares
     * @return
     */
    public void eliminarNumerosPares(){
        while (primero != null && primero.getDato() instanceof  Integer && ((Integer) primero.getDato()) % 2 ==0){
            primero = primero.getProximo();
            tam--;
        }

        Nodo<T> actual = primero;
        while(actual != null && actual.getProximo() !=  null){
            T dato = actual.getProximo().getDato();
            if (dato instanceof  Integer && ((Integer) dato) % 2 == 0){
                actual.setProximo(actual.getProximo().getProximo());
                tam--;
            } else {
                actual = actual.getProximo();
            }
        }
    }

    /**
     * Método que retorne valores impares de una lista de numeros
     * @return
     */
    public ListaSimpleEnlazada<Integer> obtenerNumerosImpares(){
        ListaSimpleEnlazada<Integer> impares = new ListaSimpleEnlazada<>();
        Nodo<T> actual = primero;
        while (actual != null) {
            Integer valor = (Integer) actual.getDato();
            if(valor % 2 != 0){
                impares.agregarUltimo(valor);
            }
            actual = actual.getProximo();
        }
        return impares;
    }

    /**
     * Método que retorna la cantidad de veces que se repite un valor
     * @return
     */
    public int contarValorRepetido(T valor){
         int aux = 0;
         Nodo<T> actual = primero;
         while (actual != null) {
             if(actual.getDato().equals(valor)){
                 aux++;
             }
             actual = actual.getProximo();
         }
         return aux;
    }

    /**
     * Método que permite concatenar dos listas simples enlazadas
     * @param lista1 Primera lista a concatenar
     * @param lista2 Segunda lista a concatenar
     * @return Nueva lista que contiene los elementos de las dos listas
     */
    public static <T extends Comparable <? super T>> ListaSimpleEnlazada<T>
    concatenarListas(ListaSimpleEnlazada<T> lista1, ListaSimpleEnlazada<T> lista2){
        ListaSimpleEnlazada<T> nuevaLista = new ListaSimpleEnlazada<>();

        for(T dato: lista1){
            nuevaLista.agregarUltimo(dato);
        }

        for(T dato : lista2){
            nuevaLista.agregarUltimo(dato);
        }
        return nuevaLista;
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
