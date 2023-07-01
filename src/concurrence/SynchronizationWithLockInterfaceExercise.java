package concurrence;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SynchronizationWithLockInterfaceExercise {
    static Cont cont = new Cont();
    static Lock lc = new ReentrantLock();

    public static void main (String... args) {
        synchronized (Object.class){

        }
        ExecutorService ex = Executors.newCachedThreadPool();// Crea un ExecutorService con un pool de treads variable que se crean a demanda
        for (int i=0; i<1000; i++){
            ex.submit(()->{
                lc.lock();// Bloquea acceso al código a otros hilos
                try {
                    int tmp = cont.getValue();
                    tmp++;
                    cont.setValue(tmp);
                    System.out.println(tmp);
                } finally {
                    lc.unlock();// Desbloquea acceso al código
                }
            });
        }
        ex.shutdown();
    }
    // Hacer la prueba quitando y poniendo el bloqueo de codigo. Cuando se quita el bloqueo de código con lock() y unlock(), la secuencia del contador se imprime de forma desordenada, porque todos los hilos acceden sin ningún tipo de control generando inconsistencias(condición de carrera) en el objeto estático que se manipula y se imprime.
    // condiciones de carrera(Que otros hilos accedan al mismo objeto o valor en el mismo instante, alterando su comportamiento, generando resultados anómalos o inconsistencias).

    //Una condición de carrera (race condition) ocurre cuando dos o más hilos de ejecución acceden a un recurso compartido al mismo tiempo, lo que puede llevar a resultados inesperados o incorrectos en la aplicación. La mayoría de las veces, no se producen excepciones específicas cuando ocurre una condición de carrera, lo que hace que sea difícil de detectar y depurar.
    //
    //En lugar de eso, los efectos de una condición de carrera pueden manifestarse de varias maneras, dependiendo de la naturaleza del recurso compartido y cómo se accede a él. Algunos ejemplos comunes incluyen:
    //
    //El valor de una variable compartida puede ser diferente de lo que se esperaba, ya que cada hilo puede leer o escribir en ella en momentos diferentes.
    //Una operación de escritura en un archivo compartido puede sobrescribir el contenido de otra operación de escritura anterior, produciendo un archivo corrupto.
    //Una transacción en una base de datos puede ser interrumpida o anulada por otra transacción que intenta acceder a los mismos datos al mismo tiempo, produciendo resultados inconsistentes.
}

class Cont{
    int value;
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}