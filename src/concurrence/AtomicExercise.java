package concurrence;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicExercise {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(); // Hace parte del conjunto de clases para operar sobre una variable int simple en un entorno multitarea en modo trhead safe.
        // A difrencias de las clases envoltorio , garantizan la integridad de los datos en entorno multitarea.
        // Utilizan internamente variables volatile(acceso directo a memoria) para grantizar la integridad de los datos
        // Las principales clases son AtomicBoolean, AtomicInteger y AtomicLong
        System.out.println(atomicInteger.incrementAndGet());
        System.out.println(atomicInteger.decrementAndGet());
        System.out.println(atomicInteger.addAndGet(2));
        System.out.println(atomicInteger.get());
        System.out.println("\n\n");

        AtomicBoolean atomicBoolean = new AtomicBoolean();
        System.out.println(atomicBoolean.get());
        atomicBoolean.set(true);
        System.out.println(atomicBoolean.get());
        atomicBoolean.compareAndSet(true,false);// compara con el primer parámetro(expectedValue), si coincide se asigna el valor del segundo parámetro
        System.out.println(atomicBoolean.get());
        atomicBoolean.compareAndSet(true,true);// compara con el primer parámetro(expectedValue), si coincide se asigna el valor del segundo parámetro
        System.out.println(atomicBoolean.get());
        System.out.println("\n\n");

        ExecutorService es = Executors.newFixedThreadPool(3);
        AtomicInteger ai = new AtomicInteger();
        for(int i=1; i<=10;i++){
            es.submit(()->System.out.print(ai.incrementAndGet()+","));// se van a imprimir los números del 1 al 10 pero con orden impredescible
        }
        es.shutdown();
    }
}
