package co.edu.uniquindio.ListasMaximaDistancia;

public class Lista {
    NodoLista inicio;

    public Lista() {
        inicio = null;
    }

    public void agregar(int x){
        inicio = new NodoLista(x, inicio);
    }

    public int maximaDistancia(int x){
        return calcularMaximaDistancia(inicio, x, 0,0, false);
    }

    private int calcularMaximaDistancia(NodoLista nodo, int x, int distancia, int maxDistancia, boolean encontrado){
        if (nodo == null) return maxDistancia;
        if(nodo.getClave() == x){
            if(!encontrado){
                return calcularMaximaDistancia(nodo.getProximo(),x,1,0, true);
            } else {
                maxDistancia = Math.max(maxDistancia, distancia);
                return calcularMaximaDistancia(nodo.getProximo(), x, 1, maxDistancia, true);
            }
        } else if (encontrado){
            return calcularMaximaDistancia(nodo.getProximo(), x, distancia+1, maxDistancia, true);
        } else {
            return calcularMaximaDistancia(nodo.getProximo(),x,0, maxDistancia, false);
        }
    }

    public void mostrar(){
        NodoLista actual = inicio;
        System.out.println("[ ");
        while(actual != null){
            System.out.println(actual.getClave() + " ");
            actual = actual.getProximo();
        }
        System.out.println("]");
    }
}
