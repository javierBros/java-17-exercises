package concurrence;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/*Supongamos que queremos simular una carrera entre varios corredores, donde cada uno de ellos corre una determinada cantidad
  de metros. Queremos que la carrera empiece cuando todos los corredores estén listos, y que al finalizar la carrera se imprima
  el tiempo total que tardaron todos los corredores en llegar a la meta. Para ello, podemos utilizar un CyclicBarrier.

  Un CyclicBarrier es un objeto que permite que un grupo de hilos espere hasta que todos los hilos del grupo lleguen a un determinado
  punto de sincronización. Una vez que todos los hilos han llegado, se ejecuta una acción especificada en el constructor del objeto.

  En nuestro ejemplo, crearemos un CyclicBarrier que esperará a que todos los corredores estén listos antes de comenzar la carrera.
  Una vez que todos los corredores han llegado a la meta, el tiempo total de carrera se imprimirá en la consola.

  En este ejemplo, creamos una clase Carrera que contiene la constante NUM_CORREDORES para indicar la cantidad de corredores que participan
  en la carrera, y la constante DISTANCIA_CARRERA para indicar la cantidad de metros que deben correr. También creamos un CyclicBarrier
  llamado BARRERA que espera a que todos los corredores estén listos.

  Luego, creamos la clase interna Corredor, que extiende de Thread. En el método run de Corredor, cada corredor espera a que todos los
  corredores estén listos llamando al método await() de BARRERA. Una vez que todos los corredores están listos, se imprime un mensaje en la
  consola para indicar que comienza la carrera. Luego, cada corredor corre la distancia de la carrera, imprimiendo en la consola la cantidad de metros recorridos.

  Al finalizar la carrera, cada corredor imprime un mensaje en la consola indicando que ha llegado a la meta.

  Una vez que todos los corredores han llegado a la meta, se ejecuta la acción definida en el constructor de BARRERA, que en este caso es
  imprimir un mensaje en la consola indicando que todos los corredores han llegado a la meta y, por lo tanto, la carrera ha terminado.

  En resumen, el CyclicBarrier nos permite esperar a que todos los corredores estén listos antes de comenzar la carrera, y esperar a que
  todos los corredores lleguen a la meta antes de imprimir el tiempo total de la carrera. Esto asegura que la carrera se ejecute correctamente
  y que se muestre el resultado correcto al final.
  */

public class CyclicBarrierCompetenciaExercise {
    private static final int NUM_CORREDORES = 5;
    private static final int DISTANCIA_CARRERA = 100;
    private static final CyclicBarrier BARRERA = new CyclicBarrier(NUM_CORREDORES, () -> System.out.println("Todos los corredores han llegado a la meta"));

    public static void main(String[] args) {
        for (int i = 0; i < NUM_CORREDORES; i++) {
            Corredor corredor = new Corredor("Corredor " + i);
            corredor.start();
        }
    }

    static class Corredor extends Thread {
        private String nombre;

        public Corredor(String nombre) {
            this.nombre = nombre;
        }

        @Override
        public void run() {
            System.out.println(nombre + " está listo para correr");
            try {
                BARRERA.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println(nombre + " comienza a correr");
            for (int i = 1; i <= DISTANCIA_CARRERA; i++) {
                System.out.println(nombre + " ha recorrido " + i + " metros");
            }
            System.out.println(nombre + " ha llegado a la meta");
        }
    }
}
