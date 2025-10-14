package co.edu.uniquindio.Ejercicio10;

import co.edu.uniquindio.Colas.Nodo;

public class Polinomio {
    private NodoPolinomio primero;

    public Polinomio() {
        this.primero = null;
    }

    public void agregarTermino(double coeficiente, int exponente){
        NodoPolinomio nuevo = new NodoPolinomio(coeficiente, exponente);

        if (primero == null) {
            primero = nuevo;
        } else {
            NodoPolinomio actual = primero;
            while (actual.proximo != null) {
                actual = actual.proximo;
            }
            actual.proximo = nuevo;
        }
    }

    public void mostrar (){
        NodoPolinomio actual = primero;
        while (actual != null) {
            System.out.print(actual.coeficiente + "x^" + actual.exponente);
            if (actual.proximo != null) System.out.print(" + ");
            actual = actual.proximo;
        }
        System.out.println();
    }

    public double evaluarValor(double x){
        double resultado = 0;
        NodoPolinomio actual = primero;
        while (actual != null) {
            resultado += actual.coeficiente * Math.pow(x, actual.exponente);
            actual = actual.proximo;
        }
        return resultado;
    }

    public void generarTablaResultados(){
        System.out.println("x\tP(x)");
        for (double x = 0.0; x <= 5.0; x += 0.5) {
            System.out.printf("%.1f\t%.4f\n", x, evaluarValor(x));
        }
    }
}
