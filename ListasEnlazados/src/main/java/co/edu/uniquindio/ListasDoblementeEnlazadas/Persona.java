package co.edu.uniquindio.ListasDoblementeEnlazadas;

public class Persona implements Comparable<Persona> {
    private String nombre;
    private String cedula;

    public Persona(String nombre, String cedula) {
        this.nombre = nombre;
        this.cedula = cedula;
    }

    public String getNombre() { return nombre; }
    public String getCedula() { return cedula; }

    @Override
    public String toString() {
        return nombre + " (" + cedula + ")";
    }

    @Override
    public int compareTo(Persona o) {
        return this.cedula.compareTo(o.cedula);
    }
}
