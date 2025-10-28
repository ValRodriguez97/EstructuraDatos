package co.edu.uniquindio.Parcial;

public class Lista {
    Nodo cabeza;

    public void insertarSumaDespuesDeCadaNodo() {
        int suma = calcularSuma(cabeza);
        insertarRecursivo(cabeza, suma);
    }

    // Calcula la suma total
    private int calcularSuma(Nodo actual) {
        if (actual == null) return 0;
        return actual.dato + calcularSuma(actual.sig);
    }

    // Inserta el valor 2 SOLO después de los nodos cuyo valor sea igual a la suma
    private void insertarRecursivo(Nodo actual, int suma) {
        if (actual == null) return;

        Nodo siguienteOriginal = actual.sig; // Guardar el siguiente original

        // SOLO insertar si el valor actual es igual a la suma
        if (actual.dato == suma) {
            Nodo nuevo = new Nodo(2);
            actual.sig = nuevo;
            nuevo.sig = siguienteOriginal;
        }

        // Llamar recursivamente con el siguiente ORIGINAL
        insertarRecursivo(siguienteOriginal, suma);
    }

    public void agregar(int dato) {
        if (cabeza == null)
            cabeza = new Nodo(dato);
        else {
            Nodo aux = cabeza;
            while (aux.sig != null)
                aux = aux.sig;
            aux.sig = new Nodo(dato);
        }
    }

    public void mostrar() {
        Nodo aux = cabeza;
        while (aux != null) {
            System.out.print(aux.dato + " -> ");
            aux = aux.sig;
        }
        System.out.println("null");
    }
}

