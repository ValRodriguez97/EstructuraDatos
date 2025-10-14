package co.edu.uniquindio.ListasMaximaDistancia;

public class NodoLista {
    private int clave;
    private NodoLista proximo;

    public NodoLista(int x, NodoLista n){
        clave = x;
        proximo = n;
    }

    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public NodoLista getProximo() {
        return proximo;
    }

    public void setProximo(NodoLista proximo) {
        this.proximo = proximo;
    }
}
