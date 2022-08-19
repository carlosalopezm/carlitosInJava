/**
 * Author: Carlos López 
 * UNI: cal2266
 * Description: ExerciseSix.java is the program that was made to anser RE 13.6
 */

import java.io.*; 
public class ExerciseSix{

    public static int permutation(int n, int r){
        if(r > n){ throw new IllegalArgumentException("r must be less than or equal to n."); 
    }

    if(n <= 1 || r <= 1){ throw new IllegalArgumentException("n and r must be integers greater than or equal to 1"); 
        }
        return (permHelper(n)/permHelper(n-r));
        
    }
    private static int permHelper(int k){
        if(k == 1){
            return 1;
        }
        else{
            return k * permHelper(k-1);
        }
    }

    public static void main(String[] args){ 
        long startTime1 = System.nanoTime(); 
        System.out.println(permutation(6, 3));
        long endTime1 = System.nanoTime();
        double x1 = endTime1 - startTime1; // time taken for cubic
        System.out.println("Time for the recursion method with a helper: " + x1);

        long startTime2 = System.nanoTime(); 
        System.out.println(permutation(7, 4));
        long endTime2 = System.nanoTime();
        double x2 = endTime2 - startTime2; // time taken for cubic
        System.out.println("Time for the recursion method with a helper: " + x2);

        long startTime3 = System.nanoTime(); 
        System.out.println(permutation(-1, 2));
        long endTime3 = System.nanoTime();
        double x3 = endTime3 - startTime3; // time taken for cubic
        System.out.println("Time for the recursion method with a helper: " + x3);

    }
}
    
