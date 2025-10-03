package co.edu.uniquindio.ListasCircularesDoblementeEnlazadas;

public class Nodo<T> {
    private T dato;
    private co.edu.uniquindio.ListasSimples.Nodo<T> proximo;

    public Nodo(T dato) {
        this.dato = dato;
        this.proximo = null;
    }

    public T getDato() {
        return dato;
    }

    public co.edu.uniquindio.ListasSimples.Nodo<T> getProximo() {
        return proximo;
    }

    public void setProximo(co.edu.uniquindio.ListasSimples.Nodo<T> proximo) {
        this.proximo = proximo;
    }
}
