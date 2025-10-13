package co.edu.uniquindio.Pilas;

public class Pila<T> {
    private Nodo<T> cima;
    private int capacidadMaxima;
    private int elementos;

    public Pila(int capacidadMaxima){
        if (capacidadMaxima <= 0){
            throw new IllegalArgumentException("El capacidad debe ser mayor que 0");
        }
        this.capacidadMaxima = capacidadMaxima;
        this.elementos = 0;
        this.cima = null;
    }

    public void empilar(T dato){
        if (elementos == capacidadMaxima) {
            throw new IllegalStateException("La pila está llena");
        }
        Nodo<T> nuevo = new Nodo<>(dato);
        nuevo.setProximo(cima);
        cima = nuevo;
        elementos++;
    }

    public T desempilar(){
        if (elementos == 0) {
            throw new IllegalStateException("La pila está vacía");
        }
        T datoEliminado = cima.getCima();
        cima = cima.getProximo();
        elementos--;
        return datoEliminado;
    }

    public T cima(){
        return cima.getCima();
    }

    public void mostrar(){
        if (elementos == 0) {
            System.out.println("Pila vacia");
            return;
        }
        System.out.println("Cima -> ");
        Nodo<T> actual = cima;
        while (actual != null){
            System.out.println(actual.getCima() + " ");
            actual = actual.getProximo();
        }
        System.out.println(" <- Fondo");
    }




}
