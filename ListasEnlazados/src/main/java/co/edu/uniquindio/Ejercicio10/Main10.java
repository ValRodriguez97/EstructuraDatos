package co.edu.uniquindio.Ejercicio10;

public class Main10 {
    public static void main(String[] args) {
        Polinomio polinomio = new Polinomio();
        polinomio.agregarTermino(3, 4);
        polinomio.agregarTermino(-4, 2);
        polinomio.agregarTermino(11, 0);

        System.out.println("Polinomio: ");
        polinomio.mostrar();

        System.out.println("\nTabla de Valores: ");
        polinomio.generarTablaResultados();
    }
}
