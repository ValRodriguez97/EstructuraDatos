package co.edu.uniquindio.Ejercicio12;

public class Nodo {
    double dato;
    Nodo proximo;

    public Nodo(double dato) {
        this.dato = dato;
        this.proximo = null;
    }

    public double getDato() {
        return dato;
    }

    public void setDato(double dato) {
        this.dato = dato;
    }

    public Nodo getProximo() {
        return proximo;
    }

    public void setProximo(Nodo proximo) {
        this.proximo = proximo;
    }
}
