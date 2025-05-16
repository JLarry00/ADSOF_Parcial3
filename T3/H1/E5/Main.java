import java.util.*;

import Conjuntos.*;

public class Main {
    public static void main(String ... args ) {
        ConjuntoInfinito<Integer> pares = // Conjunto infinito de los números pares
                                            new ConjuntoInfinito<>( x -> x % 2 == 0, // condición de pertenencia al conjunto
                                            0, // elemento inicial (no necesariamente debe cumplir la condición)
                                            n -> n + 1); // Calcula el próximo elemento a considerar
        RecorreConjunto<Integer> rec = pares.getRecorreConjunto();
        int num = 0;
        while ( num ++ < 20) { // imprime los 20 primeros elementos
            System.out.print( rec.elementoActual()+ " " ); // imprime el elemento actual
            rec.avanza(); // avanza al siguiente elemento
        }
        SortedSet<Integer> conjuntoNormalOrdenado = pares.toSet(5); // Convertir a un conjunto normal ordenado...
        System.out.println( conjuntoNormalOrdenado ); // ... que se trunca a 5 elementos
        System.out.println( pares.toStream(5).reduce(0, (x, y) -> x+y)); // obtiene stream de longitud 5 y suma
    }
}