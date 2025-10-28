package co.edu.uniquindio.Arbol;

import java.util.LinkedList;
import java.util.Queue;

public class Arbol<T extends Comparable<T>> {
    private Nodo<T> raiz;

    public Arbol() {
        this.raiz = null;
    }

    public Nodo<T> getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo<T> raiz) {
        this.raiz = raiz;
    }

    /**
     * Método para verificar si el árbol está vacio
     */
    public boolean estaVacio(){
        return raiz == null;
    }

    /**
     * Método para agregar un dato
     */
    public void agregarDato(T dato){
        raiz = agregarDatoRecursivo(raiz, dato);
    }

    private Nodo<T> agregarDatoRecursivo(Nodo<T> nodo, T dato){
        if(dato == null){
            return new Nodo<>(dato);
        }
        if (dato.compareTo(nodo.getDato()) < 0){
            nodo.setIzquierdo(agregarDatoRecursivo(nodo.getIzquierdo(), dato));
        } else if (dato.compareTo(nodo.getDato()) > 0){
            nodo.setDerecho(agregarDatoRecursivo(nodo.getDerecho(), dato));
        }

        return nodo;
    }

    /**
     * Método para recorrer el arbol en InOrden
     */
    public void recorrerInOrden(){
        recorrerInOrdenRecursivo(raiz);
        System.out.println();
    }

    private void recorrerInOrdenRecursivo(Nodo<T> nodo){
        if(nodo != null){
            recorrerInOrdenRecursivo(nodo.getIzquierdo());
            System.out.println(nodo.getDato() + " ");
            recorrerInOrdenRecursivo(nodo.getDerecho());
        }
    }

    /**
     * Recorrer en PostOrden
     */
    public void recorrerPostOrden(){
        recorrerPostOrdenRecursivo(raiz);
        System.out.println();
    }

    private void recorrerPostOrdenRecursivo(Nodo<T> nodo) {
        if(nodo != null){
            recorrerPostOrdenRecursivo(nodo.getIzquierdo());
            recorrerPostOrdenRecursivo(nodo.getDerecho());
            System.out.println(nodo.getDato() + " ");
        }
    }

    /**
     * Método para verificar si un dato existe
     */
    public boolean existeDato(T dato){
        return existeDatoRecursivo(raiz, dato);
    }

    private boolean existeDatoRecursivo(Nodo<T> nodo, T dato){
        if(dato == null){
            return false;
        }
        if (dato.equals(nodo.getDato())){
            return true;
        }

        if (dato.compareTo(nodo.getDato()) < 0){
            return existeDatoRecursivo(nodo.getIzquierdo(), dato);
        } else {
            return existeDatoRecursivo(nodo.getDerecho(), dato);
        }
    }

    /**
     * Método para obtener el peso
     */
    public int obtenerPeso(){
        return obtenerPesoRecursivo(raiz);
    }

    private int obtenerPesoRecursivo(Nodo<T> nodo){
        if(nodo == null){
            return 0;
        }
        return 1 + obtenerPesoRecursivo(nodo.getIzquierdo()) + obtenerPesoRecursivo(nodo.getDerecho());
    }

    /**
     * Método para obtener altura
     */
    public int obtenerAltura(){
        return obtenerAlturaRecursiva(raiz);
    }

    private int obtenerAlturaRecursiva(Nodo<T> nodo){
        if(nodo == null){
            return 0;
        }
        int alturaIzq = obtenerAlturaRecursiva(nodo.getIzquierdo());
        int alturaDer = obtenerAlturaRecursiva(nodo.getDerecho());

        return Math.max(alturaIzq, alturaDer) + 1;
    }

    /**
     * Método para obtener el nivel de un dato
     */
    public int obtenerNivel(T dato){
        return obtenerNivelRecursivo(raiz, dato, 1);
    }

    private int obtenerNivelRecursivo(Nodo<T> nodo, T dato, int nivel){
        if(dato == null){
            return -1;
        }
        if (dato.equals(nodo.getDato())){
            return nivel;
        }
        if(dato.compareTo(nodo.getDato()) < 0){
            return obtenerNivelRecursivo(nodo.getIzquierdo(), dato, nivel + 1);
        } else {
            return obtenerNivelRecursivo(nodo.getDerecho(), dato, nivel);
        }
    }

    /**
     * Método para contar hojas
     */
    public int contarHojas() {
        return contarHojasRecursivo(raiz);
    }

    private int contarHojasRecursivo(Nodo<T> nodo) {
        if (nodo == null) {
            return 0;
        }

        if (nodo.getIzquierdo() == null && nodo.getDerecho() == null) {
            return 1;
        }

        return contarHojasRecursivo(nodo.getIzquierdo()) +
                contarHojasRecursivo(nodo.getDerecho());
    }

    /**
     * Método para obtener el menor valor
     */
    public T obtenerMenor() {
        if (raiz == null) {
            return null;
        }
        return obtenerMenorRecursivo(raiz);
    }

    private T obtenerMenorRecursivo(Nodo<T> nodo) {
        if (nodo.getIzquierdo() == null) {
            return nodo.getDato();
        }
        return obtenerMenorRecursivo(nodo.getIzquierdo());
    }

    /**
     * Método para obtener el nodo menor
     */
    public Nodo<T> obtenerNodoMenor() {
        if (raiz == null) {
            return null;
        }
        return obtenerNodoMenorRecursivo(raiz);
    }

    private Nodo<T> obtenerNodoMenorRecursivo(Nodo<T> nodo) {
        if (nodo.getIzquierdo() == null) {
            return nodo;
        }
        return obtenerNodoMenorRecursivo(nodo.getIzquierdo());
    }

    /**
     * Método para obtener el nodo mayor
     */
    public Nodo<T> obtenerNodoMayor() {
        if (raiz == null) {
            return null;
        }
        return obtenerNodoMayorRecursivo(raiz);
    }

    private Nodo<T> obtenerNodoMayorRecursivo(Nodo<T> nodo) {
        if (nodo.getDerecho() == null) {
            return nodo;
        }
        return obtenerNodoMayorRecursivo(nodo.getDerecho());
    }

    /**
     * Método para imprimir por amplitud (nivel por nivel)
     */
    public void imprimirAmplitud() {
        if (raiz == null) {
            System.out.println("Árbol vacío");
            return;
        }

        Queue<Nodo<T>> cola = new LinkedList<>();
        cola.offer(raiz);

        while (!cola.isEmpty()) {
            Nodo<T> nodoActual = cola.poll();
            System.out.print(nodoActual.getDato() + " ");

            if (nodoActual.getIzquierdo() != null) {
                cola.offer(nodoActual.getIzquierdo());
            }

            if (nodoActual.getDerecho() != null) {
                cola.offer(nodoActual.getDerecho());
            }
        }
        System.out.println();
    }

    /**
     * Método para eliminar dato
     */
    public void eliminarDato(T dato) {
        raiz = eliminarDatoRecursivo(raiz, dato);
    }

    private Nodo<T> eliminarDatoRecursivo(Nodo<T> nodo, T dato) {
        if (nodo == null) {
            return null;
        }

        if (dato.compareTo(nodo.getDato()) < 0) {
            nodo.setIzquierdo(eliminarDatoRecursivo(nodo.getIzquierdo(), dato));
        } else if (dato.compareTo(nodo.getDato()) > 0) {
            nodo.setDerecho(eliminarDatoRecursivo(nodo.getDerecho(), dato));
        } else {
            // Caso 1: Nodo sin hijos
            if (nodo.getIzquierdo() == null && nodo.getDerecho() == null) {
                return null;
            }

            // Caso 2: Nodo con un solo hijo
            if (nodo.getIzquierdo() == null) {
                return nodo.getDerecho();
            }

            if (nodo.getDerecho() == null) {
                return nodo.getIzquierdo();
            }

            // Caso 3: Nodo con dos hijos
            T menorDelDerecho = obtenerMenorRecursivo(nodo.getDerecho());
            nodo.setDato(menorDelDerecho);
            nodo.setDerecho(eliminarDatoRecursivo(nodo.getDerecho(), menorDelDerecho));
        }

        return nodo;
    }

    /**
     * Método para borrar un arbol
     */
    public void borrarArbol(){
        raiz = null;
        System.gc();
    }





}
