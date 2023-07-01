package collections;

import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;

public class ConcurrentSkipListMapExample {
    public static void main(String[] args) {
        // Crea un nuevo ConcurrentSkipListMap
        Map<String, Integer> map = new ConcurrentSkipListMap<>();// ConcurrentSkipListMap es una buena opción si necesitas una implementación de Map que sea thread-safe y que mantenga los elementos ordenados por sus claves. Sin embargo, ten en cuenta que el rendimiento de las operaciones en ConcurrentSkipListMap puede ser menor que en HashMap u otras implementaciones de Map no thread-safe, debido a la necesidad de mantener la estructura de lista enlazada jerárquica.
        // La estructura de datos subyacente de un ConcurrentSkipListMap es una lista enlazada jerárquica, que permite una alta concurrencia en operaciones de lectura y escritura. Cada nivel de la lista enlazada es una sublista de los elementos de nivel anterior, pero saltando algunos elementos para reducir la cantidad de elementos a buscar en cada nivel. Este proceso de salto es controlado por una estructura de datos conocida como "skip list".
        // A diferencia de TreeMap, ConcurrentSkipListMap no utiliza un árbol binario de búsqueda para ordenar sus elementos, sino una estructura de listas enlazadas jerárquicas y aleatorias. Esta estructura es eficiente en términos de concurrencia y puede manejar eficazmente grandes cantidades de operaciones de lectura y escritura concurrentes.

        // Agrega algunos elementos
        map.put("Juan", 10);
        map.put("Pedro", 5);
        map.put("Maria", 8);
        map.put("Luis", 3);
        map.put("Ana", 12);

        // Imprime el contenido del mapa
        System.out.println("Contenido del mapa: " + map);

        // Actualiza el valor de una clave
        map.put("Luis", 7);

        // Imprime el contenido del mapa actualizado
        System.out.println("Contenido del mapa actualizado: " + map);

        // Elimina una clave y su valor
        map.remove("Maria");

        // Imprime el contenido del mapa actualizado
        System.out.println("Contenido del mapa actualizado: " + map);
    }
}
