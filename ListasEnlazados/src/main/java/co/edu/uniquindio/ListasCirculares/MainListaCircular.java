package co.edu.uniquindio.ListasCirculares;

public class MainListaCircular {
    public static void main(String[] args) {
        ListaCircularSimple<Integer> lista = new ListaCircularSimple<>();

        lista.agregar(10);
        lista.agregar(20);
        lista.agregar(30);

        System.out.println("Lista original:");
        lista.mostrar();

        System.out.println("Insertar 5 en posicion 0:  ");
        lista.insertar(5, 0);
        lista.mostrar();

        System.out.println("Buscar 20  -> " + lista.buscar(20));
    }
}
