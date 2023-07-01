package concurrence;

import java.util.Collection;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CallableExercise {
    public static void main (String... args) throws ExecutionException, InterruptedException {
        Callable<Integer> callb = () -> { // Esta interface es igual que Runnable, con la diferencia de que el método abstracto se llama call() y retorna objeto de tipo Future, además de poder declarar checked Exceptions.
            return IntStream.rangeClosed(1,100).reduce(0,Integer::sum)  ;
        };
        ExecutorService ex = Executors.newCachedThreadPool();
        Future<Integer> future = ex.submit(callb);// Future: Una vez lanzada una tarea, que se ejecuta concurrentemente con otras, esta interfaz nos va a permitir controlar si la ejecución ha terminado o poder obtener el valor devuelto de esa tarea.
        // A diferencia del método execute(), submit() puede recibir Runnable o Callable como parámetro, lo que le permite retornar o no, mientras que execute() solo puede lanzar tareas y no retorna nada.
        while(!future.isDone()){// El método isDone() de la interface Future me permite comprobar que la tarea ha finalizado.
            System.out.println("Esperando fin de la tarea");
        }
        System.out.println("El resultado de la tarea es "+future.get());// El método get() de la interface Future me retorna el valor que generado por el Callable. Si aún no ha terminado la tarea, queda a la espera del resultado.
        ex.shutdown();
    }
}
