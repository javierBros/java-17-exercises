public class OuterClassesExercises {
    // Exercise with static inner class
    static class StaticInnerClass{
        private int innerNum = 2;
    }
    public static void main(String[] args){
        StaticInnerClass sic = new StaticInnerClass();
        OuterClassesExercises.StaticInnerClass sicB = new OuterClassesExercises.StaticInnerClass();
        // StaticInnerClass sicC = new OuterClassesExercises().new StaticInnerClass(); // marca ERRROR de compilación
        StaticInnerClass sicD = new OuterClassesExercises.StaticInnerClass();
        prueba();
    }

    // Who can access to innerNum?

    class InnerClass {
        private int innerNum = 2;
    }
    public static void prueba(){
        OuterClassesExercises oce = new OuterClassesExercises();
        OuterClassesExercises.InnerClass inner = new OuterClassesExercises().new InnerClass();
        InnerClass ic2 = new OuterClassesExercises().new InnerClass();
        System.out.println(ic2.innerNum);
    }
}
