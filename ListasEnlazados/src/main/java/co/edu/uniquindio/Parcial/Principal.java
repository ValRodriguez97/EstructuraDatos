package co.edu.uniquindio.Parcial;

public class Principal {
    public static void main(String[] args) {
        Lista lista = new Lista();
        lista.agregar(1);
        lista.agregar(2);
        lista.agregar(3);
        lista.agregar(2);
        lista.agregar(-6);

        System.out.println("Lista original:");
        lista.mostrar();

        lista.insertarSumaDespuesDeCadaNodo();

        System.out.println("Lista modificada:");
        lista.mostrar();
    }
}
