package collections;

import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

public class ConcurrentSkipListSetExample {
    public static void main(String[] args) {
        Set<String> set = new ConcurrentSkipListSet<>();// ConcurrentSkipListSet es una implementación de la interfaz Set en Java que proporciona una estructura de datos concurrente y ordenada que permite la inserción, eliminación y búsqueda de elementos de forma eficiente y segura en hilos múltiples.
        // Es similar a un TreeSet en el sentido de que almacena los elementos en orden ascendente o descendente, pero a diferencia de un TreeSet, ConcurrentSkipListSet es thread-safe y puede ser utilizado de forma segura por múltiples hilos concurrentemente.
        set.add("orange");
        set.add("banana");
        set.add("apple");

        System.out.println(set); // Output: [apple, banana, orange]

        if (set.contains("apple")) {
            set.remove("apple");
        }

        System.out.println(set); // Output: [banana, orange]
    }
}
