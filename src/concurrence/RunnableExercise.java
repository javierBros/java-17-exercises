package concurrence;

import java.util.concurrent.Executor;
import java.util.stream.IntStream;

public class RunnableExercise implements Runnable{
    @Override
    public void run() {
        IntStream.range(1,10).forEach(System.out::println);
    }
    public static void main (String... args){
        Thread task1 = new Thread(new RunnableExercise());
        Thread task2 = new Thread(new RunnableExercise());
        task1.start();
        task2.start();
    }
}
