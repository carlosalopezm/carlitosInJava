public class ExerciseFour{

    public static int minFinder(int[] arr){
        int index = 0;
        int minValue = arr[index]; 
        return minFinderHelp(arr, index, minValue);
    }

    private static int minFinderHelp(int[] arr, int index, int minValue){ 
        if(index < arr.length && arr[index] < minValue){
            minValue = arr[index];
        }
        if(index == arr.length -1){
            return minValue; 
        }

        else{
            return(minFinderHelp(arr, index + 1, minValue));
        }


    }

    public static void main(String[] args){ 
        int[] testArr = new int[20];
        for(int j =1; j <= 20; j++){
            testArr[j-1] = j - 2;
        }
        testArr[4] = -50;
        testArr[19] = -100; 
        testArr[0] = -200;
        long startTime1 = System.nanoTime(); 
        System.out.println(minFinder(testArr));
        long endTime1 = System.nanoTime();
        double x1 = endTime1 - startTime1; // time taken for cubic
        System.out.println("Time for the recursion method with a helper: " + x1);
        


}
}