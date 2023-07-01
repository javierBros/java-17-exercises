import collections.Persona;

import java.util.Arrays;
import java.util.stream.Stream;

public class ArraysExercises {

    public static void main (String... args){

        // Arrays de una dimensión
        int[] datos;
        int vals[];
        //int v[3]// No se puede indicar el tamaño en la declaración


        Persona[] personas;
        Persona[] arrayPersonas = new Persona[10];
        arrayPersonas[3] = new Persona(10,"Truan",170);

        Stream<Persona> streamPersonas = Arrays.stream(arrayPersonas);
        streamPersonas.forEach(System.out::println);


        int[] valores = new int[]{1,2,3,4};
        int[] valores2 = {1,2,3,4};// Otra manera de inicializar valores


        // Arrays de dos dimensiones
        int[][] a;
        int[]b[];
        int[] c[][];

        a = new int[3][4];
        c = new int[2][5][10];

        a[1][2]=7;
        c[0][3][0]=8;

        for (var n:a){
            for (var v2: n) {
                System.out.println(v2);
            }
        }

        // Arrays irregulares
        int [][] d = new int[5][];
        int [][][] n = new int[4][][];
        int [][][] v = new int[2][10][];
        //int [][][] h = new int[6][][4];// No se pueden dejar dimensiones intermedias sin asignar tamaño

        d[0] = new int[4];
        d[2] = new int[7];
        n[1] = new int[4][2];
        v[0][0] = new int[6];

        int[] intArray = new int[10];
        long[][] longArray = new long[2][3];
        longArray[0][0]= intArray[1];
        intArray[1]= (int)longArray[0][0];
    }
}
