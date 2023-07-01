package concurrence;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExercises {

    public static void main (String... args){
        ExecutorService ex = Executors.newCachedThreadPool();// Crea un ExecutorService con un pool de treads variable que se crean a demanda
        ex.submit(()->System.out.println("Hola"));// el método submit() lanza la tarea y la pone en ejecución concurrente con el resto de tareas
        ex.submit(()->System.out.println("Bye"));
        ex.shutdown();// El método shutdown() me permite terminar la ejecución, si no se llama, el método no finaliza
        /*
        Executors.newFixedThreadPool(2); // Crea un pool(ExecutorService) de treads con un número fijo de hilos
        Executors.newSingleThreadExecutor(); // Crea un ExecutorService que utiliza un único Thread
        Executors.newScheduledThreadPool(2); // Devuelve un ScheduledExecutorService que permite ejecutar tareas periódicamente
        */

        // Exercise
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.execute(()-> System.out.println("1"));
        //System.out.println(es.execute(()->"2")); // No compila porque execute solo recibe interface Runnable que no retorna ningun parámetro
        es.submit(()->System.out.println("3"));
        System.out.println(es.submit(()->"4"));
    }
}
