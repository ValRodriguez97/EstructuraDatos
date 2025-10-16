package co.edu.uniquindio.Colas;

public class Cola<T> {
    private Nodo<T> inicio;
    private Nodo<T> fin;
    private int tamaño;
    private int capacidadMaxima;

    private Cola(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
        this.inicio = null;
        this.fin = null;
        this.tamaño = 0;
    }

    /**
     * Método para crear una cola vacia
     */
    public static <T> Cola<T> crearCola(int capacidadMaxima) {
        return new Cola(capacidadMaxima);
    }

    /**
     * Método para insertar elemento enqueue
     */
    public void encolar(T dato) {
        if (estaVacia()) {
            System.out.println("La cola esta llena ");
            return;
        }
        Nodo<T> nuevo = new Nodo<>(dato);
        if (estaVacia()) {
            inicio = fin = nuevo;
        } else {
            fin.setProximo(nuevo);
            fin = nuevo;
        }
        tamaño++;
    }

    public T desencolar() {
        if (estaVacia()) {
            System.out.println("La cola esta vacia ");
            return null;
        }
        T valor = inicio.getDato();
        inicio = inicio.getProximo();
        if (inicio == null) fin = null;
        tamaño--;
        return valor;
    }

    public boolean estaVacia() {
        return inicio == null;
    }

    public boolean estaLLena(){
        return tamaño >= capacidadMaxima;
    }

    public void limpiar(){
        inicio = fin = null;
        tamaño = 0;
    }

    public T inicio(){
        if(estaLLena()) return null;
        return inicio.getDato();
    }

    public int tamaño(){
        return tamaño;
    }
}
