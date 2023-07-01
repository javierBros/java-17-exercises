package streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class streamsExercises {
    public static void main (String... args){
        Stream<Integer> stream = Stream.of(1,2,3,4,5).map(i -> i*i).sorted();
        stream.forEach(System.out::println);
        //stream.filter(n->n>1).forEach(System.out::println);//Error

        //Stream de un array
        String[] cads = {"a","xy","jk","mv"};
        Stream<String> st = Arrays.stream(cads);

        //Stream de un array
        Stream<Double> std = Stream.of(2.4,7.4,9.1);

        //A partir de una rango de datos
        IntStream stint = IntStream.range(1,10);
        IntStream stint2 = IntStream.rangeClosed(1,10);
        stint.forEach(System.out::print);
        stint2.forEach(System.out::print);

        //Predicate<T>: Una interfaz funcional que representa una función que toma un argumento de tipo T y devuelve un valor booleano. Se utiliza comúnmente para filtrar elementos de un Stream.
        Predicate<Integer> isEven = n -> n % 2 == 0;
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> evenNumbers = numbers.stream().filter(isEven).collect(Collectors.toList());

        //Function<T, R>: Una interfaz funcional que representa una función que toma un argumento de tipo T y devuelve un resultado de tipo R. Se utiliza comúnmente para transformar elementos de un Stream.
        Function<String, Integer> strToInt = str -> Integer.parseInt(str);
        List<String> strings = Arrays.asList("1", "2", "3", "4", "5");
        List<Integer> integers = strings.stream().map(strToInt).collect(Collectors.toList());

        //Consumer<T>: Una interfaz funcional que representa una función que toma un argumento de tipo T y no devuelve ningún valor. Se utiliza comúnmente para realizar una operación en cada elemento de un Stream.
        Consumer<String> printString = str -> System.out.println(str);
        strings = Arrays.asList("Hello", "World", "!");
        strings.stream().forEach(printString);

        //Supplier<T>: Una interfaz funcional que representa una función que no toma ningún argumento y devuelve un valor de tipo T. Se utiliza comúnmente para generar valores para un Stream.
        Supplier<Integer> generateRandomNumber = () -> (int) (Math.random() * 100);
        List<Integer> randomNumbers = Stream.generate(generateRandomNumber).limit(10).collect(Collectors.toList());

        //BiFunction<T, U, R>: Una interfaz funcional que representa una función que toma dos argumentos, uno de tipo T y otro de tipo U, y devuelve un resultado de tipo R. Se utiliza comúnmente para combinar dos Streams.
        BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
        List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> numbers2 = Arrays.asList(6, 7, 8, 9, 10);
        //List<Integer> sum = Stream.zip(numbers1, numbers2, add).collect(Collectors.toList());

        //BinaryOperator<T>: Es una interfaz funcional en Java que representa una operación binaria que toma dos argumentos del mismo tipo y devuelve un resultado del mismo tipo. Es similar a la interfaz BiFunction<T, T, T>, pero con la restricción de que los argumentos y el resultado deben ser del mismo tipo.
        //La interfaz BinaryOperator<T> se utiliza comúnmente en las com.operaciones de reducción en las colecciones de Java, donde se requiere una función que combine dos elementos del mismo tipo en uno solo. Por ejemplo, en una operación de suma de una lista de enteros, se podría usar un objeto BinaryOperator<Integer> para sumar dos enteros y devolver el resultado.
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);
        BinaryOperator<Integer> sumador = (a, b) -> a + b;
        int sumaTotal = numeros.stream().reduce(0,sumador);
    }


}
