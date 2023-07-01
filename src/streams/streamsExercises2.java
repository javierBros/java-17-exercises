package streams;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class streamsExercises2 {
    public static void main (String... args){
        //Conteo y procesado
        /*
        Stream<Integer> st = Stream.of(2,5,7,3,6,2,3);
        st.forEach(System.out::println);
        System.out.println(st.count());// error porque se cierra el stream con el primer uso. Count() es un método final que devuelve el total de elementos
        */

        //EXTRACCION DE DATOS
        /*
        Stream<Integer> st = Stream.of(2,5,7,3,6,2,3);
        System.out.println(st.distinct().count());// distinc() método intermedio que devuelve un stream quitando los elementos duplicados, basado en el metodo equals()
        */
        /*
        Stream<Integer> st = Stream.of(2,5,7,3,6,2,3);
        Stream<Integer> st2 = st.limit(3);// limit()  método intermedio que devuelve un stream dejando únicamente los primeros n elementos
        st2.forEach(System.out::println);
        */
        /*
        Stream<Integer> st = Stream.of(2,5,7,3,6,2,3);
        Stream<Integer> st2 = st.skip(3);// skip() método intermedio que devuelve un stream saltando los n primeros elementos
        st2.forEach(System.out::println);
        */

        //COMPROBACIONES, utilizando la interface Predicate<? super T> predicate
        /*
        Stream<Integer> st = Stream.of(2,5,7,3,6,2,3);
        //Ir comentando cada vez que se usa el stream para que no se cierre. Todos funcionan en modo corto circuito
        System.out.println("Alguno mayor a 5?: " + st.anyMatch(n->n>5));
        System.out.println("Alguno mayor a 5?: " + st.allMatch(n->n>5));
        System.out.println("Alguno mayor a 5?: " + st.noneMatch(n->n>5));
        */
        /*/
        //Ejercicio que comprueba que exista un nombre que termine con la letra 'd'
        Stream<String> nombres = Stream.of("Mario","Ana","David","Belén");
        System.out.println("Algun nombre finaliza con la letra d?: " + nombres.anyMatch(n -> n.endsWith("d")));
        */

        //FILTRADO, utilizando la interface Predicate<? super T> predicate
        /*
        Stream<Integer> st = Stream.of(2,5,7,3,6,2,3);
        System.out.println(st.distinct().filter(n->n>6).count());// filter() es un método intermedio que retorna un stream con los elementos que cumplen la condición que se envía como parámetro
        */
        /*
        //findFirst() método final que devuelve el primer elemento del stream, envuelto en un Optional
        Stream<Integer> st = Stream.of(2,5,7,3,6,2,3);
        Optional<Integer> opt = st.findFirst();
        System.out.println(opt.orElse(-1));
        */
        //findAny() método final que devuelve cualquiera de los elementos del stream, envuelto en un Optional

        //OBTENCIÓN DE EXTTREMOS, utilizando la interface Comparator<? super T> comparator
        /*
        Stream<Integer> st = Stream.of(20,5,8,3,9);
        Optional<Integer> op = st.max((a,b) -> a-b);// max() es un método final que retorna el mayor valor envuelto en un Optional, haciendo uso de la Interface Comparator
        System.out.println(op.orElse(-1));
        */
        // mix() es un método final contrario al método max()

        //TRANSFORMACION, utilizando la interface Function<? super T,? extends R> mapper
        /*
        Stream<String> nombres = Stream.of("Mario","Ana","David","Belén");
        nombres.map(String::toUpperCase);// map() es un método intermedio que que transforma cada elemento del Stream definido por el objeto Function que se le pasa como parámetro
         */
        /*
        Stream<String> nombres = Stream.of("Mario","Ana","David","Belén");
        System.out.println(nombres.mapToInt(String::length).sum());// mapToInt() es un método intermedio que transforma cada elemento de un stream a Int, devolviendo un IntStream
                                                                   // método sum() es un método terminal(final) que devuelve la suma de todos los elementos del IntStream
        */

        //TRANSFORMACION Y APLANAMIENTO, haciendo uso de la interface funcional
        /*
        List<List<String>> datos = Arrays.asList(Arrays.asList("Ana","David","Belén"),
                                                 Arrays.asList("Juan","Pedro","Jon"));
        long cantidadElementos = datos.stream().flatMap(l-> l.stream().map(s->s.length())).filter(size->size>4).count();// flatMap() es un método intermedio que devuelve un nuevo Stream resultante de unir los Streams generados
        System.out.println(cantidadElementos);
        */
        //Ejercicio: escribir un bloque de código que muestre el mayor de todos los números de dicho array
        /*
        Integer[][] datos = {{8,3,5},{2,11,7},{4,1,9,6}};
        int max = Arrays.stream(datos).flatMap(l-> Arrays.stream(l)).max((a, b)->a-b).get();
        System.out.println(max);
         */

        //PROCESAMIENTO INTERMEDIO, Utiliza un (Consumer<? super T> proceso
        /*
        Stream<Integer> st = Stream.of(20,5,8,3,9,10,14);
        st.filter(n -> n%2==0)
                .peek(n->System.out.println("par: "+ n))// el método peek() es un método intermedio que me permite realizar alguna acción a cada elemento del stream y devuelve un stream idéntico para seguir trabajando con él
                .filter(n -> n > 11)
                .peek(n->System.out.println("mayores a once: "+ n))
                .forEach(System.out::println); // el método peek() actúa en modo lazy, es decir, necesita una operación final (como forEach()) para que se lleve a término
        */
        /* Ya que existen dos llamados a peek(), su lógica se imprime al momento de llamar la operación final, en este caso forEach() haciendo que se imoriman los valores que quedaban después de cada filtro respectivamente
        par: 20
        mayores a once: 20
        20
        par: 8
        par: 10
        par: 14
        mayores a once: 14
        14
        */
        /*
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);
        numeros.stream()
                .peek(n -> System.out.println("Antes de filtro: " + n))
                .filter(n -> n % 2 == 0)
                .peek(n -> System.out.println("Después de filtro: " + n))
                .forEach(System.out::println);
        */
        /*
        Antes de filtro: 1
        Antes de filtro: 2
        Después de filtro: 2
        2
        Antes de filtro: 3
        Antes de filtro: 4
        Después de filtro: 4
        4
        */
        //Ejercicio
        /*
        Stream<Integer> st = Stream.of(20,5,8,3,9);
        st.filter(n -> n%2==0)
                .peek(n->System.out.println("par: "+ n));// No se imprime nada porque el método peek() actúa en modo lazy, es decir, necesita una operación final para que se lleve a término
        */
        //Ejercicio 2
        /*
        Stream<Integer> st = Stream.of(20,5,8,3,9);
        st.filter(n -> n%2==0)
                .peek(System.out::println).allMatch(n->n>5);// El método peek() solo imprime los números que cumplen la condición de n>5, porque el método allMatch actúa en modo corto circuito
        */

        //ORDENACION, utilizando la interfaz funcional Comparator(? super T) comparator (se puede aplicar sin o con dicha interfaz)
        /*
        Stream<String> st = Stream.of("casa","pelota","lampara","disco");
        st.sorted().forEach(System.out::println);// el método sorted() SIN parámetros es una operación interemdia que ordena los elementos por su orden natural
        */
        /*
        Stream<String> st = Stream.of("casa","pelota","lampara","disco");
        //Los ordena de acuerdo a la cantidad de caracteres
        st.sorted((a,b)-> a.length()-b.length()).forEach(System.out::println);// el método sorted() CON parámetro es una operación interemdia que ordena los elementos de acuerdo a la función que se envíe con la interfaz Comparator
        */

        //REDUCCION, con la interfaz BinaryOperator<T> accumulator
        /*
        Stream<Integer> nums = Stream.of(20,5,8,3,9);
        // El método reduce() es una operación terminal que realiza la reducción de los elementos del stream a un único valor(envuelto en un Optional), utilizando la función proporcionada como parámetro de la interfaz BinaryOperator
        System.out.println(nums.reduce((a,b)->Integer.sum(a,b)).orElse(0));
        */

        //Ejercicio: Sumar los tres numeros pares más pequeños del stream
        /*
        Stream<Integer> nums = Stream.of(11,20,5,8,3,9,4,10,2);
        System.out.println(nums.sorted().filter(v->v%2==0).limit(3).reduce(Integer::sum).get());
        */

        //REDUCCION A COLECCION, con la clase Collector<? super T,A,R> collector
        /*
        Stream<Integer> nums = Stream.of(11,20,5,8,3,9,4,10,2);
        List<Integer> lista = nums.distinct().collect(Collectors.toList());// El método collect() es una operación final que retorna un List, Map o Set con los datos del Stream, en función de la implementación de Collector proporcionada
        */
        /*
        Stream<Libro> nums = Stream.of(new Libro(1,"Libro 1"),new Libro(2,"Libro 2"), new Libro(3,"Libro 3"));
        Map<Integer,String> mapa = nums.collect(Collectors.toMap(l->l.id, l->l.nombre));// El método collect() para Maps es una operación final que retorna un Map, pide dos parámetros que son dos funciones de la interfaz Function<? super T, ? extends K>
        mapa.forEach((k,v)->System.out.println(v));
        */

        //AGRUPACION
        /*
        Stream<Libro> nums = Stream.of(new Libro(1,"Libro 1",100),
                new Libro(2,"Libro 2",100),
                new Libro(3,"Libro 3", 200),
                new Libro(4,"Libro 4", 300));

        Map<Integer,List<Libro>> librosFiltradosPorNumPaginas = nums.collect(Collectors.groupingBy(l->l.numPaginas));// groupingBy() es una operación intermedia que clasifica los objetos de acuerdo a un atributo, retornando un mapa, donde la clave es el atributo y el valor es la lista elementos que coinciden o contienen ese atributo
        librosFiltradosPorNumPaginas.forEach((k,v)->System.out.println("Llave(Cantidad de páginas):"+k+" - Valor(Lista de libros con esa cantidad de páginas)"+v));
                                              //Biconsumer Interface
         */

        //PARTICION
        /*
        Stream<Libro> streamLibros = Stream.of(new Libro(1,"Libro 1",100),
                new Libro(2,"Libro 2",100),
                new Libro(3,"Libro 3", 200),
                new Libro(4,"Libro 4", 300));

        Map<Boolean,List<Libro>> libros = streamLibros.collect(Collectors.partitioningBy(l->l.numPaginas<150));// partitioningBy() es una operación intermedia que clasifica los objetos de acuerdo a la condicion Predicate que se envíe, retornando un mapa, este contará con dos agrupaciones, uno con llave true con los elementos que cumplen la condición y otro con llave false donde estarán los elementos que no la cumplen
        System.out.println("Los que tienen menos de 150 páginas : "+libros.get(true));
        System.out.println("Los que tienen 150 o más páginas : "+libros.get(false));
        */
        /*
        List<Estudiante> estudiantes = Arrays.asList(
        new Estudiante("Juan", 80),
        new Estudiante("María", 55),
        new Estudiante("Pedro", 70),
        new Estudiante("Sofía", 40),
        new Estudiante("Lucas", 90)
        );

        Map<Boolean, Long> aprobados = estudiantes.stream()
                .collect(Collectors.partitioningBy(e -> e.getNota() >= 60, Collectors.counting()));// partitioningBy() con dos parámetros es una operación intermedia hace lo mismo que el que recibe un parámetro. El segundo parámetro recibe un Collector

        System.out.println("Número de estudiantes aprobados: " + aprobados.get(true));
        System.out.println("Número de estudiantes no aprobados: " + aprobados.get(false));
        */

        //OTRAS IMPLEMENTACIONES DE COLLECTOR
        /*
        Stream<Libro> streamLibros = Stream.of(new Libro(1,"Libro 1",100),
                new Libro(2,"Libro 2",100),
                new Libro(3,"Libro 3", 200),
                new Libro(4,"Libro 4", 300));
        System.out.println(streamLibros.map(l->l.nombre).collect(Collectors.joining(",","preffix","suffix")));
        */
        /*
        Stream<Libro> streamLibros = Stream.of(new Libro(1,"Libro 1",100),
                new Libro(2,"Libro 2",100),
                new Libro(3,"Libro 3", 200),
                new Libro(4,"Libro 4", 300));
        System.out.println(streamLibros.collect(Collectors.averagingDouble(l-> l.numPaginas)));// averagingDouble() es una operacion terminal que retorna el promedio del atributo que se escoja en la función de la nterfaz ToDoubleFunction<? super T> mapper
        */
        /*
        Stream<Libro> streamLibros = Stream.of(new Libro(1,"Libro 1",100),
                new Libro(2,"Libro 2",100),
                new Libro(3,"Libro 3", 200),
                new Libro(4,"Libro 4", 300));
        System.out.println(streamLibros.collect(Collectors.summingInt(l-> l.numPaginas)));// summingInt() es una operacion terminal que retorna la suma del atributo que se escoja en la función de la interfaz ToIntFunction<? super T> mapper
        */

        //Exercises
        /*
        Stream<Integer> st = Stream.of(1,2,3,4,5).map( n -> n * n).sorted();
        st.forEach(System.out::println);
        st.filter(n -> n > 1).forEach(System.out::println); // presenta error porque el stream está agotado
        */
        /*
        1
        4
        9
        16
        25
        Exception in thread "main" java.lang.IllegalStateException: stream has already been operated upon or closed
        */
        /*
        OptionalDouble optDouble = Stream.of(1,2,3,4,5).mapToDouble(Double::valueOf).average();// el método average() es un método final que retorna promedio de los elementos de un doubleStream dentro de un objeto OptionalDouble
        System.out.println(optDouble.orElse(-1.0));
        */
        /*
        //Uso del método comparing()
        List<Libro> libros = new ArrayList<>();
        libros.add(new Libro(1,"Libro 1",100));
        libros.add(new Libro(2,"Libro 2",100));
        libros.add(new Libro(3,"Libro 3", 200));
        libros.add(new Libro(4,"Libro 4", 300)); // lista de personas
        Comparator<Libro> comparadorPorNumeroDePaginas = Comparator.comparing(Libro::getNumPaginas);// la función comparing() devuelve un comparador para comparar objetos en función de una propiedad específica.
        Collections.sort(libros, comparadorPorNumeroDePaginas);
        libros.forEach(l -> System.out.println(l.getNombre()+" - "+l.getNumPaginas()));
        */

        //Uso del método maxBy() de BinaryOperator
        BinaryOperator<Integer> operador = BinaryOperator.maxBy(Comparator.naturalOrder());//La función maxBy es un método estático definido en la interfaz BinaryOperator en Java. Toma dos objetos y devuelve el mayor de los dos, según un criterio de comparación especificado mediante un comparador.
        Integer maximo = operador.apply(10, 5);
        System.out.println(maximo); // Imprime 10
    }
}

class Libro{
    Integer id;
    String nombre;
    Integer numPaginas;

    public Libro(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Libro(Integer id, String nombre, Integer numPaginas) {
        this.id = id;
        this.nombre = nombre;
        this.numPaginas = numPaginas;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "nombre='" + nombre +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getNumPaginas() {
        return numPaginas;
    }
}
