package co.edu.uniquindio.ListasDoblementeEnlazadas;

public class MainListaDoble {
    public static void main(String[] args) {
        ListaDobleEnlazada<Integer> numeros = new ListaDobleEnlazada<>();
        numeros.agregarUltimo(10);
        numeros.agregarUltimo(15);
        numeros.agregarUltimo(22);
        numeros.agregarUltimo(33);

        System.out.println("Lista original: ");
        numeros.mostrar();

        // Obtener la lista hacia atras
        System.out.println("Lista hacia atras: ");
        numeros.imprimirHaciaAtras();

        // Recorrer la lista con el iterador
        System.out.println("\nRecorrer con el iterador");
        for (Integer num : numeros){
            System.out.println(num);
        }

        //===== METODOS CON PERSONAS =====
        ListaDobleEnlazada<Persona> personas = new ListaDobleEnlazada<>();
        personas.agregarUltimo(new Persona("Valentina", "123456"));
        personas.agregarUltimo(new Persona("Andrés", "78901"));
        personas.agregarUltimo(new Persona("Laura", "98765432"));
        personas.agregarUltimo(new Persona("Carlos", "55555"));

        System.out.println("\nLista original de personas:");;
        personas.mostrar();

        //Obtener personas con cedulas pares
        ListaDobleEnlazada<Persona> cedulasPares = personas.obtenerPersonasCedulaPar();
        System.out.println("Personas con cédula de cantidad de digitos par: ");
        cedulasPares.mostrar();
    }
}
