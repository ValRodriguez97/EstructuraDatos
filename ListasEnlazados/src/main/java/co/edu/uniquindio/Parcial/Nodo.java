package co.edu.uniquindio.Parcial;

public class Nodo {
    int dato;
    Nodo sig;

    public Nodo(int dato) {
        this.dato = dato;
        this.sig = null;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public Nodo getSig() {
        return sig;
    }

    public void setSig(Nodo sig) {
        this.sig = sig;
    }
}
