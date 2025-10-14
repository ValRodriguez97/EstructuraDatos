package co.edu.uniquindio.Ejercicio12;


import java.util.Scanner;

public class MainEjercicio12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListaEnlazada lista = new ListaEnlazada();

        System.out.print("¿Cuántos números desea ingresar?: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.print("Ingrese el número " + i + ": ");
            double numero = sc.nextDouble();
            lista.agregar(numero);
        }

        System.out.println();
        lista.mostrar();

        double media = lista.calcularMedia();
        double desviacion = lista.calcularDesviacionEstandar();

        System.out.printf("Media: %.4f%n", media);
        System.out.printf("Desviación estándar: %.4f%n", desviacion);

        sc.close();
    }
}
