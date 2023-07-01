import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;

public class OptionalExercises {
    public static void main (String... args){
        Optional<String> opt1 = Optional.of("Prueba");
        //Optional<String> opt2 = Optional.of(null);//Error
        Optional<String> opt3 = Optional.ofNullable(null);
        Optional<String> opt4 = Optional.empty();

        System.out.println(opt1.isPresent());
        System.out.println(opt1.isEmpty());
        opt1.ifPresent(n->System.out.println("Opt1 si contiene un valor y es:"+n));// Recibe una interfaz Consumer
        Optional<String> optMethodOr = opt3.or(() -> Optional.of("HolaMundo"));// Recibe una interfaz Supplier que debe retornar otro Optional, si no está vacío retorna retrona ese mismo valor envuelto en un Optional, de lo contrario retorna el valor que se le retorna en la función del supplier, también envuelto en un Optiopnañ
        System.out.println("Resultado del método or():"+optMethodOr.get());

        System.out.println(opt3.isPresent());
        System.out.println(opt3.isEmpty());

        System.out.println(opt1.get());
        //System.out.println(opt3.get());// error

        System.out.println(opt1.orElse("Opt1 Sin valor"));
        System.out.println(opt3.orElse("Opt3 Sin valor"));

        System.out.println(opt3.orElseGet(OptionalExercises::printSomething));// Recibe una interfaz Supplier

        System.out.println(opt1.map(String::toUpperCase));

        //OptionalInt y OptionalDouble para tipos primitivos
        OptionalInt optInt = OptionalInt.of(1);
        OptionalDouble optDouble = OptionalDouble.of(1.3);
    }

    static String printSomething(){
        String s = "something";
        System.out.println(s);
        return s;
    }
}
