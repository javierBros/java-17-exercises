package overridingwithinterfaces;

import java.io.FileNotFoundException;

public class C implements A, B {
    public void myMethod() throws FileNotFoundException{
        System.out.println("class C");
    }

    public static void main (String []argh) throws FileNotFoundException {
        C c = new C();
        c.myMethod();
    }
}