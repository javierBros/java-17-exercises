package concurrence;

import java.util.concurrent.*;

/*Supongamos que estamos desarrollando un sistema de registro de eventos donde múltiples hilos pueden escribir en una lista de
  eventos y, simultáneamente, otros hilos pueden leer de la lista de eventos. En este caso, necesitamos una estructura de datos
  que nos permita agregar eventos de forma segura desde varios hilos y que, al mismo tiempo, permita que otros hilos lean de ella
  sin bloqueo. Aquí es donde entra en juego CopyOnWriteArrayList.

  CopyOnWriteArrayList es una lista segura para subprocesos en la que la operación de escritura crea una copia de la lista original
  y escribe en ella. La lista original no se modifica y los lectores pueden seguir accediendo a ella sin bloqueo. Una vez que se
  completa la operación de escritura, la lista original se reemplaza con la copia modificada.

  En el siguiente ejemplo, creamos una lista de eventos eventList como una instancia de CopyOnWriteArrayList. Luego, creamos dos
  hilos diferentes: uno para agregar eventos y otro para imprimir los eventos en la lista.

  En este ejemplo, el hilo de escritura agrega 10 eventos a la lista y el hilo de lectura imprime los eventos en la lista. Al
  utilizar CopyOnWriteArrayList, podemos garantizar que el hilo de lectura puede acceder a la lista sin bloquear, incluso si el
  hilo de escritura está agregando eventos simultáneamente.

  Si en lugar de CopyOnWriteArrayList se deja un ArrayList, se podría producir una inconsistencia en la informacion de esta lista
  que comparten varias tareas, incluso una excepción coo ConcurrentModificationException. Esto ocurre porque ArrayList no es thread safe
  y no maneja un control interno de escritura y lectura pudiendo provocar estos problemas.
 */

public class    CopyOnWriteArrayListExercise {
        private CopyOnWriteArrayList<String> eventList = new CopyOnWriteArrayList<>(); // Variante de ArrayList para entornos thread safe
        ConcurrentMap<String, String> concurrentMap = new ConcurrentHashMap<>(); // Subinterfaz de Map que garantiza operaciones thread safe en un entorno multitarea. Su principal implementación es ConcurrentHashMap
        CopyOnWriteArraySet<String> arraySet = new CopyOnWriteArraySet<>();// Variante de HashSet para entornos thread safe. Internamente utiliza un CopyOnWriteArrayList para realizar operaciones.
        ConcurrentSkipListSet<String> concurrentSkipListSet = new ConcurrentSkipListSet<>();// Variante de TreeSet basada en una lista enlazada, en la que cada elemento tiene varios punteros que apuntan a otros elementos en la lista. Esta estructura permite una rápida inserción, eliminación y búsqueda de elementos, incluso en hilos múltiples.

        public void agregarEvento(String evento) {
            eventList.add(evento);
        }

        public void imprimirEventos() {
            try {
                Thread.sleep(10L);// Se agrega este sleep para que el evento de lectura empiece a leer cuando se hayan agregado algunos elementos en el eventList
                for (String evento : eventList) {
                    System.out.println(evento);
                }
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        }

        public static void main(String[] args) throws InterruptedException {
            CopyOnWriteArrayListExercise eventLog = new CopyOnWriteArrayListExercise();

            // Hilo de escritura
            Thread escritor = new Thread(() -> {
                for (int i = 0; i < 10000; i++) {
                    eventLog.agregarEvento("Evento " + i);
                }
            });

            // Hilo de lectura
            Thread lector = new Thread(eventLog::imprimirEventos);

            lector.start();
            escritor.start();
        }

}