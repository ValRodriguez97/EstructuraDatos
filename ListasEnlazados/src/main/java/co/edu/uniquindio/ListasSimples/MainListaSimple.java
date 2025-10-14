package co.edu.uniquindio.ListasSimples;

public class MainListaSimple {
    public static void main(String[] args) {

        /**
         * Metodos que involucran numeros
         */
        System.out.println("==== LISTAS CON NUMEROS ====");
        ListaSimpleEnlazada<Integer> numeros = new ListaSimpleEnlazada<>();

        numeros.agregarUltimo(2);
        numeros.agregarUltimo(3);
        numeros.agregarUltimo(4);
        numeros.agregarUltimo(5);
        numeros.agregarUltimo(6);
        numeros.agregarPrimero(7);
        numeros.agregarSegunPosicion(9,2);

        System.out.println("Lista original: ");
        numeros.mostrar();

        // Obtener elementos en posiciones impares
        ListaSimpleEnlazada<Integer> impares = numeros.obtenerElementosPosicionesImpares();
        System.out.println("Elementos en posiciones impares: ");
        impares.mostrar();

        // Eliminar números pares
        numeros.eliminarNumerosPares();
        System.out.println("Lista despues de eliminar numeros pares");
        numeros.mostrar();

        // Obtener numeros impares
        ListaSimpleEnlazada<Integer> numerosImpares = numeros.obtenerNumerosImpares();
        System.out.println("Lista con numeros impares: ");
        numerosImpares.mostrar();

        // Contar cuantas veces se repite un valor
        int repeticion = numeros.contarValorRepetido(5);
        System.out.println("El número 5 se repite " + repeticion + " veces");

        /**
         * Métodos que involucran personas
         */
        System.out.println("\n===== PRUEBA CON PERSONAS =====");
        ListaSimpleEnlazada<Persona> personas = new ListaSimpleEnlazada<>();

        personas.agregarUltimo(new Persona("Valentina", "12345678"));
        personas.agregarUltimo(new Persona("Francisco", "13579"));
        personas.agregarUltimo(new Persona("Michelle", "87654321"));
        personas.agregarUltimo(new Persona("Juan", "24681012"));
        personas.agregarUltimo(new Persona("Ana", "987654"));

        System.out.println("Lista original: ");
        personas.mostrar();

        // Obtener personas con cédula de longitud par
        ListaSimpleEnlazada<Persona> cedulaPares = personas.obtenerCedulasPares();
        System.out.println("Personas con cédula de longitud par ");
        cedulaPares.mostrar();

        //Obtener personas en posiciones impares
        ListaSimpleEnlazada<Persona> personasImpares = personas.obtenerElementosPosicionesImpares();
        System.out.println("Personas en posiciones impares: ");
        personasImpares.mostrar();

        //Concatenar dos listas
        ListaSimpleEnlazada<Integer> lista1 = new ListaSimpleEnlazada<>();
        lista1.agregarUltimo(1);
        lista1.agregarUltimo(2);
        lista1.agregarUltimo(3);

        ListaSimpleEnlazada<Integer> lista2 = new ListaSimpleEnlazada<>();
        lista2.agregarUltimo(4);
        lista2.agregarUltimo(5);

        ListaSimpleEnlazada<Integer> listaConcatenada = ListaSimpleEnlazada.concatenarListas(lista1, lista2);
        listaConcatenada.mostrar();

    }
}
