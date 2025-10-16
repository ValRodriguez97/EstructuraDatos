package co.edu.uniquindio.Colas;

public class Nodo<T> {
    private T dato;
    private Nodo<T> proximo;
    private Nodo<T> anterior;

    public Nodo(T dato) {
        this.dato = dato;
        this.proximo = null;
        this.anterior = null;
    }

    public T getDato() {
        return dato;
    }

    public Nodo<T> getProximo() {
        return proximo;
    }

    public void setProximo(Nodo<T> proximo) {
        this.proximo = proximo;
    }

    public void setDato(T tmp) {
        dato = tmp;
    }

    public Nodo<T> getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo<T> anterior) {
        this.anterior = anterior;
    }
}
