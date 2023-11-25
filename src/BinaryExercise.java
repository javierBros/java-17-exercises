public class BinaryExercise {
    public static void main (String []argh) {
        Long a = 0L;
        //String binaries = Integer.toBinaryString(a.intValue());
        StringBuilder binaries = new StringBuilder(String.format("%32s", Long.toBinaryString(a)).replaceAll(" ","0"));
        System.out.println(binaries);
        System.out.println(binaries.reverse());
        System.out.println(Long.parseLong(binaries.toString(),2));
    }
}
