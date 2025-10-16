package co.edu.uniquindio.Colas;

public class BiCola<T> {
    private Nodo<T> frente;
    private Nodo<T> fin;
    private int tamaño;
    private int maxTamaño;

    public BiCola(int maxTamaño) {
        this.frente = null;
        this.fin = null;
        this.tamaño = 0;
        this.maxTamaño = maxTamaño;
    }

    public static <T> BiCola<T> crearBicola(int maxTamaño) {
        return new BiCola<>(maxTamaño);
    }

    // Insertar al frente
    public void insertarFrente(T dato) {
        if (estaLlena()) {
            System.out.println("❌ La bicola está llena.");
            return;
        }
        Nodo<T> nuevo = new Nodo<>(dato);
        if (estaVacia()) {
            frente = fin = nuevo;
        } else {
            nuevo.setProximo(frente);
            frente.setAnterior(nuevo);
            frente = nuevo;
        }
        tamaño++;
    }

    // Insertar al final
    public void insertarFinal(T dato) {
        if (estaLlena()) {
            System.out.println("❌ La bicola está llena.");
            return;
        }
        Nodo<T> nuevo = new Nodo<>(dato);
        if (estaVacia()) {
            frente = fin = nuevo;
        } else {
            fin.setProximo(frente);
            nuevo.setAnterior(fin);
            fin = nuevo;
        }
        tamaño++;
    }

    // Eliminar desde el frente
    public T eliminarFrente() {
        if (estaVacia()) {
            System.out.println("❌ La bicola está vacía.");
            return null;
        }
        T valor = frente.getDato();
        frente = frente.getProximo();
        if (frente != null) frente.setAnterior(null); ;
        tamaño--;
        return valor;
    }

    // Eliminar desde el final
    public T eliminarFinal() {
        if (estaVacia()) {
            System.out.println("❌ La bicola está vacía.");
            return null;
        }
        T valor = fin.getDato();
        fin = fin.getAnterior();
        if (fin != null) fin.setAnterior(null);
        tamaño--;
        return valor;
    }

    public boolean estaVacia() {
        return frente == null;
    }

    public boolean estaLlena() {
        return tamaño >= maxTamaño;
    }

    public void limpiar() {
        frente = fin = null;
        tamaño = 0;
    }

    public T obtenerFrente() {
        if (estaVacia()) return null;
        return frente.getDato();
    }

    public T obtenerFinal() {
        if (estaVacia()) return null;
        return fin.getDato();
    }

    public int tamaño() {
        return tamaño;
    }
}

