

public class ExerciseTwo{

    public static int sum(int[] arr){
        int index = arr.length -1; 

       return  sumHelper(arr, index);



    }

    private static int sumHelper(int[] arr, int in){

        if(in == 0){
            return arr[0];
        }
        else{
            return arr[in] + sumHelper(arr, in-1);
    }

    }

    public static void main(String[] args){ 
        int[] testArr = new int[10];
        for(int i =1; i <= 10; i++){

            testArr[i-1] = i;
        }

        long startTime1 = System.nanoTime(); 
        System.out.println(sum(testArr));
        long endTime1 = System.nanoTime();
        double x2 = endTime1 - startTime1; // time taken for cubic

        System.out.println("Time for the recursion method with a helper: " + x2);

    }
}