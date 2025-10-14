package co.edu.uniquindio.ListasMaximaDistancia;

public class MainListaMaximaDistancia {
    public static void main(String[] args) {
        Lista lista = new Lista();

        lista.agregar(4);
        lista.agregar(7);
        lista.agregar(5);
        lista.agregar(4);
        lista.agregar(8);
        lista.agregar(4);
        lista.agregar(9);

        lista.mostrar();

        int clave = 4;
        int distancia = lista.maximaDistancia(clave);
        System.out.println("Máxima distancia entre elementos con clave " + clave + ": " + distancia);
    }
}
