public class ExceptionsExercises {
    public static void main(String[] args){
        try {
            throw new IllegalArgumentException();
        } catch (IllegalArgumentException e){
            System.out.println("1");
        } catch (RuntimeException e){
            System.out.println("2");
        } catch (Exception e){
            System.out.println("3");
        } finally {
            System.out.println("4");
        }

        try (var mcc = new MyCloseableClass()){
            mcc.myMethod();
        } catch (Exception e){
            System.out.println("1");
        } finally {
            System.out.println("3");
        }


        try (var mcc = new MyCloseableClass()){
            mcc.myMethod();
        }
    }
}

class MyCloseableClass implements AutoCloseable{
    public void myMethod(){
        System.out.println("myMethod");
        throw new RuntimeException();
    }

    @Override
    public void close(){
        System.out.println("close");
    }
}
