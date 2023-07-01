package challenges;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SumOfThreeValuesExercise {
    static int size = 0;
    static int minValue = -103;
    static int maxValue = 103;

    public static void main(String []argh)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter the target:");
        Integer target= sc.nextInt();
        while (size>1000||size<3){
            System.out.print("Please enter the size list:");
            size = sc.nextInt();
        }

        Random random = new Random();

        //If you prefer a random list please uncomment this line
        int[] randomArray = random.ints(size, minValue, maxValue + 1)
                .boxed()
                .collect(Collectors.toList())
                .stream()
                .mapToInt(Integer::intValue)
                .toArray();


        //If you prefer to create the list please uncomment these lines
        //int[] randomArray = new int[]{1,2,3,4,-5};size=5;

        System.out.println(findValues(randomArray,target));
    }

    static boolean findValues(int[] randomArray, Integer target){
        System.out.print("ARRAY:");
        Arrays.stream(randomArray).forEach(x->System.out.print(x + " "));
        System.out.println("\n---------------------------------------------------------------");

        for (int i = 0; i<size; i++){
            for (int j = 1; j<size; j++){
                for (int k = size-1; k>-1; k--){
                    if(i!=j && i!=k && j!=k && randomArray[i]+randomArray[j]+randomArray[k]==target){
                        System.out.printf("position:%d number:%d \nposition:%d number:%d \nposition:%d number:%d \ntarget:%d \n",i, randomArray[i],j,randomArray[j],k,randomArray[k],target);
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
