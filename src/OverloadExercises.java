import java.io.FileNotFoundException;

public class OverloadExercises {
    public static void main (String []argh) throws FileNotFoundException {
        var overloadExercises = new OverloadExercises();
        Integer IntegerValue = 1;
        overloadExercises.test(IntegerValue);
        overloadExercises.test(1);
        //overloadExercises.test(null);Marca error si hay dos métodos sobrecargados con enteros wrapper, uno esperando Long y el otro Integer
        Long LongValue = 3L;
        overloadExercises.test(LongValue);//Para pasar un long dentro de un parámetro int hay que castearlo

        System.out.println("\n\n");

        Double DoubleValue = 2.3;
        overloadExercises.test2(DoubleValue);// Mehtod with Double type
        overloadExercises.test2(IntegerValue);// Mehtod with float type
        overloadExercises.test2(2);// Mehtod with float type
        overloadExercises.test2(2.3);// Mehtod with double type
        overloadExercises.test2(2.3f);// Mehtod with float type
        Float FloatValue = 1f;
        overloadExercises.test2(FloatValue);// Mehtod with Float type
    }

    void test(int a) {
        System.out.println(" int primitive type");
    }

    private Integer test(Integer a) throws FileNotFoundException{
        System.out.println(" int wrapper type");
        return a;
    }

    private long test(Long a) throws FileNotFoundException{
        System.out.println(" long wrapper type");
        return a;
    }


    private String test2(double a) {
        System.out.println(" double primitive type");
        return "";
    }

    protected void test2(Double a) {
        System.out.println(" double wrapper type");
    }

    protected void test2(float a) {
        System.out.println(" float primitive type");
    }

    void test2(Float a) {
        System.out.println(" float wrapper type");
    }


}