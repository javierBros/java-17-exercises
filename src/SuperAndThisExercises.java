import java.io.FileNotFoundException;

public class SuperAndThisExercises {
    public static void main (String []argh) {
        Parent parent = new Grandson(1,"");
    }

}

class Parent {
    Parent(){
        System.out.println("class Parent without parameters");
    }
    Parent(int a, String b) {
        this();
        System.out.println("class Parent with parameters");
    }
}

class Son extends Parent {
    Son(int a, String b)  {
        super(a,b);
        System.out.println("class Son with parameters");
    }
}

class Grandson extends Son {
    Grandson(int a, String b)  {
        super(a,b);
        System.out.println("class Grandson with parameters");
    }
}