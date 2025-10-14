package co.edu.uniquindio.Ejercicio12;

public class ListaEnlazada {
    private Nodo primero;
    private int tam;

    public ListaEnlazada() {
        this.primero = null;
        this.tam = 0;
    }

    public void agregar(double dato){
        Nodo nuevo = new Nodo(dato);
        if(primero == null){
            primero = nuevo;
        } else {
            Nodo actual = primero;
            while (actual.proximo != null){
                actual = actual.proximo;
            }
            actual.proximo = nuevo;
        }
        tam++;
    }

    public double calcularMedia(){
        if( tam == 0) return 0;
        double suma = 0;
        Nodo actual = primero;
        while (actual != null){
            suma += actual.getDato();
            actual = actual.proximo;
        }
        return suma / tam;
    }

    public double calcularDesviacionEstandar(){
        if (tam <= 1) return 0;
        double media = calcularMedia();
        double sumaDiferencias = 0;
        Nodo actual = primero;
        while (actual != null){
            sumaDiferencias += Math.pow(actual.dato - media, 2);
            actual = actual.proximo;
        }
        return Math.sqrt(sumaDiferencias / (tam-1));
    }

    public void mostrar(){
        Nodo actual = primero;
        System.out.println("Lista: [ ");
        while (actual != null){
            System.out.print(actual.dato + "  ");
            actual = actual.proximo;
        }
        System.out.println("]");
    }
}
