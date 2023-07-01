public class SwitchAndRecordsExercises {
    public static void main (String []argh) {
        //Switch expressions
        /*
        int nota = 6;
        String resultado = switch(nota){
            case 1,2,3,4->"Suspenso";
            case 5,6->{var a= 5; var b=6; var c= "Aprobado-"+a+"-"+b+""; yield c; }
            case 7,8->"Notable";
            case 9,10-> {yield "Sobresaliente";}
            default->"No válido";// Es obligatorio el default
        };
        System.out.println(resultado);
        */

        /*
        DATA a = DATA.TWO;
        int r = switch (a){
            case ONE: yield 1;
            case TWO: yield 2;
            case THREE: yield 3;// Por ser un enum No es obligatorio el default
        };
        System.out.println(r);
        */

        /*
        System.out.println(test4(null));
         */

        /*
        collections.Persona p = new collections.Persona("Javier", 32, "CC");
        collections.Persona p2 = new collections.Persona("Javier", 32, "CCA");
        System.out.println(p.toString());
        System.out.println(p.equals(p2));
        System.out.println(p.nombre);
        System.out.println(p.edad);
        System.out.println(p.documento);
        */

        Punto punto1 = new Punto(10);
        System.out.println(punto1.x);
        System.out.println(punto1.y);
        Punto punto2 = new Punto(15,20);
        System.out.println(punto2.x);
        System.out.println(punto2.y);
        Book book = new Book("Relato de un asesino",14.5);
        System.out.println(book.title);
        System.out.println(book.price);
        System.out.println(book.hashCode());
        System.out.println(book.toString());

    }

    enum DATA{ONE, TWO, THREE}
    public static int test4(DATA data){
        return switch (data){
            case ONE: yield 1;
            case TWO: yield 2;
            case THREE: yield 3;// Por ser un enum No es obligatorio el default
        };
    }

    sealed interface Prueba{
        void test();
    }

    record Persona(String nombre, int edad, String documento) implements Prueba{
        @Override
        public void test() {

        }
    }

    public record Punto(int x, int y) implements prueba{
        public Punto(int x){
            this(x,x);
        }
    }

    public record Book(String title, double price){
        private final static double PLUS = 10;
        public Book{price+=PLUS;}// constructor compacto
    }
}

interface prueba{

}
