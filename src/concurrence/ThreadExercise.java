package concurrence;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ThreadExercise extends Thread{
    public void run(){
        IntStream.range(1,10).forEach(System.out::println);
    }
    public static void main (String... args){
        ThreadExercise task1 = new ThreadExercise();
        ThreadExercise task2 = new ThreadExercise();
        task1.start();
        task2.start();
    }
}
