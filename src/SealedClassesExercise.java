public sealed class SealedClassesExercise{
    public static void main (String []argh) {

        StringBuilder sb = new StringBuilder(10);
        System.out.println(sb.length());
        sb.append("Java 17 Exam");
        System.out.println(sb.capacity());
    }


    public void m(){
        System.out.println("m de base");
    }

}

non-sealed class Hija1 extends SealedClassesExercise{}


class Nieta1 extends Hija1 {
    public void test(){
        super.m();
    }
}